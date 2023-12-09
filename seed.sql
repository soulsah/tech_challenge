-- Inserir dados de exemplo
INSERT INTO Cliente (ID, CPF, Nome, Email)
VALUES (1, '12345678900', 'Guilherme', 'guilherme@email.com');

-- Inserir dados de exemplo
INSERT INTO Pedido (ID, Cliente_ID, Status)
VALUES (1, 1, 1);

INSERT INTO Produto (ID, Tipo, Descricao, Preco)
VALUES
    (1, 1, 'X-Bacon', 20.00),
    (2, 2, 'Batata Frita', 5.00),
    (3, 3, 'Coca-Cola', 7.00);


INSERT INTO TipoProduto (ID, Descricao)
VALUES
    (1, 'Lanche'),
    (2, 'Acompanhamento'),
    (3, 'Bebida');

INSERT INTO StatusPedido (ID, Descricao)
VALUES
    (1, 'Recebido'),
    (2, 'Em Preparação'),
    (3, 'Pronto'),
    (4, 'Finalizado');