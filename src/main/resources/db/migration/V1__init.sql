CREATE TABLE prices (
  price_list BIGINT NOT NULL,
   start_date TIMESTAMP NOT NULL,
   end_date TIMESTAMP NOT NULL,
   priority BIGINT,
   price DOUBLE PRECISION NOT NULL,
   curr VARCHAR(3) NOT NULL,
   product_id BIGINT NOT NULL,
   brand_id BIGINT NOT NULL,
   CONSTRAINT pk_prices PRIMARY KEY (price_list)
);

CREATE SEQUENCE prices_sequence START WITH 1 INCREMENT BY 1 MINVALUE 1;

INSERT INTO prices (price_list, brand_id, start_date, product_id, priority, end_date, price, curr) VALUES
(NEXT VALUE FOR prices_sequence, 1, '2020-06-14 00:00:00', 35455, 0, '2020-12-31 23:59:59', 10.99, 'EUR'),
(NEXT VALUE FOR prices_sequence, 1, '2020-06-14 15:00:00', 35455, 1, '2020-06-14 18:30:00', 15.99, 'EUR'),
(NEXT VALUE FOR prices_sequence, 1, '2020-06-15 00:00:00', 35455, 1, '2020-06-15 11:00:00', 20.99, 'EUR'),
(NEXT VALUE FOR prices_sequence, 1, '2020-06-15 16:00:00', 35455, 1, '2020-12-31 23:59:59', 12.99, 'EUR');