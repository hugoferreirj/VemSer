-- Criação da tabela
CREATE TABLE VEM_SER.ESTUDANTE (
  id NUMBER NOT NULL,
  nome VARCHAR2(200) NOT NULL,
  data_nascimento DATE NOT NULL,
  nr_matricula NUMBER(10) UNIQUE NOT NULL,
  ativo CHAR(1),
  PRIMARY KEY(id)
);

--Criação da Sequência
CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

-- Realização das Inserções no Banco
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'João Silva', TO_DATE('1995-03-15', 'YYYY-MM-DD'), 1234567890, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Maria Santos', TO_DATE('1998-08-22', 'YYYY-MM-DD'), 9876543210, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Pedro Lima', TO_DATE('1997-01-10', 'YYYY-MM-DD'), 4567890123, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Ana Oliveira', TO_DATE('1999-05-03', 'YYYY-MM-DD'), 7890123456, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Luiz Pereira', TO_DATE('1996-11-20', 'YYYY-MM-DD'), 2345678901, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Carla Costa', TO_DATE('1994-06-08', 'YYYY-MM-DD'), 5678901234, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Marcos Souza', TO_DATE('1993-09-27', 'YYYY-MM-DD'), 8901234567, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Lúcia Ribeiro', TO_DATE('2000-04-12', 'YYYY-MM-DD'), 1122334455, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Ricardo Mendes', TO_DATE('1992-07-18', 'YYYY-MM-DD'), 2233445566, 'S');
INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Fernanda Alves', TO_DATE('1991-12-05', 'YYYY-MM-DD'), 3344556677, 'S');


-- Selecionando os registros
SELECT *
FROM VEM_SER.ESTUDANTE;


