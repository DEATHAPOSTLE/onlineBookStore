-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinebookstore
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityId` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `commentContent` varchar(600) DEFAULT NULL,
  `commentDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_base`
--

DROP TABLE IF EXISTS `commodity_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity_base` (
  `commodityId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityName` varchar(135) DEFAULT NULL,
  `commodityPicture` varchar(3072) DEFAULT NULL,
  `commodityType` varchar(135) DEFAULT NULL,
  `commodityPrice` double DEFAULT NULL,
  `commodityIntroduce` varchar(3072) DEFAULT NULL,
  `commoditySurplus` int(11) DEFAULT NULL,
  `commodityRate` varchar(135) DEFAULT NULL,
  `commodityShelves` varchar(6) DEFAULT NULL,
  `commodityPress` varchar(135) DEFAULT NULL,
  `commodityAuthor` varchar(135) DEFAULT NULL,
  `commodityList` varchar(3072) DEFAULT NULL,
  `commodityContent` varchar(3072) DEFAULT NULL,
  `commodityInPrice` double DEFAULT '0',
  PRIMARY KEY (`commodityId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_base`
--

LOCK TABLES `commodity_base` WRITE;
/*!40000 ALTER TABLE `commodity_base` DISABLE KEYS */;
INSERT INTO `commodity_base` VALUES (1,'人生海海','人生海海.png','文学',49.5,'人生海海详情.jpg',1000,'5','1','北京十月文艺出版社','麦家','第一部<br>\n第一章<br>\n第二章<br> \n第三章<br> \n第四章<br> \n第五章<br> \n第六章<br> \n第七章<br> \n第八章<br> \n第九章<br> \n第二部<br>\n第十章<br> \n第十一章<br> \n第十二章<br> \n第十三章<br> \n第十四章<br> \n第十五章<br> \n第十六章<br> \n第三部<br>\n第十七章<br> \n第十八章<br> \n第十九章<br> \n第二十章<br>\n','\"爷爷讲，前山是龙变的，神龙见首不见尾，看不到边，海一样的，所以也叫海龙山；后山是从前山逃出来的一只老虎，所以也叫老虎山。老虎有头有颈，有腰背，有屁股，还有尾巴和一只左前脚——因为它趴着在睡觉，所以光露出一只。前山海一样大，丛山峻岭，像凝固的浪花，一浪赶一浪，波澜壮阔。老虎翻山又越岭，走了八辈子，一辈子一千年，累得要死，一逃出前山，跳过溪坎，脱险了，就趴下，睡大觉。这样子，脑头便是低落的，腰背是耷拉的，屁股是翘起的，尾巴是拖地的，并甩出来，三只脚则收拢，盘在身子下。唯一那只左前脚，倒是尽量支出来，和甩出来的尾巴合作，一前一后，钳住村庄。\n登上山顶——老虎屁股——往下看，村庄像被天空的脚蹄踏着，也像是被一声口令聚拢起来，显得紧密。其实是散乱的，屋子排的排靠的靠，大的大小的小，气派的气派破落的破落。这是一个老式的江南山村，靠山贴水，屋密人稠。屋多是两层楼房，土木结构，粉墙黛瓦；山是青山，长满毛竹和灌木杂树；水是清水，一条阔溪，清澈见底，潭深流急，盛着山的力气。溪水把鹅卵石刷得光滑，铺在弄堂里，被几百年的脚板和车轮——独轮车、脚踏车、拖拉机——磨得更光滑，有劲道。弄堂曲里拐弯，好像处处是死路，其实又四通八达的，最后都通到祠堂。\"',40),(2,'习近平谈治国理政','习近平谈治国理政.png','军事',50.5,'习近平谈治国理政详情.jpg',500,'5','1','外文出版社','习近平','\"一、坚持和发展中国特色社会主义， 实现中华民族伟大复兴的中国梦\n\n努力开创中国特色社会主义事业更加广阔的前景 ……………………………………… 3 （2014 年 8 月 20 日）\n中国共产党的领导是中国特色社会主义 最本质的特征 ……………………………… 18 （2014 年 9 月 5 日— 2017 年 2 月 13 日）\n协调推进“四个全面”战略布局 ……………………………………………………… 22 （2014 年 12 月 13 日— 2016 年 1 月 29 日）\n中国梦必须同人民对美好生活的向往 结合起来才能取得成功 ……………………… 29 （2015 年 9 月 22 日）\n不忘初心，继续前进 …………………………………………………………………… 32 （2016 年 7 月 1 日）\n\"','一、坚持和发展中国特色社会主义， 实现中华民族伟大复兴的中国梦<br>\n努力开创中国特色社会主义事业更加广阔的前景 ……………………………………… 3 （2014 年 8 月 20 日）<br>\n中国共产党的领导是中国特色社会主义 最本质的特征 ……………………………… 18 （2014 年 9 月 5 日— 2017 年 2 月 13 日）<br>\n协调推进“四个全面”战略布局 ……………………………………………………… 22 （2014 年 12 月 13 日— 2016 年 1 月 29 日）<br>\n中国梦必须同人民对美好生活的向往 结合起来才能取得成功 ……………………… 29 （2015 年 9 月 22 日）<br>\n不忘初心，继续前进 …………………………………………………………………… 32 （2016 年 7 月 1 日）<br>',40),(3,'敢于孤独的勇气','敢于孤独的勇气.png','文学',38.4,'敢于孤独的勇气详情.jpg',477,'4','1','浙江人民出版社','周国平','第Yi章：拥有幸福的能力<br>\r 论幸福<br>\r 幸福的哲学<br>\r 幸福和运气<br>\r 幸福的悖论<br>\r 最高的物质幸福<br>\r 可持续的快乐<br>\r 苦难的精神价值<br>\r 幸福和苦难都属于灵魂<br>\r 财富和幸福<br>\r <br>\r 第二章：认识你自己<br>\r 拥有“自我”<br>\r 认识你自己<br>\r 为自己写的日记<br>\r 我更愿意是我自己<br>\r 己所欲，勿施于人<br>\r 精神栖身于茅屋<br>\r 心灵土壤<br>\r 不要挡住我的阳光<br>\r 未经省察的人生没有价值<br>\r <br>\r 第三章：享受生命本身<br>\r 享受生命本身<br>\r 善良、丰富、高贵<br>\r 人生贵在行胸臆<br>\r 悲观•执着•超脱<br>\r 感受生命的奇迹<br>\r 自然和生命<br>\r 思考死：有意义的徒劳<br>\r 生命观与人生意义<br>\r 内在生命的伟大<br>\r 生命树上的果子<br>\r <br>\r 第四章：实现灵魂的价值<br>\r 哲学与你有缘<br>\r 哲学开始于仰望天穹<br>\r 世界有没有一个“本来面目”？<br>\r 智慧的诞生<br>\r 你的“自我”在哪里<br>\r 如何走进哲学<br>\r 哲学是永远的追问<br>\r 哲学不只是慰藉<br>\r 哲学的用处\"\"<br>\r ','\"有人会说，幸福这个东西很难说，好像是很主观的感觉，很难有统一的标准。确实是这样，每个人对幸福的理解是不一样的。但是，你若深入地问为什么会不一样，其实还是有标准的。一个人对幸福的理解，从大的方面来说，其实体现了价值观，就是你究竟看重什么。\r 　　古希腊哲学家亚里士多德曾经说过：幸福是我们一切行为的终极目标，我们做所有的事情其实都是手段。一个人想要赚钱赚得多一点，这本身并不是目的，他是为了由此可以过上幸福的生活。有人可能就要反驳了：我不要那么多钱，也可以幸福。比如说我读几本好书，就会感到很幸福。其实对后一种人来说，读书就是他获得幸福的手段。\r 　　对于什么是幸福，西方哲学史上主要有两种看法、两个派别。一派叫作快乐主义，其创始人是古希腊哲学家伊壁鸠鲁。近代以来，英国的一些哲学家，如亚当?斯密、约翰?穆勒、休谟对此也有所阐发。这一派认为，幸福就是快乐。但什么是快乐？快乐就是身体的无痛苦和灵魂的无烦恼。身体健康、灵魂安宁就是快乐，就是幸福。他们还特别强调一点，人要从长远来看快乐，要理智地去寻求快乐。你不能为了追求一时的、眼前的快乐，而给自己埋下一个痛苦的祸根，结果得到的可能是更大的痛苦。另一派叫作完善主义。完善主义认为，幸福就是精神上的完善，或者说道德上的完善。他们认为人身上最高贵的部分，是人的灵魂，是人的精神。你要把这部分满足了，那才是真正的幸福。这一派的代表人物是苏格拉底、康德、黑格尔、马克思等，他们强调的是人的精神满足。\"',35),(4,'鲁迅全集','鲁迅全集.png','文学',227.2,'鲁迅全集详情.jpg',435,'5','1','北京日报出版社','鲁迅','鲁迅先生全集序（蔡元培）<br>\n第一卷 坟 呐喊 野草<br>\n第二卷 热风 彷徨 朝花夕拾 故事新编<br>\n第三卷 华盖集 华盖集续编 而已集<br>\n第四卷 三闲集 二心集 伪自由书<br>\n第五卷 南腔北调集 准风月谈 花边文学<br>\n第六卷 且介亭杂文 且介亭杂文二编 且介亭杂文续编<br>\n第七卷 致许广平书信集 集外集 集外集拾遗<br>\n第八卷 会籍郡故事集 古小说钩沉<br>\n第九卷 嵇康集 中国小说史略<br>\n第十卷 小说旧闻钞 唐宋传奇集 汉文学史纲要<br>\n第十一卷 月界旅行 地底旅行 域外小说集 现代小说译丛 现代日本小说集 工人绥惠略夫<br>\n第十二卷 一个青年的梦 爱罗先珂童话集 桃色的云<br>\n第十三卷 苦闷的象征 出了象牙之塔 思想·山水·人物<br>\n第十四卷 小约翰 表 俄罗斯的童话 附：药用植物<br>\n第十五卷 近代美术史潮论 艺术论<br>\n第十六卷 壁下译丛 译丛补<br>\n第十七卷 艺术论 现代新兴文学的诸问题 文艺与批评 文艺政策<br>\n第十八卷 十月 毁灭 山民牧唱 坏孩子和别的奇闻<br>\n第十九卷 竖琴 一天的工作<br>\n第二十卷 死魂灵 附录：自传 鲁迅先生年谱 鲁迅译著书目续编 鲁迅先生的名·号·笔名录\"\"<br>\n<br>','\"\"\"行山阴道上，千岩竞秀，万壑争流，令人应接不暇\"\"；有这种环境，所以历代有著名的文学家美术家，其中如王逸少的书，陆放翁的诗，尤为永久流行的作品。最近时期，为旧文学殿军的，有李越缦先生，为新文学开山的，有周豫才先生，即鲁迅先生。\n　　鲁迅先生本受清代学者的濡染，所以他杂集会稽郡故书，校嵇康集，辑谢承后汉书，编汉碑帖，六朝墓志目录，六朝造象目录等，完全用清儒家法。惟彼又深研科学，酷爱美术，故不为清儒所囿，而又有他方面的发展，例如科学小说的翻译，中国小说史略，小说旧闻钞，唐宋传奇集等，已打破清儒轻视小说之习惯；又金石学为自宋以来较发展之学，而未有注意于汉碑之图案者，鲁迅先生独注意于此项材料之搜罗；推而至于引玉集，木刻纪程，北平笺谱等等，均为旧时代的考据家赏鉴家所未曾著手。\n　　先生阅世既深，有种种不忍见不忍闻的事实，而自己又有一种理想的世界，蕴积既久，非一吐不快。但彼既博览而又虚衷，对于世界文学家之作品，有所见略同者，尽量的迻译，理论的有卢那卡尔斯基，蒲力汗诺夫之艺术论等；写实的有阿尔志跋绥夫之工人绥惠略夫，果戈理之死魂灵等，描写理想的有爱罗先珂及其他作者之童话等，占全集之半，真是谦而勤了。\n　　\"\"借他人之酒杯，浇自己的块垒\"\"，虽也痛快，但人心不同如其面，环境的触发，时间的经过，必有种种蕴积的思想，不能得到一种相当的译本，可以发舒的，于是有创作。鲁迅先生的创作，除坟，呐喊，野草数种外，均成于一九二五至一九三六年中，其文体除小说三种，散文诗一种，书信一种外，均为杂文与短评，以十二年光阴成此多许的作品，他的感想之丰富，观察之深刻，意境之隽永，字句之正确，他人所苦思力索而不易得当的，他就很自然的写出来，这是何等天才！又是何等学力！\n　　综观鲁迅先生全集，虽亦有几种工作，与越缦先生相类似的；但方面较多，蹊径独辟，为后学开示无数法门，所以鄙人敢以新文学开山目之。\"',198),(5,'今日大吉，诸事不宜','今日大吉，诸事不宜.png','文学',57.8,'今日大吉，诸事不宜详情.jpg',806,'4','1','南海出版公司','露比·艾略特','\"\"\"前言<br>\n1.今日大吉，诸事不宜<br>\n2.当我一不小心故意毁掉一切的时候，请多包涵<br>\n3.那么，今天你心情如何？<br>\n4.迷失：自我感觉<br>\n5.我的盘子里有很多东西<br>\n6.啊，脸，咱们又见面啦<br>\n7.我是大人，郁闷大的<br>\n8.我们一切都很好\"\"<br>\n<br>\"','\"1.我第一次患上重度抑郁症是在十六岁的时候。那时我已经被进食障碍折磨了好几年，相当悲惨，经常住院。但抑郁症不一样，它就像一个又疯又傻的人一边狞笑，一边开着蒸汽压路机破门而入，把我的人生碾平，只留下一片凄惨的虚无。我并不是不在乎自己的生活，而是没有能力在乎它了。\n2.我会忘记自己是有能力做事的，只不过大脑太爱东想西想。我会转而认为自己是个极度糟糕、一事无成的白痴。这种状态相当可怕，令我孤立无援。和应对类似的病症一样，我需要经历一个过程才能意识到自己陷入了这种状态，从而相信自己的判断，开始积极地进行自我调控，而这个过程无异于打一场硬仗。\n3.请勿践踏草地。\n请勿因为草比你好，就对着草尖叫。\n刚坠入爱河的情侣，请去别处秀恩爱，不要破坏孤独之人的生活。\n请向大自然致敬，方法是在落叶里打滚，同时以固定的间隔大喊“居无定所”。\n没有人想听你说天边那朵云长得多像修枝剪。\n请把晒得到太阳的地方让给狗，它们才配得到阳光。\n4.所以，是的，生活有时很愚蠢。就像有人给了你一杯好喝的酸奶，然后告诉你这杯酸奶只能用叉子吃。于是你照做了，手上小心翼翼，花了很长很长的时间，看起来像个白痴，最后导致你一看到奶制品就会产生不好的联想。\"',52),(6,'苏东坡全集','苏东坡全集.png','文学',497.5,'苏东坡全集详情.jpg',58,'5','1','北京燕山出版社','苏轼','\"卷一　诗集\n　郭纶\n　初发嘉州\n　犍为王氏书楼\n　过宜宾见夷中乱山\n　夜泊牛口\n　牛口见月\n　戎州\n　舟中听大人弹琴\n　泊南井口期任遵圣长官，到晚不及见，复来\n　过安乐山，闻山上木叶有文，如道士篆符，云此山乃张道陵所寓二首\n　渝州寄王道矩\n　江上看山\n　涪州得山胡次子由韵\n\"','\"苏轼(1037~1101)，字子瞻，号东坡居士，眉州眉山（今属四川）人。苏轼生于诗礼世家，父子三人被誉为“三苏”。苏轼学识渊博，思想通达，以儒学体系为根本而浸染释、道的思想。苏轼平生受到两次严重的政治迫害，*次是45岁那年因“乌台诗案”而被贬至黄州，一住四年。第二次是在59岁时被贬往惠州，62岁时贬至儋州，到65岁才遇赦北归，前后在贬所六年。谪贬当然是苏轼的人生逆境，但这种逆境却使苏轼更深刻地理解了社会和人生，也使他的创作更深刻地表现出内心的情感波澜。在宋代就有人认为贬至海南并不是苏轼的不幸，逆境是时代对这位文学天才的玉成。\n　　苏轼的文学思想是文、道并重。在这种文学思想指导下，苏轼的散文呈现出多姿多采的艺术风貌。苏文气势雄放，语言却平易自然，这正是宋文异于唐文的特征之一。\"',450),(7,'他改变了中国','他改变了中国.png','军事',52.7,'他改变了中国详情.jpg',123,'5','1','上海译文出版社','江泽民','\"引言 江泽民的经历\n\n第一部分根基 1926-1989年\n第1章 1926-1943年“我的背景就是我的家庭”\n第2章 1943-1947年“我是一个爱国者”\n第3章 1947-1955年“我是工程师”\n第4章 1955-1962年“我爱才”\n第5章 1962-1976年“史无前例的破坏时期”\n第6章 1976-1985年“在工作中学习是我的习惯”\n第7章 1985-1986年“少说多干”\n第8章 1986-1989年“我怎么会不知道呢？”\n\n第二部分领导地位 1989-1996年\n第9章 1989年1月-5月“准备作长期斗争”\n\"','\"江泽民的经历　　有人说，江泽民不像毛泽东那样是一位高瞻远瞩的开国之父，也不像邓小平那样是一位勇敢的社会改革家。人们觉得毛和邓改变了中国，而江却没有。他们说，除了保持社会稳定并享受经济发展的好运气，他对中国的影响力微不足道。\n　　上面这些只是假设，而下面这些却是事实。\n　　2001 年9 月11 日，北京午夜时分，亦即纽约正午时刻，短短数小时之前美国刚刚遭受了骇人的袭击，江泽民主席紧急致电乔治·布什总统。他是最早这样做的世界领导人之一。\n　　江写道：“我谨代表中国政府和人民，向你并通过你，向美国政府和人民表示深切的慰问，并对死难者表示哀悼。中国政府一贯谴责和反对一切恐怖主义的暴力活动。”\n　　翌日夜，江主席与布什总统通了电话，再次强烈谴责“这起骇人听闻的恐怖活动”，并保证“我们愿向美方提供一切必要的支援和协助”。同日，在纽约联合国，中国投票支持美国提出的安理会反恐决议。根据北京的指示，中国驻联合国代表发言说：“昨天发生的袭击令全世界感到震惊，它虽然发生在美国，却意味着对整个国际社会的公然挑衅。”中国的外交支持明确而坚定，帮助美国在全世界范围内建立一个挫败恐怖主义的联盟。\n　　在袭击发生之后，中国几乎马上派遣了32 名反恐专家前往美国，前所未有地让美国人分享情报，这是中美关系的一个惊人的转折。在随后数月中，当美国开始策划反击时，中国的反恐人员与美国同行定期举行会晤。江泽民领导下的中国关闭了与阿富汗和长期盟友巴基斯坦的边境，以防“基地”和塔利班领袖经中国逃窜。考虑到中国关于不破坏国家主权以及不干涉他国内政的基本政策，上述积极行为尤为世人瞩目。\"',44),(8,'为什么是毛泽东','为什么是毛泽东.png','军事',35.9,'为什么是毛泽东详情.jpg',223,'5','1','光明日报出版社','任志刚','\"前言：为什么领袖是毛泽东？\n第一章：天将降大任于斯人\n第二章：只有中专学历也能成为最高领袖\n第三章：幼年共产党：没有行动力，就无法掌握主动\n第四章：成功的路往往是最窄的\n第五章：领袖必修课：用正确证明实力\n第六章：抗日战争：独立与合作的博弈\n第七章：解放战争：民心比大炮更有力量\n第八章：伟业终成\n后记：导师毛泽东\"','\"毛泽东是神吗？有人说不是，有人说是。说他不是神的人，应当问自己该如何表述和理解那不可思议和空前绝后的成功呢？说他是神的人，也该问自己这样的表述是否包含着他不可学习的意味呢？毛泽东是可以学习的吗？这可不是能轻松回答的问题。我们更应当问自己要不要学习毛泽东？我们可以肯定的是，不学习毛泽东的人会后悔，当他回首人生的时候会因为自己碌碌无为、过于平庸、虚度光阴而悔恨。中国人想成功，不学习毛泽东又能学习谁呢？学习毛泽东重点当\n然是学习他的成功之道。我们所做的这项工作就是试图用多数人能够理解的文字来解构毛泽东的成功之道，我们重点关注的是成功学意义上的毛泽东之路。\n是什么因素导致毛泽东的成功呢？有人说是马列主义的传播，有人说是因为他代表了人民，有人说是俄国人的资助，有人说是蒋介石的愚蠢，有人说是日本侵略者帮了忙，有人说这是历史的选择，等等。\n这些答案没有解答一个重要问题，那就是为什么中国革命的领袖是毛泽东？如果我们再深问一下，为什么马克思主义这一真理只有毛泽东能使用？这样我们就能深入研究，而不是仅仅停留在表层。\n代表人民就能胜利这一说法，其实来自毛泽东。解放后毛泽东的好友询问毛泽东胜利的奥秘，毛泽东说因为我们共产党代表了人民，由于以往所有的胜利者都将成功归于自己或天命，而毛泽东颠覆了历史。他认为：“人民，只有人民，才是创造历史的真正动力。”这虽然是正确答案之一，不过我们得承认，能理解这一层面的人是少而又少的。\"',33),(9,'第二次世界大战回忆录','第二次世界大战回忆录.png','军事',506.4,'第二次世界大战回忆录详情.jpg',456,'5','1','北京时代华文书局','温斯顿·丘吉尔','\"第二次世界大战回忆录01：从战争到战争\n第二章 和平的鼎盛时期\n第三章 潜伏的危险\n第四章 阿道夫·希特勒\n第五章 被蝗虫吃光的年代\n第六章 日益阴暗的景象\n第七章 空中均势的丧失\n第八章 挑战和反响\n第九章 空中和海上的问题\n第十章 对意大利的制裁\n第十一章 希特勒动手了\n第十二章 重整军备的间歇期西班牙\n第十三章 德国武装起来了\n第十四章 艾登先生担任外交大臣和他的辞职\"','\"从9月7日到11月3日，平均每天晚上有二百架德国轰炸机袭击伦敦。在此以前的三个星期对我各郡城市进行的初期轰炸，使我们大量分散了我们的高射炮部队，所以当伦敦成为主要的袭击目标之初，它设在伦敦的高射炮只有九十二门。当时认为*好是让第十一大队指挥的夜间战斗机在空中自由活动。在夜间战斗机中，有六个中队是“伯伦翰”式和“无畏”式战斗机。夜间战斗那时还处在幼稚阶段，使敌人遭受的损失很小。我们的高射炮兵却因此一连三夜没有开炮。当时，他们本身的技术也低得可怜。尽管如此，鉴于我们夜间战斗机存在的弱点和一些未能解决的问题，于是决定准许高射炮手随意使用他们*好的技术，放手射击他们看不见的目标。指挥防空炮队的派尔将军，把高射炮从各郡的城市撤回来，使伦敦的高射炮数目在四十八小时内增加了一倍多。我们自己的飞机躲开了，高射炮大显身手的机会来到了。\n伦敦居民呆在他们家里或简陋的防空洞里忍受这似乎未受任何抵抗的空袭已有三夜了。突然，在9月10日，整个防空火网打开了，而且伴随着强烈的探照灯光。这轰隆隆的炮火给予敌人的损害并不大，但它却使居民们大为满意。每个人都欢欣鼓舞，认识到我们对敌人进行还击了。从此以后，高射炮队就经常开炮；当然，由于经常练习和熟练以及当前的迫切需要，射击技术便不断有所提高。德国入侵飞机被击落的数字也逐渐增加。有时，高射炮队暂停射击，让作战方法也大为改进的夜间战斗机飞临伦敦上空。夜间空袭之外，还伴之以几乎是连续不断的白昼空袭，有时来的是小队敌机，有时甚至仅仅只有一架，在整个二十四小时内，经常是每隔一会儿就有一次警报。七百万伦敦居民对于这种奇特的生活已经习以为常了。\"',400),(10,'全球枪械图鉴大全','全球枪械图鉴大全.png','军事',51.2,'全球枪械图鉴大全详情.jpg',345,'5','1','化学工业出版社','军情视点','\"第1章　枪械概述001\n1.1　枪械发展简史002\n1.2　枪械主要分类004\n1.3　枪弹007\n\n\n第2章　突击步枪009\n2.1　苏联/俄罗斯AK-47突击步枪010\n2.2　美国M16突击步枪017\n2.3　苏联/俄罗斯AK-74突击步枪021\n2.4　苏联/俄罗斯AKM突击步枪025\n2.5　俄罗斯AK-107突击步枪029\n2.6　俄罗斯AK-12突击步枪032\n2.7　美国AR-15突击步枪035\"','\"枪械是步兵的主要武器，也是其他兵种的辅助武器。它利用火药燃气能量发射弹丸，用于打击无防护或弱防护的有生目标。早期的枪械因为射速慢、精度差、对射击姿势限制很大，所以它只是继承了弩的地位，并没有取代矛、剑等格斗武器，也没能取代弓箭。因此，14世纪到19世纪前期通常被称为火器与冷兵器并用时代。\n到了19世纪，随着枪械技术的不断发展，冷兵器开始走向衰落。在19世纪中期多场战争，如美墨战争、南北战争、普丹战争、普奥战争、普法战争、北美印第安战争等，枪械首次发挥其压倒性的战斗力，把以往枪械和冷兵器并用的战争模式彻底改变，世界各国争相开发和购置新式枪械。\n19世纪末开始，枪械的各项技术日趋成熟，小型速射枪械已经包办了连近战内的几乎所有人对人的战斗。为了应付枪林弹雨的威胁，战车也开始出现，反过来促成了比传统枪械更具单发破坏力的广义轻武器出现，也开始越了狭义枪械的境界。20世纪上半叶的两次世界大战，也不断催化各类枪械的发展。时至今日，尽管各种高科技武器不断出现，但枪械仍然在现代军队中占据着重要位置。\"',40),(11,'写给所有人的编程思维','写给所有人的编程思维.png','科技',31.3,'写给所有人的编程思维详情.jpg',123,'4','1','北京日报出版社','吉姆·克里斯蒂安','\"第一章 学会编程思维\n002　学会编程思维\n005　什么是编程？\n007　计算机无处不在\n011　计算机的特征\n019　计算机如何工作？\n026　计算机的出现\n029　编程与计算机的历史\n033　人人都能学会编程\n035　世界需要更多的编程者\n第二章 解决问题\n038　解决问题\n039　大脑是怎样工作的？\n041　解决复杂的问题\"','\"学习编程思维对于当代以及后代人们提高技术与知识水平至关重要。随着计算机在日常生活中的广泛应用、网络互联互通的进一步加深，人们的生活越来越便捷。现在，我们需要拥有这些工具，掌握其使用技能，这样才能获得有效的服务。明白了这一点，我们就可以借助现有的编程语言，进行人机“对话”，享受智能服务。而妨碍我们学习编程的一个常见问题是，不知从何学起，甚至怀疑能否学会。其实，不必为此担心，学习编程的途径有很多。\n把编程语言的过去、现在，也许还有未来，紧紧联系在一起的，其实是一整套核心概念。你会发现，这些核心概念都源于计算机科学、逻辑学和数学——这也正是我们将要探讨的相关内容。希望通过这些知识和概念帮助你学会编程思维，而且不需要事先接触一行实际的代码。现在科技发展的速度实在太快，要想准确预测未来几年我们会使用什么先进技术与产品都非常困难，更不必说要解码了。所以我们希望你通过这些核心概念的学习，获取一套可以终生受益的工具，把自己武装起来，迎接各种挑战。学习编程思维的过程，将帮助你培养批判性的思维方式，提升你的组织能力，增强你使用计算机的信心。这样，即便在以后的人生道路上遇到了编程术语的问题，也不会为\n之困扰。\n\"',25),(12,'太空','太空.png','科技',96.5,'太空详情.jpg',467,'5','1','湖南少年儿童出版社','戴维·杰弗里斯','\"太阳系巡礼\n探索宇宙\n探索地球\n探索月球\n揭秘火星\n火炉世界\n大世界旅程\n走近气态巨星\n登陆土卫六\n太阳风暴\n探索小行星\n追逐彗星\n坑坑洼洼的星球\n“新视野号”探测器\"','\"★一部人类探索太空的编年史，致敬探索的诗意和勇气 1957年，人类*艘航天器——苏联人造卫星“斯普特尼克1号”成功发射，人类太空时代拉开序幕；\n★130余幅高清图，引人入胜的太空探秘，呈现太空撼动人心之美 \n揭开8大行星、系外行星的神秘面纱；\n直击奇妙的太空生活；\n历览机器人在太空计划中所扮演的角色。 \n\n\n★前瞻视角，直击未来太空城的梦幻设计，带你进行一次科幻大片般的太空之旅 \n在月球饭店上像鸟一样地滑翔；\n登临火星，建造一座陨石城；\n建造一部从地球直通月球的太空电梯；\n供人们生活、居住的太空聚居地…… \n\n\n★烧脑般的大胆想象，预测未来宇宙发展图景 \n宇宙会灭亡吗？\n逃离太阳系，还能找到其他恒星聚居地吗？\n怎样建造“太空方舟”？ \"',90),(13,'从小爱数学','从小爱数学.png','科技',104.7,'从小爱数学详情.jpg',4335,'3','1','湖南少年儿童出版社','赵艺贞','\"妖怪笨笨吃饭团 ?数字0—10\r 纺车，纺车，纺起来 ?数字10—100\r 守护金羊的神奇法宝 ?加法\r 斯克鲁奇的圣诞之夜 ?10以上加法\r 美食追逐大比拼 ?减法\r 幸运农夫的三个宝贝 ?乘法\r 养猪王子求亲亲 ?除法\r 白雪公主分面包 ?分数\r 乌鸦哥哥变形记?可能情况个数\r 美女与野兽的玫瑰之约 ?图表与统计\r 狮子和老鹰的PK赛 ?集合\r 玩具士兵与魔法块 ?几何形状及分割\r 鲤鱼报恩记 ?立体图形\r 糊涂国王摸月亮 ?立体图形的组合\"','\"数学不但是科学之母，更是了解任何其他科学的基础，它和我们的日常生活密不可分；不仅如此，数学带来的独立思考、判断、逻辑分析及解决问题的方法，都能让孩子终身受益。\n然而，在许多人眼中，数学是很难的。怎样才能让孩子对数学感兴趣，怎样才能让孩子觉得学数学不是一件苦差呢？\n数学的启蒙是个关键。如果一开始就能抓住孩子的好奇心，孩子对数学就会产生兴趣，并且会有进一步探索的欲望；如果一开始就把严肃的、冰冷的计算和公式摆在孩子的面前，孩子的心里恐怕就已经埋下了“厌恶”的种子。\n那么，怎样做才算是成功的启蒙呢？\n我们要给孩子讲“加法”的时候，让孩子瞧一瞧，穷小子马丁是如何运用他的智慧，守护金羊并*终迎娶公主的，怎么样？\n我们要给孩子讲“减法”的时候，让孩子参加大块头老虎和小不点蛤蟆的滚蒸笼比赛，怎么样？\n我们要给孩子讲“分数”的时候，让孩子偷偷地跟着白雪公主，一齐逃出皇宫，遇到七个小矮人，怎么样？\n我们要给孩子讲“几何图形”的时候，让孩子跟随玩具士兵，一路战胜敌手，*终完成奇幻冒险，怎么样？\n……\n听起来不错吧！这就是“从小爱数学”这套丛书的妙处所在。孩子的*爱是故事，那就让数学知识融入到一个又一个有趣的故事中去吧！学好数学，变得像读故事一样简单好玩！\n★轻松阅读好玩故事，享受数学妙趣\n玩具士兵用几何魔法块完成历险，灰姑娘在长度精灵的帮助下、克服继母的刁难，辛巴达的秘密武器打开一个神奇的世界……在一个个新意迭出又冒险刺激故事里，籍由孩子爱看故事的“本能”，让孩子在轻松有趣的故事里激发学习数学的兴趣。\n★科学进阶循序渐进，打好数学基础\n精心挑选孩子入园和入学阶段*需要同时也是*感兴趣的数学主题，从认识“数字0—10”“数字１０—１００”等，逐步过渡到数字的加、减、乘、除的运算，再延伸至对分数、时间、测量、对称、集合、规律、几何图形和立体图形等的理解……从易到难、循序渐进，帮助孩子一步步建立基础的数学概念。\"',86),(14,'世界恐龙地图','世界恐龙地图.png','科技',52.4,'世界恐龙地图详情.jpg',666,'5','1','山东省地图出版社','土屋健','\"欧洲：\n瑞典 挪威\n爱沙尼亚 拉脱维亚立陶宛\n英国\n德国\n波兰\n捷克\n乌克兰\n罗马尼亚\n比利时\n法国\n瑞士\n西班牙\n葡萄牙\"','恐龙和古生物化石在世界各地都有发现，但是在世界上的哪些地方，在中国的哪些地方，找到怎样的恐龙和古生物，人们恐怕就很少知道了。如果你翻开这本书，会发现这些疑问会被愉快地解答。全书介绍了从格陵兰岛到南极、世界上44个国家和地区，从每个国家和地区的地貌特征，到从远古时代开始大陆的变化情况，在世界各地找到的约640种古生物的插图分别被描绘在这些国家和地区页面上，同时配有详细的数据和生动有趣的解说。既可以作为初级恐龙和古生物爱好者的入门读物，也可以作为资深恐龙和古生物爱好者的工具书。',40),(15,'上下五千年','上下五千年.png','科技',69.8,'上下五千年详情.jpg',65,'3','1','少年儿童出版社','林汉达','\"001　盘古开天地\n002　神农尝百草\n003　涿鹿大战\n004　尧舜禅位\n005　大禹治水\n006　后羿夺权\n007　商汤讨伐夏桀\n008　盘庚迁都到殷\n009　奴隶为相\n010　姜尚钓鱼\n011　武王伐纣\n012　周公辅助成王\n013　共和行政\n014　骊山烽火\"','\" 楚公子春申君在武关听说秦国打了败仗跑了 ,就带着八万大军回到楚国。楚考烈王仍想当霸主 ,就打发使臣上成周去请求周赧 (nǎn)王下令征伐秦国。周赧王管辖的土地还不如最小的诸侯国 ,而且还分成两半 :河南巩城一带叫 “东周”。河南王城一带叫 “西周”。周赧王答应楚王用周天子的名义去约会列国诸侯。但只有燕、楚派出了很少的兵马 ,合纵又告吹了。可是 ,秦国倒找到借口发兵来打成周。西周投降了秦国 ,周赧王做了俘虏 ,没多久就死了。打这儿起 ,西周完了。\r       秦昭襄王灭了西周 ,丞相范雎告退。公元前 251年秋天 ,秦昭襄王病死后 ,秦孝文王即位。他即位才三天就死了。太子即位 ,就是秦庄襄王 ,他用吕不韦为丞相。公元前 249年,秦庄襄王又拜吕不韦为大将 ,发兵十万灭了东周。\r       秦庄襄王灭了东周才两年 ,也病死了。吕不韦立十三岁的太子为国君 ,就是秦王政 (后来称为秦始皇 ),秦国的大权都在吕不韦手里。吕不韦为了进攻赵国 ,假意跟燕国和好 ,先打发使者去破坏燕、赵联盟。燕王叫太子丹到秦国去做抵押 ,吕不韦又叫张唐上燕国去当相国。\r       不料 ,张唐却推辞说 :“我曾经率兵攻打过赵国 ,赵国人都恨死我了 ,说谁能抓住我 ,就赏他方圆一百里的地。这次去燕国肯定要经过中间的赵国 ,我这不是有去无回吗 ?还是请派其他人去吧 !”\r       吕不韦知道后非常恼火 ,但一时又想不出更合适的人选。他闷闷不乐地回到家中 ,一言不发地在窗前站了很久 ,脸色阴沉得可怕。\r       再说 ,吕不韦家有个小门客叫甘罗 ,是原来秦国丞相甘茂的孙子 ,甘茂死后 ,他就投奔吕不韦来了。甘罗见吕不韦不高兴 ,就上前问道 :“丞相您有什么不高兴的事吗 ?”\"',65),(16,'流浪地球','流浪地球.png','娱乐',27.3,'流浪地球详情.jpg',67,'4','1','万卷出版公司','刘慈欣','\"刘慈欣<br>','\"　　科学家们发现太阳将膨胀为一颗红巨星，期间地球表面上的一切将毁灭殆尽，于是他们计划建造能将地球发射到其他星球的巨大引擎，以保证人类长远生存。\n　　庞大的地球逃脱计划开始实施。\n　　与此同时，一件又一件曾经无比熟悉的事物从人类身边消失，疑惑和猜忌在人类当中引发叛乱之火，道德和伦理不复存在。\n　　在太阳*后灭亡的瞬间，一切都平息了，每个人怀揣着恐惧和希望踏上漫长的流浪之旅……\n\n　　刘慈欣的作品场面宏大，描写细腻，富有人文情怀。代表作《三体》被誉为迄今为止中国当代*杰出的科幻小说，凭借它，大刘拿到了世界科幻小说的*奖“雨果奖”，这是亚洲人首获这项“科幻诺贝尔”殊荣。\"',25),(17,'冷场','冷场.png','娱乐',42,'冷场详情.jpg',67,'5','1','四川文艺出版社','李诞','\"\"\"**情人们**<br>\n木板与木板之间难免有缝隙<br>\n我拎的到底是什么<br>\n你拎的到底是什么<br>\n故事主角总是一男一女<br>\n在白光后<br>\n<br>\n**狠人们**<br>\n居酒屋绑匪<br>\n逃逸<br>\n现代人标本<br>\n没有狗在叫<br>\n盗时\"\"<br>\n<br>\"','\"写小说成了件需要解释的事。\n很多个局面上很多杯酒对面很多人问， 你怎么又要出书。\n我也有些应对的答案：\n“没事写写，没想怎么样。”\n“就是过去一两年，一些东西。”\n“我写就为了自己过瘾关你什么事。”\n我生性懦弱，谈到写作，从来都说，早放弃早快乐，\n我写不成我认可的水平， 就轻松写写， 看看有没有人喜欢。我开心就好，你们随意。有人喜欢更好。\n不输的办法只有一个，就是不上场。\"',35),(18,'小偷家族','小偷家族.png','娱乐',40.2,'小偷家族详情.jpg',67,'5','1','北京联合出版有限公司','是枝裕和','·\"\"\"第一章   可乐饼<br>\n第二章   面筋<br>\n第三章   泳衣<br>\n第四章   魔术<br>\n第五章   弹珠<br>\n第六章   雪人\"\"<br>\n<br>\"','\"在东京角落一处无人注意的老屋里，住着秘密生活的一家人。他们靠“奶奶”的养老金生活，间或打工，习惯游荡在商店之间，顺手牵羊地偷点日常用品。\n　　一个冬夜，“爸爸”阿治发现一位被赶出家门的小女孩，\n　　把她“偷”了回去，成为新的家庭成员。\n　　众人一起度过了短暂而其乐融融的时光，\n　　然而一次意外引发了令人震惊的真相浮出水面，\n　　他们也赫然发现，日夜相处的家人，彼此背后藏着无法言说的往事和复杂的勾连……\"',38),(19,'漫威之父：斯坦李','漫威之父：斯坦李.png','娱乐',75,'漫威之父：斯坦李详情.jpg',344,'5','1','中信出版社','鲍勃·巴彻勒','\"\"\"前言：奇迹的破晓<br>\n第一章 纽约客斯坦利·利伯<br>\n第二章 少年编辑<br>\n第三章 军中剧作家<br>\n第四章 重返漫威<br>\n第五章 头号公敌<br>\n第六章 神奇四侠——新英雄的诞生<br>\n第七章 蜘蛛侠扭转败局<br>\n第八章 超级英雄部落<br>\n第九章 漫威宇宙的市场推广<br>\n第十章 偶像的诞生<br>\n第十一章 漫威有疾<br>\n第十二章 好莱坞的诱惑<br>\n第十三章 漫威操纵市场\"\"<br>\n<br>\"','\"奇迹的破晓\n“斯坦，我们要打造一支超级英雄战队。你知道的，它们将有非常广阔的市场前景。”及时漫画公司出版商马丁·古德曼对他的编辑斯坦·李大声说道。\n当古德曼敏锐地嗅到市场的新趋势时他没有丝毫的犹豫。一想到全美各地的收银机在结账时，都会为孩子们的硬币而忙碌，他就两眼放光——这些钱最终都会成为他的囊中之物。他这样想着，仿佛已经听到了薄薄的硬币掉进钱箱里清脆的声响。\n古德曼的预感并非源于幸运之神的眷顾或直觉，作为一个精明、实干的生意人，他不会以这样的方式工作。相反，据传闻，古德曼曾和几位同僚一起打高尔夫球，而他们碰上了管理着及时漫画公司的主要竞争对手——国家联合出版公司（DC漫画公司的前身）旗下的发行机构的人。这家公司就是《超人》《蝙蝠侠》和《神奇女侠》的诞生地。其间，古德曼听到他们在炫耀新系列的畅销漫画书。尤其是当他们谈到有一支超级英雄团队将会在下半年获得全新的头衔时，他们便滔滔不绝，根本停不下来。从不愿在竞争上落一丝下风的古德曼一听到这个消息就激动万分。回到办公室后，他在斯坦·李的耳旁叫嚣着说，也要打造一支超级英雄战队来与DC漫画公司抗衡……而且要迅速！\"',70),(20,'秒睡 : 幸福人生的睡眠秘诀','秒睡：幸福人生的睡眠秘诀.png','生活',31,'秒睡：幸福人生的睡眠秘诀详情.jpg',11,'4','1','人民日报出版社','刘毅君','\"\"\"自序 <br>\n第一章　现代经济社会正在剥夺你的睡眠时间 <br>\n是什么在吞噬你的睡眠时间　<br>\n不是你不想睡，是资本不让你睡　<br>\n做这个时代的少数清醒者<br>\n<br>\n第二章　掌控自己的命运，要从掌控睡眠开始 <br>\n放下手机，掌控睡眠才能掌控人生　<br>\n睡眠管理才是时间管理的核心<br>\n认识影响睡眠的五大因素，轻松掌控睡眠<br>\n<br>\n第三章　晚睡是没有勇气结束今天<br>\n安睡，跟这个世界做暂时的告别<br>\n80% 的睡眠问题其实是心理问题\"\"<br>\n<br>\"','你和幸福只差一个好梦。这个世界让你像是上了发条的钟表，忙碌个不停。殊不知，幸福人生的秘诀不是忙碌，而是睡一个好觉。资深精神科医师刘毅君，专注睡眠领域12年，临床一线成功案例精华呈现。书中由浅入深地讲解了现代人失眠的原因，提出了秒睡热身练习、自我催眠、高阶秒睡秘诀等多种健康睡眠方案，让你三秒入睡，五分钟满血复活，深睡一小时等于三小时。他独创的心理分析 认知改变 策略催眠 呼吸疗愈的综合治疗方法，有效率达99%。本书睡眠方案令无数失眠的人改善睡眠质量，重新掌控人生；帮助高压人士纾解压力，满血复活，成就幸福人生。',26),(21,'你不懂茶','你不懂茶.png','生活',34.5,'你不懂茶详情.jpg',123,'5','1','江苏凤凰文艺出版社','三宅贵男 ','\"\"\"1 日本茶<br>\n日本茶是什么样的茶? 012 <br>\n喝日本茶对身体有哪些益处? 014 <br>\n新茶、一番茶、番茶到底有什么区别? 016 <br>\n日本人平时最常喝的那种绿茶到底是什么茶? 018 <br>\n真有“静冈的茶不算茶”这回事吗? 020 <br>\n哪种日本茶最能放松身心? 022 <br>\n有一茶两喝的日本茶吗? 024 <br>\n有价格便宜、提神醒脑的日本茶吗? 026 <br>\n茶柱竖起来是好兆头? 028 <br>\n粉茶和粉末绿茶是同一种东西吗? 030 <br>\n焙茶能自己在家做吗? 032\"\"<br>\n<br>\"','\"哪种日本茶能放松身心？\n什么样的红茶适合做奶茶？ \n花草茶有哪些功效？\n世界有名的中国红茶是哪款？\n如何泡一壶好喝的茶？\n在家如何制作冰红茶？\n……\n日本资深茶艺师带你走进茶的清新世界。无论你喜欢绿茶、红茶、花草茶，还是奶茶，在这里你都能找到关于它们的内容。\"',24);
/*!40000 ALTER TABLE `commodity_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_base_examine`
--

DROP TABLE IF EXISTS `commodity_base_examine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity_base_examine` (
  `examineId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityName` varchar(135) DEFAULT NULL,
  `commodityPicture` varchar(3072) DEFAULT NULL,
  `commodityType` varchar(135) DEFAULT NULL,
  `commodityPrice` double DEFAULT NULL,
  `commodityIntroduce` varchar(3072) DEFAULT NULL,
  `commodityExamine` varchar(135) DEFAULT NULL,
  `commodityPress` varchar(135) DEFAULT NULL,
  `commodityAuthor` varchar(135) DEFAULT NULL,
  `commodityList` varchar(3072) DEFAULT NULL,
  `commodityContent` varchar(3072) DEFAULT NULL,
  `commodityInPrice` double DEFAULT '0',
  PRIMARY KEY (`examineId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_base_examine`
--

LOCK TABLES `commodity_base_examine` WRITE;
/*!40000 ALTER TABLE `commodity_base_examine` DISABLE KEYS */;
INSERT INTO `commodity_base_examine` VALUES (8,'天上人间','timg12.jpg','黄色',1222,'微信图片_20190401152233627.jpg','2','八大胡同出版社','朴一生',NULL,NULL,0),(9,'金瓶梅','QQ图片20190213163045xiaochou233.jpg','古典小说',123,'QQ图片20190218142350.png','1','无','无',NULL,NULL,0),(11,'表情包','QQ截图20190325142943.jpg','娱乐·',123,'QQ图片201902131632222245.jpg','1','石景山出版社','qhr',NULL,NULL,0),(20,'自行车','无标题.png','自行车',1234,'无标题.png','2','zxc','zxczxc',NULL,NULL,0),(21,'阿萨德','无标题.png','阿萨德',125,'无标题.png','1','阿萨德','阿萨德',NULL,NULL,0);
/*!40000 ALTER TABLE `commodity_base_examine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorites` (
  `favoritesId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `commodityId` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT '1',
  PRIMARY KEY (`favoritesId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityID` int(11) DEFAULT NULL,
  `orderPrice` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderStatus` varchar(135) DEFAULT NULL,
  `orderDTime` varchar(135) DEFAULT NULL,
  `deliveryDTime` varchar(135) DEFAULT NULL,
  `receiveDTime` varchar(135) DEFAULT NULL,
  `orderRate` varchar(135) DEFAULT NULL,
  `phoneNumber` varchar(135) DEFAULT NULL,
  `orderAddr` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (20,8,123,1,'8','2019-04-11 16:39:10','2019-04-11 16:39:10','2019-04-11 16:39:10','3','123','as'),(21,15,246,1,'3','2019-04-15 16:34:31','2019-04-15 16:51:01','2019-04-15 17:13:15','','3344','北京'),(22,15,246,1,'7','2019-04-15 16:47:48','2019-04-15 16:51:04','','','3344','北京'),(23,15,123,1,'2','2019-04-15 17:47:42','2019-04-15 21:03:12','','','3344','北京'),(24,15,123,4,'1','2019-04-15 17:50:21','','','','233','河北'),(25,15,123,0,'1','2019-04-15 21:02:42','','','','1234567890123','11234'),(26,11,22,0,'1','2019-04-15 21:14:22','','','','1234567890123','11234'),(32,32,14,0,'2','2019-04-15 22:00:22','2019-04-15 22:00:52','','','1234567890123','asd '),(33,32,14,0,'8','2019-04-15 22:00:28','','','','1234567890123','11234'),(34,11,22,0,'4','2019-04-15 22:28:14','2019-04-15 22:29:16','','','1234567890123','11234'),(35,33,125,0,'4','2019-04-15 22:36:36','','','','1234567890123','11234'),(36,8,123,1,'1','2019-04-24 21:51:10','','','','3344','åäº¬'),(37,15,492,1,'1','2019-04-24 21:52:48','','','','3344','åäº¬');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejected`
--

DROP TABLE IF EXISTS `rejected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejected` (
  `rejectedId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `rejectedStatus` varchar(135) DEFAULT NULL,
  `rejectedDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`rejectedId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejected`
--

LOCK TABLES `rejected` WRITE;
/*!40000 ALTER TABLE `rejected` DISABLE KEYS */;
INSERT INTO `rejected` VALUES (1,20,1,'1','2019-04-15 15:09:59'),(2,22,1,'2','2019-04-15 17:13:20'),(3,20,1,'7','2019-04-15 17:14:30'),(4,33,0,'7','2019-04-15 22:00:31'),(5,33,0,'7','2019-04-15 22:01:40'),(6,34,0,'3','2019-04-15 22:29:44'),(7,35,0,'3','2019-04-15 22:36:38');
/*!40000 ALTER TABLE `rejected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `shoppingCartId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityId` int(11) DEFAULT NULL,
  `userId` varchar(135) DEFAULT NULL,
  `commodityNumber` varchar(135) DEFAULT NULL,
  `registeredDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`shoppingCartId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (3,11,'3','1','2019-04-15 21:04:52'),(4,10,'0','1','2019-04-15 21:08:48'),(5,11,'0','1','2019-04-15 21:10:09'),(6,11,'0','1','2019-04-15 21:14:25'),(7,11,'0','1','2019-04-15 21:15:59'),(8,11,'0','1','2019-04-15 21:22:59'),(9,11,'0','1','2019-04-15 22:28:03');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(135) DEFAULT NULL,
  `userPassword` varchar(135) DEFAULT NULL,
  `userType` varchar(135) DEFAULT NULL,
  `userPhoneNumber` varchar(135) DEFAULT NULL,
  `userAddr1` varchar(135) DEFAULT NULL,
  `userAddr2` varchar(135) DEFAULT NULL,
  `userAddr3` varchar(135) DEFAULT NULL,
  `userAddr4` varchar(135) DEFAULT NULL,
  `userAddr5` varchar(135) DEFAULT NULL,
  `money` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','123456','2','3344','北京','河北','31','12','333','9960.4'),(2,'shop','123456','4','','','','','','','0.0'),(3,'admin','123456','3','','','','','','','0.0'),(4,'user2','123456','2','233','河北','','','','','501.6'),(5,'user3','123','1','','','','','','','0.0'),(6,'123','123','2','1234567890123','11234','','','','','743.9999999999999'),(7,'110108199508029903','123456','1','13683363035','','','','','','0.0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-27  1:11:03
