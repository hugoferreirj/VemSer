CREATE TABLE VEM_SER.PESSOA (
  id_pessoa NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  data_nascimento DATE NOT NULL,
  telefone VARCHAR2(14),
  idade NUMBER(3) NOT NULL,
  altura DECIMAL(4,2) NOT NULL,
  cpf CHAR(11) UNIQUE NOT NULL,
  PRIMARY KEY(id_pessoa)
);



-- Inserção
INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(4, 'Miguel Machado', TO_DATE('01-01-1990', 'dd-mm-yyyy'), '51999999999', 30, 1.85, '12345678999');
INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(2, 'Mayra', TO_DATE('01-01-1990', 'dd-mm-yyyy'), '51999994599', 21, 1.35, '12345673459');
INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(3, 'Katya', TO_DATE('01-01-2002', 'dd-mm-yyyy'), '51999876599', 31, 1.35, '33345673459');
INSERT INTO VEM_SER.PESSOA (id_pessoa, nome, data_nascimento, telefone, idade, altura, cpf)
VALUES(5, 'Mario Vergara', TO_DATE('01-01-1990', 'dd-mm-yyyy'), '51999999999', 30, 1.85, '12095678999');


-- Seleção
SELECT * FROM VEM_SER.PESSOA;

-- Atualização
UPDATE VEM_SER.PESSOA
SET idade = (idade + 1);

-- Deleção
DELETE FROM VEM_SER.PESSOA WHERE id_pessoa = 5;

-- Seleção
SELECT * FROM VEM_SER.PESSOA;

