create database Reto3BDbb;
use Reto3BDbb;

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

create table Entrada(
	id_entrada int primary key not null auto_increment,
    id_sesion int not null,
    Constraint FK_Sesiones_Entrada foreign key (id_sesion) references Sesiones(id_sesion)on update cascade

    
);

create table Cliente (
    dni int primary key not null,
    nombre varchar (30) not null,
    Apellidos varchar (30) not null,
    sexo varchar (1) not null,
    contrasena varchar(30) not null
);

create table Pedido (
	id_pedido int primary key not null auto_increment,
	dni int not null,
    num_pedido int not null,
    precioTotal float not null,
    Constraint FK_Cliente_Pedido foreign key (dni) references Cliente(dni)on update cascade
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

insert into Cliente values (12345678,'Juan','Mano Calva','H','12345');
insert into Cliente values (87654321,'Manoli','Garcia Guti','F','54321');

