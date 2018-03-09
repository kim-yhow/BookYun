/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bookcdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-09 14:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `Ad_name` char(30) NOT NULL,
  `Ad_pwd` char(30) NOT NULL,
  `Ad_email` char(30) NOT NULL,
  `Ad_registertime` datetime NOT NULL,
  `Ad_lastlogintm` datetime NOT NULL,
  PRIMARY KEY (`Ad_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('kim_yhow', 'adminyh', '564223274@qq.com', '2017-06-06 16:00:00', '2018-02-26 20:47:51');

-- ----------------------------
-- Table structure for tb_bookcomment
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookcomment`;
CREATE TABLE `tb_bookcomment` (
  `Re_id` int(11) NOT NULL AUTO_INCREMENT,
  `Re_writer` char(30) NOT NULL,
  `Re_book_id` int(11) NOT NULL,
  `Re_content` text NOT NULL,
  `Re_time` datetime NOT NULL,
  PRIMARY KEY (`Re_id`),
  KEY `FK_WRITER` (`Re_writer`),
  KEY `FK_BOOK` (`Re_book_id`),
  CONSTRAINT `FK_BOOK` FOREIGN KEY (`Re_book_id`) REFERENCES `tb_bookinfo` (`book_id`),
  CONSTRAINT `FK_WRITER` FOREIGN KEY (`Re_writer`) REFERENCES `tb_customer` (`Usr_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookcomment
-- ----------------------------
INSERT INTO `tb_bookcomment` VALUES ('1', 'kim', '3', ' 很喜欢', '2018-02-10 17:02:17');
INSERT INTO `tb_bookcomment` VALUES ('2', 'kim', '3', ' 哈哈哈', '2018-02-22 14:44:50');
INSERT INTO `tb_bookcomment` VALUES ('3', 'kim', '4', ' 喜欢', '2018-02-23 11:00:17');

-- ----------------------------
-- Table structure for tb_bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookinfo`;
CREATE TABLE `tb_bookinfo` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` char(30) NOT NULL,
  `book_author` char(30) NOT NULL,
  `book_transor` char(30) DEFAULT NULL,
  `book_type` char(30) NOT NULL,
  `book_price` decimal(10,2) NOT NULL,
  `book_cost` decimal(10,2) NOT NULL,
  `book_outline` text,
  `book_isbn` char(30) NOT NULL,
  `book_dealnum` int(11) NOT NULL,
  `book_num` int(11) NOT NULL,
  `book_storetime` datetime NOT NULL,
  `book_pubtime` datetime NOT NULL,
  `book_version` int(2) NOT NULL,
  `book_press` char(30) NOT NULL,
  `book_photo` char(30) NOT NULL,
  `book_comment` int(11) NOT NULL,
  `book_vprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `FK_BOOKTYPE` (`book_type`),
  CONSTRAINT `FK_BOOKTYPE` FOREIGN KEY (`book_type`) REFERENCES `tb_booktype` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookinfo
-- ----------------------------
INSERT INTO `tb_bookinfo` VALUES ('3', 'C Primer Plus 第6版 中文版', '史蒂芬·普拉达（Stephen Prata）', '无', '计算机', '96.00', '50.00', '畅销30余年的C语言编程入门教程 近百万程序员的C语言编程启蒙教程 技术大牛案头常备的工具书 针对C11标准库更新 蔡学镛 孟岩 高博倾力推荐', '9787115390592', '4', '96', '2017-08-01 00:00:00', '2016-04-01 00:00:00', '1', '人民邮电出版社', 'cpre.png', '3', '70.00');
INSERT INTO `tb_bookinfo` VALUES ('4', '沉睡的人鱼之家', '东野圭吾', '无', '文学', '39.80', '20.00', '《解忧杂货店》之后，东野圭吾又一部慰藉人心之作。如果推理小说一定要有死亡，这本书所触及的或许就是*残忍*令人绝望的一种情境。', '9787559603340', '5', '95', '2017-08-01 00:00:00', '2017-05-01 00:00:00', '1', '北京联合出版有限公司', 'csdryzj.png', '2', '29.40');
INSERT INTO `tb_bookinfo` VALUES ('5', '深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）', '周志明', '无', '计算机', '79.00', '40.00', '本书第1版两年内印刷近10次，4家网上书店的评论近4?000条，98%以上的评论全部为5星级的好评，是整个Java图书领域公认的经典著作和超级畅销书，繁体版在台湾也十分受欢迎。第2版在第1版的基础上做了很大的改进：根据*的JDK 1.7对全书内容进行了全面的升级和补充；增加了大量处理各种常见JVM问题的技巧和*实践；增加了若干与生产环境相结合的实战案例；对第1版中的错误和不足之处的修正；等等。第2版不仅技术更新、内容更丰富，而且实战性更强。', '9787111421900', '0', '100', '2018-02-24 00:00:00', '2013-06-01 00:00:00', '2', '机械工业出版社', 'javaxnj.png', '0', '51.60');
INSERT INTO `tb_bookinfo` VALUES ('6', '机器学习', '周志华', '无', '计算机', '88.00', '54.00', '击败AlphaGo的武林秘籍，赢得人机大战的必由之路：人工智能大牛周志华教授巨著，全面揭开机器学习的奥秘', '9787302423287', '0', '200', '2016-03-01 00:00:00', '2018-02-01 00:00:00', '2', '清华大学出版社', 'jqxx.png', '0', '62.00');
INSERT INTO `tb_bookinfo` VALUES ('7', '全球通史', '（美）斯塔夫里阿诺斯', '吴象婴', '历史', '96.00', '40.00', '斯塔夫里阿诺斯的这部潜心力作——《全球通史:从史前史到21世纪(第7版修订版)(中文版)(上下册)》自1970年初版问世以来，赞誉如潮，被译成多种语言流传于世，可谓经典之中的经典。第7版在保留原文精华的基础上，融入了时新的研究成果。新增了数百幅生动珍贵的图片和脉络清晰的地图，使这部名著在内容和体系上更加完善。', '9231298', '0', '100', '2017-08-01 00:00:00', '2016-04-01 00:00:00', '1', '北京大学出版社', 'qqts.png', '0', '81.80');

-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `tb_booktype`;
CREATE TABLE `tb_booktype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` char(30) NOT NULL,
  `type_booknum` int(11) NOT NULL,
  PRIMARY KEY (`type_id`,`type_name`),
  KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_booktype
-- ----------------------------
INSERT INTO `tb_booktype` VALUES ('1', '文学', '1');
INSERT INTO `tb_booktype` VALUES ('2', '小说', '0');
INSERT INTO `tb_booktype` VALUES ('3', '计算机', '3');
INSERT INTO `tb_booktype` VALUES ('4', '教辅教材', '0');
INSERT INTO `tb_booktype` VALUES ('5', '文艺', '0');
INSERT INTO `tb_booktype` VALUES ('6', '生活', '0');
INSERT INTO `tb_booktype` VALUES ('8', '历史', '1');

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `Usr_id` int(11) NOT NULL AUTO_INCREMENT,
  `Usr_name` char(30) NOT NULL,
  `Usr_pwd` char(30) NOT NULL,
  `Usr_email` char(30) NOT NULL,
  `Usr_registertime` datetime NOT NULL,
  `Usr_lastlogintm` datetime NOT NULL,
  PRIMARY KEY (`Usr_id`,`Usr_name`),
  KEY `Usr_name` (`Usr_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('1', 'kim', '123', '1234@qq.com', '2017-06-06 15:25:03', '2018-02-26 20:36:42');

-- ----------------------------
-- Table structure for tb_lvmsg
-- ----------------------------
DROP TABLE IF EXISTS `tb_lvmsg`;
CREATE TABLE `tb_lvmsg` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `msg_title` char(50) NOT NULL,
  `msg_cntent` text NOT NULL,
  `msg_usr_name` char(30) NOT NULL,
  `msg_usr_ip` char(30) NOT NULL,
  `msg_date` datetime NOT NULL,
  PRIMARY KEY (`msg_id`),
  KEY `msg_usr_name` (`msg_usr_name`),
  CONSTRAINT `tb_lvmsg_ibfk_1` FOREIGN KEY (`msg_usr_name`) REFERENCES `tb_customer` (`Usr_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_lvmsg
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_usr` char(30) NOT NULL,
  `order_price` decimal(10,2) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_ispaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`order_usr`),
  KEY `order_usr` (`order_usr`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`order_usr`) REFERENCES `tb_customer` (`Usr_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail` (
  `order_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `de_number` int(11) DEFAULT NULL,
  `de_subprice` decimal(10,2) NOT NULL,
  `order_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shoppingcar
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoppingcar`;
CREATE TABLE `tb_shoppingcar` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_usr` char(30) DEFAULT NULL,
  `car_time` datetime NOT NULL,
  `car_ispaid` int(11) NOT NULL,
  `car_totalprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shoppingcar
-- ----------------------------
INSERT INTO `tb_shoppingcar` VALUES ('27', 'kim', '2018-02-22 13:57:26', '1', '198.00');
INSERT INTO `tb_shoppingcar` VALUES ('29', 'kim', '2018-02-23 10:50:07', '1', '70.00');
INSERT INTO `tb_shoppingcar` VALUES ('30', 'kim', '2018-02-23 11:00:25', '1', '87.00');
INSERT INTO `tb_shoppingcar` VALUES ('31', 'kim', '2018-02-26 20:40:31', '1', '70.00');

-- ----------------------------
-- Table structure for tb_shoppingcar_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoppingcar_detail`;
CREATE TABLE `tb_shoppingcar_detail` (
  `car_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `de_num` int(11) NOT NULL,
  `de_subprice` decimal(10,2) NOT NULL,
  `de_time` datetime NOT NULL,
  PRIMARY KEY (`car_id`,`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shoppingcar_detail
-- ----------------------------
INSERT INTO `tb_shoppingcar_detail` VALUES ('27', '3', '2', '140.00', '2018-02-23 08:59:07');
INSERT INTO `tb_shoppingcar_detail` VALUES ('27', '4', '2', '58.00', '2018-02-23 09:27:02');
INSERT INTO `tb_shoppingcar_detail` VALUES ('29', '3', '1', '70.00', '2018-02-23 10:50:07');
INSERT INTO `tb_shoppingcar_detail` VALUES ('30', '4', '3', '87.00', '2018-02-23 11:00:25');
INSERT INTO `tb_shoppingcar_detail` VALUES ('31', '3', '1', '70.00', '2018-02-26 20:40:31');

-- ----------------------------
-- Procedure structure for Proc_cardetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_cardetail`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_cardetail`(in bookid int,in carid int,in price DECIMAL(10,2))
BEGIN
	 set @num=0;
   CALL Proc_isindetail(bookid,carid,@num);
	 if @num is NULL THEN 
			INSERT INTO `bookcdb`.`tb_shoppingcar_detail` (`car_id`,`book_id`, `de_num`, `de_subprice`, `de_time`) VALUES (carid,bookid, 1,price, NOW()); 
	ELSE
			update tb_shoppingcar_detail set de_num=@num+1 where book_id=bookid and car_id=carid;
			update tb_shoppingcar_detail set de_subprice=de_subprice+price  where book_id=bookid and car_id=carid;
  end if;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_commitorder
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_commitorder`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_commitorder`(in carid int)
BEGIN
		DECLARE  bookid INT;   -- id
    DECLARE  num  INT; 
		-- 遍历数据结束标志
    DECLARE done INT DEFAULT 0;
    -- 游标
		DECLARE cur_account CURSOR FOR select book_id ,de_num from tb_shoppingcar_detail where car_id=carid;
    -- 将结束标志绑定到游标
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
		-- 打开游标
    OPEN  cur_account;     
    -- 遍历
    read_loop: LOOP
            -- 取值 取多个字段
            FETCH  NEXT from cur_account INTO bookid, num;
            IF done THEN
                LEAVE read_loop;
             END IF;
        -- 你自己想做的操作
       update tb_bookinfo set book_dealnum=book_dealnum+num where book_id=bookid;
			 update tb_bookinfo set book_num=book_num-num where book_id=bookid;
    END LOOP;
    CLOSE cur_account;
		UPDATE tb_shoppingcar set car_ispaid=1 where car_id=carid;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_deletshopcar
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_deletshopcar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_deletshopcar`(in carid int,in bookid int)
BEGIN
    delete from tb_shoppingcar_detail where book_id=bookid and car_id=carid;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_ishascar
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_ishascar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_ishascar`(in usr char(30),out carid int)
BEGIN
 select car_id into carid from tb_shoppingcar where car_usr=usr and car_ispaid=0;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_isindetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_isindetail`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_isindetail`(in bookid int,in carid int,out num int)
BEGIN
   select de_num into num from tb_shoppingcar_detail where book_id=bookid and car_id=carid;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_removeBookshopcar
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_removeBookshopcar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_removeBookshopcar`(in carid int,in bookid int)
BEGIN
	 set @num=0;
   UPDATE tb_shoppingcar_detail set tb_shoppingcar_detail.de_num =tb_shoppingcar_detail.de_num-1 where book_id=bookid and car_id=carid;
	 SELECT de_num into @num from tb_shoppingcar_detail where book_id=bookid and car_id=carid;
	 if (@num =0) then 
    delete from tb_shoppingcar_detail where book_id=bookid and car_id=carid;
	 end if;

   set @price=1.0;
	 select book_vprice into @price from tb_bookinfo where book_id=bookid;
	 UPDATE tb_shoppingcar_detail set de_subprice=de_num*@price where book_id=bookid and car_id=carid;
	 UPDATE  tb_shoppingcar set car_totalprice =car_totalprice-@price where car_id=carid and car_ispaid=0;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_Shopcar
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_Shopcar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_Shopcar`(in usr char(30),in bookid int)
BEGIN
		set @dpth=5;
		select @@max_sp_recursion_depth into @dpth;
		if @dpth = 0 THEN
		set @@max_sp_recursion_depth =5;		
		end IF;
		set @cid =1;
		CALL Proc_ishascar(usr,@cid);
		if @cid is NULL THEN 
			INSERT INTO `bookcdb`.`tb_shoppingcar` (`car_usr`, `car_time`, `car_ispaid`,`car_totalprice`) VALUES (usr,NOW(),0,0);
			CALL Proc_Shopcar(usr,bookid);
		ELSE
			set @price=1.0;
			select book_vprice into @price from tb_bookinfo where book_id=bookid;
			CALL Proc_cardetail(bookid,@cid,@price);
      UPDATE  tb_shoppingcar set car_totalprice =car_totalprice+@price where car_usr=usr and car_ispaid=0;
		end if;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookAuthor
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookAuthor`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookAuthor`(in author char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_author=author where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookCost
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookCost`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookCost`(in cost DECIMAL(10,2),in id int)
BEGIN
   UPDATE tb_bookinfo set book_cost=cost where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookIsbn
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookIsbn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookIsbn`(in isbn char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_isbn=isbn where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookName
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookName`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookName`(in name char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_name=name where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookNum
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookNum`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookNum`(in num int,in id int)
BEGIN
   UPDATE tb_bookinfo set book_num=num where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookOutline
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookOutline`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookOutline`(in outline char(100),in id int)
BEGIN
   UPDATE tb_bookinfo set book_outline=outline where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookPhoto
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookPhoto`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookPhoto`(in photo char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_photo=photo where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookPress
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookPress`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookPress`(in press char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_press=press where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookPrice
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookPrice`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookPrice`(in price DECIMAL(10,2),in id int)
BEGIN
   UPDATE tb_bookinfo set book_price=price where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookPubtime
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookPubtime`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookPubtime`(in pubtime char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_pubtime=pubtime where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookStroetime
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookStroetime`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookStroetime`(in storetime char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_storetime=storetime where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookTransor
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookTransor`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookTransor`(in name char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_Transor=name where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookType
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookType`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookType`(in type char(30),in id int)
BEGIN
   UPDATE tb_bookinfo set book_type=type where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookVersion
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookVersion`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookVersion`(in version int,in id int)
BEGIN
   UPDATE tb_bookinfo set book_version=version where book_id=id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Proc_updatebookvprice
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_updatebookvprice`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatebookvprice`(in vprice DECIMAL(10,2),in id int)
BEGIN
   UPDATE tb_bookinfo set book_vprice=vprice where book_id=id;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tr_no_same_Ad_name`;
DELIMITER ;;
CREATE TRIGGER `tr_no_same_Ad_name` BEFORE INSERT ON `tb_admin` FOR EACH ROW BEGIN
  IF(new.Ad_name in(select Ad_name from tb_admin))
    then		
		INSERT IGNORE INTO `bookcdb`.`tb_admin` (`Ad_name`, `Ad_pwd`, `Ad_email`, `Ad_registertime`, `Ad_lastlogintm`) VALUES ('lkim', '123', '1234@qq.com', 'error', '2017-06-06 15:32:46');
	END if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tr_add_comment_num`;
DELIMITER ;;
CREATE TRIGGER `tr_add_comment_num` BEFORE INSERT ON `tb_bookcomment` FOR EACH ROW begin
		update tb_bookinfo set book_comment=book_comment+1;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tr_no_same_book_name`;
DELIMITER ;;
CREATE TRIGGER `tr_no_same_book_name` BEFORE INSERT ON `tb_bookinfo` FOR EACH ROW BEGIN
  IF(new.book_name in(select book_name from tb_bookinfo) and new.book_isbn in(select book_isbn from tb_bookinfo))
    then		
		INSERT INTO `bookcdb`.`tb_bookinfo` (`book_name`, `book_author`, `book_transor`, `book_type`, `book_price`, `book_cost`, `book_outline`, `book_isbn`, `book_dealnum`, `book_num`, `book_storetime`, `book_pubtime`, `book_version`, `book_press`, `book_photo`) VALUES (NULL);
	END if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tr_add_type_num`;
DELIMITER ;;
CREATE TRIGGER `tr_add_type_num` BEFORE INSERT ON `tb_bookinfo` FOR EACH ROW begin
	if(new.book_type in(select type_name from tb_booktype))
	then 
		update tb_booktype set type_booknum=type_booknum+1 where tb_booktype.type_name=new.book_type;
	else
	   insert into tb_booktype(type_name,type_booknum) values (new.book_type,1);
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tr_no_same_Usr_name`;
DELIMITER ;;
CREATE TRIGGER `tr_no_same_Usr_name` BEFORE INSERT ON `tb_customer` FOR EACH ROW BEGIN
  IF(new.Usr_name in(select Usr_name from tb_customer))
    then		
		INSERT IGNORE INTO `bookcdb`.`tb_customer` (`Usr_name`, `Usr_pwd`, `Usr_email`, `Usr_registertime`, `Usr_lastlogintm`,Usr_priority) VALUES ('lkim', '123', '1234@qq.com', 'error', '2017-06-06 15:32:46','normal');
	END if;
END
;;
DELIMITER ;
