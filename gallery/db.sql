/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.10-MariaDB : Database - db_api_gallery
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_api_gallery` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_api_gallery`;

/*Table structure for table `app_ids` */

DROP TABLE IF EXISTS `app_ids`;

CREATE TABLE `app_ids` (
  `id_app` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `app_name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `intall` int(11) NOT NULL,
  PRIMARY KEY (`id_app`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `app_ids` */

/*Table structure for table `failed_jobs` */

DROP TABLE IF EXISTS `failed_jobs`;

CREATE TABLE `failed_jobs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `failed_jobs` */

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `files` */

insert  into `files`(`id`,`file_name`,`created_at`,`updated_at`) values (30,'20200808052815.jpg',NULL,NULL),(29,'20200808052653.jpg',NULL,NULL);

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `id_image` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_kategory` int(11) NOT NULL,
  `url_thumbn` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `url_image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `set_as` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `images` */

insert  into `images`(`id_image`,`id_kategory`,`url_thumbn`,`url_image`,`set_as`) values (26,1,'localhost','3_20200808054028.jpg',NULL),(25,1,'localhost','2_20200808054028.jpg',NULL),(24,1,'localhost','1_20200808054028.jpg',NULL),(23,1,'localhost','0_20200808054028.jpg',NULL);

/*Table structure for table `kategories` */

DROP TABLE IF EXISTS `kategories`;

CREATE TABLE `kategories` (
  `id_kategory` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_app` int(11) NOT NULL,
  `nama_kategory` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_kategory`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `kategories` */

/*Table structure for table `migrations` */

DROP TABLE IF EXISTS `migrations`;

CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `migrations` */

insert  into `migrations`(`id`,`migration`,`batch`) values (1,'2019_08_19_000000_create_failed_jobs_table',1),(2,'2020_08_08_014329_create_app_ids_table',1),(3,'2020_08_08_014533_create_images_table',1),(4,'2020_08_08_014648_create_kategories_table',1),(5,'2020_08_08_015156_create_users_table',1),(6,'2020_08_08_051248_create_files_table',1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id_user` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `PASSWORD` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `LEVEL` int(11) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
