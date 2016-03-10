-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: store
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `bill_notices`
--

DROP TABLE IF EXISTS `bill_notices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_notices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bill_notices_bill_id_index` (`bill_id`),
  CONSTRAINT `bill_notices_bills_id_fk` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_notices`
--

LOCK TABLES `bill_notices` WRITE;
/*!40000 ALTER TABLE `bill_notices` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_notices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_product`
--

DROP TABLE IF EXISTS `bill_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_product` (
  `product_id` int(11) NOT NULL DEFAULT '0',
  `bill_id` int(11) NOT NULL DEFAULT '0',
  `product_count` int(11) DEFAULT NULL,
  `cost` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`bill_id`,`product_id`),
  KEY `bill_product_bill_id_index` (`bill_id`),
  KEY `bill_product_product_id_index` (`product_id`),
  CONSTRAINT `bill_product_bills_id_fk` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`id`),
  CONSTRAINT `bill_product_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_product`
--

LOCK TABLES `bill_product` WRITE;
/*!40000 ALTER TABLE `bill_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `total_cost` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bills_customer_id_index` (`customer_id`),
  CONSTRAINT `bills_customers_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'food'),(2,'lalala'),(4,'tech'),(5,'jaja'),(7,'jaja'),(8,'jaja');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_product`
--

DROP TABLE IF EXISTS `customer_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_product` (
  `customer_id` int(11) NOT NULL DEFAULT '0',
  `product_id` int(11) NOT NULL DEFAULT '0',
  `product_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`product_id`),
  KEY `customer_product_customer_id_index` (`customer_id`),
  KEY `customer_product_product_id_index` (`product_id`),
  CONSTRAINT `customer_product_customers_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `customer_product_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='shopping cart';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_product`
--

LOCK TABLES `customer_product` WRITE;
/*!40000 ALTER TABLE `customer_product` DISABLE KEYS */;
INSERT INTO `customer_product` VALUES (1,1,5),(1,4,3);
/*!40000 ALTER TABLE `customer_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Natashka','Kakashka'),(2,'Sashka','Ne kakashka');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gift_promotion`
--

DROP TABLE IF EXISTS `gift_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gift_promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gift_promotion_category_id_index` (`category_id`),
  CONSTRAINT `gift_promotion_categories_id_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gift_promotion`
--

LOCK TABLES `gift_promotion` WRITE;
/*!40000 ALTER TABLE `gift_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `gift_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gift_promotion_product`
--

DROP TABLE IF EXISTS `gift_promotion_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gift_promotion_product` (
  `gift_id` int(11) NOT NULL DEFAULT '0',
  `gift_promotion_id` int(11) NOT NULL DEFAULT '0',
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`gift_id`,`gift_promotion_id`),
  KEY `gift_promotion_gift_gift_promotion_id_index` (`gift_promotion_id`),
  KEY `gift_promotion_gift_gift_id_index` (`gift_id`),
  CONSTRAINT `gift_promotion_gift_gift_promotion_id_fk` FOREIGN KEY (`gift_promotion_id`) REFERENCES `gift_promotion` (`id`),
  CONSTRAINT `gift_promotion_gift_products_id_fk` FOREIGN KEY (`gift_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gift_promotion_product`
--

LOCK TABLES `gift_promotion_product` WRITE;
/*!40000 ALTER TABLE `gift_promotion_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `gift_promotion_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_promotion_products`
--

DROP TABLE IF EXISTS `group_promotion_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_promotion_products` (
  `product_id` int(11) NOT NULL DEFAULT '0',
  `group_promotion_id` int(11) NOT NULL DEFAULT '0',
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`,`group_promotion_id`),
  KEY `group_promotion_products_group_promotion_id_index` (`group_promotion_id`),
  KEY `group_promotion_products_product_id_index` (`product_id`),
  CONSTRAINT `group_promotion_products_group_promotions_id_fk` FOREIGN KEY (`group_promotion_id`) REFERENCES `group_promotions` (`id`),
  CONSTRAINT `group_promotion_products_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_promotion_products`
--

LOCK TABLES `group_promotion_products` WRITE;
/*!40000 ALTER TABLE `group_promotion_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_promotion_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_promotions`
--

DROP TABLE IF EXISTS `group_promotions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_promotions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_sum` decimal(12,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_promotions`
--

LOCK TABLES `group_promotions` WRITE;
/*!40000 ALTER TABLE `group_promotions` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_promotions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_promotion`
--

DROP TABLE IF EXISTS `product_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_sum` decimal(12,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_promotion_product_id_index` (`product_id`),
  CONSTRAINT `product_promotion_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_promotion`
--

LOCK TABLES `product_promotion` WRITE;
/*!40000 ALTER TABLE `product_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `products_category_id_index` (`category_id`),
  CONSTRAINT `products_categories_id_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'ler',1,5.00),(4,'name',5,123.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_cost_discounts`
--

DROP TABLE IF EXISTS `total_cost_discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_cost_discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_of_discount` int(11) DEFAULT NULL,
  `conditional_cost` decimal(12,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_cost_discounts`
--

LOCK TABLES `total_cost_discounts` WRITE;
/*!40000 ALTER TABLE `total_cost_discounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_cost_discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unconditional_discounts`
--

DROP TABLE IF EXISTS `unconditional_discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unconditional_discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_of_discount` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unconditional_discounts`
--

LOCK TABLES `unconditional_discounts` WRITE;
/*!40000 ALTER TABLE `unconditional_discounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `unconditional_discounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-11  1:25:37
