create database museu;

use museu;

 create table Obra (
       codigo integer not null auto_increment,
        autor varchar(255),
        classificacao varchar(255),
        dataCriacao date,
        descricao varchar(255),
        localProducao varchar(255),
        nome varchar(255),
        primary key (codigo)
);

    
create table Visita (
       codigo integer not null auto_increment,
        dataHoraEntrada datetime,
        dataHoraSaida datetime,
        idCartao bigint not null,
        valorEntrada double precision not null,
        visitante_idVisitante integer,
        primary key (codigo)
);
    
create table Visitante (
       DTYPE varchar(31) not null,
        idVisitante integer not null auto_increment,
        cpf varchar(255),
        email varchar(255),
        nome varchar(255),
        telefone varchar(255),
        documentoEscolar varchar(255),
        primary key (idVisitante)
);
    
alter table Visita 
add constraint FKn3qcf3gtrov3t9pk2g24qfheg 
foreign key (visitante_idVisitante) 
references Visitante (idVisitante);


create table usuario(
		usuId int primary key auto_increment,
		usuNome varchar(30) not null,
		usuSenha varchar(30) not null,
		usuTipo varchar(30) not null
);

create table sala(
    numero int primary key auto_increment,
    qtdVisitantes int,
    status varchar(30)
);

 create table Restaurador (
       cracha integer not null auto_increment,
        nome varchar(255),
        restauracao_codigo integer,
        primary key (cracha)
    );
    
alter table Restauracao 
       add constraint FK3nhj8312rmts5ngwp5qlf0q2l 
       foreign key (obra_codigo) 
       references Obra (codigo);
    
alter table Restauracao 
       add constraint FKcg53wlarann1xutliqf98c1yc 
       foreign key (restaurador_cracha) 
       references Restaurador (cracha);
    
alter table Restaurador 
       add constraint FK601wrl8jtjh208opm0nudutbe 
       foreign key (restauracao_codigo) 
       references Restauracao (codigo);


insert into sala
(qtdVisitantes, status) 
values (50,'LIVRE');

insert into sala
(qtdVisitantes, status) 
values (20,'LIVRE');

insert into sala
(qtdVisitantes, status) 
values (90,'LIVRE');

insert into 

insert into usuario
(usuNome, usuSenha, usuTipo) 
values ('Bruno', '123', 'Admin');

insert into Visitante
(cpf, email, nome, telefone, documentoEscolar, DTYPE) 
values ('123.456.789-09', 'joao.cleber@hotmail.com', 'João Cleber', '(11) 94002-8922', '1231212987', 'Estudante');

insert into Visitante
(cpf, email, nome, telefone, DTYPE) 
values ('252.239.842-34', 'jose.aug@gmail.com', 'José Augusto', '(11) 91234-5385', 'Visitante');

insert into Visitante
(cpf, email, nome, telefone, DTYPE) 
values ('498.765.351-23', 'mariacarlasouza@gmail.com', 'Maria Carla', '(11) 99438-5743', 'Visitante');

insert into Visitante
(cpf, email, nome, telefone, documentoEscolar, DTYPE) 
values ('763.447.594-98', 'gabilira@hotmail.com', 'Gabriela Lira', '(11) 97648-4341', '6358212987', 'Estudante');

insert into Visitante
(cpf, email, nome, telefone, documentoEscolar, DTYPE) 
values ('349.874.727-34', 'guilhermesil@gmail.com', 'Guilherme Silva', '(11) 99077-1584', '6387100987', 'Estudante');

insert into Visitante
(cpf, email, nome, telefone, documentoEscolar, DTYPE) 
values ('412.465.124-76', 'matho@gmail.com', 'Matheus Oliveira', '(11) 91248-7124', '8712564098', 'Estudante');

insert into Visitante
(cpf, email, nome, telefone, DTYPE) 
values ('358.907.209-73', 'marcaozika@hotmail.com', 'Marcos Castro', '(11) 91246-7538', 'Visitante');
