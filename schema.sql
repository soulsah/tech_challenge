CREATE DATABASE  tech_challenge;

-- Connect to the newly created database
\c tech_challenge;


-- Drop tables if they exist with CASCADE
DROP TABLE IF EXISTS tb_cliente CASCADE;
DROP TABLE IF EXISTS tb_pedido CASCADE;
DROP TABLE IF EXISTS tb_itens_pedido CASCADE;
DROP TABLE IF EXISTS tb_produto CASCADE;
DROP TABLE IF EXISTS tb_tipo_produto CASCADE;
DROP TABLE IF EXISTS tb_status_pedido CASCADE;




CREATE TABLE tb_cliente (
    ID INT PRIMARY KEY,
    CPF VARCHAR(11) UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255)
);


CREATE TABLE tb_pedido (
    ID INT PRIMARY KEY,
    Cliente_ID INT,
    Status INT,
    FOREIGN KEY (Cliente_ID) REFERENCES Cliente(ID)
);


CREATE TABLE tb_itens_pedido (
    Pedido_ID INT,
    Produto INT,
    Quantidade INT,
    PRIMARY KEY (Pedido_ID, Produto),
    FOREIGN KEY (Pedido_ID) REFERENCES Pedido(ID)
);

CREATE TABLE tb_produto (
    ID INT PRIMARY KEY,
    Tipo INT,
    Descricao VARCHAR(255),
    Preco DECIMAL(10, 2)
);

CREATE TABLE tb_tipo_produto (
    ID INT PRIMARY KEY,
    Descricao VARCHAR(255) NOT NULL
);

CREATE TABLE tb_status_pedido (
    ID INT PRIMARY KEY,
    Descricao VARCHAR(255) NOT NULL
);


