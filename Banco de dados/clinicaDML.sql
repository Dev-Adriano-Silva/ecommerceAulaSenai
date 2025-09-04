--DML (Data Manipulation Language)
-- INSERT (CADASTRAR)
--UPDATE (ATUALIZAR)
-- REMOVE (Apaga)

--opcional
--SET search_path TO clinica;
-- clinica.paciente -> paciente

--INSERT inserir em <SCHEMA> <TABELA>
INSERT INTO clinica.medico (nome, especialidade, crm) VALUES
('Vinicio', 'Ortopedia', '123456'),
('Ariel', 'cardiologia', '159753'),
('syu', 'pediatra', '753159'),
('fernando', 'ortopedia', '362401')

--DQL (Data query language)- linguagem de consulta de dados

--SELECT
--SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente(nome, idade, data_nascimento) VALUES
('fulano', 23, '2002-07-20'),
('jorge', 30, '2002-08-10'),
('fulano', 23, '2005-12-19')

SELECT * FROM clinica.paciente

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('Clinicia Sao caetano', 'A clinica do ABC', 'Rua niteroi')

SELECT * FROM clinica.clinica


INSERT INTO clinica.consulta(data,valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-25 09:30:00-03', 350.75, 1, 1, 2 )

SELECT * FROM clinica.consulta


--UPDATE
UPDATE clinica.consulta
SET valor = 200.50
WHERE id_consulta = 1

UPDATE clinica.consulta
SET valor = 530
WHERE valor > 500 AND valor < 1000;
--					or


DELETE FROM clinica.paciente
WHERE id_paciente = 4;

DELETE FROM clinica.paciente
WHERE id_paciente = 5;

DELETE FROM clinica.paciente
WHERE id_paciente = 6;

