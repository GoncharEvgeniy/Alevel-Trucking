CREATE TABLE `order_goods`
(
    `id_order` BIGINT(20) NOT NULL,
    `id_goods` BIGINT(20) NOT NULL,
    INDEX `FK_id_goods` (`id_goods`),
    INDEX `FK_id_order_goods` (`id_order`),
    CONSTRAINT `FK_id_order_goods` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id`),
    CONSTRAINT `FK_id_goods` FOREIGN KEY (`id_goods`) REFERENCES `goods` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
