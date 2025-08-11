DROP TABLE IF EXISTS cliente;

DROP TABLE IF EXISTS tb_produto;

CREATE TABLE tb_produto(
    id bigint PRIMARY KEY,
    codigo varchar(10) NOT NULL UNIQUE,
    nome varchar(50) NOT NULL,
    descricao varchar(100) NOT NULL,
    valor numeric(10,2) NOT NULL,
    categoria varchar(50)
);

CREATE SEQUENCE sq_produto
START 1
INCREMENT 1
OWNED BY tb_produto.id;

INSERT INTO cliente (cpf, nome, tel, endereco, numero, cidade, estado) VALUES
('111.111.111-11', 'João Silva', '11999999999', 'Rua A', '100', 'São Paulo', 'SP'),
('222.222.222-22', 'Maria Souza', '21988888888', 'Avenida B', '200', 'Rio de Janeiro', 'RJ'),
('333.333.333-33', 'Carlos Oliveira', '31977777777', 'Travessa C', '300', 'Belo Horizonte', 'MG');

SELECT * FROM cliente;