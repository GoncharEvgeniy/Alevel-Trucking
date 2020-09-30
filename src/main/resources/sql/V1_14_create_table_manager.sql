CREATE TABLE `manager`
(
    `id`         BIGINT(20)  NOT NULL,
    `birthday`   DATETIME(6) NULL DEFAULT NULL,
    `start_work` DATETIME(6) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_user_id_manager` FOREIGN KEY (`id`) REFERENCES `usrs` (`id`)
)
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
