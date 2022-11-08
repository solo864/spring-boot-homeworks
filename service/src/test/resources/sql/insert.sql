INSERT INTO customer (id, first_name, surname, email, password, birth_date, role)
VALUES (1, 'Isobelle', 'Valentine', 'isabelle@gmail.com', 'valentine123', '1999-01-01', 'USER'),
       (2, 'Findlay', 'Miruna', 'findlay@gmail.com', 'miruna123', '2020-02-02', 'USER'),
       (3, 'Cleveland', 'Abida', 'cleveland@gmail.com', 'abida123', '2001-03-03', 'USER');


INSERT INTO personal_info (id, phone_number, address, gender, customer_id)
VALUES (1, '6785435892', 'test2', 'MALE', 1),
       (2, '8905368562', 'test3', 'MALE', 2),
       (3, '9876435792', 'test4', 'MALE', 3);


INSERT INTO orders (id, registration_date, closing_date, status, customer_id)
VALUES (1, '2021-05-06', '2020-05-07', 'ACTIVE', 1),
       (2, '2022-06-07', '2020-05-07', 'ACTIVE', 1),
       (3, '2022-06-07', '2020-05-07', 'ACTIVE', 1),
       (4, '2022-06-07', '2020-05-07', 'ACTIVE', 1),
       (5, '2021-05-06', '2020-05-07', 'INACTIVE', 2),
       (6, '2022-06-07', '2020-05-07', 'ACTIVE', 2),
       (7, '2022-06-07', '2020-05-07', 'ACTIVE', 2),
       (8, '2021-05-06', '2020-05-07', 'ACTIVE', 3),
       (9, '2022-06-07', '2020-05-07', 'INACTIVE', 3);


INSERT INTO product (id, description, name, price, remaining_quantity)
VALUES (1, 'test', 'test', 11, 2),
       (2, 'test2', 'test2', 12, 2),
       (3, 'test3', 'test3', 13, 3),
       (4, 'test4', 'test4', 14, 4),
       (5, 'test5', 'test5', 15, 5),
       (6, 'test6', 'test6', 16, 6),
       (7, 'test7', 'test7', 17, 7),
       (8, 'test8', 'test8', 18, 8),
       (9, 'test9', 'test9', 19, 9),
       (10, 'test10', 'test10', 20, 10),
       (11, 'test11', 'test11', 21, 11);


INSERT INTO order_product (id, count, product_id, order_id)
VALUES (1, 10, 1, 1),
       (2, 5, 2, 2),
       (3, 16, 3, 3),
       (4, 12, 4, 4),
       (5, 13, 4, 1),
       (6, 14, 4, 2),
       (7, 15, 7, 3),
       (8, 42, 8, 1),
       (9, 12, 9, 1),
       (10, 32, 10, 2);