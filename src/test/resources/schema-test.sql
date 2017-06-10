drop TABLE areacomun if EXISTS ;

CREATE TABLE areacomun (
  id INTEGER IDENTITY PRIMARY KEY,
  codigo VARCHAR(30),
  nombre  VARCHAR(50)
);

drop TABLE inquilino if EXISTS ;

create table inquilino(
  id integer identity primary key,
  codigo varchar(30),
  nombre varchar(30)
);

drop TABLE solicitud_areacomun if EXISTS ;

create table solicitud_areacomun(
  id integer identity primary key,
  areacomun_id int ,
  inquilino_id int,
  fecha_solicitud date
);