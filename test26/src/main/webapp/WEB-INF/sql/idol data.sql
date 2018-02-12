-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- test 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. idol
CREATE TABLE IF NOT EXISTS `idol` (
  `idol_id` int(10) NOT NULL AUTO_INCREMENT,
  `idol_name` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

-- Dumping data for table test.idol: ~38 rows (대략적)
/*!40000 ALTER TABLE `idol` DISABLE KEYS */;
INSERT INTO `idol` (`idol_id`, `idol_name`) VALUES
	(2, 'EXO'),
	(3, 'Apink'),
	(4, 'WINNER'),
	(5, 'iKON'),
	(6, 'BtoB'),
	(7, 'BTS'),
	(8, 'EXID'),
	(9, 'BIGBANG'),
	(10, 'INFINITE'),
	(11, 'SISTAR'),
	(12, 'B1A4'),
	(13, 'VIXX'),
	(14, 'SPICA'),
	(15, 'AOA'),
	(16, 'GOT7'),
	(17, '	MAMAMOO'),
	(18, 'LABOUM'),
	(19, 'Lovelyz'),
	(20, 'Seventeen'),
	(21, 'UP10TION'),
	(22, 'Rubber Soul'),
	(23, 'Melody Day'),
	(24, 'GFriend'),
	(25, 'gugudan'),
	(26, 'I.O.I'),
	(27, 'NU\'EST W'),
	(28, 'WANNA·ONE'),
	(29, 'WeKi MeKi'),
	(30, 'Block B'),
	(31, 'miss A'),
	(32, 'f(x)'),
	(33, 'Girls\' Generation'),
	(34, 'Super Junior'),
	(35, 'MYTEEN'),
	(36, 'MOMOLAND'),
	(37, 'BLACKPINK'),
	(38, 'Highlight'),
	(39, 'EXO-CBX');
/*!40000 ALTER TABLE `idol` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
