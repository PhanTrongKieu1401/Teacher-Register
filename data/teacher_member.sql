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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'Ha Noi','1990-01-01','anhpn@gmail.com','Pham Ngoc Anh','anhpn','0912316141','anhpn'),(2,'Ha Noi','1990-01-01','thanhltm@gmail.com','Le Thi Minh Thanh','thanhltm','0904801508','thanhltm'),(3,'Ha Noi','1990-01-01','giaonq@gmail.com','Nguyen Quynh Giao','giaonq','0934100636','giaonq'),(4,'Ha Noi','1990-01-01','ninhdm@gmail.com','Dao Manh Ninh','ninhdm','0914788000','ninhdm'),(5,'Ha Noi','1990-01-01','thinhnd@gmail.com','Nguyen Duc Thinh','thinhnd','0913556590','thinhnd'),(6,'Ha Noi','1990-01-01','bannt@gmail.com','Nguyen Tien Ban','bannt','0904110109','bannt'),(7,'Ha Noi','1990-01-01','trinhnc@gmail.com','Nguyen Chien Trinh','trinhnc','0915400946','trinhnc'),(8,'Ha Noi','1990-01-01','minhht@gmail.com','Hoang Trong Minh','minhht','0913259259','minhht'),(9,'Ha Noi','1990-01-01','nhannd@gmail.com','Nguyen Duc Nhan','nhannd','0439170811','nhannd'),(10,'Ha Noi','1990-01-01','chaulh@gmail.com','Pham Ngoc Anh','chaulh','0911465080','chaulh'),(11,'Ha Noi','1990-01-01','ngocdt@gmail.com','Dang The Ngoc','ngocdt','0918686517','ngocdt'),(12,'Ha Noi','1990-01-01','minhnn@gmail.com','Nguyen Ngoc Minh','minhnn','0912824193','minhnn'),(13,'Ha Noi','1990-01-01','thiennd@gmail.com','Ngo Duc Thien','thiennd','0912316141','thiennd'),(14,'Ha Noi','1990-01-01','hieunt@gmail.com','Nguyen Trung Hieu','hieunt','0916566268','hieunt'),(15,'Ha Noi','1990-01-01','phuongnd@gmail.com','Nguyen Duy Phuong','phuongnd','0913575442','phuongnd'),(16,'Ha Noi','1990-01-01','bachnx@gmail.com','Ngo Xuan Bach','bachnx','0898980268','bachnx'),(17,'Ha Noi','1990-01-01','dauhx@gmail.com','Hoang Xuan Dau','dauhx','0904534390','dauhx'),(18,'Ha Noi','1990-01-01','cuongpv@gmail.com','Pham Van Cuong','cuongpv','0904018876','cuongpv'),(19,'Ha Noi','1990-01-01','hungnm@gmail.com','Nguyen Manh Hung','hungnm','0987812082','hungnm'),(20,'Ha Noi','1990-01-01','phongvt@gmail.com','Vu Trong Phong','phongvt','0912099811','phongvt'),(21,'Ha Noi','1990-01-01','thaptt@gmail.com','Tran Thi Thap','thaptt','0912212929','thaptt'),(22,'Ha Noi','1990-01-01','ducdtv@gmail.com','Dang Thi Viet Duc','ducdtv','0914932612','ducdtv'),(23,'Ha Noi','1990-01-01','haunv@gmail.com','Nguyen Van Hau','haunv','0933132286','haunv'),(24,'Ha Noi','1990-01-01','tienvh@gmail.com','Vu Huu Tien','tienvh','0914932612','tienvh'),(25,'Ha Noi','1990-01-01','trungtq@gmail.com','Tran Quoc Trung','trungtq','0901788999','trungtq'),(26,'Ha Noi','1990-01-01','hanglt@gmail.com','Le Thi Hang','hanglt','0904826618','hanglt');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
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
