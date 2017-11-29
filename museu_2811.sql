USE `museu`;

CREATE TABLE `usuario` (
  `usuId` int(11) NOT NULL AUTO_INCREMENT,
  `usuNome` varchar(30) NOT NULL,
  `usuSenha` varchar(30) NOT NULL,
  `usuTipo` varchar(30) NOT NULL,
  PRIMARY KEY (`usuId`)
);

CREATE TABLE `sala` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `qtdVisitantes` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numero`)
);

CREATE TABLE `exposicao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dataFim` date DEFAULT NULL,
  `dataInicio` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `sala_numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKrwv06kgmj6h9h7epkaoo3ajt3` (`sala_numero`),
  CONSTRAINT `FKrwv06kgmj6h9h7epkaoo3ajt3` FOREIGN KEY (`sala_numero`) REFERENCES `sala` (`numero`)
);

CREATE TABLE `obra` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `caminhoImg` varchar(255) DEFAULT NULL,
  `classificacao` varchar(255) DEFAULT NULL,
  `dataCriacao` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `localProducao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `exposicao_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK5b1tc52ubsmge8xcjbf7s66ph` (`exposicao_codigo`),
  CONSTRAINT `FK5b1tc52ubsmge8xcjbf7s66ph` FOREIGN KEY (`exposicao_codigo`) REFERENCES `exposicao` (`codigo`)
);

CREATE TABLE `exposicao_obra` (
  `Exposicao_codigo` int(11) NOT NULL,
  `obras_codigo` int(11) NOT NULL,
  PRIMARY KEY (`Exposicao_codigo`,`obras_codigo`),
  UNIQUE KEY `UK_eg2itfcdcit125qv0utyp7qyt` (`obras_codigo`),
  CONSTRAINT `FKgknumj9sa23fyt1e0qqkqas6v` FOREIGN KEY (`Exposicao_codigo`) REFERENCES `exposicao` (`codigo`),
  CONSTRAINT `FKiooyr0tqvk02bdra9ayifkb5j` FOREIGN KEY (`obras_codigo`) REFERENCES `obra` (`codigo`)
);

CREATE TABLE `restaurador` (
  `cracha` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `restauracao_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cracha`)
);

CREATE TABLE `restauracao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dataFim` date DEFAULT NULL,
  `dataInicio` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `obra_codigo` int(11) DEFAULT NULL,
  `restaurador_cracha` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK3nhj8312rmts5ngwp5qlf0q2l` (`obra_codigo`),
  KEY `FKcg53wlarann1xutliqf98c1yc` (`restaurador_cracha`),
  CONSTRAINT `FK3nhj8312rmts5ngwp5qlf0q2l` FOREIGN KEY (`obra_codigo`) REFERENCES `obra` (`codigo`),
  CONSTRAINT `FKcg53wlarann1xutliqf98c1yc` FOREIGN KEY (`restaurador_cracha`) REFERENCES `restaurador` (`cracha`)
);

ALTER TABLE `restaurador` ADD FOREIGN KEY (`restauracao_codigo`) REFERENCES `restauracao` (`codigo`);

CREATE TABLE `visitante` (
  `DTYPE` varchar(31) NOT NULL,
  `idVisitante` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `documentoEscolar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idVisitante`)
);

CREATE TABLE `visita` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dataHoraEntrada` datetime DEFAULT NULL,
  `dataHoraSaida` datetime DEFAULT NULL,
  `idCartao` bigint(20) NOT NULL,
  `valorEntrada` double NOT NULL,
  `visitante_idVisitante` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKn3qcf3gtrov3t9pk2g24qfheg` (`visitante_idVisitante`),
  CONSTRAINT `FKn3qcf3gtrov3t9pk2g24qfheg` FOREIGN KEY (`visitante_idVisitante`) REFERENCES `visitante` (`idVisitante`)
);

insert into restaurador values
(123456789, 'Bruno', null);

insert into restaurador values
(987654321, 'Juliana', null);

insert into restaurador values
(456789123, 'Carlos', null);

insert into sala
(qtdVisitantes, status) 
values (50,'LIVRE');

insert into sala
(qtdVisitantes, status) 
values (20,'LIVRE');

insert into sala
(qtdVisitantes, status) 
values (90,'LIVRE');

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

