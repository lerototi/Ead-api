CREATE TABLE usuario(
	id_usuario BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	login VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	senha VARCHAR(20) NOT NULL,
	cadastro datetime NOT NULL,
	ativo boolean NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pessoa(
	id_pessoa BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	telefone VARCHAR (19) NOT NULL,
	nascimento datetime NOT NULL,
	logradouro VARCHAR(150),
	numero INT(6),
	complemento VARCHAR(70),
	cep VARCHAR(10),
	fk_usuario BIGINT(20) NOT NULL,
	CONSTRAINT fk_usuario_pessoa
	FOREIGN KEY (fk_usuario)
	REFERENCES usuario (id_usuario)
	ON DELETE RESTRICT
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (login, email, senha, cadastro, ativo) values ("leroto", "lerototi@gmail.com", "1234", CURRENT_TIMESTAMP(), true);
INSERT INTO usuario (login, email, senha, cadastro, ativo) values ("carolcidade", "carolcidade@gmail.com", "1234", CURRENT_TIMESTAMP(), true);

INSERT INTO pessoa (nome, sobrenome, cpf, telefone, nascimento, logradouro, numero, complemento, cep, fk_usuario)
values ("Leonardo", "Torres", "736.208.311-49", "(61) 99848-7797", "1989-08-07", "Av. Pernambuco casa A1", 1, "casa da varanda", null, 1);

INSERT INTO pessoa (nome, sobrenome, cpf, telefone, nascimento, logradouro, numero, complemento, cep, fk_usuario)
values ("Carolina", "Cidade", "000.000.000-00", "(61) 99000-0000", "1992-02-24", "SQN 110 Ed. Morumbi", 202, null, null, 2);

