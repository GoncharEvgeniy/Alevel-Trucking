CREATE TABLE `building`
(
    `id`     BIGINT(20) NOT NULL AUTO_INCREMENT,
    `number` INT(11)    NOT NULL UNIQUE,
    `suffix` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
