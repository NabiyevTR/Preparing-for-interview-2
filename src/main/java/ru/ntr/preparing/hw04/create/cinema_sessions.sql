
DROP TABLE IF EXISTS `sessions`;

CREATE TABLE `sessions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `session_begin` datetime NOT NULL,
  `movie_id` int NOT NULL,
  `price_id` int NOT NULL,
  `hall_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sessions_movies_idx` (`movie_id`),
  KEY `fk_sessions_prices_idx` (`price_id`),
  KEY `fk_sessions_cinema_halls_idx` (`hall_id`),
  CONSTRAINT `fk_sessions_cinema_halls` FOREIGN KEY (`hall_id`) REFERENCES `cinema_halls` (`id`),
  CONSTRAINT `fk_sessions_movies` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `fk_sessions_prices` FOREIGN KEY (`price_id`) REFERENCES `prices` (`id`)
) 