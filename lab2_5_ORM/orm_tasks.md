# ORM

## Объектно-реляционное отображение

### Разработка инструментов автоматического отображения структуры БД на структуру объектной модели

## JPA

### Примем:

1. Имя сущностного класса и таблицы на которую он отображается должны совпадать.
2. Члены классов, имеющие объектные типы (сущности), отображаем на поля с суфиксом '_id', 
формирующим внешний ключ, такие члены аннотируем как `@ManyToOne`
3. Управляющая структура описывается интерфейсом EntityManager.
4. При создании EntityManager необходимо получить структуру сущностей,
 проверить соответствие этой структуры реляционной модели, создать подключение к БД

```sql
create database music;

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
```
```
--Запрос к базе данных (PostgreSQL) извлекающий список таблиц:

SELECT
table_name
FROM
information_schema.tables
WHERE
table_type = 'BASE TABLE'
AND
table_schema NOT IN ('pg_catalog', 'information_schema');
```

```
--Запрос к базе данных (PostgreSQL) извлекающий список полей указанной таблицы

SELECT a.attname
FROM pg_catalog.pg_attribute a
WHERE a.attrelid = (
	SELECT c.oid FROM pg_catalog.pg_class c 
	LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace
	WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = 'TABLE_NAME'
)
AND a.attnum > 0 AND NOT a.attisdropped
```