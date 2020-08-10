-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2020 at 09:58 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chayaprakashani`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL,
  `course_date` datetime DEFAULT NULL,
  `course_fee` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_teacher` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `course_date`, `course_fee`, `course_name`, `course_teacher`) VALUES
(140, '2020-10-08 17:33:28', 6000, 'Java', 'Styajit Banerjee'),
(141, '2020-10-19 17:33:30', 26000, 'SAP', 'Upama Nirjharini'),
(142, '2020-11-13 17:33:30', 13000, 'DataScience', 'Pratima Jaya'),
(143, '2020-12-13 17:33:22', 15000, 'Cyber Security', 'Charchita Mandal'),
(144, '2021-01-01 17:33:30', 6200, 'Angular Js', 'Sumona pal'),
(145, '2021-02-08 17:33:30', 7000, 'Cisco', 'Dixon Jana'),
(146, '2020-01-19 17:33:30', 16000, 'Machine Learning', 'Martha Nielson'),
(147, '2020-02-19 17:33:30', 8000, 'Web desinging', 'Adam Radcliffe'),
(148, '2020-01-29 17:33:30', 6200, 'Docker', 'Eva Jonas'),
(149, '2020-03-19 17:33:30', 7600, 'Android', 'Fatema Begam');

-- --------------------------------------------------------

--
-- Table structure for table `studentid_seq`
--

CREATE TABLE `studentid_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentid_seq`
--

INSERT INTO `studentid_seq` (`next_val`) VALUES
(6);

-- --------------------------------------------------------

--
-- Table structure for table `students_courses`
--

CREATE TABLE `students_courses` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students_courses`
--

INSERT INTO `students_courses` (`course_id`, `student_id`) VALUES
(142, 1),
(140, 2),
(145, 1),
(145, 2),
(141, 3),
(149, 3),
(143, 4),
(147, 4),
(144, 5),
(146, 5);

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `email`, `first_name`, `last_name`, `mobile`, `password`, `roles`, `user_id`) VALUES
(0, 'ADMIN@GMAIL.COM', 'ADMIN', 'ADMIN', '7894561230', 'admin123', 'ROLE_ADMIN', 'Adminadmin1234'),
(1, 'madhurima@gmail.com', 'Madhurima', 'Sanyal', '7197541131', 'omadhu12', 'ROLE_USER', 'madhurimasan123'),
(2, 'basugaya@gmail.com', 'Gayatri', 'Basu', '7197891132', 'jontrona', 'ROLE_USER', 'gayatriBasu7896'),
(3, 'apte123@gmail.com', 'Radhika', 'Apte', '9877891132', '789poi', 'ROLE_USER', 'apteradhu1456'),
(4, 'halderjoyonto@gmail.com', 'Joyonto', 'Haldar', '9877832132', 'qwer784', 'ROLE_USER', 'Joyonto8520Hal'),
(5, 'digonto@gmail.com', 'Digonto', 'Goswami', '8927832132', 'odigonto', 'ROLE_USER', 'digontoharalo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD KEY `FKjaqm5ljo0fujxfq2hd73mchk8` (`student_id`),
  ADD KEY `FKcc42107lsifo5rjyjlhdu6i6u` (`course_id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `UK_dgdone897swihpmi3wkjegrxy` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD CONSTRAINT `FKcc42107lsifo5rjyjlhdu6i6u` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  ADD CONSTRAINT `FKjaqm5ljo0fujxfq2hd73mchk8` FOREIGN KEY (`student_id`) REFERENCES `student_details` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
