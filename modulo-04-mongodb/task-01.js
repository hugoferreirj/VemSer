-- Criar bd
use vemserdbc

-- Criar collection
db.createCollection("alunos")

-- Inserir
db.alunos.insertMany([
    {
        "nome" : "Hugo",
        "data_nascimento" : new Date (2002,05,09)
    },
    {
        "nome" : "Mayra",
        "data_nascimento" : new Date (2002,12,07)
    },
    {
        "nome" : "Leticia",
        "data_nascimento" : new Date (2004,05,27)
    },
    {
        "nome" : "Rafael",
        "data_nascimento" : new Date (2001,06,01)
    },
    {
        "nome" : "Kassia",
        "data_nascimento" : new Date (2002,07,09)
    }]
)

-- Operacao 1
db.alunos.find({"nome": /ia/})

-- saida
{
  _id: ObjectId("64e533fea56c871f97cb3df7"),
  nome: 'Leticia',
  data_nascimento: 2004-06-27T03:00:00.000Z
}
{
  _id: ObjectId("64e533fea56c871f97cb3df9"),
  nome: 'Kassia',
  data_nascimento: 2002-08-09T03:00:00.000Z
}

-- Operacao 2

db.alunos.find({
  $expr: {
    $eq: [{ $year: "$data_nascimento" }, 2002]
  }
})

-- saida
{
  _id: ObjectId("64e533fea56c871f97cb3df5"),
  nome: 'Hugo',
  data_nascimento: 2002-06-09T03:00:00.000Z
}
{
  _id: ObjectId("64e533fea56c871f97cb3df9"),
  nome: 'Kassia',
  data_nascimento: 2002-08-09T03:00:00.000Z
}


-- Operacao 3

db.alunos.find({
  $expr: {
    $eq: [{ $dayOfMonth: "$data_nascimento" }, 09]
  }
})

-- saída
{
  _id: ObjectId("64e533fea56c871f97cb3df5"),
  nome: 'Hugo',
  data_nascimento: 2002-06-09T03:00:00.000Z
}
{
  _id: ObjectId("64e533fea56c871f97cb3df9"),
  nome: 'Kassia',
  data_nascimento: 2002-08-09T03:00:00.000Z
}
