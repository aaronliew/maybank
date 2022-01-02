package com.maybank.assessment.database;

import com.maybank.assessment.model.database.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {

    @Query(value = "SELECT t FROM TransactionEntity t WHERE " +
            "t.accountNumber like COALESCE(:accountNumber, t.accountNumber) and  " +
            "t.customerId like COALESCE(:customerId, t.customerId) and " +
            "t.description like COALESCE(:description, t.description)")
    Page<TransactionEntity> getTransactionsByAccountNoAndCustomerIdAndDesc(
            @Param("accountNumber") String accountNumber,
            @Param("customerId") String customerId,
            @Param("description") String description,
            Pageable pageable);
}
