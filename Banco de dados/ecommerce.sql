CREATE SCHEMA ecommerce;

CREATE TABLE ecommerce.produto(
	id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_produto TEXT NOT NULL,
	descricao TEXT NOT NULL,
	preco NUMERIC NOT NULL,
	estoque_disponivel INT NOT NULL,
	imagem_url TEXT NOT NULL
);

CREATE TABLE ecommerce.cliente(
	id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone TEXT NOT NULL,
	data_cadastro TIMESTAMPTZ NOT NULL
);

CREATE TABLE ecommerce.pedido(
	id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_cliente int REFERENCES ecommerce.cliente(id_cliente),
	data_pedido TIMESTAMPTZ NOT NULL,
	valor_total NUMERIC (18,4) NOT NULL,
	status TEXT
);

CREATE TABLE ecommerce.pagamento(
	id_pagamento INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT REFERENCES ecommerce.pedido(id_pedido),
	status TEXT,
	data_pagamento DATE
);

CREATE TABLE ecommerce.item_do_pedido(
	id_item TEXT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT REFERENCES ecommerce.pedido(id_pedido),
	id_produto INT REFERENCES ecommerce.produto(id.produto),
	quantidade INT
);