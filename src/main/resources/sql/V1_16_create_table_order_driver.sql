CREATE TABLE `order_driver`
(
    `id_order`  BIGINT(20) NOT NULL,
    `id_driver` BIGINT(20) NOT NULL,
    INDEX `FK_id_driver` (`id_driver`),
    INDEX `FK_id_order` (`id_order`),
    CONSTRAINT `FK_id_driver` FOREIGN KEY (`id_driver`) REFERENCES `driver` (`id`),
    CONSTRAINT `FK_id_order` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
