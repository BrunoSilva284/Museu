CREATE DATABASE  IF NOT EXISTS `museu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `museu`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: museu
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `exposicao`
--

DROP TABLE IF EXISTS `exposicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicao`
--

LOCK TABLES `exposicao` WRITE;
/*!40000 ALTER TABLE `exposicao` DISABLE KEYS */;
INSERT INTO `exposicao` VALUES (6,NULL,'2017-11-29','Exposicao do Google','PERMANENTE',1);
/*!40000 ALTER TABLE `exposicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exposicao_obra`
--

DROP TABLE IF EXISTS `exposicao_obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exposicao_obra` (
  `Exposicao_codigo` int(11) NOT NULL,
  `obras_codigo` int(11) NOT NULL,
  PRIMARY KEY (`Exposicao_codigo`,`obras_codigo`),
  UNIQUE KEY `UK_eg2itfcdcit125qv0utyp7qyt` (`obras_codigo`),
  CONSTRAINT `FKgknumj9sa23fyt1e0qqkqas6v` FOREIGN KEY (`Exposicao_codigo`) REFERENCES `exposicao` (`codigo`),
  CONSTRAINT `FKiooyr0tqvk02bdra9ayifkb5j` FOREIGN KEY (`obras_codigo`) REFERENCES `obra` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicao_obra`
--

LOCK TABLES `exposicao_obra` WRITE;
/*!40000 ALTER TABLE `exposicao_obra` DISABLE KEYS */;
INSERT INTO `exposicao_obra` VALUES (6,1);
/*!40000 ALTER TABLE `exposicao_obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra`
--

LOCK TABLES `obra` WRITE;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
INSERT INTO `obra` VALUES (1,'Google','C:\\Users\\bruno.a.da.silva\\Pictures\\google.png','QUADRO','2000-10-25','Logo do Google','USA','Google Logo','GUARDADA',6);
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restauracao`
--

DROP TABLE IF EXISTS `restauracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restauracao`
--

LOCK TABLES `restauracao` WRITE;
/*!40000 ALTER TABLE `restauracao` DISABLE KEYS */;
INSERT INTO `restauracao` VALUES (1,'2017-11-28','2017-11-28','FINALIZADA',1.234,1,123456789);
/*!40000 ALTER TABLE `restauracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurador`
--

DROP TABLE IF EXISTS `restaurador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurador` (
  `cracha` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `restauracao_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cracha`),
  KEY `FK601wrl8jtjh208opm0nudutbe` (`restauracao_codigo`),
  CONSTRAINT `FK601wrl8jtjh208opm0nudutbe` FOREIGN KEY (`restauracao_codigo`) REFERENCES `restauracao` (`codigo`),
  CONSTRAINT `restaurador_ibfk_1` FOREIGN KEY (`restauracao_codigo`) REFERENCES `restauracao` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=987654322 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurador`
--

LOCK TABLES `restaurador` WRITE;
/*!40000 ALTER TABLE `restaurador` DISABLE KEYS */;
INSERT INTO `restaurador` VALUES (123456789,'Bruno',NULL),(456789123,'Carlos',NULL),(987654321,'Juliana',NULL);
/*!40000 ALTER TABLE `restaurador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `qtdVisitantes` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,50,'RESERVADA'),(2,20,'LIVRE'),(3,90,'LIVRE');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
INSERT INTO `visita` VALUES (1,'2017-11-29 19:27:57','2017-11-29 19:28:00',1,12.5,8);
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitante` (
  `DTYPE` varchar(31) NOT NULL,
  `idVisitante` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `documentoEscolar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idVisitante`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES ('Estudante',1,'123.456.789-09','joao.cleber@hotmail.com','JoÃ£o Cleber','(11) 94002-8922','1231212987'),('Visitante',2,'252.239.842-34','jose.aug@gmail.com','JosÃ© Augusto','(11) 91234-5385',NULL),('Visitante',3,'498.765.351-23','mariacarlasouza@gmail.com','Maria Carla','(11) 99438-5743',NULL),('Estudante',4,'763.447.594-98','gabilira@hotmail.com','Gabriela Lira','(11) 97648-4341','6358212987'),('Estudante',5,'349.874.727-34','guilhermesil@gmail.com','Guilherme Silva','(11) 99077-1584','6387100987'),('Estudante',6,'412.465.124-76','matho@gmail.com','Matheus Oliveira','(11) 91248-7124','8712564098'),('Visitante',7,'358.907.209-73','marcaozika@hotmail.com','Marcos Castro','(11) 91246-7538',NULL),('Estudante',8,'123.456.789-09','josecarlos@hotmail.com','José Carlos Silva','(11) 91235-7349','123456780');
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-29 23:02:49
