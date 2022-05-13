CREATE TABLE tb_cidade(
    id BIGINT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    qtd_habitantes BIGINT

);

INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (1, 'São Paulo', 12396372);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (2, 'Rio de Janeiro', 6748000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (3, 'Fortaleza', 2687000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (4, 'Salvador', 7000000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (5, 'Belo Horizonte', 6000000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (6, 'Porto Alegre', 7000000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (7, 'Porto Velho', 494898);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (8, 'Palmas', 7878790);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (9, 'Recife', 2323478);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (10, 'Natal', 7852964);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (11, 'Brasilia', 1000000);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (12, 'Vitoria', null);
INSERT INTO tb_cidade (id, nome, qtd_habitantes) VALUES (13, 'Curitiba', null);