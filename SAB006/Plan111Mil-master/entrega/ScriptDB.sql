
DROP DATABASE IF EXISTS siirdb;

CREATE DATABASE IF NOT EXISTS siirdb;

USE siirdb;


CREATE TABLE IF NOT EXISTS noticias (
		noticia_id int(50) NOT NULL AUTO_INCREMENT,
		fecha date NOT NULL,
		seccion varchar(20) NOT NULL,
		nombre varchar(50) NOT NULL,
		foto varchar(100) NOT NULL,
		volanta varchar(50) NOT NULL,
		titulo varchar(50) NOT NULL,
		copete varchar(200) NOT NULL,
		cuerpo varchar(500) NOT NULL,

		CONSTRAINT noticia_pk PRIMARY KEY (noticia_id)
);


CREATE TABLE IF NOT EXISTS usuario (
		email varchar(50) NOT NULL,
		nombre varchar(50) NOT NULL,
		apellido varchar(50) NOT NULL,
		calle varchar(50) NOT NULL,
		numero int(11) NOT NULL,
        contrasena varchar(50),
		usuario_id int(11) NOT NULL AUTO_INCREMENT,

		CONSTRAINT usuario_pk PRIMARY KEY (usuario_id)
);


INSERT INTO `usuario` (`email`, `nombre`, `apellido`, `calle`, `numero`, `usuario_id`,`contrasena`) VALUES
('juan@gmail.com','Juan', 'Perez', 'Calle', 123, 0,'1234');

INSERT INTO `siirdb`.`noticias`
(`noticia_id`,`fecha`, `seccion`, `nombre`, `foto`, `volanta`, `titulo`, `copete`, `cuerpo`)
VALUES (0, "2019/4/13", "Novedades", "Titular", "url", "Volanta", "Titular", "copete", "Cuerpo");

