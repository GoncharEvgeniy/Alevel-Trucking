CREATE TABLE `building`
(
    `id`     BIGINT(20) NOT NULL AUTO_INCREMENT,
    `number` INT(11)    NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
