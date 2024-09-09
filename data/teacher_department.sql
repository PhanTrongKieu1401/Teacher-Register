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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `faculty_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2xhv1clx0m0axk2y53wm4hgl` (`faculty_id`),
  CONSTRAINT `FKj2xhv1clx0m0axk2y53wm4hgl` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Toan','BM Toan',1),(2,'Vat ly','BM Vat ly',1),(3,'Ngoai ngu','BM Ngoai ngu',1),(4,'Ly luan','BM Ly luan chinh tri',1),(5,'GDTC-QP','BM GDTC-QP',1),(6,'Mang vien thong','BM Mang vien thong',2),(7,'Tin hieu va HT','BM Tin hieu va HT',2),(8,'Thong tin vo tuyen','BM Thong tin vo tuyen',2),(9,'Khoa hoc may tinh','BM Khoa hoc may tinh',3),(10,'An toan thong tin','BM An toan thong tin',3),(11,'He thong thong tin','BM He thong thong tin',3),(12,'CN phan mem','BM CN phan mem',3),(13,'Xu ly tin hieu va truyen thong','BM Xu ly tin hieu va truyen thong',4),(14,'Dien tu may tinh','BM Dien tu may tinh',4),(15,'Kinh te','BM Kinh te',5),(16,'Quan tri','BM Quan tri',5),(17,'Tai chinh','BM Tai chinh',6),(18,'Ke toan va kiem toan','BM Ke toan va kiem toan',6),(19,'Thiet ke DPT','BM Thiet ke DPT',7),(20,'Truyen thong DPT','BM Truyen thong DPT',7),(21,'Cong nghe DPT','BM Cong nghe DPT',7);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
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
