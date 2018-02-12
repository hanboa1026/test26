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

-- 테이블 데이터 test.book:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`book_id`, `book_name`) VALUES
	(1, 'IT book'),
	(2, 'adult book'),
	(3, 'kidz book'),
	(4, 'It'),
	(5, 'Hillbilly elegy'),
	(6, 'The five love languages'),
	(7, 'The glass castle'),
	(8, 'Milk and honey'),
	(9, 'LAST LECTURE'),
	(10, 'Oliver Sacks'),
	(11, 'Outliers'),
	(12, 'Tipping point'),
	(13, 'The Little Prince'),
	(14, 'A MAN CALLED OVE'),
	(15, 'To Kill a Mockingbird'),
	(16, 'HarryPoter and the philosopher\'s stone'),
	(17, 'The vegetarian'),
	(18, 'The Catcher in the Rye'),
	(19, 'Animal Farm'),
	(20, 'The AlChemist'),
	(21, 'The Hitchhiker\'s Guide to the Galaxy'),
	(22, 'The Curious Incident of the Dog in the Night Time'),
	(23, 'Rainbow the Light Between Oceans'),
	(24, 'The Great Gatsby'),
	(25, 'The hobbit'),
	(26, 'Load of the Flies'),
	(27, 'The Picure of Dorian Gray'),
	(28, 'Little Women'),
	(29, 'Wuthering Heights'),
	(30, 'the Count of Monte Cristo'),
	(31, 'Gone with the Wind');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
