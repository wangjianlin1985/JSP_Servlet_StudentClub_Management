/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : jsp_association

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-01-08 15:35:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `act_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `org_id` int(11) NOT NULL,
  `act_date` datetime NOT NULL,
  `act_content` varchar(1024) NOT NULL,
  `act_title` varchar(100) NOT NULL,
  PRIMARY KEY (`act_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '1', '2019-04-24 22:01:55', '参与此次活动的有心理协会会员和各学院心理委员代表，校心理咨询中心瞿丽娜、何鑫华老师受邀参与组织此次活动。本期沙龙以“心灵启航”为主题，围绕“当代大学生关注的心理问题”展开讨论，旨在激发大学生对心理健康问题的关注，积极参与到心理健康活动中来。\r\n     活动由心协会长主持。第一个环节由瞿丽娜、何鑫华老师分别介绍了厦门理工学院大学生心理健康工作的概况、心理咨询的基本知识，让同学们了解到我校心理健康工作的现状，解决了大家对采用心理咨询方法解决心理困扰的疑虑。\r\n     在随后的第二环节，同学们与老师们互动，做了简单却十分有益的手指操及有趣的团体游戏“泡泡糖”。在活动过程中老师给予同学积极的提示，让参与者能够从小事中意识到自己的行为模式，进而引导同学认识自己。在随后的小组讨论中，虽然大家素不相识，但都能很快的融入角色，积极参与到小组讨论当中，每个成员都大胆的说出自己遇到的棘手的问题，小组长也客观地归纳组员提出的心理问题。通过讨论，我们发现问题主要集中在“对外人际关系，对内自我压力”两大方面。', '心理沙龙第一期——心灵启航');
INSERT INTO `activity` VALUES ('2', '1', '2019-04-18 19:51:12', '举办单位：厦门理工学院 - 四叶草心理协会活动时间：2014-03-05 14:30 至 2014-03-05 16:30活动地点：高时别墅一楼每一天，我们忙于各种学习、活动，事务、聚会，或与网络“聊天”，却不知道自己到底与谁同在。走进心理沙龙，与老师和同学一起探讨“我和谁在一起” ', '第一期心理沙龙——你和谁在一起？');
INSERT INTO `activity` VALUES ('13', '1', '2019-04-24 22:01:44', '举办单位：厦门理工学院 - 四叶草心理协会\r\n活动时间：2013-12-17 16:00 至 2013-12-17 18:00\r\n活动地点：厦门理工学院高时别墅一楼', '“愤怒情绪应对”的 第二期心理沙龙——厦理心理协会');
INSERT INTO `activity` VALUES ('16', '1', '2019-04-24 22:02:32', '活动流程：\r\n1、介绍活动的目的，并指出活动的规则：对活动重要注意的问题进行了一下解释。\r\n2、对报名成员进行分组，开始第一个心理游戏“可怜的小猫”， 主要  是活跃团队气氛。\r\n3、第一个游戏结束后，穿插一个简单的心理测验“颜色测性格”\r\n4、进行“杀人”心理策略游戏。\r\n5、接下去进行“同心协力”和“扯龙尾”，此环节主要是为了让成员了解团队合作的重要性。\r\n6、紧接着，大家围坐一圈，畅谈大学生活，以及心中的各种困惑。（着重  强调保密原则）\r\n7、最后，要求全体成员就整个活动进行以下简单的交流：今天给你印象最深的游戏是哪个？游戏中你获得了些什么？', '心理游戏大观园');
INSERT INTO `activity` VALUES ('18', '2', '2019-04-24 22:04:17', '义卖进行时，这里有你想要要的各类文学类外语类等书籍，各式生活用品，精品防晒伞，台灯等大学生活必备用品，不仅献爱心而且为自己的生活添了新伙伴，快行动起来吧！ ', '筹捐义卖——有梦想才最美丽');
INSERT INTO `activity` VALUES ('20', '2', '2019-04-24 22:04:48', '月10日西部梦想“爱心一帮一”麻山初中3、4月份的资助金已经发至孩子手中“，感谢大公无私默默资助我的好心人，你们就像我的亲人一样，让我感受到了爱与温暖，好想跟您亲口说一声谢谢！“这是孩子在感谢信中质朴的语言。“一帮一”看似平凡，却让孩子在被爱的幸福中学会了去爱他人。', '西部梦想“爱心一帮一”温暖麻山');
INSERT INTO `activity` VALUES ('22', '1', '2019-04-19 19:52:37', '举办单位：厦门理工学院 - 四叶草心理协会活动时间：2013-11-20 14:30 至 2013-11-20 16:3活动地点：高时别墅一楼（图书馆后）0', '心理沙龙第一期暨心灵启航！');

