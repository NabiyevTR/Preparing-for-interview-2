# список фильмов, для каждого — с указанием общего числа посетителей 
# за все время, среднего числа зрителей за сеанс и общей суммы сборов 
# по каждому фильму (отсортировать по убыванию прибыли). 
# Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;


(SELECT 	
		m.name AS 'Movie name',
		count(t.id) AS Spectators,
		sum(p.price) AS 'Total price',
		avg(
        (SELECT count(ta.id)
        FROM cinema.sessions sa
        INNER JOIN cinema.tickets AS ta
		ON sa.id = ta.movie_session_id
        WHERE sa.id = s.id
        GROUP BY sa.id )
        ) as 'Avg spectators per session'
FROM cinema.sessions AS s
INNER JOIN cinema.movies AS m
ON s.movie_id = m.id
INNER JOIN cinema.tickets AS t
ON s.id = t.movie_session_id
INNER JOIN cinema.prices AS p
ON p.id = s.price_id
GROUP BY m.id )
UNION
(SELECT 	
		"Summary",
		count(t.id) AS Spectators,
		sum(p.price) AS 'Total price',
		avg(
        (SELECT count(ta.id)
        FROM cinema.sessions sa
        INNER JOIN cinema.tickets AS ta
		ON sa.id = ta.movie_session_id
        WHERE sa.id = s.id
        GROUP BY sa.id )
        ) as 'Avg spectators per session'
FROM cinema.sessions AS s
INNER JOIN cinema.movies AS m
ON s.movie_id = m.id
INNER JOIN cinema.tickets AS t
ON s.id = t.movie_session_id
INNER JOIN cinema.prices AS p
ON p.id = s.price_id )




