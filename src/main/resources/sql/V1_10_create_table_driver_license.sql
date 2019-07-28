CREATE TABLE `driver_license`
(
    `id`                         BIGINT(20)  NOT NULL AUTO_INCREMENT,
    `date_of_first_registration` DATETIME(6) NOT NULL,
    `date_of_registration`       DATETIME(6) NOT NULL,
    `validity`                   DATETIME(6) NOT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
