DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tel VARCHAR(20),
    endereco VARCHAR(150),       -- renomeado de 'end' para 'endereco'
    numero VARCHAR(10),
    cidade VARCHAR(50),
    estado VARCHAR(2)
);

INSERT INTO cliente (cpf, nome, tel, endereco, numero, cidade, estado) VALUES
('111.111.111-11', 'João Silva', '11999999999', 'Rua A', '100', 'São Paulo', 'SP'),
('222.222.222-22', 'Maria Souza', '21988888888', 'Avenida B', '200', 'Rio de Janeiro', 'RJ'),
('333.333.333-33', 'Carlos Oliveira', '31977777777', 'Travessa C', '300', 'Belo Horizonte', 'MG');

SELECT * FROM cliente;