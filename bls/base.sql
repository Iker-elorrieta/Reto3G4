
create database Reto35;
use Reto35;

create table Cines(
	id_cine int  primary key not null,
    nombreCine varchar (30) not null,
    num_salas int not null
);

create table Salas(
	id_sala int primary key not null,
    nombreSalas varchar (30) not null,
    id_cine int not null,
	Constraint FK_Cines_Salas foreign key (id_cine) references Cines(id_cine)on update cascade
);

create table Peliculas(
	id_pelicula int primary key not null,
    nombrePelicula varchar(100) not null,
    precio float not null,
    duracion int not null,
    genero varchar (30) not null
);

create table Sesiones(
	id_sesion int primary key not null,
    fecha date not null,
    hora time not null,
    id_pelicula int not null,
    id_sala int not null,
	Constraint FK_Peliculas_Sesiones foreign key (id_pelicula) references Peliculas(id_pelicula)on update cascade,
    Constraint FK_Salas_Sesiones foreign key (id_sala) references Salas(id_sala)on update cascade
);

create table Cliente (
    dni varchar(9) primary key not null,
    nombre varchar (30) not null,
    Apellidos varchar (30) not null,
    sexo varchar (1) not null,
    contrasena varchar(30) not null
);

create table Pedido (
	id_pedido int primary key not null auto_increment,
	dni varchar(9) not null,
    precioTotal float not null,
    Constraint FK_Cliente_Pedido foreign key (dni) references Cliente(dni)on update cascade
);

create table Entrada(
	id_entrada int primary key not null auto_increment,
    id_sesion int not null,
    id_pedido int not null,
    Constraint FK_Sesiones_Entrada foreign key (id_sesion) references Sesiones(id_sesion)on update cascade,
    Constraint FK_Pedido_Entrada foreign key (id_pedido) references Pedido(id_pedido)on update cascade
);

insert into Cines values (1,'Cines Yelmo',3);
insert into Cines values (2,'Cines Elorrieta',2);
insert into Cines values (3,'Cines Muñoz',3);

insert into Salas values (1,'Sala Principal',1);
insert into Salas values (2,'Sala Secundaria',1);
insert into Salas values (3,'Sala Tercera',1);
insert into Salas values (4,'Sala Principal',2);
insert into Salas values (5,'Sala Secundaria',2);
insert into Salas values (6,'Sala Principal',3);
insert into Salas values (7,'Sala Secundaria',3);
insert into Salas values (8,'Sala Tercera',3);

