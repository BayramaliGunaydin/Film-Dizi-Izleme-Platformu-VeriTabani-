-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: netflixveritabani
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `kullanıcılar`
--

DROP TABLE IF EXISTS `kullanıcılar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanıcılar` (
  `kullanıcıadı` varchar(45) NOT NULL,
  `kullanıcıemail` varchar(45) NOT NULL,
  `kullanıcısifre` varchar(45) DEFAULT NULL,
  `kullanıcıdogumtarihi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kullanıcıemail`),
  UNIQUE KEY `kullanıcıemail_UNIQUE` (`kullanıcıemail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanıcılar`
--

LOCK TABLES `kullanıcılar` WRITE;
/*!40000 ALTER TABLE `kullanıcılar` DISABLE KEYS */;
INSERT INTO `kullanıcılar` VALUES ('a','a','a','2');
/*!40000 ALTER TABLE `kullanıcılar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanıcıprogram`
--

DROP TABLE IF EXISTS `kullanıcıprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanıcıprogram` (
  `sayac` int NOT NULL AUTO_INCREMENT,
  `kullaniciprogramemail` varchar(45) DEFAULT NULL,
  `izlemetarihi` varchar(45) DEFAULT NULL,
  `izlemesüresi` varchar(45) DEFAULT NULL,
  `kaldigibolum` int DEFAULT NULL,
  `puan` int DEFAULT '0',
  `kaldigiprogram` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sayac`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanıcıprogram`
--

LOCK TABLES `kullanıcıprogram` WRITE;
/*!40000 ALTER TABLE `kullanıcıprogram` DISABLE KEYS */;
/*!40000 ALTER TABLE `kullanıcıprogram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programlar`
--

DROP TABLE IF EXISTS `programlar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programlar` (
  `program_ıd` int NOT NULL AUTO_INCREMENT,
  `Programadi` varchar(45) NOT NULL,
  `Programtipi` varchar(45) DEFAULT NULL,
  `Programtürü` int DEFAULT NULL,
  `Bölümsayisi` int DEFAULT NULL,
  `Programlaruzunlugu` varchar(45) DEFAULT NULL,
  `programlar_puan` float DEFAULT NULL,
  PRIMARY KEY (`program_ıd`,`Programadi`),
  KEY `tür_idx` (`Programtürü`),
  CONSTRAINT `programlar_ibfk_1` FOREIGN KEY (`Programtürü`) REFERENCES `programtür` (`programtür_programıd`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programlar`
--

LOCK TABLES `programlar` WRITE;
/*!40000 ALTER TABLE `programlar` DISABLE KEYS */;
INSERT INTO `programlar` VALUES (1,'72 sevimli hayvan','Film',1,1,'2:02:36',5.5),(2,'Alaca Karanlık','Film',2,1,'2:02:36',4.5),(3,'Alvin ve Sincaplar','Film',3,1,'2:02:36',7.4),(4,'Angry Birds','Dizi',4,19,'43:51',4.3),(5,'Arif V 216','Film',5,1,'2:02:36',7.3),(6,'Assassıns Creed','Film',6,1,'2:02:36',8.1),(7,'Atiye','Dizi',7,30,'43:51',5.2),(8,'Aydaki Son Adam','Film',8,1,'2:02:36',4.8),(9,'Basketball or Nothing','Tv Show',9,25,'45:21',6.1),(10,'Başlangıç','Film',10,1,'2:02:36',6.3),(11,'Ben Efsaneyim','Film',11,1,'2:02:36',5),(12,'Beni Böyle Sev','Dizi',12,31,'43:51',7),(13,'Beyblade','Dizi',13,39,'43:51',6.9),(14,'Bizi Hatırla','Film',14,1,'2:02:36',7.3),(15,'Büyük Tasarımlar','Tv Show',15,25,'45:21',8.2),(16,'Car Masters','Tv Show',16,27,'45:21',7.5),(17,'Charlienin Çikolata Fabrikası','Film',17,1,'2:02:36',6.6),(18,'Criminal','Dizi',18,29,'43:51',5.4),(19,'Da Vinci Şifresi','Film',19,1,'2:02:36',5.5),(20,'Dangal','Film',20,1,'2:02:36',6.2),(21,'Delibal','Film',21,1,'2:02:36',4.9),(22,'Diriliş Ertuğrul','Dizi',22,40,'43:51',5.9),(23,'Dream Big','Film',23,1,'2:02:36',6.1),(24,'Dünyanın En Sıra Dışı Evleri','Tv Show',24,21,'45:21',2.5),(25,'Ejderhalar','Dizi',25,20,'43:51',7.2),(26,'Frankestein ','Film',26,1,'2:02:36',6),(27,'Gezegenimiz','Film',27,1,'2:02:36',5.3),(28,'Harry Potter lüm Yadigarları','Film',28,1,'2:02:36',7.5),(29,'How I met your mother','Dizi',29,1,'43:51',4.7),(30,'Interstellar','Film',30,29,'2:02:36',7.4),(31,'Jaws','Film',31,1,'2:02:36',5.4),(32,'Jurassic World','Film',32,1,'2:02:36',6.6),(33,'Jurassıc Park','Film',33,1,'2:02:36',5.7),(34,'Kara Şövalye','Film',34,1,'2:02:36',7.5),(35,'Kardeşim Benim','Film',35,1,'2:02:36',5.2),(36,'Kung Fu Panda','Film',36,1,'2:02:36',4.9),(37,'Kung Fu Panda Muhteşem Sırlar','Dizi',37,22,'43:51',5.1),(38,'Kuşçular','Film',38,1,'2:02:36',6.4),(39,'Kuşlarla Dans','Film',39,1,'2:02:36',5),(40,'Leyla ile Mecnun','Dizi',40,39,'43:51',4.9),(41,'Marsta Keşif','Film',41,1,'2:02:36',6.1),(42,'Marwel Iron Fist','Dizi',42,13,'43:51',6),(43,'Maşa ve Koca Ayı','Dizi',43,18,'43:51',5.9),(44,'Maske','Film',44,1,'2:02:36',5.8),(45,'Mega Zeka','Film',45,1,'2:02:36',4.8),(46,'Mercan Peşinde','Film',46,1,'2:02:36',7.3),(47,'Mission Blue','Film',47,1,'2:02:36',6.7),(48,'Mr. Bean Tatilde','Film',48,1,'2:02:36',5.5),(49,'Örümcek Adam','Film',49,1,'2:02:36',7.1),(50,'Pandemic','Film',50,1,'2:02:36',6.9),(51,'Patron Bebek Yine İş başında','Dizi',51,17,'43:51',7.5),(52,'pk','Film',52,1,'2:02:36',6.2),(53,'Plastik Okyanus','Film',53,1,'2:02:36',4.4),(54,'Pokemon','Film',54,1,'2:02:36',7.6),(55,'Rakamlarla Tahmin','Film',55,1,'2:02:36',6.7),(56,'Recep İvedik 6','Film',56,1,'2:01:59',4.2),(57,'Scooby-Doo','Film',57,1,'2:02:36',8.6),(58,'Sherlock Holmes','Film',58,1,'2:02:36',7.4),(59,'Shrek ','Film',59,1,'2:02:36',6.2),(60,'Şirinler','Film',60,1,'2:02:36',5.9),(61,'Sıradışı Kulübeler','Tv Show',61,24,'45:21',4.8),(62,'Sonic X ','Dizi',62,21,'43:51',8),(63,'Stranger Tings','Dizi',63,27,'43:51',6.8),(64,'Sünger Bob','Dizi',64,37,'43:51',4.8),(65,'The Big Family Cooking','Tv Show',65,25,'45:21',6.3),(66,'The Blacklist','Dizi',66,12,'43:51',5.9),(67,'The Originals','Dizi',67,13,'43:51',7.8),(68,'Transformers Kayıp Çağ','Film',68,1,'2:02:36',4.9),(69,'Trol Avcıları: Arcadia Hikayeleri','Dizi',69,18,'43:51',6.1),(70,'Yerçekimi','Film',70,1,'2:02:36',4.8),(71,'Yüzüklerin Efendisi İki Kule','Film',71,1,'2:02:36',9.3),(72,'Yüzüklerin Efendisi kralın Dönüşü','Film',72,1,'2:02:36',9.1);
/*!40000 ALTER TABLE `programlar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programtür`
--

DROP TABLE IF EXISTS `programtür`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programtür` (
  `tür_index` int NOT NULL AUTO_INCREMENT,
  `programtür_programıd` int DEFAULT NULL,
  `programtür_türıd` int DEFAULT NULL,
  PRIMARY KEY (`tür_index`),
  KEY `programtürü_idx` (`programtür_türıd`),
  KEY `asd_idx` (`programtür_programıd`),
  CONSTRAINT `programtür_ibfk_2` FOREIGN KEY (`programtür_türıd`) REFERENCES `tür` (`tür_ıd`),
  CONSTRAINT `programtür_ibfk_3` FOREIGN KEY (`programtür_programıd`) REFERENCES `programlar` (`program_ıd`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programtür`
--

LOCK TABLES `programtür` WRITE;
/*!40000 ALTER TABLE `programtür` DISABLE KEYS */;
INSERT INTO `programtür` VALUES (1,1,2),(2,1,4),(3,2,1),(4,2,10),(5,3,5),(6,4,5),(7,4,8),(19,5,3),(20,5,8),(21,6,1),(22,6,3),(23,7,1),(24,7,10),(25,8,2),(26,9,11),(27,10,1),(28,11,3),(29,12,6),(30,12,10),(31,13,5),(32,14,6),(33,15,11),(34,16,11),(35,17,5),(36,17,8),(37,18,7),(38,19,7),(39,20,6),(40,21,6),(41,21,10),(42,22,1),(43,23,2),(44,24,11),(45,25,1),(46,25,5),(47,26,1),(48,26,3),(49,26,9),(50,27,2),(51,27,4),(52,28,1),(53,28,3),(54,28,5),(55,29,10),(56,30,1),(57,30,6),(58,31,7),(59,32,1),(60,33,1),(61,33,3),(62,34,1),(63,34,3),(64,35,6),(65,35,8),(66,36,1),(67,36,5),(68,37,1),(69,38,2),(70,38,4),(71,39,2),(72,40,10),(73,41,2),(74,41,4),(75,42,1),(76,43,5),(77,44,1),(78,44,3),(79,45,5),(80,45,8),(81,46,2),(82,47,2),(83,48,5),(84,49,1),(85,49,3),(86,50,2),(87,50,4),(88,51,5),(89,51,8),(90,52,3),(91,52,10),(92,53,2),(93,54,5),(94,55,2),(95,56,1),(96,57,5),(97,58,1),(98,59,5),(99,59,8),(100,60,5),(101,60,8),(102,61,11),(103,62,1),(104,63,1),(105,63,9),(106,64,5),(107,64,8),(108,65,11),(109,66,1),(110,66,7),(111,67,6),(112,67,9),(113,68,1),(114,69,1),(115,69,5),(116,70,3),(117,70,6),(118,71,1),(119,71,3),(120,72,1),(121,72,3);
/*!40000 ALTER TABLE `programtür` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `programtürü`
--

DROP TABLE IF EXISTS `programtürü`;
/*!50001 DROP VIEW IF EXISTS `programtürü`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `programtürü` AS SELECT 
 1 AS `group_concat(programtür_türıd SEPARATOR ',')`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `programtürü1`
--

DROP TABLE IF EXISTS `programtürü1`;
/*!50001 DROP VIEW IF EXISTS `programtürü1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `programtürü1` AS SELECT 
 1 AS `group_concat(programtür_türıd SEPARATOR ',')`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tür`
--

DROP TABLE IF EXISTS `tür`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tür` (
  `tür_ıd` int NOT NULL AUTO_INCREMENT,
  `tür_programtürü` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tür_ıd`),
  KEY `programturu_idx` (`tür_programtürü`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tür`
--

LOCK TABLES `tür` WRITE;
/*!40000 ALTER TABLE `tür` DISABLE KEYS */;
INSERT INTO `tür` VALUES (1,'Aksiyon ve Macera'),(2,'Belgesel'),(3,'Bilim Kurgu ve Fantastik Yapımlar'),(4,'Bilim ve Doğa'),(5,'Çocuk ve Aile'),(6,'Drama'),(7,'Gerilim'),(8,'Komedi'),(9,'Korku'),(11,'Reality Program'),(10,'Romantik');
/*!40000 ALTER TABLE `tür` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `programtürü`
--

/*!50001 DROP VIEW IF EXISTS `programtürü`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `programtürü` AS select group_concat(`programtür`.`programtür_türıd` separator ',') AS `group_concat(programtür_türıd SEPARATOR ',')` from `programtür` group by `programtür`.`programtür_programıd` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `programtürü1`
--

/*!50001 DROP VIEW IF EXISTS `programtürü1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `programtürü1` AS select group_concat(`programtür`.`programtür_türıd` separator ',') AS `group_concat(programtür_türıd SEPARATOR ',')` from (`programtür` join `programlar`) group by `programtür`.`programtür_programıd` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-01 17:51:26
