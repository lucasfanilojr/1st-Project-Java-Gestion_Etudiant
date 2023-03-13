CREATE DATABASE gestionuniversite;
use gestionuniversite;

CREATE TABLE IF NOT EXISTS `cours` (
  `codeC` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(47) DEFAULT NULL,
  `coefficient` int(11) DEFAULT NULL,
  PRIMARY KEY (`codeC`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `etudiant` (
  `matriE` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `codeC` int(11) NOT NULL,
  PRIMARY KEY (`matriE`),
  KEY `codeC` (`codeC`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `professeur` (
  `matricule` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `codeC` int(11) NOT NULL,
  PRIMARY KEY (`matricule`),
  KEY `codeC` (`codeC`)
) ENGINE=MyISAM;