insert into Peliculas values (1,'Shrek',7.5,90,'Comedia');
insert into Peliculas values (2,'Interestelar',7.5,169,'Drama');
insert into Peliculas values (3,'John Wick',7.5,101,'Acción');
insert into Peliculas values (4,'Hello Kitty Becomes A Princess',7.5,55,'Terror');
insert into Peliculas values (5,'Zatura',7.5,101,'Ciencia Ficción');
insert into Peliculas values (6,'Top Gun',7.5,140,'Ciencia Ficción');
insert into Peliculas values (7,'Fast and Furious',7.5,120,'Ciencia Ficción');
insert into Peliculas values (8,'Dinosaurios',7.5,90,'Ciencia Ficción');
insert into Peliculas values (9,'Padre no hay más que uno',7.5,105,'Comedia');
insert into Peliculas values (10,'Torrente 3',7.5,90,'Comedia');
insert into Peliculas values (11, 'Jurassic Park', 8.0, 127, 'Ciencia Ficción');
insert into Peliculas values (12, 'The Dark Knight', 8.5, 152, 'Acción');
insert into Peliculas values (13, 'Forrest Gump', 8.0, 142, 'Drama');
insert into Peliculas values (14, 'Pulp Fiction', 8.5, 154, 'Drama');
insert into Peliculas values (15, 'The Matrix', 8.0, 136, 'Ciencia Ficción');
insert into Peliculas values (16, 'Terminator 2: Judgment Day', 8.0, 137, 'Acción');
insert into Peliculas values (17, 'The Lion King', 8.0, 88, 'Animación');
insert into Peliculas values (18, 'The Shawshank Redemption', 8.5, 142, 'Drama');
insert into Peliculas values (19, 'The Godfather', 8.5, 175, 'Drama');
insert into Peliculas values (20, 'Star Wars: Episode IV - A New Hope', 8.0, 121, 'Ciencia Ficción');
insert into Peliculas values (21, 'Avatar', 8.0, 162, 'Ciencia Ficción');
insert into Peliculas values (22, 'Titanic', 8.0, 194, 'Drama');
insert into Peliculas values (23, 'Inception', 8.5, 148, 'Ciencia Ficción');
insert into Peliculas values (24, 'Fight Club', 8.5, 139, 'Drama');
insert into Peliculas values (25, 'The Lord of the Rings: The Fellowship of the Ring', 8.0, 178, 'Fantasía');
insert into Peliculas values (26, 'The Silence of the Lambs', 8.0, 118, 'Drama');
insert into Peliculas values (27, 'Goodfellas', 8.0, 146, 'Drama');
insert into Peliculas values (28, 'Gladiator', 8.0, 155, 'Acción');
insert into Peliculas values (29, 'The Departed', 8.5, 151, 'Drama');
insert into Peliculas values (30, 'Saving Private Ryan', 8.0, 169, 'Acción');
insert into Peliculas values (31, 'The Terminator', 8.0, 107, 'Acción');
insert into Peliculas values (32, 'Batman Begins', 8.0, 140, 'Acción');
insert into Peliculas values (33, 'The Dark Knight Rises', 8.0, 164, 'Acción');
insert into Peliculas values (34, 'The Godfather: Part II', 8.5, 202, 'Drama');
insert into Peliculas values (35, 'The Lord of the Rings: The Two Towers', 8.0, 179, 'Fantasía');
insert into Peliculas values (36, 'The Silence of the Lambs', 8.5, 118, 'Suspenso');
insert into Peliculas values (37, 'Pulp Fiction', 8.5, 154, 'Drama');
insert into Peliculas values (38, 'The Shawshank Redemption', 9.3, 142, 'Drama');
insert into Peliculas values (39, 'The Matrix', 8.7, 136, 'Acción');
insert into Peliculas values (40, 'Inception', 8.8, 148, 'Ciencia Ficción');
insert into Peliculas values (41, 'The Prestige', 8.5, 130, 'Drama');
insert into Peliculas values (42, 'The Dark Knight Rises', 8.4, 165, 'Acción');
insert into Peliculas values (43, 'Star Wars: Episode IV - A New Hope', 8.6, 121, 'Ciencia Ficción');
insert into Peliculas values (44, 'The Lion King', 8.5, 89, 'Animación');
insert into Peliculas values (45, 'The Little Mermaid', 7.6, 83, 'Animación');
insert into Peliculas values (46, 'Coco', 8.4, 105, 'Animación');
insert into Peliculas values (47, 'Up', 8.2, 96, 'Animación');
insert into Peliculas values (48, 'Finding Nemo', 8.1, 100, 'Animación');
insert into Peliculas values (49, 'The Incredibles', 8.0, 115, 'Animación');
insert into Peliculas values (50, 'Ratatouille', 8.0, 111, 'Animación');


