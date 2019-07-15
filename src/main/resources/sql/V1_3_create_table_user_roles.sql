CREATE TABLE `user_roles`
(
    `user_id` BIGINT(20) NOT NULL,
    `role_id` BIGINT(20) NOT NULL,
    INDEX `role` (`role_id`),
    INDEX `user` (`user_id`),
    CONSTRAINT `fk_user_roles_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
        ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `fk_user_roles_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
        ON DELETE CASCADE ON UPDATE RESTRICT
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB;