CREATE TABLE IF NOT EXISTS customer(id integer not null auto_increment primary key,name varchar(20),address varchar(50),age integer,job varchar(20)) engine=ndb;
INSERT INTO customer VALUES (null,"John","street24",23,"programmer");
INSERT INTO customer VALUES (null,"Kate","street18",25,"system administrator");
