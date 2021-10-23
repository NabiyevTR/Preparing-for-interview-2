DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movies_movies_length_idx` (`duration_id`),
  CONSTRAINT `fk_films_films_duration` FOREIGN KEY (`duration_id`) REFERENCES `movies_duration` (`id`)
) 