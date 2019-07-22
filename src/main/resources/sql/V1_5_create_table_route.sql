CREATE TABLE `route`
(
    `id`               BIGINT(20) NOT NULL AUTO_INCREMENT,
    `distance`         DOUBLE     NOT NULL,
    `id_end_address`   BIGINT(20) NOT NULL,
    `id_start_address` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_id_end_address` (`id_end_address`),
    INDEX `FK_id_start_address` (`id_start_address`),
    CONSTRAINT `FK_id_start_address` FOREIGN KEY (`id_start_address`) REFERENCES `address` (`id`),
    CONSTRAINT `FK_id_end_address` FOREIGN KEY (`id_end_address`) REFERENCES `address` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
