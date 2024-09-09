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
-- Table structure for table `sectionclass`
--

DROP TABLE IF EXISTS `sectionclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sectionclass` (
  `id` int NOT NULL AUTO_INCREMENT,
  `actualcapacity` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `maxcapacity` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject_of_semester_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcpgk5rttiv8cnoy8fkkqs7y59` (`subject_of_semester_id`),
  CONSTRAINT `FKcpgk5rttiv8cnoy8fkkqs7y59` FOREIGN KEY (`subject_of_semester_id`) REFERENCES `subjectofsemester` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sectionclass`
--

LOCK TABLES `sectionclass` WRITE;
/*!40000 ALTER TABLE `sectionclass` DISABLE KEYS */;
INSERT INTO `sectionclass` VALUES (1,0,'Danh cho D20CNPM1',60,'Nhom 03',1),(2,0,'Danh cho D20CNPM1',60,'Nhom 01',2),(3,0,'Danh cho D20CNPM1',60,'Nhom 02',3),(4,0,'Danh cho D20CNPM1',60,'Nhom 01',4),(5,0,'Danh cho D20CNPM1',60,'Nhom 02',4),(6,0,'Danh cho D20CNPM1',60,'Nhom 03',4),(7,0,'Danh cho D20CNPM1',60,'Nhom 04',4),(8,0,'Danh cho D20CNPM1',60,'Nhom 01',5),(9,0,'Danh cho D20CNPM1',60,'Nhom 06-01',6),(10,0,'Danh cho D20CNPM1',60,'Nhom 06-02',6),(11,0,'Danh cho D20HTTT1',60,'Nhom 01',7),(12,0,'Danh cho D20HTTT1',60,'Nhom 01',8),(13,0,'Danh cho D20HTTT1',60,'Nhom 02',8),(14,0,'Danh cho D20HTTT1',60,'Nhom 03',8),(15,0,'Danh cho D20HTTT1',60,'Nhom 04',8),(16,0,'Danh cho D20HTTT1',60,'Nhom 01',9),(17,0,'Danh cho D20HTTT1',60,'Nhom 02',9),(18,0,'Danh cho D20HTTT1',60,'Nhom 03',9),(19,0,'Danh cho D20HTTT1',60,'Nhom 04',9),(20,0,'Danh cho D20HTTT1',60,'Nhom 01',10),(21,0,'Danh cho D20HTTT1',60,'Nhom 02',10),(22,0,'Danh cho D20HTTT1',60,'Nhom 03',10),(23,0,'Danh cho D20HTTT1',60,'Nhom 04',10),(24,0,'Danh cho D20HTTT1',60,'Nhom 02',11),(25,0,'Danh cho D20HTTT1',60,'Nhom 01',12);
/*!40000 ALTER TABLE `sectionclass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12  2:27:59
