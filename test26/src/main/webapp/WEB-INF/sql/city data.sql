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

-- 테이블 데이터 test.city:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`city_id`, `city_name`) VALUES
	(1, 'jeonju'),
	(2, 'seoul'),
	(3, 'jeju'),
	(4, 'Daegu'),
	(5, 'Gwangju'),
	(6, 'Ulsan'),
	(7, 'Daejeon'),
	(8, 'Gangwon-do'),
	(9, 'Jeju-do'),
	(10, 'Busan'),
	(11, 'Pyeongyang'),
	(12, 'Gaeseong'),
	(13, 'Pyeonganbuk-do'),
	(14, 'Hamgueongbuk-dp'),
	(15, 'Hwanghaebuk-do'),
	(16, 'Hwanghaenam-do'),
	(17, 'Daegu'),
	(18, 'Incheone'),
	(19, 'Goyang-si'),
	(20, 'Ilsan-gu'),
	(21, 'Osan'),
	(22, 'Guri'),
	(23, 'Sosa-gu'),
	(24, 'Seongnam-si'),
	(25, 'wonmi-gu'),
	(26, 'suwon-si'),
	(29, 'Paju-si'),
	(30, 'Donghae-si'),
	(31, 'Gangneyng-si');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
