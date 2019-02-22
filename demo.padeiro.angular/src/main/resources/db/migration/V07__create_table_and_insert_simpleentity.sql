CREATE TABLE SIMPLE_ENTITY (
	ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	CODE VARCHAR(255) NOT NULL,
	DESCRIPTION VARCHAR(255) NOT NULL,
	TYPE VARCHAR(255) NOT NULL,
	REMARK VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO SIMPLE_ENTITY (code,description,type,remark) values ('SL', 'Salario','country',null);
INSERT INTO SIMPLE_ENTITY (code,description,type,remark) values ('MZ','Moçambique', 'country', null);
INSERT INTO SIMPLE_ENTITY (code,description,type,remark) values ('TC', 'Top Club', 'country', null);
INSERT INTO SIMPLE_ENTITY (code,description,type,remark) values ('CEMIG', 'CEMIG', 'country', 'Geração');
INSERT INTO SIMPLE_ENTITY (code,description,type,remark) values ('DMAE', 'DMAE', 'country', null);

