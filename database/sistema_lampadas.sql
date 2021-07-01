-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.23 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para mydb
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;

-- Copiando estrutura para tabela mydb.lampadas
CREATE TABLE IF NOT EXISTS `lampadas` (
  `idLampadas` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idLampadas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela mydb.lampadas: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `lampadas` DISABLE KEYS */;
INSERT INTO `lampadas` (`idLampadas`) VALUES
	(1),
	(2),
	(3),
	(4);
/*!40000 ALTER TABLE `lampadas` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.tempo_ligado
CREATE TABLE IF NOT EXISTS `tempo_ligado` (
  `idTempo_Ligado` int NOT NULL AUTO_INCREMENT,
  `Lampadas_idLampadas` int NOT NULL,
  `tempo` int NOT NULL,
  `data` varchar(50) NOT NULL,
  PRIMARY KEY (`idTempo_Ligado`),
  KEY `fk_Tempo_Ligado_Lampadas_idx` (`Lampadas_idLampadas`),
  CONSTRAINT `fk_Tempo_Ligado_Lampadas` FOREIGN KEY (`Lampadas_idLampadas`) REFERENCES `lampadas` (`idLampadas`)
) ENGINE=InnoDB AUTO_INCREMENT=1931 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela mydb.tempo_ligado: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `tempo_ligado` DISABLE KEYS */;
INSERT INTO `tempo_ligado` (`idTempo_Ligado`, `Lampadas_idLampadas`, `tempo`, `data`) VALUES
	(1923, 2, 74, '30/06/2021'),
	(1924, 3, 74, '30/06/2021'),
	(1925, 4, 74, '30/06/2021'),
	(1926, 1, 65, '30/06/2021'),
	(1927, 1, 108, '30/06/2021'),
	(1928, 1, 0, '30/06/2021'),
	(1929, 1, 0, '30/06/2021'),
	(1930, 4, 123, '30/06/2021');
/*!40000 ALTER TABLE `tempo_ligado` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
