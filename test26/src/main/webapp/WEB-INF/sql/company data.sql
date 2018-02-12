-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.57 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 데이터 test.company:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_id`, `company_name`) VALUES
	(1, 'ksmart'),
	(2, 'dsn'),
	(3, 'jns'),
	(4, 'Coca-Cola'),
	(5, 'Pepsi'),
	(6, 'Nikon'),
	(7, 'Adidas'),
	(8, 'Nike'),
	(9, 'Mozila'),
	(10, 'Skype'),
	(11, 'vodafone'),
	(12, 'ASUS'),
	(13, 'Cannon'),
	(14, 'Nokia'),
	(15, 'Reebok'),
	(16, 'Twitter'),
	(17, 'Wipipedia'),
	(18, 'Lenovo'),
	(19, 'LG'),
	(20, 'SAMSUNG'),
	(21, 'HTC'),
	(22, 'APPLE'),
	(23, 'Virgin Group'),
	(24, 'EBAY'),
	(25, 'AMAZON'),
	(26, 'ZARA'),
	(27, 'Audi'),
	(28, 'Sony'),
	(29, 'Goole'),
	(30, 'IBM'),
	(31, 'Microsoft');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
