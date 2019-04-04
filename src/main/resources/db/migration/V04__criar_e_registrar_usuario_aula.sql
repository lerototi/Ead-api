CREATE TABLE usuario_assiste_aulas(
	id_usuario_assiste_aulas BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
	fk_aula BIGINT(20) NOT NULL,
	fk_usuario BIGINT(20) NOT NULL,
	data_aula_iniciada DATETIME,
	data_aula_completa DATETIME,
	aula_iniciada BOOLEAN,
	aula_completa BOOLEAN,
	CONSTRAINT fk_aula_usuario_assiste_aulas FOREIGN KEY (fk_aula) REFERENCES aula (id_aula),
	CONSTRAINT fk_usuario_usuario_assiste_aulas FOREIGN KEY (fk_usuario) REFERENCES usuario(id_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;