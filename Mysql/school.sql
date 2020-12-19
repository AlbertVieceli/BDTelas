create database school;
use school;
-- drop database school;

CREATE TABLE cursos (
    cod_curso INTEGER NOT NULL,
    nome_curso VARCHAR(30),
    tipo_curso VARCHAR(30),
    carga_h_curso INTEGER,
    cod_instituto INTEGER,
    PRIMARY KEY (cod_curso)
);

insert into cursos values
(1, 'Administração de Empresas', 'Bacharel', 360, 111),
(2, 'BioMedicina', 'Mestrado', 550, 222),
(3, 'Ciencias da Computação', 'Mestrado', 440, 333),
(4, 'Ciencias Sociais', 'Gestão', 404, 222);

CREATE TABLE professores (
    iden_prof INTEGER NOT NULL,
    nome_prof VARCHAR(30),
    rua_prof VARCHAR(30),
    bairro_prof VARCHAR(30),
    cidade_prof VARCHAR(30),
    estado_prof VARCHAR(30),
    espec_prof VARCHAR(30),
    titulo_prof VARCHAR(30),
    telefone_prof VARCHAR(12),
    data_nascim DATE,
    PRIMARY KEY (iden_prof)
);

insert into professores(iden_prof,nome_prof,rua_prof,bairro_prof,cidade_prof,estado_prof,
espec_prof,titulo_prof, telefone_prof, data_nascim)
values
(1,'José Valdo','rua osasco 121', 'central','São Paulo',
'São Paulo','Matemática',
'Doutorado', '444444444', '1988-01-10'),
(4,'Maria Francisca','rua Guarulhos 600', 'Brasilandia','Campinas',
'São Paulo','História',
'Mestrado', '111111111', '1990-08-17'),
(8,'Marcelo Chico','Av Longo 1001', 'Suldão','Belo Horizonte',
'Minas Gerais','Matemática',
'Mestrado', '222222222', '1970-12-22'),
(24,'Marcão Bulhões','rua Central 69', 'ABC','São Paulo',
'São Paulo','Geologia',
'Doutorado', '333333333', '1977-03-16'),
(12,'Ana Julia','rua Leste 999', 'Osasco','São Paulo',
'São Paulo','Biologia',
'Doutorado', '355599933', '1988-05-26'),
(11,'Roberta Paiva','rua Norte 999', 'Jabaquara','São Paulo',
'São Paulo','Química',
'Doutorado', '355599666', '1990-11-07');


CREATE TABLE disciplinas (
    cod_disc INTEGER NOT NULL,
    cod_curso INTEGER not null ,
    iden_prof INTEGER not null ,
    nome_disc VARCHAR(30),
    carga_horaria INTEGER,
    aulas_semana INTEGER,
    PRIMARY KEY (cod_disc),
    foreign key (cod_curso)
		REFERENCES cursos(cod_curso),
	foreign key (iden_prof)
		references professores(iden_prof)
);

insert into disciplinas values
(1,1,1,'Algebra',60,4),
(2,4,24,'Geografia',30,2),
(3,3,8,'Calculo 1',60,4),
(4,4,4,'História',45,3),
(5,2,11,'Química',40,2),
(7,2,12,'Fisionomia',50,3),
(8,1,8,'Fisica',50,3);



CREATE TABLE alunos (
    matricula INTEGER NOT NULL,
    nome_aluno VARCHAR(30),
    data_nascimento DATE,
    cod_curso INTEGER,
    nome_curso VARCHAR(30),
    cod_disc INTEGER,
    nome_disc VARCHAR(30),
    nota_P1 FLOAT,
    nota_P2 FLOAT,
    media FLOAT,
    faltas INTEGER,
    PRIMARY KEY (matricula),
    FOREIGN KEY (cod_curso)
        REFERENCES cursos (cod_curso),
	FOREIGN KEY (cod_disc)
        REFERENCES disciplinas (cod_disc)
);

insert into alunos (matricula, nome_aluno, data_nascimento, cod_curso, nome_curso, cod_disc, nome_disc, 
nota_P1, nota_P2, media, faltas) 
values
(1, 'Paulo tacioli', '2001-06-03', 1, 'Administração de Empresas', 1, 'Algebra', 8, 6, (nota_P1 + nota_P2)/2, 0),
(2, 'Felipe de Sousa', '1200-04-12', 3, 'Ciencias da Computação', 3, 'Calculo 1', 2, 9, (nota_P1 + nota_P2)/2, 6),
(3, 'Vinicius Albert', '2001-05-22', 2, 'BioMedicina', 5, 'Química', 6, 10, (nota_P1 + nota_P2)/2, 4),
(4, 'Rogerinho de Ingá', '2001-05-22', 2, 'BioMedicina', 7, 'Fisionomia', 6, 10, (nota_P1 + nota_P2)/2, 3);

CREATE TABLE logins (
    login VARCHAR(15) NOT NULL UNIQUE,
    senha VARCHAR(15) NOT NULL
);

insert into logins values('admin','admin');

SELECT * FROM professores;

SELECT * FROM disciplinas;

SELECT * FROM alunos;

SELECT * FROM cursos;

-- VIEW Cursos/Professores
select p.iden_prof, p.nome_prof,d.cod_disc,d.nome_disc, c.cod_curso, c.nome_curso
from professores p inner join disciplinas d
on d.iden_prof = p.iden_prof inner join  cursos c
on d.cod_curso = c.cod_curso;
-- VIEW Cursos/Disciplinas
select c.cod_curso, c.nome_curso, c.carga_h_curso, d.cod_disc, d.nome_disc,d.aulas_semana
from cursos c inner join disciplinas d
on c.cod_curso = d.cod_curso;
-- VIEW Professores/Disciplinas
select p.iden_prof, p.nome_prof, p.espec_prof,d.cod_disc, d.nome_disc, d.aulas_semana
from professores p inner join disciplinas d
on p.iden_prof = d.iden_prof;
-- VIEW Alunos/Disciplinas
select a.matricula, a.nome_aluno, a.cod_curso, a.nome_curso, a.nome_disc, d.cod_disc, d.carga_horaria, d.aulas_semana
from alunos a inner join disciplinas d
on a.cod_disc = d.cod_disc;
