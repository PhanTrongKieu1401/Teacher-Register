-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: teacher
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `week`
--

DROP TABLE IF EXISTS `week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `week` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `week`
--

LOCK TABLES `week` WRITE;
/*!40000 ALTER TABLE `week` DISABLE KEYS */;
INSERT INTO `week` VALUES (1,'Cung hoc nao','Tuan 1'),(2,'Cung hoc nao','Tuan 2'),(3,'Cung hoc nao','Tuan 3'),(4,'Cung hoc nao','Tuan 4'),(5,'Cung hoc nao','Tuan 5'),(6,'Cung hoc nao','Tuan 6'),(7,'Cung hoc nao','Tuan 7'),(8,'Cung hoc nao','Tuan 8'),(9,'Cung hoc nao','Tuan 9'),(10,'Cung hoc nao','Tuan 10'),(11,'Cung hoc nao','Tuan 11'),(12,'Cung hoc nao','Tuan 12'),(13,'Cung hoc nao','Tuan 13'),(14,'Cung hoc nao','Tuan 14'),(15,'Cung hoc nao','Tuan 15'),(16,'Cung hoc nao','Tuan 16'),(17,'Cung hoc nao','Tuan 17'),(18,'Cung hoc nao','Tuan 18'),(19,'Cung hoc nao','Tuan 19'),(20,'Cung hoc nao','Tuan 20'),(21,'Cung hoc nao','Tuan 21'),(22,'Cung hoc nao','Tuan 22'),(23,'Cung hoc nao','Tuan 23'),(24,'Cung hoc nao','Tuan 24'),(25,'Cung hoc nao','Tuan 25'),(26,'Cung hoc nao','Tuan 26'),(27,'Cung hoc nao','Tuan 27'),(28,'Cung hoc nao','Tuan 28'),(29,'Cung hoc nao','Tuan 29'),(30,'Cung hoc nao','Tuan 30'),(31,'Cung hoc nao','Tuan 31'),(32,'Cung hoc nao','Tuan 32'),(33,'Cung hoc nao','Tuan 33'),(34,'Cung hoc nao','Tuan 34'),(35,'Cung hoc nao','Tuan 35'),(36,'Cung hoc nao','Tuan 36'),(37,'Cung hoc nao','Tuan 37'),(38,'Cung hoc nao','Tuan 38'),(39,'Cung hoc nao','Tuan 39'),(40,'Cung hoc nao','Tuan 40'),(41,'Cung hoc nao','Tuan 41'),(42,'Cung hoc nao','Tuan 42'),(43,'Cung hoc nao','Tuan 43'),(44,'Cung hoc nao','Tuan 44'),(45,'Cung hoc nao','Tuan 45'),(46,'Cung hoc nao','Tuan 46'),(47,'Cung hoc nao','Tuan 47'),(48,'Cung hoc nao','Tuan 48'),(49,'Cung hoc nao','Tuan 49'),(50,'Cung hoc nao','Tuan 50'),(51,'Cung hoc nao','Tuan 51'),(52,'Cung hoc nao','Tuan 52');
/*!40000 ALTER TABLE `week` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12  2:28:00
