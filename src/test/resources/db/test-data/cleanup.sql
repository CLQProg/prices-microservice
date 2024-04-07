DELETE FROM brands_products;
DELETE FROM brands;
DELETE FROM products;
DELETE FROM prices;

ALTER SEQUENCE prices_sequence RESTART WITH 1;
ALTER SEQUENCE brands_sequence RESTART WITH 1;