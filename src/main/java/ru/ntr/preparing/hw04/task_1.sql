# ошибки в расписании (фильмы накладываются друг на друга), 
# отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», 
# «время начала», «длительность», «фильм 2», «время начала», «длительность»;

SELECT 	m.name as 'Movie Name', 
		s.session_begin as 'Sesion begin', 
        d.duration as 'Movie duration', 
        (SELECT mn.name
        FROM cinema.sessions AS sn
        INNER JOIN cinema.movies as mn
        ON sn.movie_id = mn.id
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1) as 'Next session movie name',        
        (SELECT sn.session_begin
        FROM cinema.sessions AS sn
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1) as 'Next session movie begin',       
		(SELECT dn.duration
        FROM cinema.sessions AS sn
        INNER JOIN cinema.movies AS mn
		ON sn.movie_id = mn.id
		INNER JOIN cinema.movies_duration AS dn
		ON mn.duration_id = dn.id
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1) as 'Next Session movie duration'     
        
FROM cinema.sessions AS s
INNER JOIN cinema.movies AS m
ON s.movie_id = m.id
INNER JOIN cinema.movies_duration AS d
ON m.duration_id = d.id
WHERE (hall_id = 1 AND DATE_ADD(s.session_begin, INTERVAL d.duration MINUTE) > 
		(SELECT sn.session_begin
        FROM cinema.sessions AS sn
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1))
ORDER BY  DATE_ADD(s.session_begin, INTERVAL d.duration MINUTE) 
		- (SELECT sn.session_begin
        FROM cinema.sessions AS sn
        WHERE (sn.session_begin >= s.session_begin AND sn.id != s.id AND hall_id=1 )
        ORDER BY sn.session_begin
        LIMIT 1)
