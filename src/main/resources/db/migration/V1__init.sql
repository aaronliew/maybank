DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
   `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
   `account_number` varchar(255) DEFAULT NULL,
   `amount` bigint(20) DEFAULT NULL,
   `customer_id` varchar(255) DEFAULT NULL,
   `description` varchar(255) DEFAULT NULL,
   `transaction_date` datetime DEFAULT NULL,
   `record_create_date` datetime DEFAULT NULL,
   `record_update_date` datetime DEFAULT NULL,
   PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
