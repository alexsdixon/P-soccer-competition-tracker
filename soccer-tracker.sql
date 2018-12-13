-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Oct 15, 2018 at 07:00 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soccer-tracker`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `topic` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `created`, `description`, `topic`) VALUES
(1, '2018-10-04 12:32:41', 'The first match in the competition will take place on October 6 where Rockfort FC will face long time rival Spartans.', 'League Opening Match'),
(2, '2018-10-04 12:33:58', 'Tim McDonald says his team is ready to take on Spartans.', 'Rockfort FC Ready'),
(3, '2018-10-04 12:36:43', 'Lead Analyst Tom Tavarez said he believes Arnett Gardens FC Will win the Competition. He then went on to praise Lionel Messi as the best player in the competition.', 'Analyst Opinion'),
(4, '2018-10-04 12:38:31', 'Rockfort FC, Arnett Gardens FC and Harbour View United.', 'Top 3 Pick '),
(5, '2018-10-04 12:40:48', 'Neymar\'s shooting and dribbling abilities are remarkable.', 'Coaches Top Pick - Rockfort FC'),
(6, '2018-10-04 12:42:15', 'Ozil\'s play making abilities and distance shooting will be a problem for the opposition.', 'Coaches Top Pick - Tivoli United'),
(7, '2018-10-04 12:43:41', 'With the strong defensive tactics and play making abilities Paul Pogba can become the player of the competition.', 'Coaches Top Pick - Panthers FC'),
(8, '2018-10-04 12:44:47', 'Once we have Players like Kante and Hazard we should finish in the top 3.', 'Coaches Top Pick - Harbour View United'),
(9, '2018-10-04 12:45:45', 'Aguero is one of the best Strikers that the world has ever seen and with a player like him i am confident that we can lift the Trophy.', 'Coaches Top Pick - Portmore FC'),
(10, '2018-10-04 12:47:06', 'With the experience and knowledge of Robben and Ribery we should be able to give any team a hard time.', 'Coaches Top Pick - Spartans'),
(11, '2018-10-04 12:48:37', 'My team is the most well rounded team in the competition and with the skills that Gareth Bale have we will definitely win.', 'Coaches Top Pick - Watford FC'),
(12, '2018-10-04 12:51:04', 'Luiz Suarez along with Lionel Messi will definitely shake up this competition.', 'Coaches Top Pick - Arnett Gardens FC');

-- --------------------------------------------------------

--
-- Table structure for table `fixture`
--

CREATE TABLE `fixture` (
  `id` int(11) NOT NULL,
  `away_team_goal` varchar(255) DEFAULT NULL,
  `home_team_goal` varchar(255) DEFAULT NULL,
  `match_date` date NOT NULL,
  `match_time` varchar(255) NOT NULL,
  `ref_name` varchar(255) NOT NULL,
  `team_id` int(11) DEFAULT NULL,
  `team_second_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fixture`
--

INSERT INTO `fixture` (`id`, `away_team_goal`, `home_team_goal`, `match_date`, `match_time`, `ref_name`, `team_id`, `team_second_id`) VALUES
(17, '1', '3', '2018-10-06', '1:00 PM', 'Alex Dixon', 1, 6),
(18, '4', '0', '2018-10-06', '4:00 PM', 'John Smith', 8, 5),
(19, '1', '1', '2018-10-07', '1:00 PM', 'Alex Dixon', 7, 4),
(20, '0', '2', '2018-10-07', '4:00 PM', 'John Smith', 2, 3),
(21, '0', '2', '2018-10-13', '1:00 PM', 'Alex Dixon', 1, 5),
(22, '2', '2', '2018-10-13', '4:00 PM', 'John Smith', 6, 4),
(23, '3', '0', '2018-10-14', '1:00 PM', 'Alex Dixon', 8, 2),
(24, '1', '1', '2018-10-14', '4:00 PM', 'John Smith', 3, 7),
(25, '', '', '2018-10-20', '1:00 PM', 'Alex Dixon', 8, 6),
(26, '', '', '2018-10-20', '4:00 PM', 'John Smith', 1, 2),
(27, '', '', '2018-10-21', '1:00 PM', 'Alex Dixon', 7, 5),
(28, '', '', '2018-10-21', '4:00 PM', 'John Smith', 3, 4),
(29, '', '', '2018-10-28', '1:00 PM', 'Alex Dixon', 1, 8),
(30, '', '', '2018-10-28', '4:00 PM', 'John Smith', 7, 6),
(31, '', '', '2018-10-29', '1:00 PM', 'Alex Dixon', 3, 5),
(32, '', '', '2018-10-29', '4:00 PM', 'John Smith', 2, 4),
(33, '', '', '2018-11-03', '1:00 PM', 'Alex Dixon', 3, 8),
(34, '', '', '2018-11-03', '4:00 PM', 'John Smith', 7, 2),
(35, '', '', '2018-11-04', '1:00 PM', 'Alex Dixon', 1, 4),
(36, '', '', '2018-11-04', '4:00 PM', 'John Smith', 6, 5),
(37, '', '', '2018-11-10', '1:00 PM', 'Alex Dixon', 1, 7),
(38, '', '', '2018-11-10', '4:00 PM', 'John Smith', 8, 4),
(39, '', '', '2018-11-11', '1:00 PM', 'Alex Dixon', 6, 3),
(40, '', '', '2018-11-11', '4:00 PM', 'John Smith', 2, 5),
(41, '', '', '2018-11-17', '1:00 PM', 'Alex Dixon', 1, 3),
(42, '', '', '2018-11-17', '4:00 PM', 'John Smith', 8, 7),
(43, '', '', '2018-11-18', '1:00 PM', 'Alex Dixon', 6, 2),
(44, '', '', '2018-11-18', '4:00 PM', 'John Smith', 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `assists` int(11) NOT NULL,
  `clean_sheet` int(11) NOT NULL,
  `games_played` int(11) NOT NULL,
  `goal_scored` int(11) NOT NULL,
  `player_name` varchar(255) NOT NULL,
  `position` int(11) DEFAULT NULL,
  `red_card` int(11) NOT NULL,
  `yellow_card` int(11) NOT NULL,
  `team_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id`, `assists`, `clean_sheet`, `games_played`, `goal_scored`, `player_name`, `position`, `red_card`, `yellow_card`, `team_id`) VALUES
(1, 0, 1, 2, 0, 'Zack R', 0, 0, 0, 1),
(2, 0, 1, 2, 0, 'John Cut', 1, 0, 1, 1),
(3, 1, 2, 2, 0, 'Ronald Martin', 1, 0, 0, 1),
(4, 4, 1, 2, 0, 'Dave Messam', 2, 0, 0, 1),
(5, 0, 1, 2, 0, 'Roy K', 2, 0, 1, 1),
(6, 0, 0, 1, 0, 'Pedro', 3, 0, 0, 1),
(7, 0, 0, 2, 4, 'Neymar', 3, 0, 0, 1),
(8, 0, 1, 2, 1, 'Karim Benzema ', 4, 0, 0, 1),
(9, 0, 1, 1, 0, 'Mark Kruger', 4, 0, 0, 1),
(10, 0, 2, 2, 0, 'Schezny', 0, 0, 0, 2),
(11, 0, 2, 2, 0, 'Kolorav', 1, 0, 1, 2),
(12, 0, 2, 2, 0, 'Mertesacker', 1, 1, 2, 2),
(13, 3, 2, 2, 2, 'Ozil', 2, 0, 0, 2),
(14, 2, 2, 2, 0, 'Mikhetaryan', 2, 0, 0, 2),
(15, 0, 1, 1, 0, 'Theo Walcott', 3, 0, 0, 2),
(16, 0, 2, 2, 1, 'Lacazette', 3, 0, 0, 2),
(17, 0, 2, 2, 2, 'Reus', 4, 0, 0, 2),
(18, 0, 2, 2, 0, 'Schurle', 4, 0, 0, 2),
(19, 0, 0, 2, 0, 'De Gea', 0, 0, 0, 3),
(20, 1, 0, 2, 0, 'Luke Shaw', 1, 0, 1, 3),
(21, 0, 0, 2, 0, 'Grimaldo', 1, 0, 1, 3),
(22, 0, 0, 2, 0, 'Felanni', 2, 0, 0, 3),
(23, 0, 0, 2, 0, 'Paul Pogba', 2, 1, 0, 3),
(24, 0, 0, 2, 0, 'Juan Mata', 3, 0, 0, 3),
(25, 0, 0, 2, 0, 'Marcus Rashford', 3, 0, 0, 3),
(26, 0, 0, 2, 1, 'Lukaaku', 4, 0, 0, 3),
(27, 0, 0, 2, 0, 'Martial', 4, 0, 0, 3),
(28, 0, 0, 2, 0, 'Curtious', 0, 0, 0, 4),
(29, 0, 0, 2, 0, 'David Luiz', 1, 0, 0, 4),
(30, 0, 0, 2, 0, 'Azpilacueta', 1, 0, 0, 4),
(31, 0, 0, 2, 0, 'Kante', 2, 0, 1, 4),
(32, 0, 0, 1, 0, 'Matic', 2, 0, 0, 4),
(33, 2, 0, 2, 2, 'Hazard', 3, 0, 0, 4),
(34, 1, 0, 2, 0, 'Willian', 3, 0, 0, 4),
(35, 0, 0, 2, 1, 'Morata', 4, 0, 0, 4),
(36, 0, 0, 2, 0, 'Giroud', 4, 0, 1, 4),
(37, 0, 1, 2, 0, 'P Chung', 0, 0, 0, 5),
(38, 0, 1, 2, 0, 'Kompany', 1, 0, 1, 5),
(39, 0, 1, 2, 0, 'Mendy', 1, 0, 0, 5),
(40, 3, 1, 2, 1, 'David Silva', 2, 0, 0, 5),
(41, 1, 1, 2, 0, 'De Bruyne', 2, 0, 0, 5),
(42, 0, 1, 2, 0, 'Sane', 3, 0, 1, 5),
(43, 0, 0, 1, 0, 'Raheem Sterling', 3, 0, 0, 5),
(44, 0, 1, 2, 3, 'Aguero', 4, 0, 0, 5),
(45, 0, 1, 2, 0, 'Gabriel Jesus', 4, 0, 0, 5),
(46, 0, 0, 2, 0, 'M.Neur', 0, 0, 0, 6),
(47, 0, 0, 2, 0, 'K.Boateng', 1, 0, 1, 6),
(48, 1, 0, 2, 0, 'David Alaba', 1, 0, 0, 6),
(49, 0, 0, 2, 0, 'Thiago', 2, 0, 0, 6),
(50, 0, 0, 1, 0, 'Javi Martinez', 2, 1, 0, 6),
(51, 1, 0, 2, 0, 'F.Ribery', 3, 0, 0, 6),
(52, 1, 0, 2, 2, 'Robben', 3, 0, 0, 6),
(53, 0, 0, 2, 0, 'Thomas Mueller', 4, 0, 0, 6),
(54, 0, 0, 2, 1, 'R.Lewandowski', 4, 0, 1, 6),
(55, 0, 0, 2, 0, 'Casillas', 0, 0, 0, 7),
(56, 0, 0, 2, 0, 'Pepe', 1, 1, 2, 7),
(57, 0, 0, 2, 0, 'Varane', 1, 0, 0, 7),
(58, 1, 0, 2, 0, 'Isco', 2, 0, 0, 7),
(59, 1, 0, 1, 0, 'Toni Kroos', 2, 0, 0, 7),
(60, 0, 0, 2, 0, 'Vasquez', 3, 0, 0, 7),
(61, 0, 0, 1, 0, 'Marcus Asensio', 3, 0, 0, 7),
(62, 0, 0, 2, 1, 'Griezmann', 4, 0, 0, 7),
(63, 0, 0, 2, 1, 'Gareth Bale', 4, 0, 0, 7),
(64, 0, 0, 2, 0, 'Anelka', 0, 0, 0, 8),
(65, 0, 0, 2, 0, 'Umtitti', 1, 0, 1, 8),
(66, 0, 0, 2, 0, 'Diego Goodin', 1, 0, 1, 8),
(67, 0, 0, 2, 0, 'S.Busquets', 2, 0, 0, 8),
(68, 0, 0, 2, 0, 'Koke', 2, 0, 0, 8),
(69, 0, 0, 2, 0, 'Lionel Messi', 3, 0, 0, 8),
(70, 0, 0, 2, 0, 'Carassco', 3, 0, 0, 8),
(71, 0, 0, 2, 0, 'Luiz Suarez', 4, 0, 1, 8),
(72, 0, 0, 2, 0, 'Diego Costa', 4, 0, 0, 8);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `goal_difference` int(11) NOT NULL,
  `goals_against` int(11) NOT NULL,
  `goals_for` int(11) NOT NULL,
  `matches_draw` int(11) NOT NULL,
  `matches_lost` int(11) NOT NULL,
  `matches_played` int(11) NOT NULL,
  `matches_won` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `team_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`id`, `goal_difference`, `goals_against`, `goals_for`, `matches_draw`, `matches_lost`, `matches_played`, `matches_won`, `points`, `team_name`) VALUES
