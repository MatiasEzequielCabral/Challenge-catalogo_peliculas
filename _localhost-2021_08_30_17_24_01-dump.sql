-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: catalogo
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'soy una imagen','accion'),(2,'soy una imagen','terror'),(3,'soy una imagen','animacion');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_peliculas`
--

DROP TABLE IF EXISTS `genero_peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero_peliculas` (
  `genero_id` bigint NOT NULL,
  `peliculas_id` bigint NOT NULL,
  UNIQUE KEY `UK_s1dokogelx4iwrmr5gp7lvmuq` (`peliculas_id`),
  KEY `FKsej3ofbkjhwlafn2cq4ek5lvk` (`genero_id`),
  CONSTRAINT `FKj9k3bxc7vrso9xv9om7o3303p` FOREIGN KEY (`peliculas_id`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `FKsej3ofbkjhwlafn2cq4ek5lvk` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_peliculas`
--

LOCK TABLES `genero_peliculas` WRITE;
/*!40000 ALTER TABLE `genero_peliculas` DISABLE KEYS */;
INSERT INTO `genero_peliculas` VALUES (1,1),(1,2),(2,4),(3,3);
/*!40000 ALTER TABLE `genero_peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,2,'2021-08-29 20:42:23.118000','soy una imagen','tomb rider'),(2,3,'2021-08-29 20:42:23.118000','soy una imagen','hitman'),(3,5,'2021-08-29 20:42:23.118000','soy una imagen','madagascar'),(4,4,'2021-08-29 20:42:23.118000','soy una imagen','la bruja');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_personajes`
--

DROP TABLE IF EXISTS `pelicula_personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_personajes` (
  `pelicula_id` bigint NOT NULL,
  `personajes_id` bigint NOT NULL,
  KEY `FKn5qwcr1elhktsvtfbj1jpu9f5` (`personajes_id`),
  KEY `FKsnhmov1jaby1giyyy1x8y9shi` (`pelicula_id`),
  CONSTRAINT `FKn5qwcr1elhktsvtfbj1jpu9f5` FOREIGN KEY (`personajes_id`) REFERENCES `personajes` (`id`),
  CONSTRAINT `FKsnhmov1jaby1giyyy1x8y9shi` FOREIGN KEY (`pelicula_id`) REFERENCES `pelicula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_personajes`
--

LOCK TABLES `pelicula_personajes` WRITE;
/*!40000 ALTER TABLE `pelicula_personajes` DISABLE KEYS */;
INSERT INTO `pelicula_personajes` VALUES (1,1),(1,4),(2,1),(2,2),(3,2),(3,3),(4,1),(4,3);
/*!40000 ALTER TABLE `pelicula_personajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `edad` int NOT NULL,
  `historia` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peso` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,15,'hola bb','soy urll','Sara',70),(2,11,'hola','soy pepito.rul','Pepe',72),(3,53,'hellou','url del fin del mundo','Antonio',90),(4,15,'al final','urlita','Felipe',73);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes_peliculas`
--

DROP TABLE IF EXISTS `personajes_peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes_peliculas` (
  `personaje_id` bigint NOT NULL,
  `peliculas_id` bigint NOT NULL,
  KEY `FKh99248owsle5ufv8wparimetk` (`peliculas_id`),
  KEY `FKtgmy2qembx3b993wsae75jry7` (`personaje_id`),
  CONSTRAINT `FKh99248owsle5ufv8wparimetk` FOREIGN KEY (`peliculas_id`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `FKtgmy2qembx3b993wsae75jry7` FOREIGN KEY (`personaje_id`) REFERENCES `personajes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes_peliculas`
--

LOCK TABLES `personajes_peliculas` WRITE;
/*!40000 ALTER TABLE `personajes_peliculas` DISABLE KEYS */;
INSERT INTO `personajes_peliculas` VALUES (1,1),(1,2),(1,4),(2,3),(2,2),(3,3),(3,4),(4,1);
/*!40000 ALTER TABLE `personajes_peliculas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-30 17:24:01
