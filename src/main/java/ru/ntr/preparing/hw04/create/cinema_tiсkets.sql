DROP TABLE IF EXISTS `tickets`;

CREATE TABLE `tickets` (
  `id` int NOT NULL,
  `movie_session_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tickets_sessions_idx` (`movie_session_id`),
  CONSTRAINT `fk_tickets_sessions` FOREIGN KEY (`movie_session_id`) REFERENCES `sessions` (`id`)
) 