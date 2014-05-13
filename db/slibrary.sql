-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11 Mei 2014 pada 01.55
-- Versi Server: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `slibrary`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
  `kd_buku` varchar(6) NOT NULL,
  `nama_buku` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `penulis` varchar(30) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `kd_kategori` varchar(4) NOT NULL,
  `kd_tataletak` varchar(4) NOT NULL,
  PRIMARY KEY (`kd_buku`),
  KEY `kd_kategori` (`kd_kategori`),
  KEY `kd_tataletak` (`kd_tataletak`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kd_buku`, `nama_buku`, `jumlah`, `stok`, `penulis`, `penerbit`, `kd_kategori`, `kd_tataletak`) VALUES
('BUK001', 'Rekayasa Perangkat Lunak', 10, 10, 'Roger Pressman', 'Informatika', 'KG01', 'TL01'),
('BUK002', 'WEB Programming Power Pack', 15, 15, 'Alexander F.K Sibero', 'MediaKom', 'KG01', 'TL01'),
('BUK003', 'Algoritma dan Pemrograman', 10, 10, 'Rinaldi Munir', 'Informatika', 'KG01', 'TL01'),
('BUK004', 'Struktur Dataa', 201, 201, 'Rosa A.S. dkka', 'Modula1', 'KG02', 'A100');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `kd_kategori` varchar(4) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`kd_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`kd_kategori`, `nama_kategori`, `keterangan`) VALUES
('KG01', 'Informatika', 'buku buku buku'),
('KG02', 'Pengembangan Diri', 'kategori untuk menambah kapasitas diri');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `NIM` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  ` no_telp` varchar(12) NOT NULL,
  PRIMARY KEY (`NIM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `nama`, `alamat`, `email`, ` no_telp`) VALUES
('6306120029', 'Martya Atika Diwasasri', 'jalan pga', 'aciatika@gmail.com', '087890932155'),
('6306122053', 'Muhammad Azis Lutfi', 'Jalan Surabaya', 'azisupi@gmail.com', '087638278729'),
('6306124113', 'Rahmi Maulidina Nistia', 'jalan sukabirus gg slamat 3 no 11c', 'rahmimn@gmail.com', '085793659439');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_harus_kembali` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `denda` double NOT NULL,
  `NIM` varchar(10) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `NIM` (`NIM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `id_petugas` varchar(6) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `alamat`, `email`, `no_telp`, `username`, `password`) VALUES
('ADM001', 'Admin Ganteng Cantik', 'jalan beringin', 'adminganteng@gmail.com', '07777777777', 'admin', 'admin'),
('PET001', 'Petugas Cantik', 'jalan apa apa nya dong', 'petcantik@gmail.com', '087656732782', 'cantik', 'banget');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjambuku`
--

CREATE TABLE IF NOT EXISTS `pinjambuku` (
  `id_transaksi` varchar(6) NOT NULL,
  `kd_buku` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tataletak`
--

CREATE TABLE IF NOT EXISTS `tataletak` (
  `kd_tataletak` varchar(4) NOT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`kd_tataletak`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tataletak`
--

INSERT INTO `tataletak` (`kd_tataletak`, `keterangan`) VALUES
('A100', 'dimana hatiku senangg'),
('TL01', 'dekat mana aja');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`kd_kategori`) REFERENCES `kategori` (`kd_kategori`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`kd_tataletak`) REFERENCES `tataletak` (`kd_tataletak`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_nim` FOREIGN KEY (`NIM`) REFERENCES `mahasiswa` (`NIM`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
