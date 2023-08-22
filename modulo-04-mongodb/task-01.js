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
