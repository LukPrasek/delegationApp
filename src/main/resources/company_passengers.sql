
 SET NAMES utf8 ;


DROP TABLE IF EXISTS `passengersId`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `passengersId` (
  `passenger_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`passenger_id`),
  KEY `emp_id_idx` (`emp_id`),
  KEY `cad_id_idx` (`car_id`),
  CONSTRAINT `fk_car_id` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `passengersId` WRITE;
/*!40000 ALTER TABLE `passengersId` DISABLE KEYS */;
INSERT INTO `passengersId` VALUES (27,1,3),(29,1,6),(34,1,15);
/*!40000 ALTER TABLE `passengersId` ENABLE KEYS */;
UNLOCK TABLES;

