CREATE TABLE `driver_license_category`
(
    `driver_license_id` BIGINT(20)   NOT NULL,
    `category`          VARCHAR(255) NULL DEFAULT NULL,
    INDEX `FK_driver_license_id` (`driver_license_id`),
    CONSTRAINT `FK_driver_license_id` FOREIGN KEY (`driver_license_id`) REFERENCES `driver_license` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;

