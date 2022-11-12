create table usuario(
                        idusuario serial not null primary key,
                        nickname char(30) not null ,
                        clave char(30) not null ,
                        admin boolean
);

create table encuesta(
                         idencuesta serial not null primary key,
                         idusuario int references usuario(idusuario),
                         nombre varchar(200),
                         sexo varchar(200),
                         deporte varchar(200),
                         temafavorito varchar(200),
                         nivelestudio varchar(200),
                         fecha date,
                         hora time
);

create or replace view select_datos as
select
    sum(case when e.sexo = 'Femenino' then 1 else 0 end) as Femenino,
    sum(case when e.sexo = 'Masculino' then 1 else 0 end) as Masculino
from encuesta e;

create or replace view select_datos_deportes as
select
    sum(case when e.deporte = 'Futbol' then 1 else 0 end) as Futbol,
    sum(case when e.deporte = 'Basketball' then 1 else 0 end) as Basketball,
    sum(case when e.deporte = 'Jockey' then 1 else 0 end) as Jockey,
    sum(case when e.deporte = 'Baseball' then 1 else 0 end) as Baseball,
    sum(case when e.deporte = 'Golf' then 1 else 0 end) as Golf
from encuesta e;

select * from select_datos;
select * from select_datos_deportes;

insert into usuario (nickname, clave, admin)
values ('admin','1234',true);