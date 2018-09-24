 SET NAMES utf8 ;

DROP TABLE IF EXISTS `employees`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `start_working_date` date DEFAULT NULL,
  `employee_position` varchar(32) DEFAULT NULL,
  `car_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FKE_car_ID` (`car_id`),
  CONSTRAINT `FKE_car_ID` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `employees` WRITE;

INSERT INTO `employees` VALUES
(1,'Luk','Pra','1987-12-31','1987-12-31','DIRECTOR',1),
(2,'Michal','Kowalski','1987-01-31','2018-02-01','SUPERVISOR',NULL),
(3,'Kamil','Nowak','1987-10-31','2018-03-01','WORKER',NULL),
(4,'Dominik','Wasowski','1987-05-31','2018-04-01','WORKER',NULL),
(6,'Piotr','Keska','1975-03-05','2018-03-05','WORKER',NULL),
(14,'Andrzej','Malinowski','1975-03-05','2018-03-05','WORKER',NULL),
(15,'Mieczysław','Grad','1987-10-31','2018-02-01','WORKER',NULL),
(16,'Piotr','Bieniek','1987-01-31','2018-03-05','WORKER',NULL),
(17,'Jan','Kopycki','1968-05-23','2017-05-01','SUPERVISOR',NULL),
(18,'Kamil','Drogowski','1974-05-11','2017-03-05','WORKER',NULL);

UNLOCK TABLES;

