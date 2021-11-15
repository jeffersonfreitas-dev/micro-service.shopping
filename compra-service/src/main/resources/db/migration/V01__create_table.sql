create schema if not exists compras;

create table compras.compra (
	id bigserial primary key,
	user_id varchar(100) not null,
	date timestamp not null,
	total float not null
);

create table compras.item (
	id_compra bigserial references compras.compra(id),
	produto_id varchar(100) not null,
	preco float not null
);