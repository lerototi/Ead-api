CREATE TABLE aula(
	id_aula BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	url VARCHAR(200),
	texto VARCHAR(1500),
	data datetime,
	fk_aula_pai BIGINT(20)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE aula ADD CONSTRAINT FOREIGN KEY (fk_aula_pai) REFERENCES aula (id_aula);

INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('Flexibilidade','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), null);
INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('alongamentos Inferiores','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), 1);
INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('alongamentos Superiores','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), 1);
INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('Fortalecimento','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), null);
INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('Abdomen','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), 4);
INSERT INTO aula (nome, url, texto, data, fk_aula_pai) values ('Lombar','https://www.youtube.com/watch?v=MYG1rpah2lw', null, CURRENT_TIMESTAMP(), 4);






