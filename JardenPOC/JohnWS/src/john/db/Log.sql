DROP TABLE JohnLog;

CREATE TABLE JohnLog (
    ident INTEGER IDENTITY NOT NULL PRIMARY KEY,
    owner VARCHAR(30),
    message VARCHAR(256) NOT NULL,
    createTime TIMESTAMP NOT NULL
);

CREATE INDEX JohnLogIndex
ON JohnLog (owner);
