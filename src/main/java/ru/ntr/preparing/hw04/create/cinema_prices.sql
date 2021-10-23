DROP TABLE IF EXISTS `prices`;

CREATE TABLE `prices` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 