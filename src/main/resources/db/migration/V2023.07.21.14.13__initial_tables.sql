CREATE TABLE movies.movie
(
    movie_id    serial
        constraint pk_casing
            primary key,
    imdb_id     varchar(256) unique not null,
    title       varchar(256),
    actors      varchar(256),
    genre       varchar(256),
    year        varchar(256),
    rated       varchar(256),
    released    varchar(256),
    imdb_rating varchar(256)
);
