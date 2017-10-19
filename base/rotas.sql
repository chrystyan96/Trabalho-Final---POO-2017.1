# Host: localhost  (Version 5.5.5-10.1.25-MariaDB)
# Date: 2017-10-19 11:04:31
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "localidade"
#

DROP TABLE IF EXISTS `localidade`;
CREATE TABLE `localidade` (
  `id` varchar(10) NOT NULL,
  `nome` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "localidade"
#


#
# Structure for table "rotas"
#

DROP TABLE IF EXISTS `rotas`;
CREATE TABLE `rotas` (
  `id` varchar(10) NOT NULL,
  `origem` varchar(20) DEFAULT '',
  `destino` varchar(20) DEFAULT '',
  `custoGrama` float DEFAULT '0',
  `capacidadeTotal` float DEFAULT '0',
  `capacidadeAlocada` float DEFAULT '0',
  `tempoDeEntrega` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "rotas"
#

