CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorization (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_authorization (
	user_id BIGINT(20) NOT NULL,
	authorization_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, authorization_id),
	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (authorization_id) REFERENCES authorization(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, email, password) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO user (id, name, email, password) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO authorization (id, description) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO authorization (id, description) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO authorization (id, description) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO authorization (id, description) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO authorization (id, description) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO authorization (id, description) values (6, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO authorization (id, description) values (7, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO authorization (id, description) values (8, 'ROLE_PESQUISAR_LANCAMENTO');

-- admin
INSERT INTO user_authorization (user_id, authorization_id) values (1, 1);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 2);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 3);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 4);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 5);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 6);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 7);
INSERT INTO user_authorization (user_id, authorization_id) values (1, 8);

-- maria
INSERT INTO user_authorization (user_id, authorization_id) values (2, 2);
INSERT INTO user_authorization (user_id, authorization_id) values (2, 5);
INSERT INTO user_authorization (user_id, authorization_id) values (2, 8);
