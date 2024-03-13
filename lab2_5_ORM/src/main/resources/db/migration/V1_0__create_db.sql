create table musictrack (
	id integer,
	name varchar(512),
	length integer,
	musician_id integer,
	autor_id integer,
	date char(10),
	genre_id integer,
	constraint musictrack_pk primary key (id)
);

insert into musictrack (id,name) values (1, 'Колокольчик');