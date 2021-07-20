--Explique o conceito de normalização e para que é usado.
--Normalização é o processo de modelar o banco de dados projetando a forma como as informações serão armazenadas a fim de eliminar, ou pelo menos minimizar, a redundância no banco.

--Adicione um filme à tabela de filmes.
INSERT INTO public.movies
(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES(NULL, NULL, 'A Volta dos que Não Foram', 5, 0, '2020-11-16', '120', '05');

--Adicione um gênero à tabela de gêneros.
INSERT INTO public.genres
(created_at, updated_at, "name", ranking, active)
VALUES(NULL, NULL, 'Mas Uno', 3, 10);

--Associe o filme do Ex 2. ao gênero criado no Ex. 3.
UPDATE public.movies
SET genre_id='13'
WHERE id=22;

--Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
UPDATE public.actors
SET favorite_movie_id='22'
WHERE id=1;

--Crie uma cópia temporária da tabela de filmes.
select * into temp table movietmp from movies;
select * from movietmp;

--Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
delete from movietmp where awards < 5; 

--Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
select distinct g."name" from genres g inner join movies m on(CAST(m.genre_id as integer) = g.id);

--Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
select distinct a.first_name, a.last_name from actors a inner join movies m on(cast(a.favorite_movie_id as integer) = m.id) where m.awards > 3;

--Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
explain select distinct g."name" from genres g inner join movies m on(CAST(m.genre_id as integer) = g.id);
explain select distinct a.first_name, a.last_name from actors a inner join movies m on(cast(a.favorite_movie_id as integer) = m.id) where m.awards > 3;

--O que são os índices? Para que servem?
Servem para otimizar consultas, criando uma mapeamento dos registros.

--Crie um índice sobre o nome na tabela de filmes.
create index title_index on movies(title);

--Verifique se o índice foi criado corretamente.
Sim.