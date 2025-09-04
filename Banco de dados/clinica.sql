-- É um comentário!
/*
 Comentário de multiplas linhas!
*/
-- SET search_patch TO clinica
-- DDL - Criar - Create (Schema, Tabela)
CREATE SCHEMA clinica;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico (
	-- Informar Colunas 
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMÁRIA
	-- GENERATED ALWAYS AS IDENTITY - A CHAVE PRIMÁRIA
	-- É CRIADA AUTOMATICAMENTE
	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);

CREATE TABLE clinica.paciente (
	id_paciente INT PRIMARY KEY 
	GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade INT NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE clinica.clinica (
	id_clinica INT PRIMARY KEY 
	GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT
);

CREATE TABLE clinica.consulta (
	id_consulta INT PRIMARY KEY
	GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC (10, 4),
	-- Maneira Extensa
	id_medico INT NOT NULL,
	FOREIGN KEY (id_medico) 
	REFERENCES clinica.medico(id_medico),
	-- Maneira Abreviada
	id_clinica INT NOT NULL 
	REFERENCES clinica.clinica(id_clinica),
	id_paciente INT NOT NULL
	REFERENCES clinica.paciente(id_paciente)
);

--DDL - Comandos que Criam, Editam ou Removem Tabelas, COlunas, Schema, Banco de Dados
--CREATE <O QUE CRIAR>
--DROP <O QUE REMOVER>
--ALTER <O QUE EDITAR>

ALTER TABLE clinica.paciente
ADD COLUMN	CPF varchar(14) UNIQUE

--rENOMEAR COLUNA
ALTER TABLE clinica.paciente
RENAME TO novopaciente

--TRUNCATE - LIMPA A TABELA
--RESTART IDENTITY - reinicia a sequenia

--DML(linguagem de manipulacao de dados)
--insert <o que inserir>
--DELETE <o que excluir>
--UPDATE <o que atualizar>

--DQL(Linguagem de consulta de dados)
-- Visualizacao de dados
--SELECT - seleciona dados para serem visualizados