-- ----------------------------
-- Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_intro` varchar(1024) DEFAULT NULL,
  `org_name` varchar(32) NOT NULL,
  `org_found_date` datetime NOT NULL,
  `org_status` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community
-- ----------------------------
INSERT INTO `community` VALUES ('1', '它是一个协助个人成长、促进潜能发挥的健康乐园。我们的宗旨是广泛宣传心理健康知识，提高心理素质水平，引导学生在工作、学习、生活中，坦然面对挫折与失败，协调良好的人际关系，营造轻松温馨的氛围。我们通过开展一系列“心理健康”活动，创造同学们相互沟通交流的机会，为在我校逐步形成“人人关注心理，助人自助”的良好心理氛围而努力。同时，我们协会将走出校门，融入社会，关心弱势群体，在校外开展公益活动，一日爱心活动。', '四叶草心理协会', '2017-02-16 00:00:00', '1', '1');
INSERT INTO `community` VALUES ('2', '西部梦想社团是由一批对西部怀着深厚感情的学生创办的，社团在这三年中迅速成长。协会成员以自己是“西梦人”而骄傲，以行动践行着服务西部的承诺。', '西部梦想', '2015-07-17 11:10:23', '1', '2');
INSERT INTO `community` VALUES ('3', '绿爱环保协会是于2006年9月诞生的学生环保协会,崇尚着绿色,爱,和谐的宗旨。倡导人与自然和谐，亲近自然，热爱自然，保护自然； 关注校园环保，社会环保。有属于自己的会旗,会歌,会标。是热爱自然，爱好环保的人温馨的家，绿色爱好者之家。', '绿爱环保协会', '2017-06-08 11:10:39', '1', '3');
INSERT INTO `community` VALUES ('4', '陶韵社以教授陶笛演奏技巧为主要活动。配合相关演出以及沙龙活动，旨在为大家打造一个轻松自由的音乐学习与交流的环境，让小巧玲珑的陶笛粉饰你的大学生活。', '陶韵社 ', '2019-04-17 00:00:00', '1', '4');
INSERT INTO `community` VALUES ('5', '作为一个全院性科技运用社团，以培养同学们更能适应科技飞速发展的时代。社团一切活动，以“激发思维、开阔眼界”为中心，让同学们走向社会，提供一个良好的提前锻炼与体验的机会。', '科技创业者协会', '2017-06-29 09:30:12', '1', '5');
INSERT INTO `community` VALUES ('6', '是在院团委直接关怀和支持下建立的学生艺术团体。内设会会长，协会聘请我校艺术系闫超老师和林志明书法家担任指导顾问，全心全意服务广大会员。文房四宝，传承不息，扬我中华，一纸黑白，别样世界！', '书画协会', '2019-04-05 21:55:21', '1', '6');
INSERT INTO `community` VALUES ('8', 'tttttttttttttttttttt', '学习部', '2020-01-08 06:00:44', '1', '1');

-- ----------------------------
-- Table structure for `comm_notice`
-- ----------------------------
DROP TABLE IF EXISTS `comm_notice`;
CREATE TABLE `comm_notice` (
  `org_id` int(11) NOT NULL,
  `noti_content` varchar(1024) NOT NULL,
  `noti_date` datetime NOT NULL,
  `noti_id` int(11) NOT NULL AUTO_INCREMENT,
  `noti_title` varchar(32) NOT NULL,
  `stat` enum('0','1','2') NOT NULL DEFAULT '0',
  PRIMARY KEY (`noti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_notice
