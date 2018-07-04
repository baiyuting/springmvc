create table news(
 `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `imgs` varchar(255) DEFAULT NULL,
  `audit_status` int(255) DEFAULT '0' COMMENT '审核状态有两种：审核状态 = 0：未审核；审核状态 = 1：已审核，可以浏览。',
  `audit_date` datetime DEFAULT NULL,
  `audit_user_id` int(11) DEFAULT '-1' COMMENT '默认没有审核人',
  `audit_fail_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

 CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `grade` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

