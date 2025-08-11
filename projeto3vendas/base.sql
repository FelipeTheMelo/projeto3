CREATE TABLE tb_cliente (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf BIGINT NOT NULL UNIQUE,
    tel BIGINT NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    numero BIGINT NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    data_nascimento DATE -- Se quiser incluir data de nascimento
);

-- Tabela Produto com novo campo categoria
CREATE TABLE tb_produto (
    id BIGINT PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    categoria VARCHAR(150) -- novo campo categoria
);

-- Tabela Venda
CREATE TABLE tb_venda (
    id BIGINT PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    id_cliente_fk BIGINT NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL,
    data_venda TIMESTAMPTZ NOT NULL,
    status_venda VARCHAR(50) NOT NULL,
    CONSTRAINT fk_id_cliente_venda FOREIGN KEY (id_cliente_fk) REFERENCES tb_cliente(id)
);

-- Tabela Produto_Quantidade (item da venda)
CREATE TABLE tb_produto_quantidade (
    id BIGINT PRIMARY KEY,
    id_produto_fk BIGINT NOT NULL,
    id_venda_fk BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_id_produto_quantidade_produto FOREIGN KEY (id_produto_fk) REFERENCES tb_produto(id),
    CONSTRAINT fk_id_produto_quantidade_venda FOREIGN KEY (id_venda_fk) REFERENCES tb_venda(id)
);

-- Sequências
CREATE SEQUENCE sq_cliente START 1 INCREMENT 1 OWNED BY tb_cliente.id;
CREATE SEQUENCE sq_produto START 1 INCREMENT 1 OWNED BY tb_produto.id;
CREATE SEQUENCE sq_venda START 1 INCREMENT 1 OWNED BY tb_venda.id;
CREATE SEQUENCE sq_produto_quantidade START 1 INCREMENT 1 OWNED BY tb_produto_quantidade.id;