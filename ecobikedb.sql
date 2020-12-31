-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecobikerentaldb
-- ------------------------------------------------------
-- Server version	8.0.19

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
  `dockId` int DEFAULT NULL,
  `typeId` int NOT NULL,
  `image_url` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dockId` (`dockId`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `bike_ibfk_1` FOREIGN KEY (`dockId`) REFERENCES `dock` (`id`),
  CONSTRAINT `bike_ibfk_2` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES ('1',13,1,3,'assets/double.png'),('10',58,1,1,'assets/standard.png'),('100',80,10,2,'assets/electric.png'),('11',69,2,3,'assets/double.png'),('12',0,2,3,'assets/double.png'),('13',59,2,1,'assets/standard.png'),('14',48,2,2,'assets/electric.png'),('15',8,2,2,'assets/electric.png'),('16',78,2,2,'assets/electric.png'),('17',40,2,1,'assets/standard.png'),('18',66,2,2,'assets/electric.png'),('19',66,2,3,'assets/double.png'),('2',40,1,3,'assets/double.png'),('20',37,2,2,'assets/electric.png'),('21',19,3,1,'assets/standard.png'),('22',0,3,2,'assets/electric.png'),('23',30,3,3,'assets/double.png'),('24',27,3,2,'assets/electric.png'),('25',25,3,2,'assets/electric.png'),('26',41,3,2,'assets/electric.png'),('27',45,3,2,'assets/electric.png'),('28',93,3,1,'assets/standard.png'),('29',4,3,3,'assets/double.png'),('3',96,1,3,'assets/double.png'),('30',7,3,1,'assets/standard.png'),('31',43,4,1,'assets/standard.png'),('32',49,4,3,'assets/double.png'),('33',72,4,1,'assets/standard.png'),('34',11,4,2,'assets/electric.png'),('35',22,4,1,'assets/standard.png'),('36',27,4,1,'assets/standard.png'),('37',56,4,2,'assets/electric.png'),('38',77,4,2,'assets/electric.png'),('39',97,4,3,'assets/double.png'),('4',7,1,3,'assets/double.png'),('40',60,4,1,'assets/standard.png'),('41',20,5,1,'assets/standard.png'),('42',70,5,1,'assets/standard.png'),('43',81,5,1,'assets/standard.png'),('44',97,5,3,'assets/double.png'),('45',80,5,1,'assets/standard.png'),('46',63,5,2,'assets/electric.png'),('47',14,5,2,'assets/electric.png'),('48',56,5,3,'assets/double.png'),('49',28,5,1,'assets/standard.png'),('5',89,1,1,'assets/standard.png'),('50',49,5,2,'assets/electric.png'),('51',43,6,3,'assets/double.png'),('52',29,6,1,'assets/standard.png'),('53',42,6,2,'assets/electric.png'),('54',87,6,2,'assets/electric.png'),('55',97,6,2,'assets/electric.png'),('56',73,6,1,'assets/standard.png'),('57',14,6,2,'assets/electric.png'),('58',72,6,2,'assets/electric.png'),('59',12,6,2,'assets/electric.png'),('6',44,1,3,'assets/double.png'),('60',98,6,1,'assets/standard.png'),('61',64,7,2,'assets/electric.png'),('62',63,7,3,'assets/double.png'),('63',77,7,3,'assets/double.png'),('64',50,7,1,'assets/standard.png'),('65',24,7,2,'assets/electric.png'),('66',14,7,1,'assets/standard.png'),('67',56,7,1,'assets/standard.png'),('68',99,7,3,'assets/double.png'),('69',69,7,3,'assets/double.png'),('7',86,1,1,'assets/standard.png'),('70',5,7,2,'assets/electric.png'),('71',92,8,3,'assets/double.png'),('72',48,8,3,'assets/double.png'),('73',35,8,3,'assets/double.png'),('74',65,8,2,'assets/electric.png'),('75',65,8,1,'assets/standard.png'),('76',26,8,1,'assets/standard.png'),('77',60,8,3,'assets/double.png'),('78',6,8,1,'assets/standard.png'),('79',77,8,3,'assets/double.png'),('8',88,1,3,'assets/double.png'),('80',95,8,2,'assets/electric.png'),('81',70,9,2,'assets/electric.png'),('82',87,9,2,'assets/electric.png'),('83',23,9,1,'assets/standard.png'),('84',85,9,1,'assets/standard.png'),('85',54,9,1,'assets/standard.png'),('86',5,9,3,'assets/double.png'),('87',68,9,3,'assets/double.png'),('88',85,9,3,'assets/double.png'),('89',70,9,3,'assets/double.png'),('9',72,1,3,'assets/double.png'),('90',83,9,2,'assets/electric.png'),('91',46,10,1,'assets/standard.png'),('92',69,10,3,'assets/double.png'),('93',15,10,1,'assets/standard.png'),('94',99,10,3,'assets/double.png'),('95',28,10,2,'assets/electric.png'),('96',27,10,3,'assets/double.png'),('97',23,10,1,'assets/standard.png'),('98',75,10,2,'assets/electric.png'),('99',59,10,3,'assets/double.png');
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for AccountOrder
create table AccountOrder (
	accountid int not null,
    bikeid varchar(20) not null,
    `rent_start` varchar(20) NULL
);

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
INSERT INTO `card` VALUES (1,'1111111','Ngo Quang Ming','VietCongBank','1225'),(2,'2222222','Trinh Long','VietteenBank','1230');
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock`
--

