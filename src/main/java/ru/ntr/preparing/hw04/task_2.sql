# перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. 
# Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT 	m.name as 'Movie Name', 
		s.session_begin as 'Sesion begin', 
        d.duration as 'Movie duration', 
		(SELECT sn.session_begin
        FROM cinema.sessions AS sn
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1) as 'Next session begin', 
        TIMEDIFF(   
			(SELECT sn.session_begin
			FROM cinema.sessions AS sn        
			WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
			ORDER BY sn.session_begin
			LIMIT 1),
			DATE_ADD(s.session_begin, interval d.duration MINUTE)         
        ) AS break  
FROM cinema.sessions AS s
INNER JOIN cinema.movies AS m
ON s.movie_id = m.id
INNER JOIN cinema.movies_duration AS d
ON m.duration_id = d.id
WHERE (hall_id = 1 AND
	TIMEDIFF(   
				(SELECT sn.session_begin
				FROM cinema.sessions AS sn        
				WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
				ORDER BY sn.session_begin
				LIMIT 1),
				DATE_ADD(s.session_begin, interval d.duration MINUTE)         
			) >= '00:00:30'
)
ORDER BY  break
