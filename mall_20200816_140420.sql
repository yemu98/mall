-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(255) NOT NULL COMMENT '收件人',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `phone` varchar(255) NOT NULL COMMENT '电话号',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '删除状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (13,1,'csp','山东省烟台市','17865569207',1,'2020-03-25 04:11:59','2020-03-25 04:11:59'),(14,1,'常绍鹏','山东省济南市','17866568888',1,'2020-03-26 03:12:33','2020-03-26 03:12:33'),(15,2,'常绍鹏','山东省聊城市阳谷县','15106817747',1,'2020-03-26 11:21:00','2020-03-27 09:34:37'),(16,2,'常绍鹏','山东省','17865669999',1,'2020-03-27 09:34:04','2020-03-27 09:34:35'),(17,2,'test','山东','18888888888',0,'2020-03-27 09:35:32','2020-03-27 09:35:32'),(18,12,'sss','fdfdsf sfds','1112223333',1,'2020-05-14 06:51:02','2020-05-14 06:51:02');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carousel`
--

DROP TABLE IF EXISTS `carousel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL COMMENT '跳转链接',
  `img_url` varchar(255) NOT NULL COMMENT '图片链接',
  `info` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carousel`
--

LOCK TABLES `carousel` WRITE;
/*!40000 ALTER TABLE `carousel` DISABLE KEYS */;
INSERT INTO `carousel` VALUES (2,'https://pages.tmall.com/wow/a/act/tmall/tmc/26144/wupr?spm=a21bo.2017.201862-1.d1.5af911d9oAsyFN&pos=1&wh_pid=industry-190175&acm=20140506001.1003.8.7649775&scm=1003.8.20140506001.OTHER_1585347358843_7649775','http://img.yemuc.xyz/59b456177df8425089186da3060eba11.jpg','亲子节2','2020-04-25 04:58:31','2020-04-25 04:58:31'),(17,'http://yemuc.xyz','http://img.yemuc.xyz/363062b5756d4d7aaedcf5b16a451edd.jpg','yemuc','2020-04-25 07:56:13','2020-04-25 07:56:13'),(18,'https://item.jd.com/100012038814.html','http://img.yemuc.xyz/4d7f9f375e104261a7e13956d5eb2c30.jpg','matebook','2020-04-29 11:54:24','2020-04-29 11:54:24');
/*!40000 ALTER TABLE `carousel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (127,13,222,1,'2020-05-22 10:52:19','2020-05-22 10:52:19'),(129,16,3,1,'2020-07-01 04:54:21','2020-07-01 04:54:23');
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,NULL,'手机'),(2,1,'手机配件'),(3,2,'手机壳');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL COMMENT '商品id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `grade` int(2) NOT NULL COMMENT '评分',
  `content` varchar(512) DEFAULT NULL COMMENT '评价内容',
  `order_number` varchar(255) NOT NULL COMMENT '订单号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (1,'http://img.yemuc.xyz/9x.jpg',2,'1c2d724b95cc7cd3 - 副本.jpg'),(2,'http://img.yemuc.xyz/xiaomi8.jpg',2,'1c2d724b95cc7cd3 - 副本.jpg'),(4,'http://img.yemuc.xyz/9x.jpg',3,'0bedaba1e05119ac.jpg'),(52,'http://img.yemuc.xyz/0d581744498b49aa864076fec3e3c8b4.jpg',64,'4cd2d0e022d22db5.jpg'),(53,'http://img.yemuc.xyz/9067b7fa2b39489db0751f4521d28454.jpg',64,'3c775e6dbad436c6.jpg'),(54,'http://img.yemuc.xyz/fb6253314444451698f617c0d7cc7154.jpg',65,'1c2d724b95cc7cd3 - 副本.jpg'),(55,'http://img.yemuc.xyz/a4dc376bdd0a4ba99f6fc711b4ba6b8a.jpg',65,'1c2d724b95cc7cd3.jpg'),(56,'http://img.yemuc.xyz/e172ce3060ed4687aa076f45a0bf743d.jpg',66,'6ad831c264db7296.jpg'),(57,'http://img.yemuc.xyz/afc86d39e82e4e86a52321d636ccf5f3.jpg',66,'59804402N1c4e5159.jpg'),(64,'http://img.yemuc.xyz/d2af7f4f447843b19d84f613116aaf09.jpg',68,'890f91d5861c755f.jpg'),(65,'http://img.yemuc.xyz/a558b78317614abfad0b4b58cffbc69b.jpg',1,'1c2d724b95cc7cd3 - 副本.jpg'),(79,'http://img.yemuc.xyz/57f93bb8d76447e797c5b0d0792199d1.jpg',179,'1e4891921f674cf7bb4a87394d7819cf'),(80,'http://img.yemuc.xyz/d6d97ea47a63425ea7b9d93996e9129f.jpg',180,'4b996814f30d45158a73f4344bb92383'),(81,'http://img.yemuc.xyz/b58057c2f25e4cdba7468ee504f11141.jpg',181,'467eabeba4404628ab7e73b5da5878f3'),(82,'http://img.yemuc.xyz/e58d25277ac4495e896108be36fa04ff.jpg',182,'7342c4918aff425fad4d2444fdabe83d'),(83,'http://img.yemuc.xyz/cf58ae64dc1f401eafb6316065cc89a3.jpg',183,'c4ca424b66ed4ceba4545218b8a13250'),(84,'http://img.yemuc.xyz/bce83ba4179644198f21a336a9c0c47e.jpg',184,'11317f1cb1854534aae639f9738b81a6'),(85,'http://img.yemuc.xyz/703d033a8afb4df6a3439137c5b64e91.jpg',185,'d4c9347332bc4e3eacae859d9bc5f8cb'),(86,'http://img.yemuc.xyz/fc5f6882fc19411cb26fafe1521b7295.jpg',186,'0282454d63184423bfcecfaf2e86e3a8'),(87,'http://img.yemuc.xyz/cc68b6280afd4659b8218bba432b5d3b.jpg',187,'d2589208a2d147f08f44fcb2c7f26114'),(88,'http://img.yemuc.xyz/86c7744f90184a33866d9f4e559219fb.jpg',188,'5debc3e5eeb24045a27ad759eeb6d41a'),(89,'http://img.yemuc.xyz/ca8edc97825a4102bf3a983536309979.jpg',189,'1da10be5b77446ef9faec3b6e361b365'),(90,'http://img.yemuc.xyz/556903e70f4c4e288be8200def56cb23.jpg',190,'f9a0c70f2a2047309fdbff503cb9720c'),(91,'http://img.yemuc.xyz/6e3e7fb9d74946f9bb4eaed4010fc9f1.jpg',191,'31cdf8e8fd4f42ae81040554f85a34fb'),(92,'http://img.yemuc.xyz/823c8e2852534c7298c38ce453eeadb8.jpg',192,'0332749e81604524be40bd390ca37bbe'),(93,'http://img.yemuc.xyz/2fbf05b4510140e4837581ed0833ba5b.jpg',193,'faa8732dde704e818d1567e86e76dfd4'),(94,'http://img.yemuc.xyz/84bca4fa06e94519be0a47994e7a35da.jpg',194,'c2edeea4285b4160b9055205d665ce21'),(95,'http://img.yemuc.xyz/41b855899ec54caf8d57be93057e8256.jpg',195,'287604504dc94f1aa440b7ef5a780ec1'),(96,'http://img.yemuc.xyz/2300af6fdffc4d4ba9bc4d6ce4147aa9.jpg',196,'ccbb781e37914a119b042a9dc16ba3fa'),(97,'http://img.yemuc.xyz/e136607de01e45989865b7c27edff629.jpg',197,'ed68ac6f01424b5a8036028ccd204544'),(98,'http://img.yemuc.xyz/ecc2f68ed7854b32b95df91b9e38c029.jpg',198,'0fc811d76c184080be88229c8397113e'),(99,'http://img.yemuc.xyz/73bad914c0914942bbe0d69ad6e8df9b.jpg',199,'1887472388c34480b8ebf5e84411ea0f'),(100,'http://img.yemuc.xyz/4748938ca6c64fc9a7c1d17ea443a206.jpg',200,'51bad738de2c4aa2a029718e19de744a'),(101,'http://img.yemuc.xyz/e7f05259924b4fd88126256de44ed997.jpg',201,'eea950a1010a49a6b056432635177cbf'),(102,'http://img.yemuc.xyz/0152e176248f4890b83019a35e239d4b.jpg',202,'fdfc22f076ea4794adc7ffbe1a76eae3'),(103,'http://img.yemuc.xyz/00b95fe8d40f4c5fbf209170491474a9.jpg',203,'7f4fe25e6f0e4312875e134ed8c1c968'),(104,'http://img.yemuc.xyz/09908a44527f472ead9a3e4e6ed2ae37.jpg',204,'6381d5a214924548b94c647cc6ebcaf7'),(105,'http://img.yemuc.xyz/9dd4359cba3c431dae6bdc74770b857f.jpg',205,'b5ae16664f56456da42018ec831568ca'),(106,'http://img.yemuc.xyz/e325bfac11a141fa8434feb386c8f444.jpg',207,'07e918d9a1a8423db124ac0ed7655afa'),(107,'http://img.yemuc.xyz/198a2670b8db4bcba101b551a79e9921.jpg',208,'0803c816420e44fc824750d184089912'),(108,'http://img.yemuc.xyz/ca2ce2d90cea4d58a9fee00e3c6a2106.jpg',209,'ccf97237db6641eab81fdf06e6631422'),(109,'http://img.yemuc.xyz/96ebab5a1eb6452290d3cd8a929ae5bb.jpg',210,'aa55763249064a8c9aa3c518e9efcb23'),(110,'http://img.yemuc.xyz/7d1689068ede48d9a22784d4aece2aac.jpg',211,'6946bb2fcd224a64bb71b8c87781b329'),(111,'http://img.yemuc.xyz/4c9cebccb0994c5cafa585dd0840c75c.jpg',212,'8f82e828802049e190f2771c55ce96d9'),(112,'http://img.yemuc.xyz/df658c8aec954ba1a3837133f3bf0a1b.jpg',213,'c8e99f64d6074bf195d1a89d8edde5b5'),(113,'http://img.yemuc.xyz/6db34f27fad341d9b58665ea2efbfe4a.jpg',214,'d82a8345064e4c1694359bb6ff7e3103'),(114,'http://img.yemuc.xyz/87c9b4e479ea45a095638a082c455877.jpg',215,'ec15c8d81853421bbd0289b91ab83d77'),(115,'http://img.yemuc.xyz/f01660950dd94bf3b03db47c79494620.jpg',216,'715ef93b03444c28b235bfe1daeabc4d'),(116,'http://img.yemuc.xyz/5ad90ae15ca740ccb51b1cab5c7916ac.jpg',217,'cab8b598121945df9bf7ecbd85426a30'),(117,'http://img.yemuc.xyz/2d9aef559dab4fe7a916b7d017ac7105.jpg',218,'cffd9eb276f2455db99b961b1d96b6d4'),(118,'http://img.yemuc.xyz/0cb23515de044fde849267ce7dc0910e.jpg',219,'bee75f0dfccb4e648eb94eeb3a6edaf3'),(119,'http://img.yemuc.xyz/712891688c8a45338b604bc6fbe74828.jpg',220,'74e7cd83d4d94bfebb37e594afa3e4f0'),(120,'http://img.yemuc.xyz/e242f59b2dbd4bd79036851ca0459226.jpg',221,'c9cf338c4d3846ad99745091cd4a5869'),(121,'http://img.yemuc.xyz/f3895e31194e41ef840bedff9001f806.jpg',222,'82592e61de5e4aef9c3cb90366b3a6f6'),(122,'http://img.yemuc.xyz/27cda164094a4d8786032eb4b00827ec.jpg',223,'a663ba0f6e844e4d9044e6ba886ea44b'),(123,'http://img.yemuc.xyz/8a51041a32bd485a8775b5b423c8102c.jpg',224,'11c39304d78d4266a7cd351e0939fa20'),(124,'http://img.yemuc.xyz/0184a6d386494d66b84cf2c0dea42580.jpg',225,'47279d18d0b54435aba01bf7844c7ac7'),(125,'http://img.yemuc.xyz/c33205b8f43a45bfb07430c52c7ec2ad.jpg',226,'3514767daf314a099fa07528abe6cebb'),(126,'http://img.yemuc.xyz/b667c580e6994330b0f784cec58df6c5.jpg',227,'30217188db394c2aa692c30f66f22fe2'),(127,'http://img.yemuc.xyz/0c862e9fdf89469e819b25f444203def.jpg',228,'49f16332b06843b6bb0b75607df58b70'),(128,'http://img.yemuc.xyz/cca954ada96d4e44b3ec22bf29383e34.jpg',229,'870fc4e61b69451cbfaa5d6e52175bc7'),(129,'http://img.yemuc.xyz/8023c5081be64c31a758125785680e30.jpg',230,'f745d41b90d14ee7b47eb836a9681664'),(130,'http://img.yemuc.xyz/29431c6824f741ccb3efbbe9875727de.jpg',231,'93c7d4ae315d42fdb281fd2134fef1b3'),(131,'http://img.yemuc.xyz/b9822b452b7941d29fc270e046c3f1b1.jpg',232,'86153e3fb62d474b929b6db1a2c4ae2f'),(132,'http://img.yemuc.xyz/83655a0a6fd24710a6490c89a53f7341.jpg',233,'1e870e686b544f44868c121718eabf49'),(133,'http://img.yemuc.xyz/9c5e090641c04eb9b46ca6bd3dcd22bc.jpg',234,'40d5a667064a47e5ac6c7f9314e2c640'),(134,'http://img.yemuc.xyz/a61eef0b6c1c446f8ff4b806f3a052f4.jpg',235,'80eb392968e04d52a9534342e26cf1d3'),(135,'http://img.yemuc.xyz/78f31e9855f54026ad648d1d13cdb9f0.jpg',236,'1a19d72a70d34d30a9ce94e6926ee811'),(136,'http://img.yemuc.xyz/a87cef013f2e4a30adc355443ef715a2.jpg',237,'37a3ce7174b740c2aa8ddd2ea7d39582'),(137,'http://img.yemuc.xyz/05bc52f4055342cab5914882628f65ed.jpg',238,'662dd28cbe894d688e2656f7aff11917'),(138,'http://img.yemuc.xyz/5bc11a8911b345c0819bbd37113f0133.jpg',239,'da07f7f2871b4ab6959c7d5097998685'),(139,'http://img.yemuc.xyz/77e25cd8d87247138e710e578039d013.jpg',240,'39b6d38bd7d6456bbdee598297c9aeb7'),(140,'http://img.yemuc.xyz/cfbecfce56a34484bfb185419ee01b0f.jpg',241,'b675a0ee01a64c42bff89cb94c1b2bc0'),(141,'http://img.yemuc.xyz/20e8ca50676c4e6aa9535515fd3caee6.jpg',242,'4fa906583a0045d39dd08af438fffb5b'),(142,'http://img.yemuc.xyz/8dae25efd2dd46879aacd40adb08634e.jpg',243,'bfc789daa7204bba84469b0541940e56'),(143,'http://img.yemuc.xyz/c5924101ed844f12805613375c9cd65f.jpg',244,'7848f796058f4307a492edccd398b915'),(144,'http://img.yemuc.xyz/95d20dd1810b46c7b988b435501aee8f.jpg',245,'ccb19e6e36d34995a01147192687efc7'),(145,'http://img.yemuc.xyz/ceb632ffe59f4419b645222baa1de267.jpg',246,'c25a7ffde844436881a027aaf248340d'),(146,'http://img.yemuc.xyz/dada3d5a318f4215b8ec8dff931dbc3b.jpg',247,'96f75b0424cb4439956d336c52057a15'),(147,'http://img.yemuc.xyz/bca81d7c173942e8b4f1540d6f5256d1.jpg',248,'094aa60368084257b28d3c287b61239a'),(148,'http://img.yemuc.xyz/b8eebc291da44cd7ba38124aad4cc831.jpg',249,'6534bd84a21548829b5d137b954cbb66'),(149,'http://img.yemuc.xyz/020fcc9f9ff6489ea5d884709746e767.jpg',250,'de24ec275af647d494b3cc0048c95c6b'),(150,'http://img.yemuc.xyz/64b7d61bf46d4893a1621e0056857372.jpg',251,'42f0248f86264407881dfd0ef467411b'),(151,'http://img.yemuc.xyz/6bd7f8d146ed4fcb98b62209478aacde.jpg',252,'516b0bf5fbb74223831a279ab077c783'),(152,'http://img.yemuc.xyz/b3972fd4287546dd93e58be343f82cc5.jpg',253,'ff38f693c9884fd0ad39deb7c95baeaa'),(153,'http://img.yemuc.xyz/e85c63ff324544d5ab21ba93b7cfb5ef.jpg',254,'7131eeebb1b8451ebd0d51e76c955cc2'),(154,'http://img.yemuc.xyz/f832e72f23e3459c8ef486e33023dcd6.jpg',255,'dffe513130a240e4afd542b525bd4f7d'),(155,'http://img.yemuc.xyz/185d1735d17b41d685f55d2cfb4849a2.jpg',256,'e08059761ce142779cd160d957b41acf'),(156,'http://img.yemuc.xyz/942cf95051f74fd981f43e5b4c97faeb.jpg',257,'f129fd4590274f5ea2ecdbece0101678'),(157,'http://img.yemuc.xyz/7d96c288e76044a98fb34bc4138adebb.jpg',258,'933f72ac936f41a7876858d29fe121fe'),(158,'http://img.yemuc.xyz/3c09cabc63bf4be89f2ff3e72ae4e4fe.jpg',259,'c0abdd3de52a4eb6a122755dfdb079f6'),(159,'http://img.yemuc.xyz/4ea92571a2f74aadb8723f8817e26649.jpg',260,'88dace33165e492e8f3dc329724487d3'),(160,'http://img.yemuc.xyz/8d52ab0205724068a15515e3fce04fa9.jpg',261,'44a4372b948b449f9542783f3833af31'),(161,'http://img.yemuc.xyz/269f99c8bdda4ae486b7d3cd851a2129.jpg',262,'5a372b443955402fafa68372e4ffd598'),(162,'http://img.yemuc.xyz/89196fb00ae3433092898100ecae91fd.jpg',263,'75f100495ea0405a89a4b0d92d021b07'),(163,'http://img.yemuc.xyz/be66aa8e81f1407a8936facd867e3b52.jpg',264,'14502df64ef1452b9dc7debe51ffe6c6'),(164,'http://img.yemuc.xyz/bf579630494c423b9d8780ce2a9974d2.jpg',265,'52d3eaea3de348b082cc6183f11322d0'),(165,'http://img.yemuc.xyz/52c9be5eb74e4654a188cda3a53de547.jpg',266,'b32d03bfb9914e479b9336b0fa244ffd'),(166,'http://img.yemuc.xyz/f53801a1e0b7440f8d30fb58103ba694.jpg',267,'7bcb46ee880a42d3b4e58dd8384f4419'),(167,'http://img.yemuc.xyz/29a57ca488304bb89e7c640fee004832.jpg',268,'1c9c3fa9a96247aea75d4dc48d6b060c'),(168,'http://img.yemuc.xyz/92fb0541ba0e405098a243fd63016709.jpg',269,'7ae794b568e748afab723644e1817f9e'),(169,'http://img.yemuc.xyz/1d383c5f935e4958ad2f8d2c1071aa09.jpg',270,'5eae5ae2c2394bac8cd377a774bc4683'),(170,'http://img.yemuc.xyz/1ede9d44e94a4530a7004a0a2311fed3.jpg',271,'eb92bc6e4f15449b9a16d9d036b53af3'),(171,'http://img.yemuc.xyz/ee181674c70447e9b8c1eec6444e8c8c.jpg',272,'82bbee34989b4149a9ee15272b38d0a8'),(172,'http://img.yemuc.xyz/ac55cebbd16347caa00e3610708143f1.jpg',273,'1fe3744c69b2414880902418dffc824d'),(173,'http://img.yemuc.xyz/5a2b11e546a34f7cb90d948416f07fcb.jpg',274,'5a774f1e184449efa43ba1ba85b6147c'),(174,'http://img.yemuc.xyz/2566ce6ba2594f43a2384189c4e3f4da.jpg',275,'a4ec81b5f5c549dc89876e0a9e4c7ca9'),(175,'http://img.yemuc.xyz/91c3054adb1b4e81a1732542d040c502.jpg',276,'e455faee81a84d938c17624ea2e46829'),(176,'http://img.yemuc.xyz/223a50274a3241c087c4b55da2918591.jpg',277,'867ef569ab794b7abe9facd800fa9bf8'),(177,'http://img.yemuc.xyz/d0763de35c824dc996b16371a79c130f.jpg',278,'71480c288ccf4e4d8f9e7379f71311a0'),(178,'http://img.yemuc.xyz/480a5b51e1c7496ca34c876421e9fbf3.jpg',279,'4c47bb19dd864d8f9f8f3d126cf8de25'),(179,'http://img.yemuc.xyz/63c6bac01a2e4556b7fb83801912fb24.jpg',280,'27424fe8922e4ddab249865a85335eb7'),(180,'http://img.yemuc.xyz/b6ac21a00ea2458981d53f585b34861c.jpg',281,'be70b7da5e3a4b3d8403fa73eadbf72d'),(181,'http://img.yemuc.xyz/0d19f84ce20e43feb9be400621b88336.jpg',282,'a83e82f2f0f14fa0b37d6392d514cda4'),(182,'http://img.yemuc.xyz/5085c88d04ec48058d48d4a52d94c26d.jpg',283,'a4e9c1ef74d24504b504260d15d4bd4a'),(183,'http://img.yemuc.xyz/29bc37e7ed994834a490d82499dbeb48.jpg',284,'220c13514c1a4b6ead637840b36f3a68'),(184,'http://img.yemuc.xyz/0ad46fc4926e4b6bbdf039d1bda16ea5.jpg',285,'9291cff03db6446c9b2348743eca0bd5'),(185,'http://img.yemuc.xyz/370da2e932124e118c664f1fe92e645a.jpg',286,'c4b5676a78054bb7aa6b25416128890a'),(186,'http://img.yemuc.xyz/1014ecb1c7014e038f09e745aa271dc1.jpg',287,'64895677888c4b9aa48c3ea7281e48af'),(187,'http://img.yemuc.xyz/3a0c61b014bc400fa2f1c0102659d89b.jpg',288,'51b9552b6b9a41a695c88d36416c8e4d'),(188,'http://img.yemuc.xyz/b3735b67b8a843c580968cd5cd3b41e7.jpg',289,'02efdeadb3384783a6f42e566d038599'),(189,'http://img.yemuc.xyz/e6a816f68e6c408286fb6c029d47f11e.jpg',290,'d47eac92a61045c8b377191349931b10'),(190,'http://img.yemuc.xyz/71b61942f347407686f2429a736993a5.jpg',291,'8d0cc8f0137f48188ed281033f97ead0'),(191,'http://img.yemuc.xyz/8473c049687f4f488d31dbf6b625fd46.jpg',292,'91008618fbb54b2bbfc5ebfc232c61ad'),(192,'http://img.yemuc.xyz/dc2165c3b698400f8ca4ebeb4966c846.jpg',293,'9e898c69e91542e186e4737e02a0d0dc'),(193,'http://img.yemuc.xyz/153368c3fd61400f88a5d7522b4fb603.jpg',294,'7a7119f77c274c968b0b1598885e1dda'),(194,'http://img.yemuc.xyz/1bf3c7066f72415c8c65f3b5d12f442d.jpg',295,'e17f7b39583546e29d2ad0cf73410b2a'),(195,'http://img.yemuc.xyz/fa5a2261521c4816b6d8d081920f01a9.jpg',296,'d9b47f1f60f141b3856b1dbb7cc47bbd'),(196,'http://img.yemuc.xyz/89dd2e1846ee43cdade10326f56f4161.png',297,'批注 2020-03-29 131141.png'),(213,'http://img.yemuc.xyz/f29a7e4c937e4a309a45b112c01cf87d.jpg',0,'背景图.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_similarity`
--

DROP TABLE IF EXISTS `item_similarity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_similarity` (
  `pid1` int(11) NOT NULL,
  `pid2` int(11) NOT NULL,
  `similarity` double(11,5) NOT NULL DEFAULT '0.00000',
  PRIMARY KEY (`pid1`,`pid2`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_similarity`
--

LOCK TABLES `item_similarity` WRITE;
/*!40000 ALTER TABLE `item_similarity` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_similarity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual_recommend`
--

DROP TABLE IF EXISTS `manual_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `level` int(5) NOT NULL DEFAULT '1' COMMENT '推荐等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual_recommend`
--

LOCK TABLES `manual_recommend` WRITE;
/*!40000 ALTER TABLE `manual_recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `manual_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(64) DEFAULT NULL COMMENT '订单号',
  `uid` int(11) NOT NULL COMMENT '消费者id',
  `pid` int(11) NOT NULL COMMENT '商品id',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT '购买数量',
  `total` decimal(10,2) NOT NULL COMMENT '总价',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `status` varchar(64) NOT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_dictionary`
--

DROP TABLE IF EXISTS `order_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_dictionary` (
  `id` int(11) NOT NULL COMMENT 'id',
  `description` varchar(255) NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_dictionary`
--

LOCK TABLES `order_dictionary` WRITE;
/*!40000 ALTER TABLE `order_dictionary` DISABLE KEYS */;
INSERT INTO `order_dictionary` VALUES (0,'待支付'),(1,'待发货'),(2,'待收货'),(3,'待评价'),(4,'交易完成'),(5,'取消订单（在发货前）'),(6,'退款中'),(7,'换货中'),(8,'交易关闭'),(9,'删除状态');
/*!40000 ALTER TABLE `order_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_main`
--

DROP TABLE IF EXISTS `order_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_main` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(64) NOT NULL COMMENT '订单号',
  `uid` int(11) NOT NULL COMMENT '消费者id',
  `pid` int(11) NOT NULL COMMENT '商品id',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT '购买数量',
  `total` decimal(10,2) NOT NULL COMMENT '总价',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `pay_way` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `status` int(3) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_main`
--

LOCK TABLES `order_main` WRITE;
/*!40000 ALTER TABLE `order_main` DISABLE KEYS */;
INSERT INTO `order_main` VALUES (27,'15852220589662183',2,183,1,6999.00,15,'online',9,'0','2020-03-26 11:27:38','2020-03-30 03:08:16'),(28,'15852220592432185',2,185,1,0.00,15,'online',4,'','2020-03-26 11:27:39','2020-03-30 03:50:56'),(29,'15852221254972182',2,182,1,0.00,15,'online',9,'','2020-03-26 11:28:45','2020-03-30 03:50:57'),(30,'158522279720123',2,3,1,1099.01,15,'online',9,'','2020-03-26 11:39:57','2020-03-30 03:51:02'),(31,'158522305682123',2,3,1,1099.01,15,'online',9,'','2020-03-26 11:44:16','2020-03-30 03:51:04'),(32,'158522358543223',2,3,1,1099.01,15,'online',4,'','2020-03-26 11:53:05','2020-03-30 03:51:06'),(33,'158522365346222',2,2,1,2499.00,15,'online',8,'','2020-03-26 11:54:13','2020-03-30 03:51:08'),(34,'1585274661685268',2,68,2,11998.00,15,'online',9,'','2020-03-27 02:04:21','2020-03-30 03:51:10'),(35,'15852839771292212',2,212,1,3699.00,15,'online',9,'','2020-03-27 04:39:37','2020-03-30 03:51:12'),(36,'15852983819922182',2,182,2,0.00,15,'online',9,'','2020-03-27 08:39:42','2020-03-30 03:59:16'),(37,'158529858333422',2,2,1,2499.00,15,'online',9,'','2020-03-27 08:43:03','2020-03-30 02:47:37'),(38,'158529862879022',2,2,1,2499.00,15,'online',9,'','2020-03-27 08:43:48','2020-03-30 02:47:39'),(39,'158553627688123',2,3,1,1099.01,15,'online',9,'','2020-03-30 02:44:36','2020-03-30 02:53:52'),(40,'15856184220522183',2,183,1,6999.00,15,'online',9,'','2020-03-31 01:33:42','2020-03-31 01:33:42'),(41,'15856184793682182',2,182,1,0.00,15,'online',9,'','2020-03-31 01:34:39','2020-03-31 01:34:39'),(42,'158561852270722',2,2,1,2499.00,15,'online',9,'','2020-03-31 01:35:22','2020-03-31 01:35:22'),(43,'158562061059822',2,2,1,2499.00,15,'online',8,'','2020-03-31 02:10:10','2020-03-31 02:10:10'),(44,'15856208371752182',2,182,1,0.00,15,'online',9,'','2020-03-31 02:13:57','2020-03-31 02:13:57'),(45,'158563062608823',2,3,1,1099.01,15,'online',9,'','2020-03-31 04:57:06','2020-03-31 04:57:06'),(46,'158571500798823',2,3,2,2198.02,15,'online',9,'','2020-04-01 04:23:28','2020-04-01 04:23:28'),(47,'15857891177872184',2,184,1,3189.00,15,'online',4,'','2020-04-02 00:58:37','2020-04-02 00:58:37'),(48,'158588254076022',2,2,1,2499.00,15,'online',4,'','2020-04-03 02:55:40','2020-04-03 02:55:40'),(49,'15858826565892179',2,179,1,2099.00,15,'online',4,'','2020-04-03 02:57:36','2020-04-03 02:57:36'),(50,'15862268153182186',2,186,1,280.00,15,'online',4,'','2020-04-07 02:33:35','2020-04-07 02:33:35'),(51,'15862268383302193',2,193,1,2599.00,15,'online',4,'','2020-04-07 02:33:58','2020-04-07 02:33:58'),(52,'15862269193072196',2,196,1,1266.00,15,'online',4,'','2020-04-07 02:35:19','2020-04-07 02:35:19'),(53,'15862269885622196',2,196,1,1266.00,15,'online',4,'','2020-04-07 02:36:28','2020-04-07 02:36:28'),(54,'15862270257512186',2,186,35,9800.00,15,'online',4,'','2020-04-07 02:37:05','2020-04-07 02:37:05'),(55,'15881283114442183',2,183,1,6999.00,15,'online',1,'','2020-04-29 02:45:11','2020-04-29 02:45:11'),(56,'158813246564423',2,3,1,1099.00,15,'online',9,'','2020-04-29 03:54:25','2020-04-29 03:54:25'),(57,'15882144086251230',1,230,1,3399.00,13,'online',0,'','2020-04-30 02:40:08','2020-04-30 02:40:08'),(58,'15882144087481250',1,250,1,5489.00,13,'online',0,'','2020-04-30 02:40:08','2020-04-30 02:40:08'),(59,'15882334105322189',2,189,3,4797.00,15,'online',4,'','2020-04-30 07:56:50','2020-04-30 07:56:50'),(60,'158885038954112',1,2,6,11994.00,13,'online',0,'','2020-05-07 11:19:49','2020-05-07 11:19:49'),(61,'15888503896191185',1,185,1,0.00,13,'online',0,'','2020-05-07 11:19:49','2020-05-07 11:19:49'),(62,'1589439064741123',12,3,1,1099.00,18,'online',9,'','2020-05-14 06:51:04','2020-05-14 06:51:04'),(63,'1589441443282122',12,2,1,1999.00,18,'online',9,'','2020-05-14 07:30:43','2020-05-14 07:30:43'),(64,'15901430989222212',2,212,2,7398.00,15,'online',1,'','2020-05-22 10:24:58','2020-05-22 10:24:58'),(65,'159135687151223',2,3,6,6594.00,15,'outline',2,'','2020-06-05 11:34:31','2020-06-05 11:34:31');
/*!40000 ALTER TABLE `order_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `info` varchar(255) DEFAULT NULL COMMENT '标题',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `category` varchar(255) DEFAULT NULL COMMENT '分类id',
  `status` varchar(255) DEFAULT '1' COMMENT '商品状态在售，下架，售空',
  `stock` int(11) DEFAULT NULL COMMENT '库存量',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'荣耀20 李现同款 4800万超广角AI四摄 3200W美颜自拍 麒麟Kirin980全网通版8GB+128GB 幻影蓝 全面屏手机','华为荣耀20','华为（HUAWEI）',1999.00,'1','true',93,'2020-02-19 02:39:01','2020-04-25 06:47:39'),(3,'荣耀9X 麒麟810 4000mAh超强续航 4800万超清夜拍 6.59英寸升降全面屏 全网通4GB+64GB 魅海蓝','荣耀9X','华为（HUAWEI）',1099.00,'1','true',90,'2020-02-19 02:39:01','2020-04-03 09:56:12'),(68,'飞行堡垒笔记本','飞行堡垒笔记本','华硕',4999.00,'','true',10,'2020-02-28 11:20:21','2020-04-03 09:55:57'),(179,'【行业爆款·高配主机·超值之选】活动下单即送24英寸高端电竞显示器，升级GTX1050高端电竞N卡，抢升16G高频内存更多活动','硕扬 i9级处理器/GTX1050独显/16G内存/办公游戏台式组装电脑主机/DIY组装机','硕扬',2099.00,NULL,'true',98,'2020-03-03 04:21:25','2020-04-03 03:17:31'),(180,'【行业爆款·高配主机·超值之选】活动下单即送24英寸高端电竞显示器，升级GTX1050高端电竞N卡，抢升16G高频内存更多活动','硕扬 i9级处理器/GTX1050独显/16G内存/办公游戏台式组装电脑主机/DIY组装机','硕扬',2099.00,NULL,'true',100,'2020-03-03 04:25:10','2020-04-03 03:17:31'),(181,'【行业爆款·高配主机·超值之选】活动下单即送24英寸高端电竞显示器，升级GTX1050高端电竞N卡，抢升16G高频内存更多活动','硕扬 i9级处理器/GTX1050独显/16G内存/办公游戏台式组装电脑主机/DIY组装机','硕扬',2099.00,NULL,'true',100,'2020-03-03 04:26:56','2020-04-03 03:17:31'),(182,'【3.5日低至3299，享6期免息】全面屏，超轻薄，轻至1.38kg,长续航，钻切蓝边时尚炫酷，多屏协同，无缝传输！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',95,'2020-03-03 04:27:12','2020-04-03 03:17:31'),(183,'狄派 i7 9700K八核/P2000/32G内存 创意设计师电脑绘图3D渲染台式组装主机图形工作站 影视后期【i5 9600K/P1000 4G 】','狄派 i7 9700K八核/P2000/32G内存 创意设计师电脑绘图3D渲染台式组装主机图形工作站 影视后期【i5 9600K/P1000 4G 】','狄派',6999.00,NULL,'true',92,'2020-03-03 04:27:20','2020-04-03 03:17:31'),(184,'九代酷睿I3，8G大内存，512G大容量疾速SSD，内置WIFI，蓝牙，工业用9针串口，一步到位的办公神器','联想天逸510S','联想（Lenovo）',3189.00,NULL,'true',98,'2020-03-03 04:27:48','2020-04-03 03:17:31'),(185,'【3.5日低至3399，享6期免息】全面屏87%屏占比，超轻薄，长续航，钻切蓝边时尚炫酷，指纹识别，多屏协同！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',95,'2020-03-03 04:27:50','2020-04-03 03:17:31'),(186,'【企业免押金】设备3天起租，短租或超短租请联系客服，拍错不发货,买家承担寄回运费，默认顺丰，北京地区支持上门或闪送','ThinkPadx220','ThinkPad',280.00,NULL,'true',63,'2020-03-03 04:27:51','2020-04-03 03:17:31'),(187,'【企业免押金】设备3天起租，短租或超短租请联系客服，拍错不发货,买家承担寄回运费，默认顺丰，北京地区支持上门或闪送','【租赁】苹果MacBook Pro15.4英寸笔记本电脑视频剪辑作图一 i7 8G 256G固态15.4英寸','Apple',6000.00,NULL,'true',100,'2020-03-03 04:27:52','2020-04-03 03:17:31'),(188,'【替换季焕新机】晒单享好礼+白条6期免息，游戏掌机免费抽；宅家上课，高效更快乐。更多福利，即刻查看','戴尔Ins 3670-R3848S/R38N8S','戴尔（DELL）',4699.00,NULL,'true',100,'2020-03-03 04:27:53','2020-07-04 06:51:27'),(189,'酷耶(Cooyes)i5四核/GTX1660独显6G/台式机电脑主机整机全套组装家用游戏电竞 套餐一(GTX750独显电脑主机)','酷耶(Cooyes)i5四核/GTX1660独显6G/台式机电脑主机整机全套组装家用游戏电竞 套餐一(GTX750独显电脑主机)','酷耶（Cooyes）',1599.00,NULL,'true',97,'2020-03-03 04:27:55','2020-04-03 03:17:31'),(190,'下单即送24英寸曲面高清显示器！限量升级i9级八核十六线程搭配RX580-4G吃鸡游戏战机，助你畅快吃鸡无压力！！','逆世界 i7升i9级八核十六线程/RX580 4G吃鸡独显32G内存游戏台式电脑主机DIY组装机 套餐二：八核十六线程/RX580 4G吃鸡独显','逆世界',2399.00,NULL,'true',100,'2020-03-03 04:27:56','2020-04-03 03:17:31'),(191,'九代酷睿I5，8G大内存，512G大容量疾速SSD，内置WIFI，蓝牙，工业用9针串口，一步到位的办公神器','联想天逸510S','联想（Lenovo）',3989.00,NULL,'true',99,'2020-03-03 04:27:58','2020-04-03 03:17:31'),(192,'【替换季焕新机】晒单享好礼+白条6期免息，游戏掌机免费抽；宅家上课，高效更快乐。更多福利，即刻查看','戴尔Vostro 3471-R14N8R','戴尔（DELL）',3599.00,NULL,'true',100,'2020-03-03 04:27:59','2020-07-04 06:51:27'),(193,'轻薄窄边款，键盘含防破溅设计，守护组件安全','ThinkPadE480','ThinkPad',2599.00,NULL,'true',99,'2020-03-03 04:28:00','2020-04-03 04:27:26'),(194,'【武极女神节，全店主机1-10名抢666元现金红包】新九代i5、一线品质主板+6G大显存显卡、畅玩电竞！更多惊喜点我查看》','武极 新i5 9400F/GTX1660-6G/B365 游戏台式吃鸡电脑主机DIY组装机','武极',3899.00,NULL,'true',100,'2020-03-03 04:28:02','2020-04-03 03:17:31'),(195,'华硕(ASUS) 猎鹰V4 21.5英寸商用办公一体机台机电脑(Intel 4417U 4G内存 128GSSD+1T 全高清 上门售后)白','华硕猎鹰V4','华硕（ASUS）',2799.00,NULL,'true',100,'2020-03-03 04:28:03','2020-04-03 03:17:31'),(196,'【京仓直发快速达，限量神券马上领】春节送利，直降再领满减券，加抢免费升级！送键鼠音响礼包+大奖刮刮卡前50台升21.5英寸+120G固态立赚400！点击提前加购','博仑帅（BOLUNSHUAI）BLS-195A','博仑帅（BOLUNSHUAI）',1266.00,NULL,'true',98,'2020-03-03 04:28:04','2020-04-03 03:17:31'),(197,'【明星爆款！稀缺货源！】R5锐龙处理器+高速512G存储+FHD面板！全新窄边框大视野！更多优惠，请点我','华硕FL8700','华硕（ASUS）',3399.00,NULL,'true',99,'2020-03-03 04:28:05','2020-04-03 03:17:31'),(198,'此商品将于2020-03-05,00点结束闪购特卖，宅家游戏主机专场','威龙远航 i7升八核E5 2665/16G/GTX1060 游戏台式吃鸡电脑主机/DIY组装机 配置二（六核+16G+GTX950M-4G）','威龙远航',1979.00,NULL,'true',100,'2020-03-03 04:28:07','2020-04-03 03:17:31'),(199,'【替换季焕新机】晒单享好礼+白条6期免息，游戏掌机免费抽；宅家上课，高效更快乐。更多福利，即刻查看','戴尔Vostro 3471-R13N9R','戴尔（DELL）',3099.00,NULL,'true',100,'2020-03-03 04:28:08','2020-07-04 06:51:27'),(200,'外星人智控中心,G模式一键散热,九代标压,GTX显卡,窄边框,72高色域,双风扇散热','戴尔G3','戴尔（DELL）',5399.00,NULL,'true',100,'2020-03-03 04:28:09','2020-04-03 03:17:31'),(208,'【现货】九代i7八核，GTX1660Ti电竞显卡，256G双硬盘速容兼顾，15L机箱精工巧琢！拯救者系列至高24期免息》','联想联想（Lenovo）GeekPro','联想（Lenovo）',6499.00,NULL,'true',100,'2020-03-03 04:50:32','2020-04-03 03:17:31'),(209,'【二手95新】Apple MacBook Pro 15.4英寸 二手苹果笔记本电脑 19款/灰色/256G/MV902/带T','【二手95新】Apple MacBook Pro 15.4英寸 二手苹果笔记本电脑 19款/灰色/256G/MV902/带T','Apple',16400.00,NULL,'true',100,'2020-03-03 04:50:34','2020-04-03 03:17:31'),(210,'【翼480升级型号翼490（25CD）】512G固态硬盘，运行速度更快，2G高性能显卡，让画面更清晰点击选购','ThinkPad翼480','ThinkPad',4499.00,NULL,'true',100,'2020-03-03 04:50:35','2020-04-03 03:17:31'),(211,'搭载2G高性能显卡，让画面更清晰，支持双通道可拓展至32GB','ThinkPad翼480','ThinkPad',4499.00,NULL,'true',100,'2020-03-03 04:50:36','2020-04-03 03:17:31'),(212,'【热销爆款】【年度战略新品首发】满血版R5锐龙处理器、PCIE大容量高速固态、全高清防眩光窄边框化妆品套装优惠','小米小米笔记本','小米（MI）',3699.00,NULL,'true',97,'2020-03-03 04:50:38','2020-04-03 03:17:31'),(213,'狄派 酷睿i5/i7电竞游戏吃鸡办公台式机电脑主机/四核/16G/独显/组装电脑整机 电脑主机+24英寸曲面显示器 套餐一（i5四核/8G/240G/独显）','狄派 酷睿i5/i7电竞游戏吃鸡办公台式机电脑主机/四核/16G/独显/组装电脑整机 电脑主机+24英寸曲面显示器 套餐一（i5四核/8G/240G/独显）','狄派',2299.00,NULL,'true',100,'2020-03-03 04:50:39','2020-04-03 03:17:31'),(214,'【双倍实力，金属轻薄本】窄边框，双内存通道，双风扇散热》国货之光专场','联想扬天','联想（Lenovo）',3499.00,NULL,'true',100,'2020-03-03 04:50:40','2020-04-03 03:17:31'),(215,'【宅在家】MacBook学习办公双管齐下，让你走遍室内都不怕，限量赠送AppleMusic新用户免费试用别说你不心动！','AppleMMQA2CH/A','Apple',7900.00,NULL,'true',100,'2020-03-03 04:50:42','2020-04-03 03:17:31'),(216,'【宅在家】MacBook学习办公双管齐下，让你走遍室内都不怕，限量赠送AppleMusic新用户免费试用别说你不心动！','AppleMQD32CH/A','Apple',6278.00,NULL,'true',100,'2020-03-03 04:50:43','2020-04-03 03:17:31'),(217,'【灵越10nm10代CPU新品】大容量空间站,支持双硬盘位拓展,独显,512G固态硬盘,时尚窄边框设计,IPS全高清屏','戴尔灵越5000','戴尔（DELL）',4499.00,NULL,'true',100,'2020-03-03 04:50:44','2020-04-03 03:17:31'),(218,'【宅在家】MacBook学习办公双管齐下，让你走遍室内都不怕，限量赠送AppleMusic新用户免费试用别说你不心动！','AppleMRQY2CH/A','Apple',12858.00,NULL,'true',100,'2020-03-03 04:50:46','2020-04-03 03:17:31'),(219,'战翔酷睿i5 9400F/i7独显4G吃鸡游戏台式机电脑主机LOL组装家用办公电竞全套整机送24曲屏 套餐一酷睿i5/8G/256G/560 4G独显','战翔酷睿i5 9400F/i7独显4G吃鸡游戏台式机电脑主机LOL组装家用办公电竞全套整机送24曲屏 套餐一酷睿i5/8G/256G/560 4G独显','战翔',2499.00,NULL,'true',100,'2020-03-03 04:50:46','2020-04-03 03:17:31'),(220,'【网课优选】性价比高，轻薄机身设计，MX250高性能独显、全高清窄边框，蓝光护盾呵护双眼更多活动请点击','宏碁无','宏碁（acer）',3989.00,NULL,'true',100,'2020-03-03 04:50:48','2020-04-03 03:17:31'),(221,'【3.5日低至3699，享6期免息】全面屏87%屏占比，超轻薄，长续航，钻切蓝边时尚炫酷，指纹识别，多屏协同！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',100,'2020-03-03 04:50:50','2020-04-03 03:17:31'),(222,'【十代处理器新品】【年度旗舰机】全金属机身、增强版酷睿I7处理器、MX250高性能显卡、全高清窄边框化妆品套装优惠','小米小米笔记本','小米（MI）',4999.00,NULL,'true',100,'2020-03-03 04:50:52','2020-04-03 03:17:31'),(223,'【网课学习好帮手、智能办公更高效】23.8英寸大屏幕，微边框高色域广视角，六核酷睿I5性能强，轻松扩展大容量，超薄机身更时尚','联想AIO逸','联想（Lenovo）',4999.00,NULL,'true',100,'2020-03-03 04:50:53','2020-04-03 03:17:31'),(224,'【现货速发】365天不打烊！热销爆款，1660独显游戏主机，畅玩吃鸡网游！查看更多》》','酷耶(Cooyes)i5四核/GTX1660独显6G/台式机电脑主机整机全套组装家用游戏电竞 套餐一(GTX750独显电脑主机)','酷耶（Cooyes）',1599.00,NULL,'true',100,'2020-03-03 04:50:55','2020-04-03 03:17:31'),(225,'威沃（ViNWO VW）工业防尘全封闭无风扇工控机迷你主机微型电脑嵌入式耐高低温6USB/6COM 全封闭防尘无风扇-四核J1900 2G/32G SSD WIFI','VINWO VWVW-215GH/LH','VINWO VW',1599.00,NULL,'true',100,'2020-03-03 04:50:56','2020-04-03 03:17:31'),(226,'【线上学习好利器，宅家办公更省心】AMD高性能核显，集成Vega显卡，助力流畅办公！享白条三期免息，点击抢购》','AOC215A73440','AOC',1849.00,NULL,'true',100,'2020-03-03 04:50:57','2020-04-03 03:17:31'),(227,'【联想扬天企业采购节】，评价晒单有机会获得3000元E卡，支持远程办公，100万小时无故障运行，四年上门服务，办公优选~详情戳我','联想扬天M4000s商用办公台式电脑整机（i3-9100 8G 1T 集成显卡 WIN10 4年上门服务）','联想（Lenovo）',2899.00,NULL,'true',100,'2020-03-03 04:50:59','2020-04-03 03:17:31'),(228,'【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，拉丝工艺大机箱','联想天逸510Pro','联想（Lenovo）',5499.00,NULL,'true',100,'2020-03-03 04:51:00','2020-04-03 03:17:31'),(229,'【网课好伙伴，办公更高效】96%屏占比+72%高色域+2mm微边框，搭载intel十代处理器；白条6期免息，购物无压力。更多好物，即刻查看','戴尔Ins 22-3275-R1908W','戴尔（DELL）',2399.00,NULL,'true',100,'2020-03-03 04:51:01','2020-04-03 03:17:31'),(230,'联想(Lenovo)小新14英寸 AMD锐龙版R5（全新12nm）轻薄笔记本电脑(R5-3500U 8G 1T+128G PCIE IPS)渣渣灰','联想联想小新14锐龙版','联想（Lenovo）',3399.00,NULL,'true',99,'2020-03-03 04:51:03','2020-04-03 03:17:31'),(231,'狄派 送显示器酷睿i3-9100F升酷睿i5台式电脑主机独显吃鸡搬砖多开LOL游戏直播组装电脑整机 电脑主机 套餐四(酷睿i5四核/16G/GTX1650独显)','狄派 送显示器酷睿i3-9100F升酷睿i5台式电脑主机独显吃鸡搬砖多开LOL游戏直播组装电脑整机 电脑主机 套餐四(酷睿i5四核/16G/GTX1650独显)','狄派',3399.00,NULL,'true',100,'2020-03-03 04:51:04','2020-04-03 03:17:31'),(232,'【网课好伙伴，办公更高效】96%屏占比+72%高色域+2mm微边框，搭载intel十代处理器；白条6期免息，购物无压力。更多好物，即刻查看','戴尔Ins 22-3275-R3908W','戴尔（DELL）',2799.00,NULL,'true',100,'2020-03-03 04:51:05','2020-04-03 03:17:31'),(233,'AOC六核一体机电脑9代I5/酷睿I3I7高配游戏家用办公台式一体式整机 21.5英寸J3160四核8G/256G大容量固态','AOC六核一体机电脑9代I5/酷睿I3I7高配游戏家用办公台式一体式整机 21.5英寸J3160四核8G/256G大容量固态','AOC',2199.00,NULL,'true',100,'2020-03-03 04:51:07','2020-04-03 03:17:31'),(234,'【网课好伙伴，办公更高效】96%屏占比+72%高色域+2mm微边框，搭载intel十代处理器；白条6期免息，购物无压力。更多好物，即刻查看','戴尔Ins 24-3475-R1608W','戴尔（DELL）',2799.00,NULL,'true',100,'2020-03-03 04:51:08','2020-04-03 03:17:31'),(235,'【送“新机咨询服务+好礼，送完即止】因物流影响，服务中安装辅助材料无法与主机同时送达，望理解并耐心等待，更多精彩','华为MateBook 14','华为（HUAWEI）',6699.00,NULL,'true',100,'2020-03-03 04:51:10','2020-04-03 03:17:31'),(236,'I3九代酷睿，512G高速固态硬盘，8G大内存，内置WIFI,蓝牙，7L小机箱，高效无线现代化办公，小欧台式机注册享5年上门维修》','惠普S01-pF035ccn','惠普（HP）',2999.00,NULL,'true',100,'2020-03-03 04:51:11','2020-04-03 03:17:31'),(237,'华硕（ASUS）台式机S340商务家用办公学生游戏商用电脑主机新八代酷睿i3/i5处理器公司整机 搭配21.5寸显示器 【商务办公】G4900/8G/1T+256G','华硕（ASUS）华硕S340','华硕（ASUS）',3499.00,NULL,'true',100,'2020-03-03 04:51:12','2020-04-03 03:17:31'),(238,'替换季抢新机！【PLUS会员专享999特价】【京仓闪电直发，快速到家】【下单即送机械手感键鼠套装】企业办公采购智选戳','一品国度 AMD跑分16万四核SSD固态/DDR3游戏组装电脑主机DIY组装机台式办公 套一 7480/8G/120G固态(16万跑分）','一品国度',1188.00,NULL,'true',100,'2020-03-03 04:51:14','2020-07-04 06:51:27'),(239,'若是1100元，就在数量那里输入11加入购物车和主机一起拍下付款即可','武极 100元差价链接，差多少补多少，请勿乱拍','武极',100.00,NULL,'true',100,'2020-03-03 04:51:16','2020-04-03 03:17:31'),(240,'活动下单即送24英寸高端电竞显示器，抢升480G高速固态硬盘，升GTX1050TI-4G游戏显卡，限时升级六角兽异形机箱更多活动','硕扬 酷睿i7/GTX1050TI独显/480G SSD/游戏台式吃鸡电脑主机DIY组装机','硕扬',2979.00,NULL,'true',100,'2020-03-03 04:51:17','2020-04-03 03:17:31'),(241,'【办公不掉线，停课不停学】惠普战系列台式机，优惠享不停，助力高效办公学习，更有注册可享升级5年上门》','惠普HP ZHAN 66 Pro G1 MT','惠普（HP）',2899.00,NULL,'true',100,'2020-03-03 04:51:19','2020-04-03 03:17:31'),(242,'【新品上市,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。','戴尔Vostro 5090-R18N8R','戴尔（DELL）',5299.00,NULL,'true',100,'2020-03-03 04:51:20','2020-04-03 03:17:31'),(243,'战神盟主 i9升E5八核/GTX1060独显6G 吃鸡游戏台式机电脑主机全套整机 主机 16G/240G/GTX1060独显6G','战神盟主 i9升E5八核/GTX1060独显6G 吃鸡游戏台式机电脑主机全套整机 主机 16G/240G/GTX1060独显6G','战神盟主',3199.00,NULL,'true',100,'2020-03-03 04:51:22','2020-04-03 03:17:31'),(244,'【抢升240G高速硬盘】华硕品质板卡套装、全一线品牌！京东DIY行业机皇、好评6W+！更多惊喜点我查看》','武极i7 8700升9700F/华硕GTX1660-6G/240G游戏台式吃鸡电脑主机/DIY组装机','武极',5399.00,NULL,'true',100,'2020-03-03 04:51:23','2020-04-03 03:17:31'),(245,'【宅在家】MacBook学习办公双管齐下，让你走遍室内都不怕，限量赠送AppleMusic新用户免费试用别说你不心动！','AppleMacBook Pro 13.3','Apple',10688.00,NULL,'true',100,'2020-03-03 04:51:25','2020-04-03 03:17:31'),(246,'荣耀笔记本电脑MagicBook Pro 第三方Linux版16.1英寸全面屏轻薄本（标压锐龙R5 3550H 8G 512G 100%sRGB）银','华为荣耀MagicBook','华为（HUAWEI）',3999.00,NULL,'true',100,'2020-03-03 04:51:26','2020-04-03 03:17:31'),(247,'【3.5日低至3699，享6期免息】全面屏87%屏占比，超轻薄，长续航，钻切蓝边时尚炫酷，指纹识别，多屏协同！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',100,'2020-03-03 04:51:27','2020-04-03 03:17:31'),(248,'I3九代酷睿，1T海量存储，8G大内存，内置WIFI,蓝牙，7L小机箱，高效无线现代化办公，小欧台式机注册享5年上门维修》','惠普S01-pF031ccn','惠普（HP）',2899.00,NULL,'true',100,'2020-03-03 04:51:28','2020-04-03 03:17:31'),(249,'狄派 酷睿i5电脑主机i5-9400F/16G/1660独显/电竞吃鸡游戏台式机组装电脑整机 主机+24显示器 套餐四 吃鸡(九代i5六核/8G/GTX1050)','狄派 酷睿i5电脑主机i5-9400F/16G/1660独显/电竞吃鸡游戏台式机组装电脑整机 主机+24显示器 套餐四 吃鸡(九代i5六核/8G/GTX1050)','狄派',3699.00,NULL,'true',100,'2020-03-03 04:51:30','2020-04-03 03:17:31'),(250,'【网课优选，咨询客服有优惠，数量有限先到先得】爆款电竞优选，大尺寸双风扇，九代标压处理器，72%高色域屏，512SSD.PCIe固态硬盘更多活动请点击','宏碁AN515','宏碁（acer）',5489.00,NULL,'true',99,'2020-03-03 04:51:31','2020-04-03 03:17:31'),(251,'【办公不掉线，停课不停学】惠普战系列台式机，优惠享不停，助力高效办公学习，更有注册可享升级5年上门》','惠普HP ZHAN 66 Pro G1 MT','惠普（HP）',2999.00,NULL,'true',100,'2020-03-03 04:51:32','2020-04-03 03:17:31'),(252,'联想(Lenovo)YOGAS740英特尔酷睿i5 14.0英寸超轻薄笔记本电脑移动超能版(i5-1035G1 8G 512G MX250)深空灰','联想Yoga','联想（Lenovo）',5999.00,NULL,'true',100,'2020-03-03 04:51:33','2020-04-03 03:17:31'),(253,'亚当贝尔24-27英寸曲面超薄一体机电脑 酷睿i5/i7独显游戏组装吃鸡办公家用台式电脑主机整套 24英寸/酷睿i5/4G/256G（秒杀爆款）','亚当贝尔24-27英寸曲面超薄一体机电脑 酷睿i5/i7独显游戏组装吃鸡办公家用台式电脑主机整套 24英寸/酷睿i5/4G/256G（秒杀爆款）','亚当贝尔',1549.00,NULL,'true',100,'2020-03-03 04:51:34','2020-04-03 03:17:31'),(254,'本店所有商品正常发货，京东包邮！','宏华 INTEL高端四核六核/4G独显/16G内存吃鸡游戏办公台式组装电脑主机/DIY兼容机全套整机 主机 配置一','宏华（HONUA）',798.00,NULL,'true',100,'2020-03-03 04:51:35','2020-04-03 03:17:31'),(255,'惠普（HP）星14系列青春版 十代酷睿14英寸窄边框轻薄笔记本电脑游戏本 精选版（R3-3200U 集显） 配置一：8G内存/256G固态','惠普（HP）星14系列青春版 十代酷睿14英寸窄边框轻薄笔记本电脑游戏本 精选版（R3-3200U 集显） 配置一：8G内存/256G固态','惠普（HP）',3299.00,NULL,'true',100,'2020-03-03 04:51:36','2020-04-03 03:17:31'),(256,'全新第十代CPU，180度开合，标配背光键盘，19项军规测试','惠普战66 Pro 14 G3','惠普（HP）',5299.00,NULL,'true',100,'2020-03-03 04:51:38','2020-04-03 03:17:31'),(257,'【戴尔灵越台机全新升级512SSD】九代i5处理器，搭配17.3L大机箱，290W高效电源，强大扩展“大”有可玩。','戴尔Ins 3670-R38N9S','戴尔（DELL）',4799.00,NULL,'true',100,'2020-03-03 04:51:39','2020-04-03 03:17:31'),(258,'【网课学习好帮手、智能办公更高效】锐龙处理器，双通道更高速，三年上门服务，内置WiFi，预装Office，拉丝工艺大机箱','联想天逸510 Pro','联想（Lenovo）',3199.00,NULL,'true',100,'2020-03-03 04:51:40','2020-04-03 03:17:31'),(259,'【3.5日低至4699，享6期免息】十代酷睿CPU，强劲性能，全面屏，钻切蓝边时尚设计，13小时长续航，多屏协同，无缝传输！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',100,'2020-03-03 04:51:42','2020-04-03 03:17:31'),(260,'现货秒发，拒绝等待！抢升华硕主板+酷睿i5-4590+1050Ti-4G独显+送499元24IPS曲面屏全高特效吃鸡！更多配置戳戳戳','速佳宜：酷睿i5/华硕主板/8G/GTX1050Ti 4G办公台式吃鸡游戏组装电脑主机DIY组装 三：酷睿i5四核/8G/240G/送24高清屏','速佳宜数码',1899.00,NULL,'true',100,'2020-03-03 04:51:43','2020-04-03 03:17:31'),(261,'ARTONE 手工真皮 18K镀金轻奢本 13.3英寸全面屏 双屏 轻薄笔记本电脑(i7-10510U 16G 1TSSD MX250 2G)白色','华硕ARTONE','华硕（ASUS）',16999.00,NULL,'true',100,'2020-03-03 04:51:44','2020-04-03 03:17:31'),(262,'【酷睿i5/i7-限量送机械手感键鼠】黑色低奢金属机箱设计，酷睿处理器精选搭配多套餐可选，办公不等待，商用好帮手，游戏好能手，采购好选择，五年质保无忧售后~','华橙 酷睿i5升i7 920/RX580独显吃鸡游戏企业办公台式组装电脑主机/DIY组装机 主机+显示器 套餐一(酷睿i5+120G+办公高清核显)','华橙',1269.00,NULL,'true',100,'2020-03-03 04:51:45','2020-04-03 03:17:31'),(263,'【京天品牌秒杀】3月3日0点开抢,全场限时秒杀！高端水冷主机直降500元，更有热销外设半价来抢！戳我','京天（KOTIN）JT400-952060','京天（KOTIN）',3599.00,NULL,'true',100,'2020-03-03 04:51:46','2020-04-03 03:17:31'),(264,'【灵越5000fit酷睿十代新品】5MM窄边框,IPS防眩光屏,MX250独显,高性能固态硬盘,Type-C接口,智能温控','戴尔灵越 fit','戴尔（DELL）',5599.00,NULL,'true',100,'2020-03-03 04:51:48','2020-04-03 03:17:31'),(265,'【华硕品牌狂欢】3月3日10:00-3月4日10:00，破晓7爆款限时直降，i5低至4389，i7低至5499，购机赠原装鼠标，晒单有礼，详情咨询客服！','华硕（ASUS）PX574','华硕（ASUS）',4389.00,NULL,'true',100,'2020-03-03 04:51:49','2020-04-03 03:17:31'),(266,'此商品将于2020-03-05,00点结束闪购特卖，宅家游戏主机专场','威龙远航 i7升六核E5645/16G/GTX960M-4G 办公游戏台式组装电脑主机/DIY组装机 配置一（六核+8G+HD7570-4G）','威龙远航',1579.00,NULL,'true',100,'2020-03-03 04:51:50','2020-04-03 03:17:31'),(267,'航向者 i7升英特尔八核E5/RX580独显32G内存台式组装电脑主机DIY组装机吃鸡LOL游戏办公 电脑主机+显示器 套餐一(i5级四核+4G+办公集显)','航向者 i7升英特尔八核E5/RX580独显32G内存台式组装电脑主机DIY组装机吃鸡LOL游戏办公 电脑主机+显示器 套餐一(i5级四核+4G+办公集显)','航向者',1189.00,NULL,'true',100,'2020-03-03 04:51:52','2020-04-03 03:17:31'),(268,'【全新金属轻薄本E495上市】轻薄之间，坚固依旧。高效稳定，轻薄便携。传承ThinkPad设计','ThinkPadE495','ThinkPad',3699.00,NULL,'true',100,'2020-03-03 04:51:53','2020-04-03 03:17:31'),(269,'【网课学习好帮手、智能办公更高效】23.8英寸大屏幕，微边框高色域广视角，弹出式摄像头，美背设计更时尚','联想ideacentre AIO 520','联想（Lenovo）',2899.00,NULL,'true',100,'2020-03-03 04:51:54','2020-04-03 03:17:31'),(270,'【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱','联想天逸510S','联想（Lenovo）',3199.00,NULL,'true',100,'2020-03-03 04:51:55','2020-04-03 03:17:31'),(271,'【共抗疫情，同心协力】小新潮7000爆款限时直降，8G内存256G固态降至2749元；小新AIR14京东仓直发如您着急用电脑请您一定要选择这款','联想（Lenovo）潮7000-14','联想（Lenovo）',0.00,NULL,'true',100,'2020-03-03 04:51:56','2020-04-03 03:17:31'),(272,'【抢送24英寸电竞曲面屏】酷睿新九代i5-9400F+技嘉电竞主板，搭配4G/6G独显可选RTX2060，游戏畅玩无阻》五年质保》电竞好装备》选华橙电脑~','华橙 i5 9400F/RTX2060 6G/16G DDR4吃鸡游戏台式组装电脑主机/DIY组装机 套二/i5 9400F/8G/RX580-4G','华橙',2769.00,NULL,'true',100,'2020-03-03 04:51:58','2020-04-03 03:17:31'),(273,'华硕(ASUS) 猎鹰V4 27英寸一体机台式电脑(新八代i7-8550U 8G内存 256GSSD+1T MX150 2G 高清 上门售后)黑','华硕猎鹰V4','华硕（ASUS）',7199.00,NULL,'true',100,'2020-03-03 04:51:59','2020-04-03 03:17:31'),(274,'此商品将于2020-03-05,00点结束闪购特卖，宅家游戏主机专场','威龙远航 i7升八核E5 2665/16G/GTX1060 游戏台式吃鸡电脑主机/DIY组装机 配置四（八核+16G+GTX1060-3G）','威龙远航',2879.00,NULL,'true',100,'2020-03-03 04:52:00','2020-04-03 03:17:31'),(275,'【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱','联想天逸510Pro','联想（Lenovo）',4799.00,NULL,'true',100,'2020-03-03 04:52:02','2020-04-03 03:17:31'),(276,'人脸智能识别摄像头，底座可为手机无线充电，JBL专业音效2.1音箱，16GB双通道内存【更多店铺活动】','联想（Lenovo）AIO 520X Max-ICB','联想（Lenovo）',12299.00,NULL,'true',100,'2020-03-03 04:52:03','2020-04-03 03:17:31'),(277,'现货秒发，拒绝等待！抢升华硕主板+酷睿i5-4590+1050Ti-4G独显+送499元24IPS曲面屏全高特效吃鸡！更多配置戳戳戳','速佳宜：酷睿i5/华硕主板/8G/GTX1050Ti 4G办公台式吃鸡游戏组装电脑主机DIY组装 四：酷睿i5/4G独显/240G/送24高清屏','速佳宜数码',2299.00,NULL,'true',100,'2020-03-03 04:52:05','2020-04-03 03:17:31'),(278,'【升级版2TB+256G,容量与速度兼备】九代酷睿i7处理器,16G内存,4年整机上门+3年硬盘保留服务,超强扩展能力,免工具拆装。','戴尔Vostro 5090-R29N6R','戴尔（DELL）',6999.00,NULL,'true',100,'2020-03-03 04:52:06','2020-04-03 03:17:31'),(279,'狄派 i7升十核E5-4620V3/游戏台式机电脑主机/6G独显吃鸡电竞组装电脑整机全套 套餐一 （六核/4G独显 电脑主机）','狄派 i7升十核E5-4620V3/游戏台式机电脑主机/6G独显吃鸡电竞组装电脑整机全套 套餐一 （六核/4G独显 电脑主机）','狄派',1699.00,NULL,'true',100,'2020-03-03 04:52:07','2020-04-03 03:17:31'),(280,'【宅家不止战】九代i5，512GSSD，GTX1660Ti，畅快吃鸡！暖春开工季，晒单送好礼，点击直达会场','宏碁暗影骑士 N50-N93','宏碁（acer）',5499.00,NULL,'true',100,'2020-03-03 04:52:08','2020-04-03 03:17:31'),(281,'【办公不掉线，停课不停学】惠普战系列台式机，优惠享不停，助力高效办公学习，更有注册可享升级5年上门》','惠普HP ZHAN 99 Pro G1 MT','惠普（HP）',4099.00,NULL,'true',100,'2020-03-03 04:52:09','2020-04-03 03:17:31'),(282,'华硕(ASUS) 飞行堡垒7 九代英特尔酷睿i7 120Hz高速屏游戏笔记本电脑(i7-9750H 8G 512SSD GTX1650)金属电竞','华硕飞行堡垒7','华硕（ASUS）',6489.00,NULL,'true',100,'2020-03-03 04:52:11','2020-04-03 03:17:31'),(283,'【联想扬天企业采购节】，评价晒单有机会获得3000元E卡，支持远程办公，100万小时无故障运行，四年上门服务，办公优选~详情戳我','联想扬天M5900d','联想（Lenovo）',2299.00,NULL,'true',100,'2020-03-03 04:52:13','2020-04-03 03:17:31'),(284,'【戴尔灵越游戏台机升级256SSD+1T双硬盘】九代i7处理器，全新GTX1650显卡，强大扩展能力，让你开启疾速模式。','戴尔Ins 3670-R59N9S','戴尔（DELL）',6699.00,NULL,'true',100,'2020-03-03 04:52:14','2020-04-03 03:17:31'),(285,'武极i3 8100升9100F四核/2G独显/华硕主板办公娱乐家用台式电脑主机兼容机/DIY组装机 配置一（i3 9100F+4G+120G）','武极i3 8100升9100F四核/2G独显/华硕主板办公娱乐家用台式电脑主机兼容机/DIY组装机 配置一（i3 9100F+4G+120G）','武极',1666.00,NULL,'true',100,'2020-03-03 04:52:16','2020-04-03 03:17:31'),(286,'【购机送好礼，送完即止】2K高清全面屏，轻薄金属机身，可远程协同办公，便携无忧、畅爽娱乐！更多精彩','华为MateBook 13','华为（HUAWEI）',3699.00,NULL,'true',100,'2020-03-03 04:52:17','2020-04-03 03:17:31'),(287,'【升级为100%sRGB高色域】全新十代酷睿I5处理器、康宁玻璃全贴合窄边框、高端商务轻薄本、全尺寸背光键盘化妆品套装优惠','小米pro','小米（MI）',5899.00,NULL,'true',100,'2020-03-03 04:52:18','2020-04-03 03:17:31'),(288,'【精锐9代\"芯\"品】九代i5+512G大固态性能更强，运行速度更快，内置WiFi，助力高效办公！更多活动','清华同方精锐M820','清华同方（THTF）',2999.00,NULL,'true',100,'2020-03-03 04:52:20','2020-04-03 03:17:31'),(289,'【网课学习好帮手、智能办公更高效】微边框高色域广视角，几何支架，超薄机身更时尚','联想AIO 520C','联想（Lenovo）',2399.00,NULL,'true',100,'2020-03-03 04:52:21','2020-04-03 03:17:31'),(290,'【联想扬天企业采购节】，评价晒单有机会获得3000元E卡，支持远程办公，100万小时无故障运行，四年上门服务，办公优选~更多优惠戳我','联想扬天M4000s 商用办公台式电脑整机（I5-9400 8G 1T 键鼠 串口 2019office 四年上门）','联想（Lenovo）',3666.00,NULL,'true',100,'2020-03-03 04:52:23','2020-04-03 03:17:31'),(291,'戴尔（DELL）OptiPlex7070MFF 商用办公迷你微型台式电脑 定制主机 客厅HTPC9代 单主机（含键鼠） i7-9700/8G/256G','戴尔（DELL）OptiPlex7070MFF 商用办公迷你微型台式电脑 定制主机 客厅HTPC9代 单主机（含键鼠） i7-9700/8G/256G','戴尔（DELL）',4749.00,NULL,'true',100,'2020-03-03 04:52:24','2020-04-03 03:17:31'),(292,'双硬盘,外星人智控中心,G模式一键散热,九代标压,GTX显卡,窄边框,双风扇散热','戴尔G3','戴尔（DELL）',5999.00,NULL,'true',100,'2020-03-03 04:52:25','2020-04-03 03:17:31'),(293,'【新品上市,I7,16G内存】4年整机上门+3年硬盘保留服务,九代酷睿i7处理器,GT730,2G显卡,超强扩展能力,免工具拆装。','戴尔Vostro 5090-R19N6R','戴尔（DELL）',6899.00,NULL,'true',100,'2020-03-03 04:52:27','2020-04-03 03:17:31'),(294,'【3.5日低至4999，享6期免息】特尔十代酷睿CPU，强劲性能，全面屏，钻切蓝边时尚设计，13小时长续航，多屏协同！查看','华为荣耀MagicBook','华为（HUAWEI）',0.00,NULL,'true',100,'2020-03-03 04:52:28','2020-04-03 03:15:06'),(295,'【轻薄时尚】【FHD窄边框】全贴合无边式玻璃覆盖、128GSSD支持M.2接口、轻至1.07kg、薄至12.9mm化妆品套装优惠','小米Air12','小米（MI）',3599.00,NULL,'true',100,'2020-03-03 04:52:30','2020-04-03 03:15:03'),(296,'华硕(ASUS) VivoBook14s 14.0英寸轻薄笔记本电脑(i5-10210U 8G 512G+32G傲腾增强版SSD MX250 2G独显)银色','华硕Vivobook 系列','华硕（ASUS）',4689.00,NULL,'true',100,'2020-03-03 04:52:31','2020-04-03 03:14:50'),(297,'csp新品上市','新品上市','csp',99999999.00,'','true',100,'2020-04-03 02:51:06','2020-04-03 02:51:06');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail_img`
--

DROP TABLE IF EXISTS `product_detail_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_detail_img` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `pid` int(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail_img`
--

LOCK TABLES `product_detail_img` WRITE;
/*!40000 ALTER TABLE `product_detail_img` DISABLE KEYS */;
INSERT INTO `product_detail_img` VALUES (1,2,'http://img.yemuc.xyz/9x.jpg'),(2,2,'http://img.yemuc.xyz/d2af7f4f447843b19d84f613116aaf09.jpg'),(3,2,'http://img.yemuc.xyz/fc5f6882fc19411cb26fafe1521b7295.jpg');
/*!40000 ALTER TABLE `product_detail_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info_img`
--

DROP TABLE IF EXISTS `product_info_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info_img` (
  `id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info_img`
--

LOCK TABLES `product_info_img` WRITE;
/*!40000 ALTER TABLE `product_info_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_info_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_main_img`
--

DROP TABLE IF EXISTS `product_main_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_main_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(11) DEFAULT NULL COMMENT '商品id',
  `path` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_main_img`
--

LOCK TABLES `product_main_img` WRITE;
/*!40000 ALTER TABLE `product_main_img` DISABLE KEYS */;
INSERT INTO `product_main_img` VALUES (1,2,'http://img.yemuc.xyz/xiaomi8.jpg'),(2,1,'http://img.yemuc.xyz/test.png'),(3,3,'http://img.yemuc.xyz/9x.jpg'),(6,8,'http://img.yemuc.xyz/375541b69ac84e92a39c3c76632dae87.jpg'),(7,6,'http://img.yemuc.xyz/507e78ec209e417d9cf312bcefef17e9.jpg'),(8,7,'http://img.yemuc.xyz/bddedaf73e5f42eaae1203bcc55c37b8.png');
/*!40000 ALTER TABLE `product_main_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tag`
--

DROP TABLE IF EXISTS `product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL COMMENT '标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tag`
--

LOCK TABLES `product_tag` WRITE;
/*!40000 ALTER TABLE `product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend_history`
--

DROP TABLE IF EXISTS `recommend_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommend_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend_history`
--

LOCK TABLES `recommend_history` WRITE;
/*!40000 ALTER TABLE `recommend_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommend_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL COMMENT '商品id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `grade` int(2) NOT NULL COMMENT '评分',
  `content` varchar(512) DEFAULT NULL COMMENT '评价内容',
  `order_number` varchar(255) NOT NULL COMMENT '订单号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,185,2,5,'不错','15852220592432185','2020-03-31 03:45:36','2020-03-31 03:45:36'),(2,185,2,2,'不错','15852221254972182','2020-03-31 04:00:08','2020-03-31 04:33:17'),(3,3,2,4,'还行','158522358543223','2020-03-31 09:38:28','2020-03-31 09:38:28'),(4,184,2,3,'一般般吧','15857891177872184','2020-04-02 06:32:27','2020-04-02 06:32:27'),(5,2,2,5,'很好','158588254076022','2020-04-03 02:56:27','2020-04-03 02:56:27'),(6,179,2,5,'很好','15858826565892179','2020-04-03 02:58:33','2020-04-03 02:58:33'),(7,189,2,5,'很好','15882334105322189','2020-04-30 07:58:26','2020-04-30 07:58:26'),(8,186,2,5,'aa','15862270257512186','2020-05-23 11:17:12','2020-05-23 11:17:12'),(9,196,2,5,'aa','15862269885622196','2020-05-23 11:17:21','2020-05-23 11:17:21'),(10,196,2,5,'hao','15862269193072196','2020-05-23 11:17:27','2020-05-23 11:17:27'),(11,193,2,5,'good','15862268383302193','2020-05-23 11:17:41','2020-05-23 11:17:41'),(12,186,2,5,'很好','15862268153182186','2020-05-23 11:17:47','2020-05-23 11:17:47');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sell`
--

DROP TABLE IF EXISTS `sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sell` (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sell`
--

LOCK TABLES `sell` WRITE;
/*!40000 ALTER TABLE `sell` DISABLE KEYS */;
/*!40000 ALTER TABLE `sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `phone` char(12) NOT NULL COMMENT '手机号',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  `role` varchar(255) NOT NULL DEFAULT 'customer',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '删除状态0为已删除 1为可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','17865569207','admin','admin',1,'2020-02-08 06:37:44','2020-02-08 06:37:44'),(2,'测试','15106817747','2222','customer',1,'2020-01-06 10:32:01','2020-02-03 10:02:18'),(3,'常绍鹏','17865566666','123456','customer',1,'2020-02-07 07:29:58','2020-02-14 04:55:16'),(4,'常鹏','17865569208','123456','customer',1,'2020-02-07 08:14:24','2020-02-07 08:14:24'),(5,'nih和','15106817777','123456','customer',1,'2020-02-07 10:23:42','2020-02-07 10:23:42'),(6,'aad','15106817748','123456','customer',1,'2020-02-07 10:25:42','2020-02-07 10:25:42'),(7,'6666','15166666666','666666','customer',1,'2020-02-07 10:27:25','2020-02-07 10:27:25'),(8,'8866','18866666666','111111','customer',1,'2020-02-08 08:31:26','2020-02-08 08:31:26'),(9,'8888','18888888888','888888','customer',1,'2020-02-16 06:46:55','2020-02-16 06:46:55'),(10,'whiney','16666666666','123456','customer',1,'2020-05-12 09:17:49','2020-05-12 09:17:49'),(11,'whiney','15066678899','123456','customer',1,'2020-05-12 09:18:28','2020-05-12 09:18:28'),(12,'12ww','13333669999','123456789','customer',1,'2020-05-14 06:50:06','2020-05-14 06:50:06'),(13,'222','17865569222','222222','customer',1,'2020-05-22 10:47:13','2020-05-22 10:47:13'),(14,'1111','17865569211','111111','customer',1,'2020-05-22 10:56:24','2020-05-22 10:56:24'),(15,'123456','15962540975','123456','customer',1,'2020-07-01 04:53:19','2020-07-01 04:53:19'),(16,'123','15380890060','123123','customer',1,'2020-07-01 04:54:00','2020-07-01 04:54:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_click_history`
--

DROP TABLE IF EXISTS `user_click_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_click_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `pid` int(11) DEFAULT NULL COMMENT '用户点击商品id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_click_history`
--

LOCK TABLES `user_click_history` WRITE;
/*!40000 ALTER TABLE `user_click_history` DISABLE KEYS */;
INSERT INTO `user_click_history` VALUES (1,9,2,'2020-02-19 04:08:16'),(4,9,2,'2020-02-19 04:14:11'),(5,2,2,'2020-02-19 04:18:21'),(6,2,3,'2020-02-19 09:10:23'),(7,2,63,'2020-02-19 09:10:26'),(8,2,2,'2020-02-19 09:29:28'),(9,9,3,'2020-02-19 10:08:58'),(10,9,2,'2020-02-19 10:11:39'),(11,2,2,'2020-02-26 05:23:54'),(12,2,2,'2020-02-26 09:03:41'),(13,2,2,'2020-02-26 09:04:16'),(14,2,2,'2020-02-26 09:08:22'),(15,2,2,'2020-02-26 09:08:37'),(16,2,63,'2020-02-26 09:08:39'),(17,2,63,'2020-02-26 09:15:30'),(18,2,3,'2020-02-26 09:26:06'),(19,2,63,'2020-02-26 10:25:25'),(20,2,2,'2020-02-26 10:36:22'),(21,2,63,'2020-02-26 10:36:26'),(22,2,2,'2020-02-26 10:37:33'),(23,2,2,'2020-02-26 10:42:08'),(24,2,63,'2020-02-26 10:45:36'),(25,2,63,'2020-02-26 10:45:39'),(26,2,63,'2020-02-26 10:45:40'),(27,2,2,'2020-02-26 10:48:32'),(28,2,2,'2020-02-26 10:48:37'),(29,2,63,'2020-02-26 12:30:32'),(30,2,63,'2020-02-27 02:51:48'),(31,2,63,'2020-02-27 03:01:58'),(32,2,2,'2020-02-27 04:30:18'),(33,2,187,'2020-03-03 04:32:43'),(34,2,203,'2020-03-03 04:54:36'),(35,2,179,'2020-03-04 09:45:55'),(36,2,3,'2020-03-04 09:45:58'),(37,2,216,'2020-03-04 09:46:03'),(38,2,3,'2020-03-04 09:47:35'),(39,2,3,'2020-03-04 09:47:38'),(40,2,68,'2020-03-04 09:47:41'),(41,2,180,'2020-03-04 09:47:43'),(42,2,185,'2020-03-04 09:47:46'),(43,2,204,'2020-03-10 03:28:53'),(44,2,3,'2020-03-10 03:28:56'),(45,2,63,'2020-03-10 03:28:59'),(46,2,3,'2020-03-10 03:29:04'),(47,2,2,'2020-03-10 03:29:06'),(48,2,3,'2020-03-10 03:30:10'),(49,2,3,'2020-03-10 03:30:14'),(50,2,63,'2020-03-10 03:30:16'),(51,2,179,'2020-03-10 03:30:18'),(52,2,3,'2020-03-10 03:53:38'),(53,2,250,'2020-03-10 08:46:36'),(54,2,68,'2020-03-10 08:47:12'),(55,2,3,'2020-03-10 08:48:05'),(56,2,179,'2020-03-11 02:58:44'),(57,2,3,'2020-03-11 02:59:04'),(58,2,3,'2020-03-11 03:00:43'),(59,2,2,'2020-03-11 03:01:11');
/*!40000 ALTER TABLE `user_click_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_log` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '行为类型，点击，加入购物车，购买，评价',
  `level` int(4) NOT NULL DEFAULT '1' COMMENT '行为权重，点击1，加购2，购买3，评价按评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=393 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
INSERT INTO `user_log` VALUES (1,2,2,'click',1),(2,2,3,'buy',3),(3,2,2,'click',1),(4,2,3,'click',1),(5,2,3,'click',1),(6,2,184,'click',1),(7,2,184,'click',1),(8,2,2,'click',1),(9,2,2,'click',1),(10,2,2,'click',1),(11,2,2,'click',1),(12,2,2,'click',1),(13,2,2,'click',1),(14,2,2,'click',1),(15,2,2,'click',1),(16,2,183,'click',1),(17,2,183,'addCart',2),(18,2,183,'click',1),(19,2,186,'click',1),(20,2,196,'click',1),(21,2,193,'click',1),(22,2,179,'click',1),(23,2,2,'click',1),(24,2,196,'click',1),(25,2,186,'click',1),(26,2,184,'click',1),(27,2,3,'click',1),(28,2,2,'click',1),(29,2,185,'click',1),(30,2,2,'click',1),(31,2,183,'click',1),(32,2,186,'click',1),(33,2,196,'click',1),(34,2,193,'click',1),(35,2,179,'click',1),(36,2,2,'click',1),(37,2,184,'click',1),(38,2,3,'click',1),(39,2,185,'click',1),(40,2,2,'click',1),(41,2,196,'click',1),(42,2,186,'click',1),(43,2,2,'click',1),(44,2,183,'click',1),(45,2,186,'click',1),(46,2,186,'click',1),(47,2,2,'click',1),(48,1,183,'click',1),(49,2,222,'click',1),(50,2,222,'click',1),(51,2,3,'click',1),(52,2,3,'addCart',2),(53,2,212,'click',1),(54,2,222,'click',1),(55,2,222,'click',1),(56,2,3,'click',1),(57,2,280,'click',1),(58,2,212,'search',2),(59,2,222,'search',2),(60,2,287,'search',2),(61,2,295,'search',2),(62,2,2,'search',2),(63,2,3,'search',2),(64,2,182,'search',2),(65,2,185,'search',2),(66,2,221,'search',2),(67,2,235,'search',2),(68,2,246,'search',2),(69,2,247,'search',2),(70,2,259,'search',2),(71,2,286,'search',2),(72,2,294,'search',2),(73,2,212,'search',2),(74,2,222,'search',2),(75,2,287,'search',2),(76,2,295,'search',2),(77,2,2,'search',2),(78,2,3,'search',2),(79,2,182,'search',2),(80,2,185,'search',2),(81,2,221,'search',2),(82,2,235,'search',2),(83,2,246,'search',2),(84,2,247,'search',2),(85,2,259,'search',2),(86,2,286,'search',2),(87,2,294,'search',2),(88,2,212,'search',2),(89,2,222,'search',2),(90,2,287,'search',2),(91,2,295,'search',2),(92,2,2,'search',2),(93,2,3,'search',2),(94,2,182,'search',2),(95,2,185,'search',2),(96,2,221,'search',2),(97,2,235,'search',2),(98,2,246,'search',2),(99,2,247,'search',2),(100,2,259,'search',2),(101,2,286,'search',2),(102,2,294,'search',2),(103,2,212,'search',2),(104,2,222,'search',2),(105,2,287,'search',2),(106,2,295,'search',2),(107,2,241,'click',1),(108,2,241,'click',1),(109,2,2,'click',1),(110,2,196,'click',1),(111,2,68,'search',2),(112,2,282,'search',2),(113,2,68,'click',1),(114,2,212,'search',2),(115,2,222,'search',2),(116,2,287,'search',2),(117,2,295,'search',2),(118,2,295,'click',1),(119,2,193,'click',1),(120,2,3,'search',2),(121,2,3,'click',1),(122,2,3,'search',2),(123,1,3,'click',1),(124,1,230,'click',1),(125,1,230,'addCart',2),(126,1,250,'click',1),(127,1,250,'addCart',2),(128,1,182,'click',1),(129,1,2,'click',1),(130,1,2,'addCart',2),(131,1,179,'click',1),(132,1,179,'addCart',2),(133,1,3,'search',2),(134,1,3,'click',1),(135,1,230,'click',1),(136,1,260,'click',1),(137,1,3,'click',1),(138,1,2,'click',1),(139,1,2,'addCart',2),(140,1,2,'search',2),(141,1,2,'click',1),(142,1,2,'search',2),(143,1,2,'search',2),(144,1,2,'click',1),(145,1,216,'click',1),(146,2,189,'click',1),(147,2,189,'addCart',2),(148,2,3,'search',2),(149,2,3,'click',1),(150,2,212,'search',2),(151,2,222,'search',2),(152,2,287,'search',2),(153,2,295,'search',2),(154,2,212,'click',1),(155,2,212,'addCart',2),(156,1,185,'click',1),(157,1,185,'addCart',2),(158,2,193,'click',1),(159,2,3,'click',1),(160,2,3,'click',1),(161,2,295,'click',1),(162,2,228,'click',1),(163,2,3,'click',1),(164,2,235,'click',1),(165,2,2,'search',2),(166,2,3,'search',2),(167,2,182,'search',2),(168,2,185,'search',2),(169,2,221,'search',2),(170,2,235,'search',2),(171,2,246,'search',2),(172,2,247,'search',2),(173,2,259,'search',2),(174,2,286,'search',2),(175,1,184,'search',2),(176,1,191,'search',2),(177,1,208,'search',2),(178,1,214,'search',2),(179,1,223,'search',2),(180,1,227,'search',2),(181,1,228,'search',2),(182,1,230,'search',2),(183,1,252,'search',2),(184,1,258,'search',2),(185,1,184,'click',1),(186,1,252,'click',1),(187,1,184,'search',2),(188,1,191,'search',2),(189,1,208,'search',2),(190,1,214,'search',2),(191,1,223,'search',2),(192,1,227,'search',2),(193,1,228,'search',2),(194,1,230,'search',2),(195,1,252,'search',2),(196,1,258,'search',2),(197,1,191,'click',1),(198,11,182,'click',1),(199,11,3,'search',2),(200,11,3,'click',1),(201,12,3,'click',1),(202,12,3,'addCart',2),(203,12,3,'click',1),(204,12,2,'click',1),(205,12,2,'addCart',2),(206,12,2,'click',1),(207,1,3,'click',1),(208,1,230,'click',1),(209,1,213,'click',1),(210,1,182,'search',2),(211,1,185,'search',2),(212,1,221,'search',2),(213,1,246,'search',2),(214,1,247,'search',2),(215,1,259,'search',2),(216,1,294,'search',2),(217,1,3,'click',1),(218,1,2,'click',1),(219,12,2,'click',1),(220,12,2,'addCart',2),(221,12,2,'click',1),(222,12,2,'addCart',2),(223,12,212,'search',2),(224,12,222,'search',2),(225,12,287,'search',2),(226,12,295,'search',2),(227,12,222,'click',1),(228,12,2,'search',2),(229,12,2,'click',1),(230,2,3,'click',1),(231,2,2,'click',1),(232,2,3,'click',1),(233,2,2,'click',1),(234,2,182,'click',1),(235,2,2,'click',1),(236,2,2,'addCart',2),(237,13,212,'search',2),(238,13,222,'search',2),(239,13,287,'search',2),(240,13,295,'search',2),(241,13,212,'click',1),(242,13,212,'search',2),(243,13,222,'search',2),(244,13,287,'search',2),(245,13,295,'search',2),(246,13,222,'click',1),(247,13,212,'search',2),(248,13,222,'search',2),(249,13,287,'search',2),(250,13,295,'search',2),(251,13,287,'click',1),(252,13,212,'search',2),(253,13,222,'search',2),(254,13,287,'search',2),(255,13,295,'search',2),(256,13,295,'click',1),(257,13,212,'search',2),(258,13,222,'search',2),(259,13,287,'search',2),(260,13,295,'search',2),(261,13,212,'search',2),(262,13,222,'search',2),(263,13,287,'search',2),(264,13,295,'search',2),(265,13,222,'click',1),(266,13,222,'addCart',2),(267,14,259,'click',1),(268,14,182,'click',1),(269,14,196,'click',1),(270,14,259,'click',1),(271,14,2,'click',1),(272,14,2,'search',2),(273,14,3,'search',2),(274,14,182,'search',2),(275,14,185,'search',2),(276,14,221,'search',2),(277,14,235,'search',2),(278,14,246,'search',2),(279,14,247,'search',2),(280,14,259,'search',2),(281,14,286,'search',2),(282,14,2,'click',1),(283,14,2,'search',2),(284,14,3,'search',2),(285,14,182,'search',2),(286,14,185,'search',2),(287,14,221,'search',2),(288,14,235,'search',2),(289,14,246,'search',2),(290,14,247,'search',2),(291,14,259,'search',2),(292,14,286,'search',2),(293,14,235,'click',1),(294,14,2,'search',2),(295,14,3,'search',2),(296,14,182,'search',2),(297,14,185,'search',2),(298,14,221,'search',2),(299,14,235,'search',2),(300,14,246,'search',2),(301,14,247,'search',2),(302,14,259,'search',2),(303,14,286,'search',2),(304,14,294,'click',1),(305,14,2,'search',2),(306,14,3,'search',2),(307,14,182,'search',2),(308,14,185,'search',2),(309,14,221,'search',2),(310,14,235,'search',2),(311,14,246,'search',2),(312,14,247,'search',2),(313,14,259,'search',2),(314,14,286,'search',2),(315,14,286,'click',1),(316,14,2,'search',2),(317,14,3,'search',2),(318,14,182,'search',2),(319,14,185,'search',2),(320,14,221,'search',2),(321,14,235,'search',2),(322,14,246,'search',2),(323,14,247,'search',2),(324,14,259,'search',2),(325,14,286,'search',2),(326,14,246,'click',1),(327,14,2,'search',2),(328,14,3,'search',2),(329,14,182,'search',2),(330,14,185,'search',2),(331,14,221,'search',2),(332,14,235,'search',2),(333,14,246,'search',2),(334,14,247,'search',2),(335,14,259,'search',2),(336,14,286,'search',2),(337,2,3,'click',1),(338,2,3,'click',1),(339,2,2,'click',1),(340,2,2,'click',1),(341,2,3,'click',1),(342,2,182,'click',1),(343,2,183,'click',1),(344,2,186,'click',1),(345,2,212,'click',1),(346,2,3,'click',1),(347,2,2,'click',1),(348,2,182,'click',1),(349,2,183,'click',1),(350,2,186,'click',1),(351,2,185,'click',1),(352,2,196,'click',1),(353,2,185,'click',1),(354,2,184,'click',1),(355,2,179,'click',1),(356,2,185,'click',1),(357,2,186,'click',1),(358,2,189,'click',1),(359,1,227,'click',1),(360,2,212,'click',1),(361,2,259,'click',1),(362,2,212,'search',2),(363,2,222,'search',2),(364,2,287,'search',2),(365,2,295,'search',2),(366,2,212,'click',1),(367,2,212,'click',1),(368,2,3,'search',2),(369,2,3,'click',1),(370,2,3,'addCart',2),(371,2,212,'search',2),(372,2,222,'search',2),(373,2,287,'search',2),(374,2,295,'search',2),(375,2,222,'click',1),(376,2,212,'search',2),(377,2,222,'search',2),(378,2,287,'search',2),(379,2,295,'search',2),(380,2,287,'click',1),(381,2,212,'search',2),(382,2,222,'search',2),(383,2,287,'search',2),(384,2,295,'search',2),(385,2,295,'click',1),(386,2,3,'click',1),(387,2,3,'addCart',2),(388,16,3,'click',1),(389,16,3,'addCart',2),(390,16,3,'addCart',2),(391,16,3,'addCart',2),(392,16,3,'click',1);
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_search_history`
--

DROP TABLE IF EXISTS `user_search_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_search_history` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_search_history`
--

LOCK TABLES `user_search_history` WRITE;
/*!40000 ALTER TABLE `user_search_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_search_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tag`
--

DROP TABLE IF EXISTS `user_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tag` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tag`
--

LOCK TABLES `user_tag` WRITE;
/*!40000 ALTER TABLE `user_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_unlike`
--

DROP TABLE IF EXISTS `user_unlike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_unlike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_unlike`
--

LOCK TABLES `user_unlike` WRITE;
/*!40000 ALTER TABLE `user_unlike` DISABLE KEYS */;
INSERT INTO `user_unlike` VALUES (42,1,258,'2020-04-30 03:48:16'),(44,1,259,'2020-05-12 03:58:31'),(45,1,294,'2020-05-12 03:58:38'),(46,13,235,'2020-05-22 10:51:37'),(47,13,3,'2020-05-22 10:51:39'),(48,13,294,'2020-05-22 10:52:00'),(49,13,2,'2020-05-22 10:52:53'),(50,14,287,'2020-05-22 10:57:00'),(51,16,255,'2020-07-01 05:00:17'),(52,16,257,'2020-07-01 05:00:18'),(53,16,250,'2020-07-01 05:00:18'),(54,16,209,'2020-07-01 05:00:18'),(55,16,243,'2020-07-01 05:00:19'),(56,16,266,'2020-07-01 05:00:19'),(57,16,179,'2020-07-01 05:00:19'),(58,16,182,'2020-07-01 05:00:19'),(59,16,200,'2020-07-01 05:00:19'),(60,16,220,'2020-07-01 05:00:19'),(61,16,252,'2020-07-01 05:00:20'),(62,16,246,'2020-07-01 05:00:20'),(63,16,272,'2020-07-01 05:00:20'),(64,16,297,'2020-07-01 05:00:28');
/*!40000 ALTER TABLE `user_unlike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-16 14:04:20
