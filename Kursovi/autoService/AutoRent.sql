CREATE DATABASE  IF NOT EXISTS `autorent` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `autorent`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: autorent
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `idbill` int NOT NULL AUTO_INCREMENT,
  `iduser` int NOT NULL,
  `idcar` int NOT NULL,
  `frontPassport` varchar(200) NOT NULL,
  `backPassport` varchar(200) NOT NULL,
  `driver` tinyint NOT NULL,
  `rentTime` int NOT NULL,
  `cost` double NOT NULL,
  `paymentStatus` tinyint NOT NULL DEFAULT '0',
  `rentStatus` varchar(45) DEFAULT NULL,
  `returnStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbill`,`iduser`,`idcar`),
  KEY `billCars_idx` (`idcar`),
  KEY `userBill_idx` (`iduser`),
  CONSTRAINT `billCars` FOREIGN KEY (`idcar`) REFERENCES `cars` (`idCar`),
  CONSTRAINT `userBill` FOREIGN KEY (`iduser`) REFERENCES `users` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,1,2,'https://www.independent.ie/breaking-news/irish-news/3260c/30937433.ece/AUTOCROP/w620/PANews_P-bda51548-f67e-4b94-bd94-c06d3a050e87_I1.jpg','https://www.uscis.gov/sites/default/files/images/article-i9-central/USCIS_US-Passport-Card-Back_241x161%402x.jpg',1,10,121000,1, NULL,NULL),(2,1,3,'https://www.independent.ie/breaking-news/irish-news/3260c/30937433.ece/AUTOCROP/w620/PANews_P-bda51548-f67e-4b94-bd94-c06d3a050e87_I1.jpg','https://www.uscis.gov/sites/default/files/images/article-i9-central/USCIS_US-Passport-Card-Back_241x161%402x.jpg',0,12,120000,1,NULL,NULL);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `idCar` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `qualityClass` varchar(45) NOT NULL,
  `costPerHour` double NOT NULL,
  `brand` varchar(45) NOT NULL,
  PRIMARY KEY (`idCar`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (2,'Mercedes S500','S',12000,'Mercedes'),(3,'BMW M4 Competition','S',10000,'BMW'),(4,'BMW M3 Competition','S',13000,'BMW');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idrole` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idrole`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (3,'admin'),(2,'manager'),(1,'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(200) NOT NULL,
  `dateOfBirthday` date NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `idrole` int NOT NULL DEFAULT '1',
  `banStatus` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`iduser`,`idrole`),
  KEY `userRole_idx` (`idrole`),
  CONSTRAINT `userRole` FOREIGN KEY (`idrole`) REFERENCES `roles` (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Name0','Surname0','Famale','user@gmail.com','userpass','2002-02-20','+39041241124',1,0),(2,'Name1','Surname1','Male','admin@gmail.com','adminpass','2000-01-01','+3904233331422',3,0),(3,'Name2','Surname2','Male','manager@gmail.com','managerpass','2000-01-01','+39042141422',2,0),(4,'Banned','Banned','Banned','ban@gmail.com','bannedpass','2000-01-01','Banned',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'autorent'
--

--
-- Dumping routines for database 'autorent'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 17:04:32
