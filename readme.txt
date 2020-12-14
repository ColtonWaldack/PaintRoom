This program is just a text example to show the creation of a database linked Java program. In order to set it up, you must first have a mysql server running on your local machine. The database must be called "Paintroom" and it must contain a table called receipt. Here are the commands to create such a database in your mysql server.

create database Paintroom;

use Paintroom;

create table receipt (
fullname varchar(25) primary key not null,
email varchar(25),
address varchar(50),
state varchar(10),
zip varchar(8),
paintcount int,
colorone varchar(15),
colortwo varchar(15),
colorthree varchar(15),
colorfour varchar(15),
tapecount int,
brushtype varchar(15),
comments varchar(150));

