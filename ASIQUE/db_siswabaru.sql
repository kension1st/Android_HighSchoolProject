-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2018 at 09:12 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_siswabaru`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_asal_sekolah`
--

CREATE TABLE `tb_asal_sekolah` (
  `id_sekolah` int(11) NOT NULL,
  `nama_sekolah` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_asal_sekolah`
--

INSERT INTO `tb_asal_sekolah` (`id_sekolah`, `nama_sekolah`) VALUES
(121, 'SMP PGRI 2 DENPASAR'),
(122, 'SMP PGRI 3 DENPASAR');

-- --------------------------------------------------------

--
-- Table structure for table `tb_calon_siswa`
--

CREATE TABLE `tb_calon_siswa` (
  `id_calonsiswa` int(11) NOT NULL,
  `id_sekolah` int(11) DEFAULT NULL,
  `id_staff` int(11) DEFAULT NULL,
  `kode_jurusan` int(11) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `nisn` varchar(10) DEFAULT NULL,
  `nik` int(11) DEFAULT NULL,
  `alamat` varchar(30) DEFAULT NULL,
  `jk` varchar(15) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `nama_wali` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_calon_siswa`
--

INSERT INTO `tb_calon_siswa` (`id_calonsiswa`, `id_sekolah`, `id_staff`, `kode_jurusan`, `nama`, `nisn`, `nik`, `alamat`, `jk`, `no_telp`, `nama_wali`) VALUES
(101, 121, 22, 12, 'Gede Putra', '0003718273', 2147483647, 'Denpasar', 'Laki - Laki', '089604355348', 'Gede Wayan'),
(102, 122, 22, 12, 'Joko Suparman', '0003005021', 3456345, 'Denpasar', 'Laki - Laki', '06798679321', 'Wetok');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jurusan`
--

CREATE TABLE `tb_jurusan` (
  `kode_jurusan` int(11) NOT NULL,
  `nama_jurusan` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jurusan`
--

INSERT INTO `tb_jurusan` (`kode_jurusan`, `nama_jurusan`) VALUES
(11, 'RPL'),
(12, 'TKJ'),
(13, 'MM');

-- --------------------------------------------------------

--
-- Table structure for table `tb_staff`
--

CREATE TABLE `tb_staff` (
  `id_staff` int(11) NOT NULL,
  `nama_staff` varchar(50) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  `level_user` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_staff`
--

INSERT INTO `tb_staff` (`id_staff`, `nama_staff`, `username`, `pass`, `level_user`) VALUES
(22, 'Josua', 'admin', 'admin', 'Admin'),
(2, 'Wayan', 'wayan', 'wa123', 'Staff'),
(3, 'Ketut Gede', 'ketut', 'ket123', 'Staff'),
(4, 'Ketut Wayan', 'wayan', 'wayan123', 'Staff'),
(5, 'Ketut Gede', 'admin', 'kesadj23', 'Admin	');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_asal_sekolah`
--
ALTER TABLE `tb_asal_sekolah`
  ADD PRIMARY KEY (`id_sekolah`);

--
-- Indexes for table `tb_calon_siswa`
--
ALTER TABLE `tb_calon_siswa`
  ADD PRIMARY KEY (`id_calonsiswa`),
  ADD KEY `id_sekolah` (`id_sekolah`),
  ADD KEY `id_staff` (`id_staff`),
  ADD KEY `kode_jurusan` (`kode_jurusan`);

--
-- Indexes for table `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  ADD PRIMARY KEY (`kode_jurusan`);

--
-- Indexes for table `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD PRIMARY KEY (`id_staff`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_asal_sekolah`
--
ALTER TABLE `tb_asal_sekolah`
  MODIFY `id_sekolah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;
--
-- AUTO_INCREMENT for table `tb_calon_siswa`
--
ALTER TABLE `tb_calon_siswa`
  MODIFY `id_calonsiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
--
-- AUTO_INCREMENT for table `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  MODIFY `kode_jurusan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tb_staff`
--
ALTER TABLE `tb_staff`
  MODIFY `id_staff` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
