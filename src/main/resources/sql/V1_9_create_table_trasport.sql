CREATE TABLE `transport`
(
    `id`                     BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `license_plate_number`   VARCHAR(255) NOT NULL UNIQUE,
    `load_capacity`          INT(11)      NOT NULL,
    `max_height_of_goods`    INT(11)      NULL DEFAULT NULL,
    `max_length_of_goods`    INT(11)      NULL DEFAULT NULL,
    `max_volume_of_goods`    INT(11)      NULL DEFAULT NULL,
    `max_width_of_goods`     INT(11)      NULL DEFAULT NULL,
    `name`                   VARCHAR(255) NOT NULL,
    `status`                 VARCHAR(255) NULL DEFAULT NULL,
    `type`                   VARCHAR(255) NULL DEFAULT NULL,
    `cost_per_one_kilometer` DOUBLE       NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
