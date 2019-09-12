CREATE TABLE `users`
(
    `id`                         BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `username`                   VARCHAR(255) NOT NULL UNIQUE,
    `password`                   VARCHAR(255) NOT NULL,
    `email`                      VARCHAR(255) NOT NULL UNIQUE,
    `first_name`                 VARCHAR(255) NOT NULL,
    `last_name`                  VARCHAR(255) NOT NULL,
    `second_name`                VARCHAR(255) NOT NULL,
    `phone`                      VARCHAR(255) NOT NULL,
    `is_account_non_expired`     BIT(1)       NULL DEFAULT NULL,
    `is_account_non_locked`      BIT(1)       NULL DEFAULT NULL,
    `is_credentials_non_expired` BIT(1)       NULL DEFAULT NULL,
    `is_enabled`                 BIT(1)       NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;