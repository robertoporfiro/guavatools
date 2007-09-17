DROP TABLE PRODUCT;

CREATE TABLE Product (
	code VARCHAR(15) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(100),
    price FLOAT NOT NULL
);

CREATE INDEX ProductIndex
ON Product (name);

INSERT INTO Product (code, name, description, price) values
	('brazilnut', 'brazil nuts', 'Brazils; 100gm', 1.30),
	('peanut', 'peanuts', 'Ground nuts; 200gm', 0.95),
	('hazelnut', 'hazelnuts', 'Loved by squirrels and cadburys; 50gm', 1.10);

SELECT * FROM PRODUCT;