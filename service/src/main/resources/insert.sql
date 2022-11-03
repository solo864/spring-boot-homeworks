INSERT INTO customer (first_name, surname, email, password, birth_date, role)
VALUES ('Isobelle', 'Valentine', 'isabelle@gmail.com', 'valentine123', '1999-01-01', 'USER'),
       ('Findlay', 'Miruna', 'findlay@gmail.com', 'miruna123', '2020-02-02', 'USER'),
       ('Cleveland', 'Abida', 'cleveland@gmail.com', 'abida123', '2001-03-03', 'USER');


INSERT INTO personal_info (phone_number, address, gender, customer_id)
VALUES ('6785435892', 'test2', 'MALE', 1),
       ('8905368562', 'test3', 'MALE', 2),
       ('9876435792', 'test4', 'MALE', 3);


INSERT INTO orders (registration_date, closing_date, status, customer_id)
VALUES ('2021-05-06', '2020-05-07', 'ACTIVE', 1),
       ('2022-06-07', '2020-05-07', 'ACTIVE', 1),
       ('2022-06-07', '2020-05-07', 'ACTIVE', 1),
       ('2022-06-07', '2020-05-07', 'ACTIVE', 1),
       ('2021-05-06', '2020-05-07', 'INACTIVE', 2),
       ('2022-06-07', '2020-05-07', 'ACTIVE', 2),
       ('2022-06-07', '2020-05-07', 'ACTIVE', 2),
       ('2021-05-06', '2020-05-07', 'ACTIVE', 3),
       ('2022-06-07', '2020-05-07', 'INACTIVE', 3);



INSERT INTO product (description, name, price, remaining_quantity)
VALUES ('test', 'test', 11, 2),
       ('test2', 'test2', 12, 2),
       ('test3', 'test3', 13, 3),
       ('test4', 'test4', 14, 4),
       ('test5', 'test5', 15, 5),
       ('test6', 'test6', 16, 6),
       ('test7', 'test7', 17, 7),
       ('test8', 'test8', 18, 8),
       ('test9', 'test9', 19, 9),
       ('test10', 'test10', 20, 10),
       ('test11', 'test11', 21, 11);


INSERT INTO order_product (count, product_id, order_id)
VALUES (10, 1, 1),
       (5, 2, 2),
       (16, 3, 3),
       (12, 4, 4),
       (13, 4, 1),
       (14, 4, 2),
       (15, 7, 3),
       (42, 8, 1),
       (12, 9, 1),
       (32, 10, 2);