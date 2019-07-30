CREATE TABLE `driver`
(
    `id`                BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `birthday`          DATETIME(6)  NOT NULL,
    `start_work`        DATETIME(6)  NOT NULL,
    `status`            VARCHAR(255) NOT NULL,
    `id_driver_license` BIGINT(20)   NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_id_driver_license` (`id_driver_license`),
    CONSTRAINT `FK_id_user` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
    CONSTRAINT `FK_id_driver_license` FOREIGN KEY (`id_driver_license`) REFERENCES `driver_license` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
