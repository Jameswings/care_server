-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 06 月 05 日 19:57
-- 服务器版本: 5.1.44
-- PHP 版本: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `care_server`
--

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `account`
--


-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `iden` char(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `cell_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`id`, `user_id`, `name`, `type`, `iden`, `nick_name`, `sex`, `age`, `cell_phone`, `phone`, `creation_time`) VALUES
('00000000000000000000000000000001', '00000000000000000000000000000002', 'CK', 1, '440123195409231234', 'goodday', 1, 54, '123908102984', '1203801921', '2013-05-22 17:15:59');

-- --------------------------------------------------------

--
-- 表的结构 `customer_contact`
--

DROP TABLE IF EXISTS `customer_contact`;
CREATE TABLE IF NOT EXISTS `customer_contact` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `customer_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `relationship` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `customer_contact`
--


-- --------------------------------------------------------

--
-- 表的结构 `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
CREATE TABLE IF NOT EXISTS `customer_details` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `customer_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zipcode` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `customer_details`
--


-- --------------------------------------------------------

--
-- 表的结构 `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE IF NOT EXISTS `diagnosis` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `doctor_ecg_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `diagnosis`
--


-- --------------------------------------------------------

--
-- 表的结构 `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `iden` char(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `cell_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `doctor`
--

INSERT INTO `doctor` (`id`, `user_id`, `name`, `title`, `iden`, `nick_name`, `sex`, `cell_phone`, `phone`, `creation_time`) VALUES
('00000000000000000000000000000009', '00000000000000000000000000000001', 'Wing', 'Dc', '430123197702134321', 'Bigshow', 2, '1239817239', '19283719', '2013-05-21 17:17:17');

-- --------------------------------------------------------

--
-- 表的结构 `doctor_ecg`
--

DROP TABLE IF EXISTS `doctor_ecg`;
CREATE TABLE IF NOT EXISTS `doctor_ecg` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `doctor_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ecg_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `annotation` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `doctor_ecg`
--


-- --------------------------------------------------------

--
-- 表的结构 `doc_cus`
--

DROP TABLE IF EXISTS `doc_cus`;
CREATE TABLE IF NOT EXISTS `doc_cus` (
  `doctor_id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `customer_id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `mark` int(2) DEFAULT NULL,
  `note` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`doctor_id`,`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `doc_cus`
--

INSERT INTO `doc_cus` (`doctor_id`, `customer_id`, `mark`, `note`) VALUES
('00000000000000000000000000000009', '00000000000000000000000000000001', 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `ecg_data`
--

DROP TABLE IF EXISTS `ecg_data`;
CREATE TABLE IF NOT EXISTS `ecg_data` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `customer_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `file_location` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `ecg_data`
--

INSERT INTO `ecg_data` (`id`, `customer_id`, `file_location`, `creation_time`) VALUES
('1', '00000000000000000000000000000001', 'ftp/2013-04-22_22-22-59.dat', '2013-06-04 20:07:24'),
('2', '00000000000000000000000000000001', 'ftp/2013-04-22_22-28-52.dat', '2013-06-03 20:07:53'),
('3', '00000000000000000000000000000001', 'ftp/2013-04-23_21-26-25.dat', '2013-06-03 20:08:24'),
('4', '00000000000000000000000000000001', 'ftp/2013-04-24_20-29-24.dat', '2013-06-01 20:08:46');

-- --------------------------------------------------------

--
-- 表的结构 `ecg_details`
--

DROP TABLE IF EXISTS `ecg_details`;
CREATE TABLE IF NOT EXISTS `ecg_details` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `ecg_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `ecg_details`
--


-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(3) DEFAULT NULL,
  `message` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `notice`
--


-- --------------------------------------------------------

--
-- 表的结构 `notice_history`
--

DROP TABLE IF EXISTS `notice_history`;
CREATE TABLE IF NOT EXISTS `notice_history` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(3) DEFAULT NULL,
  `message` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `notice_history`
--


-- --------------------------------------------------------

--
-- 表的结构 `pending_request`
--

DROP TABLE IF EXISTS `pending_request`;
CREATE TABLE IF NOT EXISTS `pending_request` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(3) DEFAULT NULL,
  `message` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `pending_request`
--

INSERT INTO `pending_request` (`id`, `type`, `message`, `cmd`, `from_type`, `from_id`, `to_type`, `to_id`, `creation_time`) VALUES
('402880473e93e6de013e93e702740000', 0, NULL, '01010011', 1, '12345678901234567890123456789012', 0, NULL, '2013-05-11 22:03:10');

-- --------------------------------------------------------

--
-- 表的结构 `pending_response`
--

DROP TABLE IF EXISTS `pending_response`;
CREATE TABLE IF NOT EXISTS `pending_response` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `pending_response`
--


-- --------------------------------------------------------

--
-- 表的结构 `request_history`
--

DROP TABLE IF EXISTS `request_history`;
CREATE TABLE IF NOT EXISTS `request_history` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `request_history`
--


-- --------------------------------------------------------

--
-- 表的结构 `response_history`
--

DROP TABLE IF EXISTS `response_history`;
CREATE TABLE IF NOT EXISTS `response_history` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmd` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `from_type` int(2) DEFAULT NULL,
  `from_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `to_type` int(2) DEFAULT NULL,
  `to_id` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `response_history`
--


-- --------------------------------------------------------

--
-- 表的结构 `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` char(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `status`, `type`) VALUES
('00000000000000000000000000000001', 'doctor', '123456', 1, 1),
('00000000000000000000000000000002', 'Bean', '123456', 1, 2);
