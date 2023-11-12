create database market;

create sequence client_seq;
create sequence merch_seq;
create sequence bascket_seq;

create table client (
    id bigint  primary key default nextval('client_seq'),
    name varchar(255),
    username varchar(255) unique,
    password varchar(255),
    phonenumber varchar(255)
);

create table merch (
    id bigint primary key default nextval('merch_seq'),
    name varchar(255),
    articul varchar(255),
    price double precision
);

create table bascket (
    id bigint primary key default nextval('bascket_seq'),
    merch_id bigint,
    client_id bigint,
    purchasedate timestamp,
    constraint merch_fk foreign key (merch_id) references merch(id),
    constraint client_fk foreign key (client_id) references client(id)
);

insert into merch (name,articul,price) values
('Молоко 3.2', '00000000101', 72),
('Молоко 0', '00000000102', 50),
('Масло сливочное 72', '00000000103', 119),
('Кефир 3.2', '00000000104', 45),
('Катык 3.2', '00000000105', 51);

insert into client (name, username, password, phonenumber)
values ('Admin', 'admin', '1234','+7918023456')