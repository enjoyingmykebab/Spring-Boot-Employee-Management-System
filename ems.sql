-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 17, 2021 at 07:04 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ems`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(36) NOT NULL,
  `role_id` int(36) NOT NULL,
  `full_name` varchar(128) NOT NULL,
  `birth_date` varchar(10) NOT NULL,
  `home_address` varchar(512) NOT NULL,
  `domicile_address` varchar(512) DEFAULT NULL,
  `phone_number` varchar(24) NOT NULL,
  `email` varchar(48) NOT NULL,
  `password` text NOT NULL,
  `created_at` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `role_id`, `full_name`, `birth_date`, `home_address`, `domicile_address`, `phone_number`, `email`, `password`, `created_at`) VALUES
(1, 1, 'Bohn Doe', '05-11-1999', 'CJ, Indonesia', 'WJ, Indonesia', '62', 'admin@bondopangaji.com', '5f4dcc3b5aa765d61d8327deb882cf99', '2021-10-09'),
(2, 2, 'John Doe', '11-05-1999', 'SW, Malaysia', 'MT, Singapore', '62', 'employee1@bondopangaji.com', '5f4dcc3b5aa765d61d8327deb882cf99', '2021-10-10'),
(17, 2, 'Jane Doe', '06-12-2001', 'WS, Indonesia', 'WP, Indonesia', '62', 'employee2@bondopangaji.com', '5f4dcc3b5aa765d61d8327deb882cf99', '2021-10-16');

-- --------------------------------------------------------

--
-- Table structure for table `payroll`
--

CREATE TABLE `payroll` (
  `payroll_id` int(36) NOT NULL,
  `employee_id` int(36) NOT NULL,
  `payroll_date` varchar(10) NOT NULL,
  `hourly_rate` bigint(255) NOT NULL,
  `annual_salary` bigint(255) NOT NULL,
  `tax` int(255) NOT NULL,
  `net_salary` bigint(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payroll`
--

INSERT INTO `payroll` (`payroll_id`, `employee_id`, `payroll_date`, `hourly_rate`, `annual_salary`, `tax`, `net_salary`) VALUES
(9, 2, '11-10-2021', 5, 60, 5, 57);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(36) NOT NULL,
  `role_title` varchar(48) NOT NULL,
  `role_description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_title`, `role_description`) VALUES
(1, 'Admin', 'Admin privilege'),
(2, 'Employee', 'Employee privilege');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `FK_ROLE_ID` (`role_id`) USING BTREE;

--
-- Indexes for table `payroll`
--
ALTER TABLE `payroll`
  ADD PRIMARY KEY (`payroll_id`),
  ADD KEY `FK_EMPLOYEE_ID` (`employee_id`) USING BTREE;

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(36) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `payroll`
--
ALTER TABLE `payroll`
  MODIFY `payroll_id` int(36) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(36) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_roleid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payroll`
--
ALTER TABLE `payroll`
  ADD CONSTRAINT `payroll_employeeid_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

