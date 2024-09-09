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
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacity` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKio8crqqepwi9ox33ui6enoi5x` (`building_id`),
  CONSTRAINT `FKio8crqqepwi9ox33ui6enoi5x` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,30,'Hoang gia','201-A1',1),(2,30,'Hoang gia','202-A1',1),(3,30,'Hoang gia','301-A1',1),(4,30,'Hoang gia','302-A1',1),(5,60,'Thuong dan','101-A2',2),(6,60,'Thuong dan','102-A2',2),(7,60,'Thuong dan','201-A2',2),(8,60,'Thuong dan','202-A2',2),(9,60,'Thuong dan','203-A2',2),(10,60,'Thuong dan','204-A2',2),(11,60,'Thuong dan','301-A2',2),(12,60,'Thuong dan','302-A2',2),(13,60,'Thuong dan','303-A2',2),(14,60,'Thuong dan','304-A2',2),(15,60,'Thuong dan','401-A2',2),(16,60,'Thuong dan','402-A2',2),(17,90,'Thuong dan thuc hanh','201-A3',3),(18,90,'Thuong dan thuc hanh','202-A3',3),(19,90,'Thuong dan thuc hanh','301-A3',3),(20,90,'Thuong dan thuc hanh','303-A3',3),(21,90,'Thuong dan thuc hanh','305-A3',3),(22,90,'Thuong dan thuc hanh','307-A3',3),(23,90,'Thuong dan thuc hanh','309-A3',3),(24,90,'Thuong dan thuc hanh','311-A3',3),(25,90,'Thuong dan thuc hanh','401-A3',3),(26,90,'Thuong dan thuc hanh','402-A3',3),(27,90,'Thuong dan thuc hanh','403-A3',3),(28,90,'Thuong dan thuc hanh','501-A3',3),(29,90,'Thuong dan thuc hanh','503-A3',3),(30,90,'Thuong dan thuc hanh','505-A3',3),(31,90,'Thuong dan thuc hanh','507-A3',3),(32,90,'Thuong dan thuc hanh','509-A3',3);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12  2:27:58
