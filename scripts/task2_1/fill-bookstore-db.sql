CREATE TABLE IF NOT EXISTS book (id INTEGER NOT NULL AUTO_INCREMENT,title VARCHAR(50),author VARCHAR (20),price DECIMAL(5,2), PRIMARY KEY(id));
INSERT INTO book(id,title,author,price) VALUES (null,"Sherlock Holmes","Arthur Conan Doyle",25.63);
INSERT INTO book(id,title,author,price) VALUES (null, "The Three Musketeers", "Alexandre Dumas",16.45);
INSERT INTO book(id,title,author,price) VALUES (null, "The Adventures of Tom Sawyer", "Mark Twain",30.25);
INSERT INTO book(id,title,author,price) VALUES (null, "Winnie The Pooh", "A. A. Milne",18.35);
INSERT INTO book(id,title,author,price) VALUES (null, "Alice Adventures in Wonderland", "Lewis Carroll",20.45);
CREATE TABLE IF NOT EXISTS publishers (id INTEGER NOT NULL AUTO_INCREMENT,name VARCHAR(50),PRIMARY KEY (id));