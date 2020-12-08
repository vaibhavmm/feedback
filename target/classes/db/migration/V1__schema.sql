CREATE TABLE IF NOT EXISTS item(
id SERIAL PRIMARY KEY,
name VARCHAR(50),
timestamp TIMESTAMP
);
CREATE TABLE IF NOT EXISTS product_wise_rating(
id serial,
item_id INT,
user_id INT,
rating INT,
timestamp TIMESTAMP NOT NULL,
PRIMARY KEY(item_id,user_id)
);

INSERT INTO item(name) values ('Lab Test Order');
INSERT INTO item(name) values ('Mindfulness');
INSERT INTO item(name) values ('CarePlan');
INSERT INTO item(name) values ('WellBeing');
INSERT INTO item(name) values ('COVID-19');

