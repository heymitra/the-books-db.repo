create table author
(
    id  serial primary key,
    first_name varchar,
    last_name  varchar,
    age int
);

create table book
(
    id       serial primary key,
    title    varchar,
    publish_year varchar,
    author_id int references author (id)
);