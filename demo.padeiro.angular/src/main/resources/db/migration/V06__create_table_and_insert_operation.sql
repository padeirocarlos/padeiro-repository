CREATE TABLE operation (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	validaty_date DATE NOT NULL,
	payment_date DATE,
	value DECIMAL(10,2) NOT NULL,
	observation VARCHAR(100),
	operation_type VARCHAR(20) NOT NULL,
	category_id BIGINT(20) NOT NULL,
	person_id BIGINT(20) NOT NULL,
	FOREIGN KEY (category_id) REFERENCES category(code),
	FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 0, 1, 1);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 1, 2, 2);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Top Club', '2017-06-10', null, 120, null, 0, 3, 3);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 0, 3, 4);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('DMAE', '2017-06-10', null, 200.30, null, 1, 3, 5);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 0, 4, 6);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Bahamas', '2017-06-10', null, 500, null, 1, 1, 7);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 1, 4, 8);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 1, 3, 3);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 0, 5, 5);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Café', '2017-06-10', null, 8.32, null, 0, 1, 6);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 1, 5, 4);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 1, 4, 3);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 1, 4, 2);
INSERT INTO operation (description,validaty_date,payment_date,value,observation,operation_type,category_id,person_id) values ('Lanche', '2017-06-10', null, 10.20, null, 1, 4, 1);

