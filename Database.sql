CREATE DATABASE  IF NOT EXISTS `doan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `doan`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: doan
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `ID` varchar(10) NOT NULL,
  `IDCus` varchar(10) NOT NULL,
  `IDCar` varchar(10) DEFAULT NULL,
  `TotalPrice` float DEFAULT NULL,
  PRIMARY KEY (`ID`,`IDCus`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `IDCar` (`IDCar`),
  KEY `IDCus` (`IDCus`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`IDCar`) REFERENCES `car` (`ID`),
  CONSTRAINT `bill_ibfk_3` FOREIGN KEY (`IDCus`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billinfo` (
  `IDBill` varchar(10) NOT NULL,
  `IDJob` varchar(10) NOT NULL,
  `Amount` int DEFAULT NULL,
  `Discount` float DEFAULT NULL,
  `Price` float DEFAULT NULL,
  PRIMARY KEY (`IDBill`,`IDJob`),
  KEY `IDJob` (`IDJob`),
  CONSTRAINT `billinfo_ibfk_2` FOREIGN KEY (`IDJob`) REFERENCES `job` (`ID`),
  CONSTRAINT `billinfo_ibfk_3` FOREIGN KEY (`IDBill`) REFERENCES `bill` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `brandcar`
--

DROP TABLE IF EXISTS `brandcar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brandcar` (
  `BrandName` varchar(50) NOT NULL,
  PRIMARY KEY (`BrandName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `ID` varchar(10) NOT NULL,
  `Brand` varchar(50) DEFAULT NULL,
  `Decription` varchar(150) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `DateIn` date DEFAULT NULL,
  `DateOut` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_brandcar` (`Brand`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`Brand`) REFERENCES `brandcar` (`BrandName`),
  CONSTRAINT `FK_brandcar` FOREIGN KEY (`Brand`) REFERENCES `brandcar` (`BrandName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Picture` blob,
  `IDCar` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_htk_id_car` (`IDCar`),
  CONSTRAINT `fk_htk_id_car` FOREIGN KEY (`IDCar`) REFERENCES `car` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Unit` varchar(50) DEFAULT NULL,
  `Value` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Address` varchar(1000) DEFAULT NULL,
  `Salary` float DEFAULT NULL,
  `Type` int NOT NULL,
  `Picture` blob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `ID` varchar(10) NOT NULL,
  `JobName` varchar(100) DEFAULT NULL,
  `Value` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobinfo`
--

DROP TABLE IF EXISTS `jobinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobinfo` (
  `IDJob` varchar(10) NOT NULL,
  `IDDevice` varchar(10) NOT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`IDJob`,`IDDevice`),
  KEY `IDDevice` (`IDDevice`),
  CONSTRAINT `jobinfo_ibfk_1` FOREIGN KEY (`IDJob`) REFERENCES `job` (`ID`),
  CONSTRAINT `jobinfo_ibfk_2` FOREIGN KEY (`IDDevice`) REFERENCES `device` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `ID` varchar(10) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `userName_UNIQUE` (`Username`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `revenue`
--

DROP TABLE IF EXISTS `revenue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revenue` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Type` int NOT NULL,
  `Value` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-26 16:20:49
