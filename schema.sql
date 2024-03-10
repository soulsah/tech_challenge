CREATE DATABASE tech_challenge;

-- Connect to the newly created database
\c tech_challenge;

-- Drop tables if they exist with CASCADE
DROP TABLE IF EXISTS tb_cliente CASCADE;
DROP TABLE IF EXISTS tb_pedido CASCADE;
DROP TABLE IF EXISTS tb_itens_pedido CASCADE;
DROP TABLE IF EXISTS tb_produto CASCADE;
DROP TABLE IF EXISTS tb_tipo_produto CASCADE;
DROP TABLE IF EXISTS tb_status_pedido CASCADE;
DROP TABLE IF EXISTS tb_fila_pedidos CASCADE;
DROP TABLE IF EXISTS tb_cartao CASCADE;

CREATE TABLE tb_tipo_produto (
                                 ID SERIAL PRIMARY KEY,
                                 Descricao VARCHAR(255) NOT NULL
);

CREATE TABLE tb_status_pedido (
                                  ID SERIAL PRIMARY KEY,
                                  Descricao VARCHAR(255) NOT NULL
);

CREATE TABLE tb_cliente (
                            ID SERIAL PRIMARY KEY,
                            CPF VARCHAR(11) UNIQUE NOT NULL,
                            Nome VARCHAR(255) NOT NULL,
                            Email VARCHAR(255)
);

CREATE TABLE tb_produto (
                            ID SERIAL PRIMARY KEY,
                            Tipo INT,
                            Descricao VARCHAR(255),
                            Preco DECIMAL(10, 2)
);

CREATE TABLE tb_pedido (
                           ID SERIAL PRIMARY KEY,
                           Cliente_ID INT,
                           Status INT,
                           FOREIGN KEY (Cliente_ID) REFERENCES tb_cliente(ID)
);

CREATE TABLE tb_itens_pedido (
                                 Pedido_ID INT,
                                 Produto INT,
                                 Quantidade INT,
                                 PRIMARY KEY (Pedido_ID, Produto),
                                 FOREIGN KEY (Pedido_ID) REFERENCES tb_pedido(ID)
);

CREATE TABLE tb_fila_pedidos (
                                 Pedido_ID SERIAL PRIMARY KEY,
                                 Cliente_ID INT,
                                 Status INT,
                                 criado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (Cliente_ID) REFERENCES tb_cliente(ID)
);

CREATE TABLE tb_cartao
(
    id              SERIAL PRIMARY KEY,
    numero_cartao   VARCHAR(255) NOT NULL,
    detentor_cartao VARCHAR(255) NOT NULL,
    data_expiracao  VARCHAR(10)  NOT NULL,
    cvv             VARCHAR(4)   NOT NULL,
    cliente_id      int          NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente (ID)
);
CREATE TABLE tb_pagamento (
                              id SERIAL PRIMARY KEY,
                              valor DOUBLE PRECISION NOT NULL,
                              status VARCHAR(255),
                              card_id int,
                              pedidoId int,
                              FOREIGN KEY (card_id) REFERENCES tb_cartao(id),
                              FOREIGN KEY (pedidoId) REFERENCES tb_pedido(id)
);
