# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     commlab
# Server version:               5.0.67-community-nt
# Server OS:                    Win32
# Target compatibility:         ANSI SQL
# HeidiSQL version:             4.0
# Date/time:                    12/22/2011 1:13:52 PM
# --------------------------------------------------------

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI,NO_BACKSLASH_ESCAPES';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'commlab'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "commlab" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "commlab";


#
# Table structure for table 'circuit'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "circuit" (
  "id" int(10) unsigned NOT NULL auto_increment,
  "name" varchar(150) NOT NULL,
  "type" varchar(50) NOT NULL,
  "node_cordinates" varchar(50) NOT NULL,
  "image_file" varchar(200) NOT NULL,
  "config_properties" varchar(150) NOT NULL,
  "remark" varchar(500) default NULL,
  PRIMARY KEY  ("id")
);



#
# Dumping data for table 'circuit'
#

# No data found.



#
# Table structure for table 'circuit_role'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "circuit_role" (
  "circuit_id" int(10) unsigned NOT NULL,
  "role_id" int(10) unsigned NOT NULL
);



#
# Dumping data for table 'circuit_role'
#

# No data found.



#
# Table structure for table 'circuit_user'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "circuit_user" (
  "circuit_id" int(10) unsigned NOT NULL,
  "user_id" int(10) unsigned NOT NULL
);



#
# Dumping data for table 'circuit_user'
#

# No data found.



#
# Table structure for table 'login_logs'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "login_logs" (
  "user_id" int(10) unsigned NOT NULL,
  "session_id" varchar(100) NOT NULL,
  "login_at" varchar(60) default NULL,
  "session_log" varchar(100) default NULL
);



#
# Dumping data for table 'login_logs'
#

# No data found.



#
# Table structure for table 'messages'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "messages" (
  "user_id" int(10) unsigned NOT NULL,
  "subject" varchar(150) default NULL,
  "message" varchar(500) default NULL,
  "status" varchar(50) NOT NULL
);



#
# Dumping data for table 'messages'
#

# No data found.



#
# Table structure for table 'roles'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "roles" (
  "id" int(10) unsigned NOT NULL,
  "name" varchar(150) NOT NULL
);



#
# Dumping data for table 'roles'
#

# No data found.



#
# Table structure for table 'users'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "users" (
  "id" int(10) unsigned NOT NULL auto_increment,
  "name" varchar(150) NOT NULL,
  "passcode" varchar(150) NOT NULL,
  "status" int(10) unsigned NOT NULL,
  PRIMARY KEY  ("id")
);



#
# Dumping data for table 'users'
#

# No data found.



#
# Table structure for table 'user_detail'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "user_detail" (
  "user_id" int(10) unsigned default NULL,
  "first_name" varchar(50) default NULL,
  "last_name" varchar(50) default NULL,
  "email_address" varchar(50) default NULL,
  "contact_no" varchar(50) default NULL,
  "address1" varchar(100) default NULL,
  "street" varchar(100) default NULL,
  "city" varchar(50) default NULL,
  "country" varchar(50) default NULL,
  "college_name" varchar(150) default NULL
);



#
# Dumping data for table 'user_detail'
#

# No data found.



#
# Table structure for table 'user_role'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "user_role" (
  "user_id" int(10) unsigned NOT NULL,
  "role_id" int(10) unsigned NOT NULL
);



#
# Dumping data for table 'user_role'
#

# No data found.

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
