DROP TABLE JardenAccount;

CREATE TABLE JardenAccount (
    userName VARCHAR(20) NOT NULL PRIMARY KEY,
    password VARCHAR(20) NOT NULL,
    balance FLOAT NOT NULL
);

DELETE FROM JardenAccount;

INSERT INTO JardenAccount (userName, password, balance) values
	('john', 'john', 1000),
	('sam', 'sam', 1000),
	('joe', 'joe', 1000),
	('julie', 'julie', 1000);
