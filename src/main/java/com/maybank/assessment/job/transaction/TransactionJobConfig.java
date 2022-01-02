package com.maybank.assessment.job.transaction;

import com.maybank.assessment.model.database.TransactionEntity;
import com.maybank.assessment.model.job.transaction.Transaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class TransactionJobConfig extends DefaultBatchConfigurer {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Transaction> reader() {
        return new FlatFileItemReaderBuilder<Transaction>()
                .name("transactionItemReader")
                .resource(new ClassPathResource("csv/dataSource.txt"))
                .linesToSkip(1)
                .delimited()
                .delimiter("|")
                .names(new String[]{"accountNumber", "transactionAmount", "description", "transactionDate","transactionTime","customerId"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>() {{
                    setTargetType(Transaction.class);
                }})
                .build();
    }

    @Bean
    public TransactionItemProcessor processor() {
        return new TransactionItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<TransactionEntity> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<TransactionEntity>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO transaction (customer_id, " +
                        "account_number, amount, description, " +
                        "transaction_date, record_create_date, " +
                        "record_update_date) " +
                        "VALUES (:customerId, :accountNumber, :amount, " +
                        ":description, :transactionDate, now(), now())")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importTransactionJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importTransactionJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<TransactionEntity> writer) {
        return stepBuilderFactory.get("step1")
                .<Transaction, TransactionEntity> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

    @Override
    public void setDataSource(DataSource dataSource) {
    }

}
