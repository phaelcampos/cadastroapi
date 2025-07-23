-- V2: Migration para adicionar a coluna de RANK na tabela de cadastros

ALTER TABLE tb_user
ADD COLUMN rank VARCHAR(255)