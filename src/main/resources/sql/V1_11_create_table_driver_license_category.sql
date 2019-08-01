CREATE TABLE `driver_license_category`
(
    `id_driver_license` BIGINT(20)   NOT NULL,
    `category`          VARCHAR(255) NULL DEFAULT NULL,
    INDEX `FK_driver_license_id` (`id_driver_license`),
    CONSTRAINT `FK_driver_license_id` FOREIGN KEY (`id_driver_license`) REFERENCES `driver_license` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
