use ecobikerentaldb;

-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ecobikerentaldb
-- ------------------------------------------------------
-- Server version	8.0.19
use ecobikerentaldb;
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
-- Table structure for table `account`
--
LOCK TABLES `account` WRITE;
DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `customerId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'mingcorn','naproulete',1),(2,'longpm','mingoipush',2);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `id` varchar(20) NOT NULL, 
  `battery_status` int NOT NULL,
  `dockId` int NOT NULL,
  `typeId` int NOT NULL,
  `image_url` varchar(250) default null,
  PRIMARY KEY (`id`),
  KEY `dockId` (`dockId`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `bike_ibfk_1` FOREIGN KEY (`dockId`) REFERENCES `dock` (`id`),
  CONSTRAINT `bike_ibfk_2` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(17) NOT NULL,
  `cardHolderName` varchar(45) NOT NULL,
  `bank` varchar(45) NOT NULL,
  `expDate` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,1111111,'Ngo Quang Ming','VietCongBank','1225'),(2,2222222,'Trinh Long','VietteenBank','1230');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardownership`
--

DROP TABLE IF EXISTS `cardownership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardownership` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accountId` int NOT NULL,
  `cardID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accountId` (`accountId`),
  KEY `cardID` (`cardID`),
  CONSTRAINT `cardownership_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`),
  CONSTRAINT `cardownership_ibfk_2` FOREIGN KEY (`cardID`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardownership`
--

LOCK TABLES `cardownership` WRITE;
/*!40000 ALTER TABLE `cardownership` DISABLE KEYS */;
INSERT INTO `cardownership` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `cardownership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Ngo Quang Ming','0push','mingkopush@gmail.com'),(2,'Trinh Long','0912345678','longpm@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dock`
--

DROP TABLE IF EXISTS `dock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coordinate` varchar(45) NOT NULL,
  `numOfBike` int NOT NULL,
  `area` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock`
--

LOCK TABLES `dock` WRITE;
/*!40000 ALTER TABLE `dock` DISABLE KEYS */;
INSERT INTO `dock` VALUES (1,'1,1',3,45,'Dockter','Dai Co Viet 1st');
INSERT INTO `dock` VALUES (2,'1,2',3,45,'Dockter','Dai Co Viet 2nd');
INSERT INTO `dock` VALUES (3,'2,1',3,45,'Dockter','Dai Co Viet 3rd');
INSERT INTO `dock` VALUES (4,'2,2',3,45,'Dockter','Dai Co Viet 4th');
INSERT INTO `dock` VALUES (5,'1,3',3,45,'Dockter','Dai Co Viet 5th');
INSERT INTO `dock` VALUES (6,'3,1',3,45,'Dockter','Dai Co Viet 6th');
INSERT INTO `dock` VALUES (7,'10,10',30,100,'Dockter','Hai Ba Trung 12th');
INSERT INTO `dock` VALUES (8,'20,20',4,4,'Dockter','Dai La 77th');
INSERT INTO `dock` VALUES (9,'50,50',30,100,'Dockter','Ham Nghi 1st');
INSERT INTO `dock` VALUES (10,'100,100',30,100,'Dockter','Hue 30th');
INSERT INTO `dock` VALUES (11,'10,10',30,100,'Dockter','Hai Ba Trung 50th');
INSERT INTO `dock` VALUES (12,'10,10',0,0,'Dockter','DCM 1st');
INSERT INTO `dock` VALUES (13,'1,1',3,45,'Dockter','Dai Co Viet 1st');
INSERT INTO `dock` VALUES (14,'1,2',3,45,'Dockter','Dai Co Viet 2nd');
INSERT INTO `dock` VALUES (15,'2,1',3,45,'Dockter','Dai Co Viet 3rd');
INSERT INTO `dock` VALUES (16,'2,2',3,45,'Dockter','Dai Co Viet 4th');
INSERT INTO `dock` VALUES (17,'1,3',3,45,'Dockter','Dai Co Viet 5th');
INSERT INTO `dock` VALUES (18,'3,1',3,45,'Dockter','Dai Co Viet 6th');
INSERT INTO `dock` VALUES (19,'10,10',30,100,'Dockter','Hai Ba Trung 12th');
INSERT INTO `dock` VALUES (20,'20,20',4,4,'Dockter','Dai La 77th');
INSERT INTO `dock` VALUES (21,'50,50',30,100,'Dockter','Ham Nghi 1st');
INSERT INTO `dock` VALUES (22,'100,100',30,100,'Dockter','Hue 30th');
INSERT INTO `dock` VALUES (23,'10,10',30,100,'Dockter','Hai Ba Trung 50th');
INSERT INTO `dock` VALUES (24,'10,10',0,0,'Dockter','DCM 1st');
/*!40000 ALTER TABLE `dock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rent_start` datetime NOT NULL,
  `rent_end` datetime NOT NULL,
  `accountId` int NOT NULL,
  `bikeId` varchar(20) NOT NULL,
  `total` double not null,
  PRIMARY KEY (`id`),
  KEY `accountId` (`accountId`),
  KEY `bikeId` (`bikeId`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`),
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`bikeId`) REFERENCES `bike` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'2020-11-02 09:30:00','2020-11-01 09:45:00',1,1,300000),(2,'2020-11-01 09:31:00','2020-11-01 09:46:00',2,2,400000);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `timestamp` datetime NOT NULL,
  `cardId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cardId` (`cardId`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`cardId`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,10000,'2020-11-01 10:30:00',1),(2,20000,'2020-11-01 10:31:00',2);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `value` double NOT NULL,
  `pay_factor` double NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;

/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecobikerental'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-28  9:05:33



