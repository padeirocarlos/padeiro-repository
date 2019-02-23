CREATE TABLE person (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	logradouro VARCHAR(255) NOT NULL,
	number VARCHAR(255) NOT NULL,
	complemento VARCHAR(255) NOT NULL,
	outcountry VARCHAR(255) NOT NULL,
	cep VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
	state VARCHAR(255) NOT NULL,
	active VARCHAR(1) NOT NULL	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO person (name,logradouro,number,complemento,outcountry,cep,city,state,active) values ('Luis','Logra Douro','NUMER','Complemento QUELMANE','50MT','125_CEP','QUELIMANE','state',1);
INSERT INTO person (name,logradouro,number,complemento,outcountry,cep,city,state,active) values ('Nito','Logra Douro','NUMER','Complemento QUELMANE','50MT','125_CEP','QUELIMANE','state',1);
INSERT INTO person (name,logradouro,number,complemento,outcountry,cep,city,state,active) values ('Carlos','Logra Douro','NUMER','Complemento QUELMANE','50MT','125_CEP','QUELIMANE','state',1);
INSERT INTO person (name,logradouro,number,complemento,outcountry,cep,city,state,active) values ('Marcelino','Logra Douro','NUMER','Complemento QUELMANE','50MT','125_CEP','QUELIMANE','state',1);
INSERT INTO person (name,logradouro,number,complemento,outcountry,cep,city,state,active) values ('sergio','Logra Douro','NUMER','Complemento QUELMANE','50MT','125_CEP','QUELIMANE','state',1);