-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2017 at 02:02 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `username` varchar(10) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`username`, `password`) VALUES
('rofi', '1234'),
('roman', '1234'),
('admin', 'admin'),
('sumanto', 'sukirman'),
('admon', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `datapinjam`
--

CREATE TABLE `datapinjam` (
  `nama` text NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `noresi` int(10) NOT NULL,
  `nopol` varchar(10) NOT NULL,
  `pinjam` date NOT NULL,
  `kembali` date NOT NULL,
  `harga` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datapinjam`
--

INSERT INTO `datapinjam` (`nama`, `alamat`, `noresi`, `nopol`, `pinjam`, `kembali`, `harga`) VALUES
('Sisuka', 'Jl.Jepun Nippon A6 Sukarno', 5864, 'M 5234 LE', '2017-03-18', '2017-03-21', 60000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
