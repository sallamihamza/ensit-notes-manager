-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 31, 2024 at 09:48 PM
-- Server version: 5.6.20-log
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `affectation`
--

CREATE TABLE IF NOT EXISTS `affectation` (
`id_affectation` int(10) NOT NULL,
  `id_utilisateur` int(10) DEFAULT NULL,
  `id_classe` int(10) DEFAULT NULL,
  `id_matiere` int(10) DEFAULT NULL,
  `annee_scolaire` varchar(10) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE IF NOT EXISTS `classes` (
`id_classe` int(10) NOT NULL,
  `nom_classe` varchar(50) NOT NULL,
  `niveau` varchar(50) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`id_classe`, `nom_classe`, `niveau`) VALUES
(1, 'Math 101', 'Secondary'),
(2, 'Physics 101', 'University'),
(3, 'Chemistry 101', 'Primary'),
(4, 'Biology 101', 'Secondary'),
(5, 'History 101', 'University'),
(6, 'Literature 101', 'Primary'),
(7, 'Computer Science 101', 'Secondary'),
(8, 'Music 101', 'University'),
(9, 'Geography 101', 'Primary'),
(10, 'Art 101', 'Secondary');

-- --------------------------------------------------------

--
-- Table structure for table `classes_matiere`
--

CREATE TABLE IF NOT EXISTS `classes_matiere` (
  `id_classe` int(10) NOT NULL DEFAULT '0',
  `id_matiere` int(10) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes_matiere`
--

INSERT INTO `classes_matiere` (`id_classe`, `id_matiere`) VALUES
(10, 15);

-- --------------------------------------------------------

--
-- Table structure for table `etudiants`
--

CREATE TABLE IF NOT EXISTS `etudiants` (
`id_etudiant` int(10) NOT NULL,
  `nom_etudiant` varchar(20) NOT NULL,
  `prenom_etudiant` varchar(20) NOT NULL,
  `cin_etudiant` varchar(20) DEFAULT NULL,
  `tel_etudiant` varchar(20) DEFAULT NULL,
  `date_naissance` date NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `num_inscription` int(20) NOT NULL,
  `nom_classe` varchar(20) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `etudiants`
--

INSERT INTO `etudiants` (`id_etudiant`, `nom_etudiant`, `prenom_etudiant`, `cin_etudiant`, `tel_etudiant`, `date_naissance`, `adresse`, `num_inscription`, `nom_classe`) VALUES
(2, 'Smith', 'Anna', '87654321', '', '2004-09-21', 'Rue 2, france', 1002, 'GMAM3'),
(3, 'Brown', 'Michael', '56781234', '87654321', '2000-05-25', 'Rue 3, Tunis', 1003, '5ème B'),
(4, 'Wilson', 'Emma', '43218765', '76543210', '2003-07-08', 'Rue 4, Tunis', 1004, 'History 101');

-- --------------------------------------------------------

--
-- Table structure for table `matieres`
--

CREATE TABLE IF NOT EXISTS `matieres` (
`id_matiere` int(10) NOT NULL,
  `nom_matiere` varchar(50) NOT NULL,
  `coefficient` int(5) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `matieres`
--

INSERT INTO `matieres` (`id_matiere`, `nom_matiere`, `coefficient`) VALUES
(1, 'Mathematics', 5),
(2, 'Physics', 4),
(3, 'Chemistry', 3),
(4, 'Biology', 2),
(5, 'History', 4),
(6, 'Literature', 3),
(7, 'Computer Science', 5),
(8, 'Music', 2),
(9, 'Geography', 3),
(10, 'Art', 4),
(11, 'Geography', 55),
(15, 'info', 5);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
`id_utilisateur` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `nom_utilisateur` varchar(50) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `role` enum('ENSEIGNANT','ADMIN') NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `date_naissance` date NOT NULL,
  `cin_utilisateur` varchar(20) NOT NULL,
  `grade` varchar(50) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `prenom`, `nom_utilisateur`, `mot_de_passe`, `role`, `telephone`, `date_naissance`, `cin_utilisateur`, `grade`) VALUES
(1, 'John', 'Doe', 'jdoe', 'password123', 'ENSEIGNANT', '123456789', '1985-01-01', '123456789', 'Professeur'),
(2, 'Jane', 'Smith', 'jsmith', 'password456', 'ADMIN', '987654321', '1990-02-15', '987654321', NULL),
(3, 'Alice', 'Johnson', 'alicej', 'password789', 'ENSEIGNANT', '123987456', '1983-05-21', '135792468', 'Professor'),
(4, 'Bob', 'White', 'bobw', 'password321', 'ADMIN', '456123789', '1987-09-14', '112233445', NULL),
(5, 'Charlie', 'Brown', 'charlieb', 'password654', 'ENSEIGNANT', '321654987', '1980-11-30', '998877665', 'Lecturer'),
(6, 'David', 'Green', 'dgreen', 'password888', 'ADMIN', '222333444', '1992-03-10', '556677889', NULL),
(7, 'Emma', 'Taylor', 'emmat', 'password222', 'ENSEIGNANT', '777888999', '1987-07-17', '223344556', 'Assistant Professor'),
(8, 'Frank', 'Wilson', 'frankw', 'password000', 'ADMIN', '555444333', '1989-11-05', '112233667', NULL),
(9, 'Grace', 'Lewis', 'gracel', 'password111', 'ENSEIGNANT', '999777666', '1986-12-19', '667788990', 'Associate Professor'),
(10, 'Hannah', 'Martinez', 'hannahm', 'password333', 'ENSEIGNANT', '444333222', '1984-02-03', '889900112', 'Head of Department');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `affectation`
--
ALTER TABLE `affectation`
 ADD PRIMARY KEY (`id_affectation`), ADD KEY `id_utilisateur` (`id_utilisateur`), ADD KEY `id_classe` (`id_classe`), ADD KEY `id_matiere` (`id_matiere`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
 ADD PRIMARY KEY (`id_classe`);

--
-- Indexes for table `classes_matiere`
--
ALTER TABLE `classes_matiere`
 ADD PRIMARY KEY (`id_classe`,`id_matiere`), ADD KEY `id_matiere` (`id_matiere`);

--
-- Indexes for table `etudiants`
--
ALTER TABLE `etudiants`
 ADD PRIMARY KEY (`id_etudiant`), ADD UNIQUE KEY `nom_etudiant` (`nom_etudiant`), ADD UNIQUE KEY `prenom_etudiant` (`prenom_etudiant`), ADD KEY `fk_classses` (`nom_classe`);

--
-- Indexes for table `matieres`
--
ALTER TABLE `matieres`
 ADD PRIMARY KEY (`id_matiere`);

--
-- Indexes for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
 ADD PRIMARY KEY (`id_utilisateur`), ADD UNIQUE KEY `nom_utilisateur` (`nom_utilisateur`), ADD UNIQUE KEY `cin_utilisateur` (`cin_utilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `affectation`
--
ALTER TABLE `affectation`
MODIFY `id_affectation` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
MODIFY `id_classe` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `etudiants`
--
ALTER TABLE `etudiants`
MODIFY `id_etudiant` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `matieres`
--
ALTER TABLE `matieres`
MODIFY `id_matiere` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
MODIFY `id_utilisateur` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
