-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 05 月 23 日 01:57
-- 服务器版本: 5.5.20
-- PHP 版本: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `care_server`
--

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`id`, `user_id`, `name`, `type`, `iden`, `nick_name`, `sex`, `age`, `cell_phone`, `phone`, `creation_time`) VALUES
('0001', '002', 'Andy', 1, '44255219650922123X', '不舒服', 1, 57, '18600000000', '1231236712842512', '2013-05-14 08:08:00');

--
-- 转存表中的数据 `doctor`
--

INSERT INTO `doctor` (`id`, `user_id`, `name`, `title`, `iden`, `nick_name`, `sex`, `cell_phone`, `phone`, `creation_time`) VALUES
('0001', '001', 'Wings', 'Dc', '440123197701231234', 'Big show', 2, '13888888888', '88888888', '2013-05-23 00:00:00');

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `status`, `type`) VALUES
('001', 'doctor', '123456', 1, 1),
('002', 'customer', '123456', 1, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
