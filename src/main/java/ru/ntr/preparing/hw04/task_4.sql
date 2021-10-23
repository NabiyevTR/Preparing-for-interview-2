# число посетителей и кассовые сборы, сгруппированные по времени начала фильма: 
# с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

USE cinema;

DELIMITER //

DROP PROCEDURE IF EXISTS getResultSet;

CREATE PROCEDURE getResultSet(from_ datetime, to_ datetime )
   BEGIN
		SELECT 
			from_,
            to_,
			COUNT(t.id) as Spectators,
			SUM(p.price) as 'Total price'
		FROM cinema.sessions as s 
		INNER JOIN cinema.tickets as t
		ON s.id = t.movie_session_id
		INNER JOIN cinema.prices as p
		ON s.price_id = p.id
		WHERE s.session_begin BETWEEN from_ AND to_ ;
  
  END //
DELIMITER ;

# Как я понял в MYSQL нельзя получить таблицу из процедуры или функции. Поэтому решение ниже:


(SELECT 
			"2021-10-22 9:00:00" as 'From',
            "2021-10-22 15:00:00" as 'To',
			COUNT(t.id) as Spectators,
			SUM(p.price) as 'Total price'
FROM cinema.sessions as s 
INNER JOIN cinema.tickets as t
ON s.id = t.movie_session_id
INNER JOIN cinema.prices as p
ON s.price_id = p.id
WHERE s.session_begin BETWEEN "2021-10-22 9:00:00" AND "2021-10-22 15:00:00")

UNION
        
(SELECT 
			"2021-10-22 15:00:00" as 'From',
            "2021-10-22 18:00:00" as 'To',
			COUNT(t.id) as Spectators,
			SUM(p.price) as 'Total price'
FROM cinema.sessions as s 
INNER JOIN cinema.tickets as t
ON s.id = t.movie_session_id
INNER JOIN cinema.prices as p
ON s.price_id = p.id
WHERE s.session_begin BETWEEN "2021-10-22 15:00:00" AND "2021-10-22 15:00:00")
        
UNION
        
(SELECT 
			"2021-10-22 18:00:00" as 'From',
            "2021-10-22 21:00:00" as 'To',
			COUNT(t.id) as Spectators,
			SUM(p.price) as 'Total price'
FROM cinema.sessions as s 
INNER JOIN cinema.tickets as t
ON s.id = t.movie_session_id
INNER JOIN cinema.prices as p
ON s.price_id = p.id
WHERE s.session_begin BETWEEN "2021-10-22 18:00:00" AND "2021-10-22 21:00:00");
