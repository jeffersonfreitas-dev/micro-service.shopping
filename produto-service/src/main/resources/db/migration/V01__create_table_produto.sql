create schema if not exists produtos;
create table produtos.categoria(
	id bigserial primary key,
	nome varchar(100) not null
);

create table produtos.produto(
	id bigserial primary key,
	nome varchar(100) not null,
	preco float not null,
	descricao varchar(100),
	produto_id varchar(200),
	id_categoria bigserial,
	constraint fk_cat01 foreign key (id_categoria) references produtos.categoria(id)
);