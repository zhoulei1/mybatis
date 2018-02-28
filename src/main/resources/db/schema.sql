drop table if exists city;
drop table if exists hotel;

create table city (`id` int(11) NOT NULL auto_increment, name varchar(50) NOT NULL, state varchar, country varchar,PRIMARY KEY (`id`));
create table hotel (city int, name varchar, address varchar, zip varchar);

