-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: softveri2020
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avion` (
  `avion_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avioprevoznik_id` bigint(20) NOT NULL,
  `tip_aviona` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`avion_id`,`avioprevoznik_id`),
  KEY `fk_avioprevoznik_idx` (`avioprevoznik_id`),
  CONSTRAINT `fk_avioprevoznik` FOREIGN KEY (`avioprevoznik_id`) REFERENCES `avioprevoznik` (`avioprevoznik_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` VALUES (1,1,'Boeing 767'),(2,2,'Boeing 767'),(3,3,'Boeing 767'),(4,4,'Boeing 767'),(5,5,'Boeing 767'),(6,6,'Boeing 767'),(7,1,'Boeing 777'),(8,2,'Boeing 777'),(9,3,'Boeing 777'),(10,4,'Boeing 787 Dreamliner'),(11,5,'Boeing 787 Dreamliner'),(12,6,'Boeing 787 Dreamliner'),(13,1,'Boeing 757'),(14,3,'Boeing 757'),(15,5,'Boeing 757'),(16,2,'Airbus A350'),(17,4,'Airbus A350'),(18,6,'Airbus A350');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avioprevoznik`
--

DROP TABLE IF EXISTS `avioprevoznik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avioprevoznik` (
  `avioprevoznik_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv_avioprevoznika` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`avioprevoznik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avioprevoznik`
--

LOCK TABLES `avioprevoznik` WRITE;
/*!40000 ALTER TABLE `avioprevoznik` DISABLE KEYS */;
INSERT INTO `avioprevoznik` VALUES (1,'Delta Air Lines'),(2,'American Airlines Group'),(3,'Air Serbia'),(4,'Wizz Air'),(5,'Turkish Airlines'),(6,' Ryanair');
/*!40000 ALTER TABLE `avioprevoznik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinacija`
--

DROP TABLE IF EXISTS `destinacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destinacija` (
  `destinacija_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv_destinacije` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`destinacija_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinacija`
--

LOCK TABLES `destinacija` WRITE;
/*!40000 ALTER TABLE `destinacija` DISABLE KEYS */;
INSERT INTO `destinacija` VALUES (1,'Atina'),(2,'Beograd'),(3,'Barselona'),(4,'Beč'),(5,'Bratislava'),(6,'Pariz'),(7,'Berlin'),(8,'Niš'),(9,'Madrid'),(10,'Zagreb'),(11,'Podgorica'),(12,'Sarajevo'),(13,'Tivt'),(14,'Sofija');
/*!40000 ALTER TABLE `destinacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `korisnik_id` bigint(12) NOT NULL AUTO_INCREMENT,
  `br_pasosa` bigint(12) DEFAULT NULL,
  `ime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `br_telefona` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`korisnik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,1234,'Dejan','Milovanovic','069123123','dejan','dejan',1),(2,1234567,'Nikola','Milovanovic','69361792410','nikola','nikola',0),(3,12345678,'Filip','Markovski','69656565','filip','filip',0),(4,102345,'Petar','Petrovic','69444333','petar','petar',0);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `let`
--

DROP TABLE IF EXISTS `let`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `let` (
  `let_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum_polaska` datetime DEFAULT NULL,
  `datum_povratka` datetime DEFAULT NULL,
  `duzina_leta` int(11) DEFAULT NULL,
  `cena_leta` decimal(20,0) DEFAULT NULL,
  `let_od` bigint(20) NOT NULL,
  `let_do` bigint(20) NOT NULL,
  `avion_id` bigint(20) NOT NULL,
  PRIMARY KEY (`let_id`),
  KEY `fk_let_od_idx` (`let_od`),
  KEY `fk_let_do_idx` (`let_do`),
  KEY `fk_avion_idx` (`avion_id`),
  CONSTRAINT `fk_avion` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`avion_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_let_do` FOREIGN KEY (`let_do`) REFERENCES `destinacija` (`destinacija_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_let_od` FOREIGN KEY (`let_od`) REFERENCES `destinacija` (`destinacija_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `let`
--

LOCK TABLES `let` WRITE;
/*!40000 ALTER TABLE `let` DISABLE KEYS */;
INSERT INTO `let` VALUES (2,'2020-07-20 00:00:00','2020-07-20 00:00:00',12,12222,1,2,1),(5,'2020-07-20 00:00:00','2020-07-28 00:00:00',120,8990,4,3,3),(6,'2020-12-12 00:00:00','2020-12-12 00:00:00',10,20,1,3,1),(7,'2020-07-20 00:00:00','2020-07-25 00:00:00',120,19990,5,14,3),(8,'2020-07-20 00:00:00','2020-07-25 00:00:00',100,1000,2,1,1),(9,'2020-07-15 00:00:00','2020-07-17 00:00:00',80,1900,8,6,6),(11,'2021-12-29 00:00:00','2021-12-31 00:00:00',60,12000,5,6,5);
/*!40000 ALTER TABLE `let` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervacija`
--

DROP TABLE IF EXISTS `rezervacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervacija` (
  `let_id` bigint(20) NOT NULL,
  `korisnik_id` bigint(20) NOT NULL,
  `datum_rezervacije` datetime DEFAULT NULL,
  `potvrdjena` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`let_id`,`korisnik_id`),
  KEY `fk_let_idx` (`let_id`),
  KEY `fk_korisnik_idx` (`korisnik_id`),
  CONSTRAINT `fk_korisnik` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_let` FOREIGN KEY (`let_id`) REFERENCES `let` (`let_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervacija`
--

LOCK TABLES `rezervacija` WRITE;
/*!40000 ALTER TABLE `rezervacija` DISABLE KEYS */;
INSERT INTO `rezervacija` VALUES (6,3,'2020-07-14 00:00:00',0),(9,2,'2020-07-14 00:00:00',1),(9,3,'2020-07-14 00:00:00',1);
/*!40000 ALTER TABLE `rezervacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'softveri2020'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-08  0:33:14
