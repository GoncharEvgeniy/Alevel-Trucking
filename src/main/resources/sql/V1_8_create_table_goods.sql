CREATE TABLE `goods`
(
    `id`     BIGINT(20) NOT NULL AUTO_INCREMENT,
    `height` INT(11)    NULL DEFAULT NULL,
    `length` INT(11)    NULL DEFAULT NULL,
    `volume` INT(11)    NULL DEFAULT NULL,
    `weight` INT(11)    NULL DEFAULT NULL,
    `width`  INT(11)    NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
