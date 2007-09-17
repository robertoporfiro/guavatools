DROP TABLE PRODUCT;

CREATE TABLE Product (
	code VARCHAR(15) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(100),
    price FLOAT NOT NULL
);

CREATE INDEX ProductIndex
ON Product (name);

INSERT INTO PRODUCT (CODE, NAME, DESCRIPTION, PRICE) VALUES 
('app1', 'apples', 'Golden Delicious; kg', 1.23),
('ban1', 'bananas', 'Canaries; kg', 1.34),
('pear1', 'pears', 'Conference; kg', 1.56);

SELECT * FROM PRODUCT;
