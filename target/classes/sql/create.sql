-- travelperson.address definição

CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `nr_address` varchar(10) DEFAULT NULL,
  `nm_city` varchar(20) DEFAULT NULL,
  `nm_country` varchar(20) DEFAULT NULL,
  `nm_state` varchar(20) DEFAULT NULL,
  `nm_address` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_person_FK` (`person_id`),
  CONSTRAINT `address_person_FK` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;