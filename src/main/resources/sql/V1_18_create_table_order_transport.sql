CREATE TABLE `order_transport`
(
    `id_order`     BIGINT(20) NOT NULL,
    `id_transport` BIGINT(20) NOT NULL,
    INDEX `FK_id_transport` (`id_transport`),
    INDEX `FK_id_order_transport` (`id_order`),
    CONSTRAINT `FK_id_order_transport` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id`),
    CONSTRAINT `FK_id_transport` FOREIGN KEY (`id_transport`) REFERENCES `transport` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
