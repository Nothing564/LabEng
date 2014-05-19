-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 19-Maio-2014 às 03:26
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `livrarialabeng`
--
CREATE DATABASE IF NOT EXISTS `livrarialabeng` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `livrarialabeng`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `CodCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `rg` varchar(12) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  PRIMARY KEY (`CodCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `CodFornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cnpj` int(11) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  PRIMARY KEY (`CodFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `Matricula` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `RG` varchar(12) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  PRIMARY KEY (`Matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE IF NOT EXISTS `livro` (
  `CodLivro` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` decimal(20,0) NOT NULL,
  `qtd` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `ValorUnt` double NOT NULL,
  PRIMARY KEY (`CodLivro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`CodLivro`, `isbn`, `qtd`, `titulo`, `autor`, `categoria`, `ValorUnt`) VALUES
(1, '1234567890', 0, 'A volta dos que não foram', 'Caique Freitas', 'Romance', 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidofornecedor`
--

CREATE TABLE IF NOT EXISTS `pedidofornecedor` (
  `CodPedido` int(11) NOT NULL AUTO_INCREMENT,
  `CodLivro` int(11) NOT NULL,
  `CodFornecedor` int(11) NOT NULL,
  `qtd` decimal(10,0) NOT NULL,
  `valorUnidade` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CodPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `CodVenda` int(11) NOT NULL AUTO_INCREMENT,
  `CodCliente` int(11) NOT NULL,
  `CodFuncionario` int(11) NOT NULL,
  `valor` double NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`CodVenda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`CodVenda`, `CodCliente`, `CodFuncionario`, `valor`, `data`) VALUES
(2, 1, 1, 100, '2014-05-12 16:01:14');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
