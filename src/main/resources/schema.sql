drop table if EXISTS  areacomun;

CREATE TABLE areacomun (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


drop table IF EXISTS inquilino;

create table inquilino (
  id int(11) unsigned not null auto_increment,
  codigo varchar(30) default 'cod',
  nombre varchar(50) default '',
  PRIMARY KEY (id)

) engine=InnoDB default charset = latin1;