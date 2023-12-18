-- Inserir dados de exemplo
INSERT INTO tb_cliente (CPF, Nome, Email)
VALUES ('12345678900', 'Guilherme', 'guilherme@email.com');

-- Inserir dados de exemplo
INSERT INTO tb_pedido (Cliente_ID, Status)
VALUES (1, 1);

INSERT INTO tb_produto (Tipo, Descricao, Preco)
VALUES
    (1, 'X-Bacon', 20.00),
    (2, 'Batata Frita', 5.00),
    (3, 'Coca-Cola', 7.00);

INSERT INTO tb_tipo_produto (Descricao)
VALUES
    ('Lanche'),
    ('Acompanhamento'),
    ('Bebida');

INSERT INTO tb_status_pedido (Descricao)
VALUES
    ('Recebido'),
    ('Em Preparação'),
    ('Pronto'),
    ('Finalizado');