insert into Sesiones values (1,'2023-02-07','16:00',1,1);
insert into Sesiones values (2,'2023-02-17','18:00',5,2);
insert into Sesiones values (3,'2023-02-09','12:30',1,3);
insert into Sesiones values (4,'2023-02-08','16:00',2,4);
insert into Sesiones values (5,'2023-02-08','18:00',3,5);
insert into Sesiones values (6,'2023-02-07','12:30',2,6);
insert into Sesiones values (7,'2023-02-17','12:30',4,7);
insert into Sesiones values (8,'2023-02-08','12:30',3,8);
insert into Sesiones values (9,'2023-02-17','12:30',2,1);
insert into  Sesiones values (10,'2023-02-07','16:30',1,1);
insert into  Sesiones values (11,'2023-02-10','16:30',5,5);
insert into  Sesiones values (12,'2023-02-10','16:30',5,2);
insert into  Sesiones values (13,'2023-02-10','16:30',5,8);
insert into  Sesiones values (14,'2023-02-10','16:30',5,1);
insert into  Sesiones values (15,'2023-03-01','16:00',6,8);
insert into  Sesiones values (16,'2023-03-01','16:00',6,7);
insert into  Sesiones values (17,'2023-03-01','15:30',6,1);
insert into  Sesiones values (18,'2023-03-01','16:00',6,4);
insert into  Sesiones values (19,'2023-03-10','17:30',7,1);
insert into  Sesiones values (20,'2023-03-10','17:00',7,3);
insert into  Sesiones values (21,'2023-03-10','17:30',7,8);
insert into  Sesiones values (22,'2023-03-10','17:00',7,5);
insert into  Sesiones values (23,'2023-03-01','16:00',8,3);
insert into  Sesiones values (24,'2023-03-01','16:30',8,5);
insert into  Sesiones values (25,'2023-03-01','16:00',8,8);
insert into  Sesiones values (26,'2023-03-01','16:30',8,2);
insert into  Sesiones values (27,'2023-03-02','17:00',9,6);
insert into  Sesiones values (28,'2023-03-02','17:00',9,3);
insert into  Sesiones values (29,'2023-03-02','17:45',9,4);
insert into  Sesiones values (30,'2023-03-02','17:00',9,7);
insert into  Sesiones values (31,'2023-03-04','18:45',10,5);
insert into  Sesiones values (32,'2023-03-04','18:00',10,8);
insert into  Sesiones values (33,'2023-03-04','18:30',10,1);
insert into  Sesiones values (34,'2023-03-04','18:00',10,2);
insert into Sesiones values (35,'2023-03-05','15:00',2,3);
insert into Sesiones values (36,'2023-03-06','17:30',4,4);
insert into Sesiones values (37,'2023-03-07','13:00',1,5);
insert into Sesiones values (38,'2023-03-08','14:30',3,6);
insert into Sesiones values (39,'2023-03-09','11:00',5,7);
insert into Sesiones values (40,'2023-03-10','16:00',38,2);
insert into Sesiones values (41,'2023-03-11','19:00',4,1);
insert into Sesiones values (42,'2023-03-12','10:30',38,2);
insert into Sesiones values (43,'2023-03-13','15:30',3,3);
insert into Sesiones values (44,'2023-03-14','12:00',5,4);
insert into Sesiones values (45,'2023-03-15','16:30',2,5);
insert into Sesiones values (46,'2023-03-16','18:00',4,6);
insert into Sesiones values (47,'2023-03-17','13:30',1,7);
insert into Sesiones values (48,'2023-03-18','15:00',3,8);
insert into Sesiones values (49,'2023-03-19','10:00',5,1);
insert into Sesiones values (50,'2023-03-20','17:00',2,2);
insert into Sesiones values (51,'2023-03-21','14:00',4,3);
insert into Sesiones values (52,'2023-03-22','12:30',1,4);
insert into Sesiones values (53,'2023-03-23','16:00',3,5);
insert into Sesiones values (54,'2023-03-24','18:30',5,6);
insert into Sesiones values (55,'2023-03-25','11:30',2,7);
insert into Sesiones values (56,'2023-03-26','13:00',4,8);
insert into Sesiones values (57,'2023-03-27','15:30',1,1);
insert into Sesiones values (58,'2023-03-28','17:00',3,2);
insert into Sesiones values (59,'2023-03-29','12:00',5,3);
insert into Sesiones values (60,'2023-03-30','16:30',2,4);
insert into Sesiones values (61,'2023-03-31','18:00',4,5);
insert into Sesiones values (62,'2023-04-01','13:30',1,6);
insert into Sesiones values (63,'2023-04-02','15:00',3,7);
insert into Sesiones values (64,'2023-04-03','10:00',5,8);


insert into Cliente values (12345678,'Juan','Mano Calva','H','12345');
insert into Cliente values (87654321,'Manoli','Garcia Guti','F','54321');

insert into Pedido values(null,12345678,15);
insert into Pedido values(null,87654321,15);
insert into Pedido values(null,12345678,17);
insert into Pedido values(null,87654321,125);
insert into Pedido values(null,12345678,130);

insert into Entrada values(null,5,1);
insert into Entrada values(null,3,2);
insert into Entrada values(null,20,3);
insert into Entrada values(null,15,4);
insert into Entrada values(null,31,5);






