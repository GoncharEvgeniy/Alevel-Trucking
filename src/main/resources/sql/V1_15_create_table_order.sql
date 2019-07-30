CREATE TABLE `orders`
(
    `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `cost`        DOUBLE       NULL DEFAULT NULL,
    `status`      VARCHAR(255) NULL DEFAULT NULL,
    `id_customer` BIGINT(20)   NULL DEFAULT NULL,
    `id_manager`  BIGINT(20)   NULL DEFAULT NULL,
    `id_route`    BIGINT(20)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_id_customer` (`id_customer`),
    INDEX `FK_id_manager` (`id_manager`),
    INDEX `FK_id_route` (`id_route`),
    CONSTRAINT `FK_id_route` FOREIGN KEY (`id_route`) REFERENCES `route` (`id`),
    CONSTRAINT `FK_id_manager` FOREIGN KEY (`id_manager`) REFERENCES `manager` (`id`),
    CONSTRAINT `FK_id_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