-- ----------------------------
INSERT INTO `comm_notice` VALUES ('1', '心理协会开启换届开启，报名时间2019-4-12至2019-5-20，请有意愿的同学报名参加', '2019-04-22 18:34:39', '2', '心理协会管理层选拔', '0');
INSERT INTO `comm_notice` VALUES ('1', '心理协会将在心理健康周进行一系列的活动，希望有志愿参与服务的同学踊跃报名，此项活动主要分三个环节，第一环节为开幕式。由专业人员表演，活跃活动气氛。拉开序幕。第二介绍宣传各社团，使同学们更加了解社团。第三环节为各社团的特色节目表演，由社团内部人员表演。在活动中，我们会组织社团人员进行销售社团特色饰品。我们社团联合会还打算在此活动中拉取赞助以进一步丰富活动内容，更有利于社团后期工作。6月分，教育部将对我院进行评估，为此我们社团联合会特意策划了“校园社团文化活动周”我们策划了一场大型晚会。我们相信此活动会赢得学院师生的喜爱。截止时间2019-5-20', '2019-04-13 18:34:57', '3', '心理健康周志愿者招募', '1');
INSERT INTO `comm_notice` VALUES ('1', '\r\n关于推迟社团文化节立项活动申请截止时间的通知：各社团会长，现将文化节立项活动申请截止时间推迟至3月31日（下周五）七八节课，请各社团利用这一周的时间积极申报文化节期间立项活动。请大家注意：文化节期间举办的立项活动才可参与优秀社团活动的评选，以及影响社团各方面评奖评优，希望各社团予以重视！特别是新评定的品牌社团，希望大家可以做好品牌社团的模范带头作用，在文化节期间积极举办各类有意义的、优质社团活动！', '2019-04-25 19:32:41', '4', '关于推迟社团文化节立项活动申请截止时间的通知', '2');
INSERT INTO `comm_notice` VALUES ('1', '为贯彻落实《中共中央国务院关于进一步加强和改进大学生思想政治教育的意见》（中发〔2004〕16号）精神，现就加强和改进大学生社团工作提出如下通知：新疆艺术学院学生社团是由具有共同爱好的学生自愿发起，为提高自身素质，以社团的形式进行组织并且经常性地开展各项符合校园健康文化导向的群众性学生团体。随着社会发展、科技进步和教育改革的不断深入，我院学生社团在发展过程中出现了网络社团增多、跨校活动增多、与社会联系增多等新情况和新趋势。在新形势下，我院要从加强和改进大学生思想政治教育，全面推进素质教育，实施科教兴国、人才强国战略，培育中国特色社会主义事业合格建设者和可靠接班人的高度进一步加强和改进大学生社团工作。加强和改进大学生社团工作的总体要求是：以邓小平理论和“三个代表”重要思想为指导，全面贯彻党的教育方针；以推动大学生全面发展为目标，坚持以人为本，全面推进素质教育，充分发挥学生自我教育、自我管理、自我服务的积极性；坚持建设和管理并重，积极扶持、规范运作，促进健康发展；推动学生社团在活跃校园文化、加强和改进大学生思想政治教育、服务学校改革发展稳定等方面发挥更大的作用。加强和改进大学生社团工作的主要任务是：积极支持学生社团活动，大力促进学生社团发展；切实加强对学生社团管理，引导学生社团健康发展。', '2019-04-18 19:37:41', '5', '关于进一步加强和改进大学生社团工作的通知', '2');
INSERT INTO `comm_notice` VALUES ('2', '为了更好的发展甘肃甘露公益中心公益事业，经过理事会决议，现甘肃甘露公益中心北京工作站将落成于北京市丰台区昌宁大厦德聚鑫电子商务（北京）有限公司。并聘请胡嵩先生为甘肃甘露公益中心理事兼北京工作站站长；黄旭嵘女士，罗启汉先生，张江琴女士三位为甘露公益中心理事兼北京工作站副站长。北京具体工作由胡嵩站长开展，由常务理事长黄莉女士，副理事长刘权嘉先生监督。\r\n特此通知', '2019-04-18 19:40:47', '6', '关于北京工作联络站落成的通知', '2');
INSERT INTO `comm_notice` VALUES ('1', '爱心家园“阳光行动”开始啦！ \r\n为响应党的十七大关心农民工子女教育的号召，新疆艺术学院爱心家园本着“爱心”“助学”两个主题，举办此次以“奉献爱心 共建和谐 喜迎奥运 共享阳光”为主题的爱心助学系列大型活动“阳光行动”。本次活动将以大型晚会“同在蓝天下——走进农民工子女学校”作为序幕。 \r\n爱心家园将与“爱心小学”合作建立阳光助学站，利用课余时间给孩子们义务辅导功课，建立“一对一”帮扶，开展第二课堂，教授他们音乐、美术、舞蹈等方面的知识。为此特招募志愿者，希望有意投入爱心事业的同学们积极参与，加入我们，让我们携手共创一片蓝天！ \r\n                                                                          联系电话：彭钰——13999864679 \r\n                                                                                    刘菁菁——15909910268 \r\n  \r\n  \r\n                                                                                              共青团新疆艺术学院委员会 \r\n                                                                                              新疆艺术学院文化艺术管理系 \r\n                                                                                              新疆艺术学院社联爱心家园', '2019-04-21 00:00:00', '13', '同在蓝天下，共创一片天', '0');
INSERT INTO `comm_notice` VALUES ('2', '举办单位：厦门大学 - 西部梦想 活动时间：2019-04-16 08:00 至 2019-04-27 22:00 活动地点：海韵二期篮球场，本部三家村广场，海滨教学楼C栋楼前空地，西梦社外队员火热招募#你是否渴望到西部看看那里的星空，挥洒青春，奉献热情。4月16-17日，海韵二期篮球场，本部三家村广场，海滨教学楼C栋楼前空地，欢迎现场报名，网络报名xmuxbmx@163.com （艺术、体育、摄影技术特长者或者支教、外联、公关经验丰富者优先）不惧一路风雨，等你一起出发', '2019-04-22 17:30:51', '15', '西梦社外队员火热招募', '0');
INSERT INTO `comm_notice` VALUES ('1', '王熙凤', '2019-07-19 00:25:01', '24', '王熙凤', '0');
INSERT INTO `comm_notice` VALUES ('1', '王熙凤', '2019-07-19 00:25:36', '25', '王熙凤', '0');
INSERT INTO `comm_notice` VALUES ('1', '发布新通知', '2019-07-19 00:31:08', '26', '发布新通知', '0');

