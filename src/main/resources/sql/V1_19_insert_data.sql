INSERT INTO trucking.address (id, id_building, id_city, id_street) VALUES (1, 1, 1, 1);
INSERT INTO trucking.address (id, id_building, id_city, id_street) VALUES (2, 2, 2, 2);
INSERT INTO trucking.address (id, id_building, id_city, id_street) VALUES (3, 3, 3, 3);
INSERT INTO trucking.address (id, id_building, id_city, id_street) VALUES (4, 4, 4, 4);
INSERT INTO trucking.building (id, number, suffix) VALUES (1, 10, '');
INSERT INTO trucking.building (id, number, suffix) VALUES (2, 60, '');
INSERT INTO trucking.building (id, number, suffix) VALUES (3, 1, null);
INSERT INTO trucking.building (id, number, suffix) VALUES (4, 26, 'А');
INSERT INTO trucking.city (id, name) VALUES (1, 'Полтава');
INSERT INTO trucking.city (id, name) VALUES (2, 'Харьков');
INSERT INTO trucking.city (id, name) VALUES (3, 'Харьков');
INSERT INTO trucking.city (id, name) VALUES (4, 'Киев');
INSERT INTO trucking.customer (id) VALUES (4);
INSERT INTO trucking.customer (id) VALUES (5);
INSERT INTO trucking.customer (id) VALUES (11);
INSERT INTO trucking.customer (id) VALUES (12);
INSERT INTO trucking.driver (id, birthday, start_work, status, id_driver_license) VALUES (3, '1990-10-12 00:00:00', '2019-12-09 00:00:00', 'IN_BOX', 1);
INSERT INTO trucking.driver (id, birthday, start_work, status, id_driver_license) VALUES (8, '1988-10-10 00:00:00', '2019-01-12 00:00:00', 'IN_BOX', 2);
INSERT INTO trucking.driver (id, birthday, start_work, status, id_driver_license) VALUES (9, '1988-10-11 00:00:00', '2018-11-12 00:00:00', 'IN_ROUTE', 3);
INSERT INTO trucking.driver_license (id, date_of_first_registration, date_of_registration, validity) VALUES (1, '1995-10-12 00:00:00', '1989-10-12 00:00:00', '2020-10-12 00:00:00');
INSERT INTO trucking.driver_license (id, date_of_first_registration, date_of_registration, validity) VALUES (2, '1970-05-12 00:00:00', '1981-05-15 00:00:00', '2019-12-07 00:00:00');
INSERT INTO trucking.driver_license (id, date_of_first_registration, date_of_registration, validity) VALUES (3, '1970-05-11 00:00:00', '1981-10-15 00:00:00', '2019-01-07 00:00:00');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (1, 'C1');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (1, 'C1E');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (1, 'CE');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (1, 'C');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (2, 'C1');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (2, 'CE');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (2, 'C');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (2, 'C1E');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (3, 'C');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (3, 'CE');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (3, 'C1E');
INSERT INTO trucking.driver_license_category (id_driver_license, category) VALUES (3, 'C1');
INSERT INTO trucking.goods (id, height, length, volume, weight, width, name) VALUES (1, 100, 100, 0, 500, 100, 'Кирпичи');
INSERT INTO trucking.goods (id, height, length, volume, weight, width, name) VALUES (2, 100, 200, 0, 200, 200, 'Рояль');
INSERT INTO trucking.goods (id, height, length, volume, weight, width, name) VALUES (3, 0, 0, 3000, 3000, 0, 'Вода');
INSERT INTO trucking.manager (id, birthday, start_work) VALUES (2, '1990-07-12 00:00:00', '2019-12-01 00:00:00');
INSERT INTO trucking.manager (id, birthday, start_work) VALUES (7, '2000-10-01 00:00:00', '2019-01-15 00:00:00');
INSERT INTO trucking.manager (id, birthday, start_work) VALUES (10, '1975-10-01 00:00:00', '2019-01-15 00:00:00');
INSERT INTO trucking.order_driver (id_order, id_driver) VALUES (1, 9);
INSERT INTO trucking.order_goods (id_order, id_goods) VALUES (1, 1);
INSERT INTO trucking.order_goods (id_order, id_goods) VALUES (2, 2);
INSERT INTO trucking.order_goods (id_order, id_goods) VALUES (2, 3);
INSERT INTO trucking.order_transport (id_order, id_transport) VALUES (1, 2);
INSERT INTO trucking.orders (id, cost, status, id_customer, id_manager, id_route) VALUES (1, 1194.5899000000002, 'ACCEPTED', 4, 10, 1);
INSERT INTO trucking.orders (id, cost, status, id_customer, id_manager, id_route) VALUES (2, 0, 'WAITING', 4, null, 2);
INSERT INTO trucking.role (id, name) VALUES (1, 'admin');
INSERT INTO trucking.role (id, name) VALUES (2, 'customer');
INSERT INTO trucking.role (id, name) VALUES (4, 'driver');
INSERT INTO trucking.role (id, name) VALUES (3, 'manager');
INSERT INTO trucking.route (id, distance, id_end_address, id_start_address) VALUES (1, 170655.7, 1, 2);
INSERT INTO trucking.route (id, distance, id_end_address, id_start_address) VALUES (2, 0, 3, 4);
INSERT INTO trucking.street (id, name) VALUES (1, 'Европейская');
INSERT INTO trucking.street (id, name) VALUES (2, 'Валентиновская');
INSERT INTO trucking.street (id, name) VALUES (3, 'Сумская');
INSERT INTO trucking.street (id, name) VALUES (4, 'Вячеслава Чорновола');
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (2, 'AX0101AX', 1500, 170, 300, 0, 170, 'FORD TRANSIT', 'IN_ROUTE', 'COVERED', 7);
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (3, 'AX0102AX', 2000, 180, 420, 0, 180, 'FORD TRANSIT', 'IN_BOX', 'COVERED', 7);
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (4, 'AX0112AX', 2000, 50, 600, 0, 200, 'Газель', 'IN_BOX', 'OPEN', 8);
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (5, 'AX0115AX', 2000, 220, 420, 0, 190, 'Газель', 'IN_BOX', 'COVERED', 8);
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (6, 'AX0515AX', 3000, 220, 420, 0, 190, 'IVECO Daily', 'IN_BOX', 'COVERED', 9);
INSERT INTO trucking.transport (id, license_plate_number, load_capacity, max_height_of_goods, max_length_of_goods, max_volume_of_goods, max_width_of_goods, name, status, type, cost_per_one_kilometer) VALUES (7, 'AX0585AX', 5000, 275, 700, 0, 250, 'Mercedes atego гидроборт', 'IN_BOX', 'COVERED', 11);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (1, 'user1', 'password1', 'user1@gmail.com', 'Админ', 'Админов', 'Админович', '+380112223000', true, true, true, true, 1);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (2, 'user2', 'password2', 'user2@gmail.com', 'Манагер', 'Манагеров', 'Манагерович', '+380112223000', true, true, true, true, 3);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (3, 'user3', 'password3', 'user3@gmail.com', 'Водила', 'Водилов', 'Водилыч', '+380112245123', true, true, true, true, 4);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (4, 'user4', 'password4', 'user4@gmail.com', 'Покупатель1', 'Покупатов', 'Покупателиевич', '+380112123456', true, true, true, true, 2);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (5, 'user5', 'password5', 'user5@gmail.com', 'Покуп2', 'Покупатов2', 'Покупателивич2', '+380112223344', true, true, true, true, 2);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (7, 'user6', 'password6', 'user6@gmail.com', 'Манагер2', 'Манагеров2', 'Манагерович2', '+380112223355', true, true, true, true, 3);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (8, 'user7', 'password7', 'user7@gmail.com', 'Дрявер2', 'Драйверов2', 'Драйверович2', '+380112228855', true, true, true, true, 4);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (9, 'user8', 'password8', 'user8@gmail.com', 'Дрявер3', 'Драйверов3', 'Драйверович3', '+380112225855', true, true, true, true, 4);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (10, 'user9', 'password9', 'user9@gmail.com', 'Манагер3', 'Манагеров3', 'Манагерович3', '+380117223355', true, true, true, true, 3);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (11, 'user11', 'password11', 'user11@gmail.com', 'Покуп2', 'Покупатов2', 'Покупателивич2', '+380112223344', true, true, true, true, 2);
INSERT INTO trucking.users (id, username, password, email, first_name, last_name, second_name, phone, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, role_id) VALUES (12, 'user12', 'password12', 'user12@gmail.com', 'Покуп2', 'Покупатов2', 'Покупателивич2', '+380112223344', true, true, true, true, 2);