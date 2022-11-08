--liquibase formatted sql

--changeset musayev:1
CREATE TABLE IF NOT EXISTS customer
(
    id         SERIAL PRIMARY KEY,
    birth_date DATE        NOT NULL,
    email      VARCHAR(64) NOT NULL UNIQUE,
    first_name VARCHAR(64) NOT NULL,
    password   VARCHAR(64) NOT NULL,
    role       VARCHAR(16) NOT NULL,
    surname    VARCHAR(64) NOT NULL
    );
--rollback DROP TABLE customer

--changeset musayev:2
CREATE TABLE IF NOT EXISTS personal_info
(
    id           SERIAL PRIMARY KEY,
    address      VARCHAR(64),
    gender       VARCHAR(32),
    phone_number VARCHAR(32),
    customer_id  INT REFERENCES customer (id)
    );
--rollback DROP TABLE personal_info

--changeset musayev:3
CREATE TABLE IF NOT EXISTS orders
(
    id                SERIAL PRIMARY KEY,
    closing_date      DATE,
    registration_date DATE,
    status            VARCHAR(32),
    customer_id       INT REFERENCES customer (id)
    );
--rollback DROP TABLE orders

--changeset musayev:4
CREATE TABLE IF NOT EXISTS product
(
    id                SERIAL PRIMARY KEY ,
    description        TEXT NOT NULL ,
    name               VARCHAR(64) NOT NULL ,
    price              NUMERIC(16,2),
    remaining_quantity INT
    );
--rollback DROP TABLE product

--changeset musayev:5
CREATE TABLE IF NOT EXISTS order_product
(
    id         SERIAL PRIMARY KEY,
    count      INT,
    created_at DATE,
    order_id   INT REFERENCES orders (id),
    product_id INT REFERENCES product (id)
    );
--rollback DROP TABLE order_product