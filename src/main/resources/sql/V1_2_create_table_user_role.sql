CREATE TABLE `user_role`
(
    `user_id` BIGINT(20)   NOT NULL,
    `roles`   VARCHAR(255) NULL DEFAULT NULL,
    INDEX `FK_user_id` (`user_id`),
    CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;