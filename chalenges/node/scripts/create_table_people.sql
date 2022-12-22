CREATE TABLE people(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    sex CHAR(1),
    age INT,
    PRIMARY KEY (id)
);

INSERT INTO people(name, age, sex)
VALUES ('Fredson', 28, 'M');

INSERT INTO people(name, age, sex)
VALUES ('Ana', 20, 'F');

INSERT INTO people(name, age, sex)
VALUES ('Maria', 19, 'F');

INSERT INTO people(name, age, sex)
VALUES ('Joaquim', 32, 'M');