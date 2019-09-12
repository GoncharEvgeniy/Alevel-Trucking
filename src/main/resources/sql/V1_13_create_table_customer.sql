CREATE TABLE `customer`
(
    `id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_user_id_customer` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
