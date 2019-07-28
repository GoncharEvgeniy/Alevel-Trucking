CREATE TABLE `address`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
    `id_building` BIGINT(20) NULL DEFAULT NULL,
    `id_city`     BIGINT(20) NULL DEFAULT NULL,
    `id_street`   BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_id_building` (`id_building`),
    INDEX `FK_id_city` (`id_city`),
    INDEX `FK_id_street` (`id_street`),
    CONSTRAINT `FK_id_street` FOREIGN KEY (`id_street`) REFERENCES `street` (`id`),
    CONSTRAINT `FK_id_building` FOREIGN KEY (`id_building`) REFERENCES `building` (`id`),
    CONSTRAINT `FK_id_city` FOREIGN KEY (`id_city`) REFERENCES `city` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
