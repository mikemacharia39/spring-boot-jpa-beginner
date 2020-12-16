
SET time_zone = "+03:00";

--
-- Database: `my_company`
--

CREATE DATABASE my_company;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `employeeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `emailAddress` varchar(150) DEFAULT NULL,
  `active` tinyint(3) NOT NULL DEFAULT '1',
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB;

--
-- Dumping data for table `employees`
--

INSERT IGNORE INTO `employees` (`employeeID`, `firstName`, `lastName`, `emailAddress`, `active`, `dateCreated`, `dateModified`) VALUES
(1, 'Mikehenry', 'Maina', 'mikemacharia39@gmail.com', 1, '2020-12-14 08:31:00', '2020-12-13 21:00:00'),
(2, 'Maxwell', 'Mzito', NULL, 1, '2020-12-14 10:58:38', '2020-12-14 10:58:38'),
(3, 'James Wambua', 'Mwanza', NULL, 1, '2020-12-14 14:01:59', '2020-12-14 14:01:59');
