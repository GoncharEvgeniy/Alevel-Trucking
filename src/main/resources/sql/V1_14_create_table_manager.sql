CREATE TABLE `manager`
(
    `id`         BIGINT(20)  NOT NULL,
    `birthday`   DATETIME(6) NULL DEFAULT NULL,
    `start_work` DATETIME(6) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_user_id` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
