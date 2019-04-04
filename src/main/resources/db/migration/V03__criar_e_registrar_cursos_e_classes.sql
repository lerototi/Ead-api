CREATE TABLE curso(
	id_curso BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	curso VARCHAR(45) NOT NULL,
	valor DECIMAL(7,2) NOT NULL,
	descricao VARCHAR(150),
	max_alunos int,
	acesso VARCHAR(10),
	criacao DATETIME NOT NULL,
	termino DATETIME,
	lancamento DATETIME,
	ativo BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE curso_usuario(
	id_curso_usuario BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	fk_usuario BIGINT(20) NOT NULL,
	fk_curso BIGINT(20) NOT NULL,
	pago BOOLEAN NOT NULL,
	valor DECIMAL(7,2),
	data_pagamento DATETIME,
	promo VARCHAR(15),
	CONSTRAINT fk_pessoa_curso_usuario FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario),
	CONSTRAINT fk_curso_curso_usuario FOREIGN KEY (fk_curso) REFERENCES curso (id_curso)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE classe(
	id_classe BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nome VARCHAR(35) NOT NULL,
	data_criacao DATETIME NOT NULL,
	quantidade_max_alunos INT
)ENGINE=InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE curso_classe(
	id_curso_classe BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	fk_classe BIGINT(20) NOT NULL,
	fk_curso BIGINT(20) NOT NULL,
	fk_usuario_criador BIGINT(20) NOT NULL,
	data_registro DATETIME NOT NULL,
	CONSTRAINT fk_classe_curso_classe FOREIGN KEY (fk_classe) REFERENCES classe (id_classe),
	CONSTRAINT fk_curso_curso_classe FOREIGN KEY (fk_curso) REFERENCES curso (id_curso),
	CONSTRAINT fk_usuario_curso_classe FOREIGN KEY (fk_usuario_criador) REFERENCES usuario(id_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE classe_aula(
	id_classe_aula BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	fk_classe BIGINT(20) NOT NULL,
	fk_aula BIGINT(20) NOT NULL,
	fk_usuario BIGINT(20) NOT NULL,
	data_registro DATETIME NOT NULL,
	CONSTRAINT fk_classe_classe_aula FOREIGN KEY (fk_classe) REFERENCES classe (id_classe),
	CONSTRAINT fk_aula_classe_aula FOREIGN KEY (fk_aula) REFERENCES aula (id_aula),
	CONSTRAINT fk_usuario_classe_aula FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO classe(nome, data_criacao, quantidade_max_alunos) VALUES ("Classe de Força", CURRENT_TIMESTAMP(), 100);
INSERT INTO classe(nome, data_criacao, quantidade_max_alunos) VALUES ("Classe de Flexibilidade", CURRENT_TIMESTAMP(), 100);
INSERT INTO classe(nome, data_criacao, quantidade_max_alunos) VALUES ("Yoga", CURRENT_TIMESTAMP(), 15);

INSERT INTO curso(curso, valor, descricao, max_alunos, acesso, criacao, termino, lancamento, ativo) VALUES ("Corpo e ação", 157.00, null, 10, "restrito", CURRENT_TIMESTAMP(), null, null, true);
INSERT INTO curso(curso, valor, descricao, max_alunos, acesso, criacao, termino, lancamento, ativo) VALUES ("Mente e ação", 120.00, null, 10, "privado", CURRENT_TIMESTAMP()+1, null, null, true);

INSERT INTO curso_usuario(fk_usuario, fk_curso, pago, valor, data_pagamento, promo) VALUES (1,1, true, 157, CURRENT_TIMESTAMP(), null);
INSERT INTO curso_usuario(fk_usuario, fk_curso, pago, valor, data_pagamento, promo) VALUES (1,2, true, 108, CURRENT_TIMESTAMP(), "dezporcento");
INSERT INTO curso_usuario(fk_usuario, fk_curso, pago, valor, data_pagamento, promo) VALUES (2,2, true, 120, CURRENT_TIMESTAMP(), null);

INSERT INTO curso_classe(fk_classe, fk_curso, fk_usuario_criador, data_registro) VALUES (1,1,1,CURRENT_TIMESTAMP());
INSERT INTO curso_classe(fk_classe, fk_curso, fk_usuario_criador, data_registro) VALUES (2,1,1,CURRENT_TIMESTAMP());
INSERT INTO curso_classe(fk_classe, fk_curso, fk_usuario_criador, data_registro) VALUES (3,2,1,CURRENT_TIMESTAMP());