CREATE TABLE `users`
(
    `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `username`    VARCHAR(255) NOT NULL UNIQUE,
    `email`       VARCHAR(255) NOT NULL UNIQUE,
    `phone`       VARCHAR(255) NOT NULL UNIQUE,
    `status`      VARCHAR(255) NOT NULL,
    `first_name`  VARCHAR(255) NOT NULL,
    `second_name` VARCHAR(255) NOT NULL,
    `last_name`   VARCHAR(255) NOT NULL,
    `password`    VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB;