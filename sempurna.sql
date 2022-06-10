-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jun 2022 pada 13.52
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sempurna`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kdbarang` varchar(10) NOT NULL,
  `nmbarang` varchar(50) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `stok` varchar(100) NOT NULL,
  `hb` varchar(50) NOT NULL,
  `hj` varchar(50) NOT NULL,
  `tahun` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kdbarang`, `nmbarang`, `merk`, `type`, `stok`, `hb`, `hj`, `tahun`) VALUES
('BRG0001', 'TELEVISI', 'SHARP', 'SH456', '0', '2000000', '3000000', '2015'),
('BRG0002', 'AC', 'BEKO', 'BK123', '0', '3000000', '3500000', '2018'),
('BRG0003', 'KULKAS', 'SAMSUNG', 'SS987', '1', '500000', '1000000', '2013');

-- --------------------------------------------------------

--
-- Struktur dari tabel `faktur`
--

CREATE TABLE `faktur` (
  `kdfaktur` varchar(15) NOT NULL,
  `tanggal` date NOT NULL,
  `idsupplier` varchar(100) NOT NULL,
  `nmsupplier` varchar(100) NOT NULL,
  `nohps` varchar(20) NOT NULL,
  `nik` varchar(100) NOT NULL,
  `nmpetugas` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `faktur`
--

INSERT INTO `faktur` (`kdfaktur`, `tanggal`, `idsupplier`, `nmsupplier`, `nohps`, `nik`, `nmpetugas`, `jabatan`) VALUES
('INBRG0001', '2020-08-03', 'SPL0001', 'Budi', '081224567', 'KRY0001', 'Rori', 'Pramuniaga'),
('INBRG0002', '2020-08-05', 'SPL0002', 'Yusuf', '08584676', 'KRY0002', 'Arif', 'Bagian Gudang'),
('INBRG0003', '2020-08-05', 'SPL0002', 'Yusuf', '08584676', 'KRY0001', 'Rori', 'Pramuniaga'),
('INBRG0004', '2020-08-05', 'SPL0001', 'Budi', '081224567', 'KRY0002', 'Arif', 'Bagian Gudang'),
('INBRG0005', '2020-08-17', 'SPL0002', 'Yusuf', '08584676', 'KRY0002', 'Arif', 'Bagian Gudang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi`
--

CREATE TABLE `isi` (
  `idnota` varchar(10) NOT NULL,
  `kdbarang` varchar(10) NOT NULL,
  `nmbarang` varchar(100) NOT NULL,
  `merk` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `stok` int(100) NOT NULL,
  `harga` int(100) NOT NULL,
  `tahunbarang` int(10) NOT NULL,
  `qty` int(100) NOT NULL,
  `subtotal` int(100) NOT NULL,
  `diskon` int(100) NOT NULL,
  `ketdiskon` varchar(100) NOT NULL,
  `totalharga` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isi`
--

INSERT INTO `isi` (`idnota`, `kdbarang`, `nmbarang`, `merk`, `type`, `stok`, `harga`, `tahunbarang`, `qty`, `subtotal`, `diskon`, `ketdiskon`, `totalharga`) VALUES
('OUT0001', 'BRG0003', 'KULKAS', 'SAMSUNG', 'SS987', 6, 1000000, 2013, 1, 1000000, 200000, '20 Persen', 800000),
('OUT0002', 'BRG0001', 'TELEVISI', 'SHARP', 'SH456', 6, 3000000, 2015, 2, 6000000, 1200000, '20 Persen', 4800000),
('OUT0003', 'BRG0001', 'TELEVISI', 'SHARP', 'SH456', 4, 3000000, 2015, 1, 3000000, 600000, '20 Persen', 2400000),
('OUT0003', 'BRG0003', 'KULKAS', 'SAMSUNG', 'SS987', 5, 1000000, 2013, 2, 2000000, 400000, '20 Persen', 1600000),
('OUT0004', 'BRG0002', 'AC', 'BEKO', 'BK123', 4, 3500000, 2018, 3, 10500000, 1050000, '10 Persen', 9450000),
('OUT0004', 'BRG0003', 'KULKAS', 'SAMSUNG', 'SS987', 3, 1000000, 2013, 2, 2000000, 600000, '30 Persen', 1400000),
('OUT0005', 'BRG0001', 'TELEVISI', 'SHARP', 'SH456', 2, 3000000, 2015, 2, 6000000, 1200000, '20 Persen', 4800000),
('OUT0005', 'BRG0002', 'AC', 'BEKO', 'BK123', 1, 3500000, 2018, 1, 3500000, 350000, '10 Persen', 3150000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `isifaktur`
--

CREATE TABLE `isifaktur` (
  `kdfaktur` varchar(100) NOT NULL,
  `kdbarang` varchar(100) NOT NULL,
  `nmbarang` varchar(100) NOT NULL,
  `merk` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `hb` int(100) NOT NULL,
  `tahun` int(100) NOT NULL,
  `qty` int(100) NOT NULL,
  `subtotalharga` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isifaktur`
--

INSERT INTO `isifaktur` (`kdfaktur`, `kdbarang`, `nmbarang`, `merk`, `type`, `hb`, `tahun`, `qty`, `subtotalharga`) VALUES
('INBRG0001', 'BRG0001', 'TELEVISI', 'SHARP', 'SH456', 2000000, 2015, 2, 4000000),
('INBRG0001', 'BRG0002', 'AC', 'BEKO', 'BK123', 3000000, 2018, 2, 6000000),
('INBRG0002', 'BRG0002', 'AC', 'BEKO', 'BK123', 3000000, 2018, 4, 12000000),
('INBRG0003', 'BRG0002', 'AC', 'BEKO', 'BK123', 3000000, 2018, 1, 3000000),
('INBRG0004', 'BRG0001', 'TELEVISI', 'SHARP', 'SH456', 2000000, 2015, 5, 10000000),
('INBRG0005', 'BRG0003', 'KULKAS', 'SAMSUNG', 'SS987', 500000, 2013, 5, 2500000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` varchar(10) NOT NULL,
  `nmkaryawan` varchar(100) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `nohpk` varchar(50) NOT NULL,
  `alamatk` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`nik`, `nmkaryawan`, `jabatan`, `nohpk`, `alamatk`) VALUES
('KRY0001', 'Rori', 'Pramuniaga', '089977889911', 'Suka Hati'),
('KRY0002', 'Mery', 'Admin', '02173385546', 'Cibinong'),
('KRY0003', 'Budiman', 'Pemilik', '02123857301', 'Cibinong'),
('KRY0004', 'Arif', 'Bagian Gudang', '0857466789', 'Bogor');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota`
--

CREATE TABLE `nota` (
  `idnota` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `idpelanggan` varchar(10) NOT NULL,
  `nmpelanggan` varchar(100) NOT NULL,
  `nohp` varchar(20) NOT NULL,
  `alamatp` varchar(200) NOT NULL,
  `nik` varchar(10) NOT NULL,
  `nmkaryawan` varchar(100) NOT NULL,
  `jabatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nota`
--

INSERT INTO `nota` (`idnota`, `tanggal`, `idpelanggan`, `nmpelanggan`, `nohp`, `alamatp`, `nik`, `nmkaryawan`, `jabatan`) VALUES
('OUT0001', '2020-08-18', 'IN0001', 'Bayu', '089915074446', 'Kab. Bogor', 'KRY0001', 'Rori', 'Pramuniaga'),
('OUT0002', '2020-08-21', 'IN0004', 'Eko', '085986644', 'Jakarta', 'KRY0001', 'Rori', 'Pramuniaga'),
('OUT0003', '2020-09-07', 'IN0001', 'Bayu', '089915074446', 'Kab. Bogor', 'KRY0002', 'Mery', '-Pilih Jabatan-'),
('OUT0004', '2021-01-11', 'IN0001', 'Bayu', '089915074446', 'Kab. Bogor', 'KRY0003', 'Budiman', 'Pemilik'),
('OUT0005', '2021-01-20', 'IN0001', 'Bayu', '089915074446', 'Kab. Bogor', 'KRY0003', 'Budiman', 'Pemilik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `idpelanggan` varchar(10) NOT NULL,
  `nmpelanggan` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `nohp` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`idpelanggan`, `nmpelanggan`, `jenis`, `nohp`, `alamat`) VALUES
('IN0001', 'Bayu', 'Laki-Laki', '089915074446', 'Kab. Bogor'),
('IN0002', 'Hany', 'Perempuan', '081269696969', 'Jakarta'),
('IN0003', 'Zaki', 'Laki-Laki', '021546654', 'Bogor');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `idsupplier` varchar(10) NOT NULL,
  `nmsupplier` varchar(100) NOT NULL,
  `nohps` varchar(50) NOT NULL,
  `alamats` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`idsupplier`, `nmsupplier`, `nohps`, `alamats`) VALUES
('SPL0001', 'Budi', '081224567', 'Jakarta'),
('SPL0002', 'Yusuf', '08584676', 'Bogor');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kdbarang`);

--
-- Indeks untuk tabel `faktur`
--
ALTER TABLE `faktur`
  ADD PRIMARY KEY (`kdfaktur`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`idnota`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`idpelanggan`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idsupplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
