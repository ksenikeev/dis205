create table country (
	id integer,
	name varchar(255),
	constraint country_pk primary key (id)
);

create table genre (
	id integer,
	name varchar(255),
	constraint genre_pk primary key (id)
);

create table musician (
	id integer,
	name varchar(255),
	country_id integer,
	constraint musician_pk primary key (id)
);

create table autor (
	id integer,
	name varchar(255),
	country_id integer,
	constraint autor_pk primary key (id)
);