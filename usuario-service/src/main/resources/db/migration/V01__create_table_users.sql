create schema if not exists usuarios;
create table usuarios.usuario(
	id varchar(200) not null primary key,
	nome varchar(100) not null,
	endereco varchar(100),
	cpf varchar(30)
);