(1, 4, 1, 5, 0, 0, 2, 2, 6, 'Rockfort FC'),
(2, 5, 0, 5, 0, 0, 2, 2, 6, 'Tivoli United'),
(3, -2, 3, 1, 1, 1, 2, 0, 1, 'Panthers FC'),
(4, 0, 3, 3, 2, 0, 2, 0, 2, 'Harbour View United'),
(5, 2, 2, 4, 0, 1, 2, 1, 3, 'Portmore FC'),
(6, -2, 5, 3, 1, 1, 2, 0, 1, 'Spartans'),
(7, 0, 2, 2, 2, 0, 2, 0, 2, 'Watford United'),
(8, -7, 7, 0, 0, 2, 2, 0, 0, 'Arnett Gardens FC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fixture`
--
ALTER TABLE `fixture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb4kwbteuwnp1ijre59cjh097r` (`team_id`),
  ADD KEY `FK6ux4hlemep7xeaombq6rt57gt` (`team_second_id`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdvd6ljes11r44igawmpm1mc5s` (`team_id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `fixture`
--
ALTER TABLE `fixture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;
--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `fixture`
--
ALTER TABLE `fixture`
  ADD CONSTRAINT `FK6ux4hlemep7xeaombq6rt57gt` FOREIGN KEY (`team_second_id`) REFERENCES `team` (`id`),
  ADD CONSTRAINT `FKb4kwbteuwnp1ijre59cjh097r` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`);

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `FKdvd6ljes11r44igawmpm1mc5s` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
