DROP TABLE PRODUCT;

CREATE TABLE Product (
	ident INTEGER IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(100),
    price FLOAT NOT NULL
);

CREATE INDEX ProductIndex
ON Product (name);

INSERT INTO Product (name, description, price) values
	('brazil nuts', 'Brazils; 100gm', 1.30),
	('peanuts', 'Ground nuts; 200gm', 0.95),
	('hazelnuts', 'Loved by squirrels and cadburys; 50gm', 1.10);