-- ----------------------------
-- Table structure for `comm_portrait`
-- ----------------------------
DROP TABLE IF EXISTS `comm_portrait`;
CREATE TABLE `comm_portrait` (
  `org_id` int(11) NOT NULL,
  `img_id` int(11) NOT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comm_portrait
-- ----------------------------
INSERT INTO `comm_portrait` VALUES ('1', '6');

-- ----------------------------
-- Table structure for `enter`
-- ----------------------------
DROP TABLE IF EXISTS `enter`;
CREATE TABLE `enter` (
  `org_id` int(11) NOT NULL,
  `rec_id` int(11) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `name` varchar(24) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT '男',
  `grade` varchar(2) DEFAULT NULL,
  `qq` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`org_id`,`rec_id`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enter
-- ----------------------------
INSERT INTO `enter` VALUES ('2', '6', 'a111', '1', '女', null, null, null, null);
INSERT INTO `enter` VALUES ('3', '7', 'user1', '王熙凤', '男', null, null, null, null);

-- ----------------------------
-- Table structure for `forum_post`
-- ----------------------------
DROP TABLE IF EXISTS `forum_post`;
CREATE TABLE `forum_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `layers` int(11) NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_post
-- ----------------------------

-- ----------------------------
-- Table structure for `homepage_img`
-- ----------------------------
DROP TABLE IF EXISTS `homepage_img`;
CREATE TABLE `homepage_img` (
  `apply_id` int(4) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(255) NOT NULL,
  `org_name` varchar(24) DEFAULT '',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `status` int(1) NOT NULL DEFAULT 0,
  `nextdel` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of homepage_img
-- ----------------------------
INSERT INTO `homepage_img` VALUES ('1', 'gaokao.png', '四叶草心理协会', '2019-04-24 15:27:41', '1', '1');
INSERT INTO `homepage_img` VALUES ('2', 'may.png', '四叶草心理协会', '2019-04-24 15:27:41', '1', '1');
INSERT INTO `homepage_img` VALUES ('3', 'summer.jpg', '四叶草心理协会', '2019-04-24 15:27:41', '1', '1');
INSERT INTO `homepage_img` VALUES ('4', '1^QQ截图20190717082306.png', '', '2019-07-19 09:32:23', '0', '0');

-- ----------------------------
-- Table structure for `homepage_news`
-- ----------------------------
DROP TABLE IF EXISTS `homepage_news`;
CREATE TABLE `homepage_news` (
  `apply_id` int(4) NOT NULL AUTO_INCREMENT,
  `news_id` int(4) NOT NULL,
  `org_name` varchar(24) DEFAULT '',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `status` int(1) NOT NULL DEFAULT 0,
  `nextdel` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of homepage_news
-- ----------------------------
INSERT INTO `homepage_news` VALUES ('11', '11', '1', '2019-07-19 00:24:46', '0', '0');
INSERT INTO `homepage_news` VALUES ('12', '12', '1', '2019-07-19 00:28:43', '1', '1');

-- ----------------------------
-- Table structure for `homepage_video`
-- ----------------------------
DROP TABLE IF EXISTS `homepage_video`;
CREATE TABLE `homepage_video` (
  `apply_id` int(4) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) NOT NULL,
  `org_name` varchar(24) DEFAULT '',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `status` int(1) NOT NULL DEFAULT 0,
  `nextdel` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of homepage_video
-- ----------------------------
INSERT INTO `homepage_video` VALUES ('7', '1^918600.mp4', '', '2019-07-19 08:33:31', '1', '1');
INSERT INTO `homepage_video` VALUES ('8', '1^918600.mp4', '', '2019-07-19 09:32:27', '0', '0');

-- ----------------------------
-- Table structure for `img`
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `img_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `img_name` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `org_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('10', '1^QQ截图20190717082306.png', '2019-07-19', null, '1');
INSERT INTO `img` VALUES ('11', '1^wechat.jpg', '2019-07-19', null, '1');

-- ----------------------------
-- Table structure for `layer`
-- ----------------------------
DROP TABLE IF EXISTS `layer`;
CREATE TABLE `layer` (
  `post_id` int(10) unsigned NOT NULL,
  `layer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `content` varchar(1024) NOT NULL,
  `date` date NOT NULL,
  `img_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`layer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of layer
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `privilege` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', 'admin', '0');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int(4) NOT NULL AUTO_INCREMENT,
  `org_id` int(4) NOT NULL,
  `news_title` varchar(64) DEFAULT NULL,
  `news_content` varchar(2048) DEFAULT NULL,
  `news_date` datetime NOT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '1', '“由你来调查”活动圆满成功', '2019年4月25日，由共青团合肥学院委员会，合肥学院学生社团联合会主办，经济社会调查协会承办的“由你来调查”活动在一区博学楼B座107教室顺利举行。本次活动旨在进一步丰富我校大学生的课余生活，培养我校大学生的调查研究能力，提高大学生理论运用于实际，理论与实际相结合的能力。\r\n\r\n此次比赛由经济系学生刘建昆，学生金慧晴，陈东旭以及陈可担任此次评委，比赛开始，主持人李帅进行发言，随后他介绍了这次比赛的规则及评分细则:1.对参赛组的七组进行编号，抽签确定各组进行PPT展示的顺序，PPT演讲要求为限时5分钟，表达要流畅；2.各组长安排组员对本组经过调查后的结果按抽签的顺序进行PPT展示；3.由本次比赛的评委对各组的PPT展示进行点评打分，评选出一、二、三等奖。.本次比赛的最终成绩由“调查材料*40%+ppt评分*60%”组成。本着公平公正的原则，采取当场打分，当场公布的方式；4.由邀请的评委们对获奖人员进行颁奖。最后他宣布比赛正式开始。\r\n\r\n7组选手在抽到顺序后，在场下的候选区内开始了赛前最后的准备，第一位选手上台进行演讲时，选手对大学生恋爱态度进行了充分地分析。第二组选手带来的是大学生手机使用情况的调查，第三组是对合肥学院大学生对图书馆使用情况调查等等。在每一位演讲选手演讲过后，金慧晴都对参加的同学进行了简单的点评。她总结到PPT的演讲并不是简单的照着字幕读，数据要有支撑，要有说服力，要有依据。因为有调查才能有发言权。比赛结束后，由评委打分评出了本次比赛的获奖小组。\r\n\r\n据悉，本次调查活动围绕在校学生的课余、文化、生活等方面展开，让同学们根据自己的兴趣爱好来选择课题，参加比赛。在调查活动中，去体验调查的乐趣，提高同学们对于调查的认识，以及普及调查的知识，为今后能开展专业的调查项目提供帮助！', '2019-04-27 14:50:57');
INSERT INTO `news` VALUES ('5', '3', '爱心助学，快协与你同行', '2019年4月2日中午十二点半快乐驿站协会七位理事赴合肥市南艳小学助学，本次活动从下午一点半正式开始，由社团成员向小学二年级学生宣传环保知识，活动持续约一个小时。七位快乐驿站协会理事主要是通过游戏和ppt演讲向小学生介绍环保知识，在互动中轻松的了解环保的重要性。通过颁发一些小礼品提高学生的积极性，用一些幽默风趣的话语活跃气氛，让孩子们在生活中学习，让学习融入他们的生活。本次活动反应效果十分明显，孩子们懂得了很多的环保知识，临走前纷纷与快乐驿站协会理事拍照告别，并期待我们的下次来临。希望更多的人参与公益性的助学活动，关爱孩子的成长，向孩子们宣传一些正能量。据悉，本次活动使孩子们了解一些环保知识，培养了他们的环保意识，让他们能够在平时的学习生活中培养出良好的行为习惯，为保护环境保卫家园贡献出自己的力量。', '2019-04-24 18:50:39');
INSERT INTO `news` VALUES ('6', '1', '康乃馨手工制作教学活动”圆满完成', '2019年5月11日及5月12日晚六点半，由合肥学院社团联合会主办，灵心居手工社承办的主题为“以花为心，献给最亲爱的她”的康乃馨手工制作教学活动在我校二期食堂门口进行，我校学子踊跃参加。本次活动分为两个部分，第一部分在教学活动前进行，即在活动宣传中，同学们可以通过网络写祝福语表达对母亲的爱，对于积极性较高的同学，社团将在母亲节当天，组织一百人给这些同学的母亲发祝福语。第二部分即教学活动，活动当日，有许多学生纷纷来此学习制作康乃馨，希望能在母亲节时能为母亲献上自己亲手制作的惊喜，在灵心居手工社相关工作人员的细心教学下，许多同学都很快学会制作并领走了自己制作的康乃馨，活动结束后，由活动负责人拍照摄影，将同学们对母亲的爱的表达记录下来。据悉，此次活动不仅能让同学们在制作过程中体会到DIY的乐趣，发挥自己的创造力，感受手工艺术的魅力，传承中华古老手艺，陶冶情操，同学们通过自己亲手做康乃馨送给母亲，还能培养青少年知恩图报的品行，弘扬中华民族学会感恩的传统美德，同时本次活动还具有创意性和环保性。', '2019-04-25 19:27:18');
INSERT INTO `news` VALUES ('7', '1', '翰墨轩书画协会举办风筝节大赛', '3月25日晚，由翰墨轩书画协会举办的艺术风筝节大赛在我校二期图书馆招聘大厅顺利举行。风筝节大赛由翰墨轩书画协会书法教学部部长许浩主持，各部门委员积极参与组织活动，在与汉宣社、手工社、艺术系学生会的合作中顺利完成任务，展厅内座无虚席，参赛者热情高涨。风筝节大赛主要分为两部分：首先进行的是在3月25日晚对风筝绘画艺术的评比，由翰墨轩提供所需工具和材料，二至四人为一组，比赛时间从18点持续到20:30，最后进行作品的评比。合院学子积极报名参与这次活动，30多组参赛选手在和小伙伴的交流与合作中尽自己的最大努力进行构思，动手尝试，画出了一幅幅漂亮的作品，有可爱的动漫人物，也有行云流水的书法秀，各类创意层出不穷，充分展现了同学们的团队精神和实际动手能力，更重要的是使中国的传统文化在校园里得到了良好的传扬。', '2019-04-12 19:29:51');
INSERT INTO `news` VALUES ('8', '2', '关爱流浪狗献爱心活动顺利进行', '7月6日到3月12日期间，由共青团合肥学院委员会、合肥学院学生社团联合会主办，合肥学院大学生地理协会承办的关爱流浪狗献爱心活动于我校顺利进行。此次活动面向我校全体在校大学生，以“关爱动物，公益启航”为主题，以知识宣传和衣物捐赠为主要内容。', '2019-04-25 19:31:33');
INSERT INTO `news` VALUES ('9', '1', '对外发布', '对外发布', '2019-07-18 21:35:37');
INSERT INTO `news` VALUES ('10', '1', '王熙凤测试', '王熙凤测试', '2019-07-18 21:35:57');
INSERT INTO `news` VALUES ('11', '1', '王熙凤', '王熙凤', '2019-07-19 00:24:45');
INSERT INTO `news` VALUES ('12', '1', '王熙凤', '王熙凤', '2019-07-19 00:24:55');

-- ----------------------------
-- Table structure for `org_user`
-- ----------------------------
DROP TABLE IF EXISTS `org_user`;
CREATE TABLE `org_user` (
  `org_id` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  `position` enum('社长','副社长','普通') NOT NULL,
  `priManaUser` int(11) NOT NULL,
  `priNoNews` int(11) NOT NULL,
  `priActi` int(11) NOT NULL,
  PRIMARY KEY (`org_id`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org_user
-- ----------------------------
INSERT INTO `org_user` VALUES ('1', '1', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('1', '2', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('1', '3', '副社长', '1', '1', '0');
INSERT INTO `org_user` VALUES ('1', '4', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('1', '5', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('1', '6', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('1', '7', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('1', '8', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('2', '1', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('2', '2', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('2', '6', '普通', '0', '0', '0');
INSERT INTO `org_user` VALUES ('3', '3', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('4', '4', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('5', '5', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('6', '6', '社长', '1', '1', '1');
INSERT INTO `org_user` VALUES ('8', '1', '社长', '1', '1', '1');

-- ----------------------------
-- Table structure for `recruitment`
-- ----------------------------
DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment` (
  `org_id` int(10) unsigned NOT NULL,
  `content` varchar(1024) NOT NULL,
  `release_date` date NOT NULL,
  `rec_title` varchar(30) NOT NULL,
  `rec_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL DEFAULT 1,
  `rec_need` varchar(11) NOT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitment
-- ----------------------------
INSERT INTO `recruitment` VALUES ('2', '社团招新2019-5-13', '2019-04-12', '社团秋季招新', '6', '1', '1,1,0,0,0,0');
INSERT INTO `recruitment` VALUES ('3', '社团招新招新截止时间2019-5-20', '2019-04-14', '招新', '7', '1', '1,0,0,0,0,0');
INSERT INTO `recruitment` VALUES ('1', '来', '2020-01-08', '纳新啦', '8', '1', '1,1,1,1,1,1');
INSERT INTO `recruitment` VALUES ('8', '学习部来来来', '2020-01-08', '学习部纳新啦', '9', '1', '1,1,1,1,1,1');
INSERT INTO `recruitment` VALUES ('8', '学习部来来来', '2020-01-08', '学习部纳新啦', '10', '1', '0,0,0,0,0,0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(50) NOT NULL,
  `uname` varchar(8) NOT NULL,
  `upwd` varchar(8) NOT NULL,
  `sex` enum('男','女') NOT NULL DEFAULT '男',
  `birth` date DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123456', '男', '1997-10-30');
INSERT INTO `user` VALUES ('10', '万娟', '123', '女', '1998-07-23');
INSERT INTO `user` VALUES ('2', '王思', '123', '女', '1997-06-20');
INSERT INTO `user` VALUES ('3', '王五', '123456', '男', '1997-07-04');
INSERT INTO `user` VALUES ('4', '张三', '123', '男', '1997-06-01');
INSERT INTO `user` VALUES ('5', '黑子', '123', '男', '1997-07-24');
INSERT INTO `user` VALUES ('6', '小白', '123', '男', '1998-10-12');
INSERT INTO `user` VALUES ('7', '王盼', '123', '男', '1996-11-01');
INSERT INTO `user` VALUES ('8', '赵四', '123', '男', '1998-06-10');
INSERT INTO `user` VALUES ('9', '王丽', '123', '女', '1997-06-11');
INSERT INTO `user` VALUES ('a111', '最会打代码', 'a111', '男', '2020-01-07');
INSERT INTO `user` VALUES ('user1', '王熙凤', '123456', '男', '2019-07-18');

-- ----------------------------
-- Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `mes_id` int(2) NOT NULL AUTO_INCREMENT,
  `from_uid` varchar(12) NOT NULL,
  `to_uid` varchar(12) NOT NULL,
  `mes_title` varchar(30) DEFAULT NULL,
  `mes_content` varchar(1024) DEFAULT NULL,
  `mes_date` datetime DEFAULT NULL,
  `stat` int(2) DEFAULT NULL,
  `collecF` int(2) DEFAULT NULL,
  `collecT` int(2) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  PRIMARY KEY (`mes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_message
-- ----------------------------
INSERT INTO `user_message` VALUES ('1', '1', '2', '秋季提醒', '秋季养生小提醒：清晨外出多穿衣，防止受凉伤身体；锻炼过后早把家回，汗湿衣衫风中吹易着凉；运动强度要适度，准备活动要充足。祝你健康！', '2019-04-06 15:24:53', '1', '1', '-1', '0');
INSERT INTO `user_message` VALUES ('2', '2', '1', '周末祝福', '秋风清爽送凉意，心情舒畅心欢喜；秋雨清澈淋运气，福禄寿喜落给你；丰收之时在秋季，工作顺利好业绩。秋天到了祝福你：事事顺心如意、大吉大利', '2019-04-14 15:25:47', '2', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('3', '1', '2', '秋季提醒', '秋日思，秋波长，秋风起，秋水凉，秋光媚，秋天爽，秋色宜人醉沙场，秋兵随你风尘扬，秋收众将等你调遣忙！祝你秋季收获溢满仓！', '2019-04-19 15:26:23', '1', '-1', '1', '0');
INSERT INTO `user_message` VALUES ('4', '1', '3', '生日祝福', '我的祝福，不是最早，不是最好，但是最诚；我的祝福，不求最美，不求最全，但求最灵。无论你已经收到多少问候，我依然献上最诚挚的祝愿：幸福一生，生日快乐！', '2019-04-13 15:08:18', '1', '1', '-1', '0');
INSERT INTO `user_message` VALUES ('5', '1', '3', '祝福', '拨动思念的心弦，音符里注入友谊的能量；碰响惦记的酒杯，味道里充满真情的芳香；采集快乐的露珠，送出祝福的吉祥：朋友，愿你好运造访，幸福上涨', '2019-04-14 15:09:32', '1', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('6', '3', '1', '祝福短信', '情谊是一首歌谣，融通心灵，悦人心扉，美好无限；友情是一朵奇葩，贯穿生活，芳香纯厚，沁人心脾。朋友，愿我们的友情天长地久，幸福永远！', '2019-04-06 17:01:10', '2', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('37', '1', '2', '秋季提醒', '用秋花编个花篮，秋叶篮底装满，装上累累秋实，再加真挚祝福，日日思念，真情问候，愿你在2011这个不平凡的秋季里，万事顺利，事业发迹，前程无忧，快乐常饶。新学期祝福语大全', '2019-04-19 00:00:00', '0', '1', '-1', '0');
INSERT INTO `user_message` VALUES ('77', '1', '3', '秋季提醒', '有没有这么一首歌，让你突然想到我。在这个秋季的雨后，一份思念涌至脑海。有些想你，我的朋友；有些牵挂，我的朋友。望你珍重，在这个思念的季节。', '2019-04-22 16:01:48', '0', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('78', '1', '4', '周末祝福', '周末种棵开心树，散回逍遥步，走上自在路，闯进好运雾。疲倦全消除，快乐你做主。花开千百度，悠闲心中驻，万事不辛苦，成功来相助。愿你幸福不胜数。', '2019-04-22 16:02:03', '1', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('80', '1', '5', '周末祝福', '周末祝福排仔细，快乐应当属第一，问候接着来报道，牵挂自然少不了，健康跟着排排站，平安到来忘不掉，最后幸福做总结，愿你周末过的好！', '2019-04-22 16:07:43', '1', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('90', '1', '6', '周末祝福', '风雨无情人有情　对你想念没有停　虽然不是常见面　一样会把你想念　发个信息把话聊　时间化作连理桥　祝你周末睡好觉　看完信息笑一笑', '2019-04-24 17:18:52', '0', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('91', 'user1', '10', '王熙凤测试', '王熙凤测试', '2019-07-18 21:20:01', '2', '-1', '-1', '0');
INSERT INTO `user_message` VALUES ('92', '1', 'user1', '申请加入社团成功', '您提交申请的加入四叶草心理协会社团申请成功', '2019-07-18 21:34:59', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('93', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:43:30', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('94', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:44:14', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('95', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:44:26', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('96', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:44:36', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('97', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:44:51', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('98', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:44:59', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('99', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:45:07', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('100', 'admin', '1', '公告上首页申请成功', '您提交申请的心理协会管理层选拔公告上首页申请成功', '2019-07-18 23:45:55', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('101', 'admin', '1', '公告上首页申请成功', '您提交申请的心理协会管理层选拔公告上首页申请成功', '2019-07-18 23:48:18', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('102', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:48:27', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('103', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:49:02', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('104', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:50:03', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('105', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:50:13', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('106', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:50:26', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('107', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:50:59', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('108', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:51:38', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('109', 'admin', '2', '公告上首页申请成功', '您提交申请的西部梦想下乡通知公告上首页申请成功', '2019-07-18 23:52:33', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('110', 'admin', '1', '公告上首页申请成功', '您提交申请的心理健康周志愿者招募公告上首页申请成功', '2019-07-18 23:53:25', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('111', '1', '1', '社团申请失败', '您提交申请的å­¦ä¹ é¨社团申请失败', '2020-01-08 00:30:54', '2', '-1', '-1', '1');
INSERT INTO `user_message` VALUES ('112', 'user1', '10', '222', '333', '2020-01-08 07:24:42', '1', '-1', '-1', '0');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_id` int(4) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('7', '1^918600.mp4', '2019-07-19 08:31:09');
