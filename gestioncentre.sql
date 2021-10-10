-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 15 fév. 2021 à 18:20
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestioncentre`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `CIN` varchar(8) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `NomF` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`CIN`, `Nom`, `Prenom`, `NomF`) VALUES
('11111111', 'firas', 'zarai', 'java'),
('22222222', 'fedi', 'zarai', 'xml'),
('33333333', 'ahmed', 'ahmed', 'html'),
('44444444', 'ali', 'ali', 'css'),
('55555555', 'manel', 'manel', 'js'),
('77777777', 'mounir', 'mounir', 'xml');

-- --------------------------------------------------------

--
-- Structure de la table `formateurs`
--

DROP TABLE IF EXISTS `formateurs`;
CREATE TABLE IF NOT EXISTS `formateurs` (
  `NomFor` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `NomF` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formateurs`
--

INSERT INTO `formateurs` (`NomFor`, `Email`, `NomF`) VALUES
('zarai', 'zarai@mail.com', 'java'),
('firas', 'firas@mail.com', 'java'),
('fedi', 'fedi@mail.com', 'html'),
('fedi', 'fedi@mail.com', 'js'),
('mounir', 'mounir', 'boostrap'),
('firaszarai', 'za@mail.com', 'xml');

-- --------------------------------------------------------

--
-- Structure de la table `formations`
--

DROP TABLE IF EXISTS `formations`;
CREATE TABLE IF NOT EXISTS `formations` (
  `NomF` varchar(30) NOT NULL,
  `Prix` varchar(30) NOT NULL,
  `Horaire` varchar(30) NOT NULL,
  `salle` varchar(30) NOT NULL,
  `Jour` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formations`
--

INSERT INTO `formations` (`NomF`, `Prix`, `Horaire`, `salle`, `Jour`) VALUES
('xml', ' 120', '8h à 12h', 'salle1', 'Lundi'),
('java', ' 100', '8h à 12h', 'salle1', 'Lundi'),
('html', '130', '8h à 12h', 'salle1', 'Lundi'),
('css', '160', '13h à 16h', 'salle2', 'Mercredi'),
('js', '90', '13h à 16h', 'salle1', 'Jeudi'),
('css', '920', '13h à 16h', 'salle2', 'Lundi'),
('boostrap', ' 90', '13h à 16h', 'salle2', 'Lundi');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
