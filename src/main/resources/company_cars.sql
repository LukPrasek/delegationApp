
 SET NAMES utf8 ;

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `seats_number` int(11) DEFAULT '5',
  `emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `FK_EMP_ID` (`emp_id`),
  CONSTRAINT `FK_EMP_ID` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `cars` WRITE;

INSERT INTO `cars` VALUES (1,'Mercedes','Sprinter',3,1),(25,'Toyota','Avensis',5,17),(31,'Kia','Ceed',5,NULL);

UNLOCK TABLES;

