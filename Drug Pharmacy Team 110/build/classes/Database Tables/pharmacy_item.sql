-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `iditem` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `warning` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `dosage` varchar(20) DEFAULT NULL,
  `reorderlevel` bigint(11) DEFAULT NULL,
  `reorderquantity` bigint(11) DEFAULT NULL,
  `deliverytime` varchar(45) DEFAULT NULL,
  `vendorcode` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditem`),
  UNIQUE KEY `iditem_UNIQUE` (`iditem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (0,'null',0,0,'null','0',0,0,'null',NULL),(1,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',0),(2,'Tylenol',0,4.5,NULL,NULL,NULL,NULL,NULL,NULL),(3,'null',0,0,'null','0',0,0,'null',NULL),(4,'null',0,0,'null','0',0,0,'null',NULL),(9,'Updated Name',5,3,'This is medicine that does stuff, duh!','9001',1,10000,'1 week',NULL),(35,'Updated Name',5,3,'This is medicine that does stuff, duh!','9001',1,10000,'1 week',NULL),(99,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',NULL),(100,'Updated Name',5,3,'This is medicine that does stuff, duh!','9001',1,10000,'1 week',NULL),(101,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',NULL),(102,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',NULL),(103,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',NULL),(500,'Updated Name',99,99,'Updated Description','99',99,99,'Updated Time',NULL),(123456789,'name                ',0,5,'description                                                                                         ','dose                ',9876543210,123456789,'Monday                                       ',1234);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-24 21:33:02
