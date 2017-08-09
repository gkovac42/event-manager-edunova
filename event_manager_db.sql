drop database if exists eventi;
create database eventi default character set utf8;
use eventi;

create table event(
id int not null primary key auto_increment,
naziv varchar(50) not null,
lokacija varchar(50),
datum_pocetak datetime,
datum_kraj datetime

);

create table ulaznica(
id int not null primary key auto_increment,
naziv varchar(50) not null,
event int not null,
cijena decimal(18,2) not null
);

create table lokacija(
id int not null primary key auto_increment,
naziv varchar(50) not null,
adresa varchar(50),
mjesto varchar(50),
drzava varchar(50),
lat varchar (50),
lng	varchar (50)
);

create table korisnik(
id int not null primary key auto_increment,
ime varchar(50) not null,
prezime varchar(50) not null,
email varchar(50) not null,
adresa varchar(50) not null,
mjesto varchar(50) not null
);

create table narudzba(
id int not null primary key auto_increment,
korisnik int not null,
dostava boolean not null,
nacin_placanja varchar(50) not null
);

create table ulaznica_narudzba(
ulaznica int not null,
narudzba int not null
);


alter table ulaznica add foreign key(event) references event(id);

alter table narudzba add foreign key(korisnik) references korisnik(id);

alter table ulaznica_narudzba add foreign key(ulaznica) references ulaznica(id);
alter table ulaznica_narudzba add foreign key(narudzba) references narudzba(id);