LOCK TABLES `dock` WRITE;
/*!40000 ALTER TABLE `dock` DISABLE KEYS */;
INSERT INTO `dock` VALUES (1,'1,1',3,45,'Dockter','Dai Co Viet 1st'),(2,'1,2',3,45,'Dockter','Chua Boc 2nd'),(3,'2,1',3,45,'Dockter','Nguyen Trai 3rd'),(4,'2,2',3,45,'Dockter','Ba Trieu 4th'),(5,'1,3',3,45,'Dockter','Vu Tong Phan 5th'),(6,'3,1',3,45,'Dockter','Dai Co Viet 6th'),(7,'10,10',30,100,'Dockter','Hai Ba Trung 12th'),(8,'20,20',4,4,'Dockter','Dai La 77th'),(9,'50,50',30,100,'Dockter','Ham Nghi 1st'),(10,'100,100',30,100,'Dockter','Hue 30th'),(11,'10,10',30,100,'Dockter','Hai Ba Trung 50th'),(13,'1,1',3,45,'Dockter','Thang Long 1st'),(14,'1,2',3,45,'Dockter','Le Thanh Nghi 2nd'),(15,'2,1',3,45,'Dockter','Tran Dai Nghia 3rd'),(16,'2,2',3,45,'Dockter','Lang 4th'),(17,'1,3',3,45,'Dockter','Lang Ha 5th'),(18,'3,1',3,45,'Dockter','Bach Mai 6th'),(19,'10,10',30,100,'Dockter','Hai Ba Trung 12th'),(20,'20,20',4,4,'Dockter','Dai La 77th'),(21,'50,50',30,100,'Dockter','Ham Nghi 1st'),(22,'100,100',30,100,'Dockter','Hue 30th'),(23,'10,10',30,100,'Dockter','Hai Ba Trung 50th'),(24,'10,10',0,0,'Dockter','DCM 1st');
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
  `total` double NOT NULL,
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
INSERT INTO `invoice` VALUES (1,'2020-11-02 09:30:00','2020-11-01 09:45:00',1,'1',300000),(2,'2020-11-01 09:31:00','2020-11-01 09:46:00',2,'2',400000);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL,
  `amount` int NOT NULL,
  `timestamp` datetime NOT NULL,
  `cardId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cardId` (`cardId`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`cardId`) REFERENCES `card` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
INSERT INTO `type` VALUES (1,'Standard bike',400000,1,NULL),(2,'Standard e-bike',700000,1.5,NULL),(3,'Twin bike',550000,1.5,NULL);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecobikerentaldb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-26 10:11:41
