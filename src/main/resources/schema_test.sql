
CREATE TABLE areacomun (
  id INTEGER IDENTITY PRIMARY KEY,
  codigo VARCHAR(30),
  nombre  VARCHAR(50)
);


create table inquilino(
  id integer identity primary key,
  codigo varchar(30),
  nombres varchar(30)
);


create table solicitud_areacomun(
  id integer identity primary key,
  areacomun_id int ,
  inquilino_id int,
  fecha_solicitud date
);