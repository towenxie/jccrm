/*!
 * Distpicker v1.0.4
 * https://github.com/fengyuanchen/distpicker
 *
 * Copyright (c) 2014-2016 Fengyuan Chen
 * Released under the MIT license
 *
 * Date: 2016-06-01T15:05:52.606Z
 */

(function (factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as anonymous module.
    define('ChineseDistricts', [], factory);
  } else {
    // Browser globals.
    factory();
  }
})(function () {

  var ChineseDistricts ={86:{2:'北京',19:'天津',36:'河北',220:'山西',351:'内蒙古',465:'辽宁',580:'吉林',650:'黑龙江',792:'上海',811:'江苏',929:'浙江',1031:'安徽',1153:'福建',1248:'江西',1359:'山东',1517:'河南',1694:'湖北',1811:'湖南',1948:'广东',2093:'广西',2217:'海南',2241:'重庆',2283:'四川',2486:'贵州',2584:'云南',2730:'西藏',2811:'陕西',2929:'甘肃',3031:'青海',3083:'宁夏',3111:'新疆',3225:'台湾',3249:'香港',3268:'澳门'},2:{3:'东城',4:'西城',5:'朝阳',6:'丰台',7:'石景山',8:'海淀',9:'门头沟',10:'房山',11:'通州',12:'顺义',13:'昌平',14:'大兴',15:'平谷',16:'怀柔',17:'密云',18:'延庆'},19:{20:'和平',21:'河东',22:'河西',23:'南开',24:'河北',25:'红桥',26:'滨海新区',27:'东丽',28:'西青',29:'津南',30:'北辰',31:'宁河',32:'武清',33:'静海',34:'宝坻',35:'蓟县'},36:{37:'石家庄',61:'唐山',76:'秦皇岛',84:'邯郸',104:'邢台',124:'保定',150:'张家口',168:'承德',180:'沧州',197:'廊坊',208:'衡水'},220:{221:'太原',232:'大同',244:'阳泉',250:'长治',264:'晋城',271:'朔州',278:'晋中',290:'运城',304:'忻州',319:'临汾',337:'吕梁'},351:{352:'呼和浩特',362:'包头',372:'乌海',376:'赤峰',389:'通辽',398:'鄂尔多斯',407:'呼伦贝尔',421:'巴彦淖尔',429:'乌兰察布',441:'兴安',448:'锡林郭勒',461:'阿拉善'},465:{466:'沈阳',480:'大连',491:'鞍山',499:'抚顺',507:'本溪',514:'丹东',521:'锦州',529:'营口',536:'阜新',544:'辽阳',552:'盘锦',557:'铁岭',565:'朝阳',573:'葫芦岛'},580:{581:'长春',592:'吉林',602:'四平',609:'辽源',614:'通化',622:'白山',629:'松原',635:'白城',641:'延边'},650:{651:'哈尔滨',670:'齐齐哈尔',687:'鸡西',697:'鹤岗',706:'双鸭山',715:'大庆',725:'伊春',743:'佳木斯',754:'七台河',759:'牡丹江',770:'黑河',777:'绥化',788:'大兴安岭'},792:{793:'黄浦',794:'卢湾',795:'徐汇',796:'长宁',797:'静安',798:'普陀',799:'闸北',800:'虹口',801:'杨浦',802:'闵行',803:'宝山',804:'嘉定',805:'浦东新区',806:'金山',807:'松江',808:'奉贤',809:'青浦',810:'崇明'},811:{812:'南京',826:'无锡',835:'徐州',847:'常州',855:'苏州',865:'南通',874:'连云港',882:'淮安',891:'盐城',901:'扬州',909:'镇江',916:'泰州',923:'宿迁'},929:{930:'杭州',944:'宁波',956:'温州',968:'嘉兴',976:'湖州',982:'绍兴',989:'金华',999:'衢州',1006:'舟山',1011:'台州',1021:'丽水'},1031:{1032:'合肥',1042:'芜湖',1051:'蚌埠',1059:'淮南',1066:'马鞍山',1073:'淮北',1078:'铜陵',1083:'安庆',1095:'黄山',1103:'滁州',1112:'阜阳',1121:'宿州',1127:'六安',1135:'亳州',1140:'池州',1145:'宣城'},1153:{1154:'福州',1168:'厦门',1175:'莆田',1181:'三明',1194:'泉州',1207:'漳州',1219:'南平',1230:'龙岩',1238:'宁德'},1248:{1249:'南昌',1259:'景德镇',1264:'萍乡',1270:'九江',1283:'新余',1286:'鹰潭',1290:'赣州',1309:'吉安',1323:'宜春',1334:'抚州',1346:'上饶'},1359:{1360:'济南',1371:'青岛',1384:'淄博',1393:'枣庄',1400:'东营',1406:'烟台',1419:'潍坊',1432:'济宁',1445:'泰安',1452:'威海',1457:'日照',1462:'莱芜',1465:'临沂',1478:'德州',1490:'聊城',1499:'滨州',1507:'菏泽'},1517:{1518:'郑州',1531:'开封',1542:'洛阳',1558:'平顶山',1569:'安阳',1579:'鹤壁',1585:'新乡',1598:'焦作',1609:'濮阳',1616:'许昌',1623:'漯河',1629:'三门峡',1636:'南阳',1650:'商丘',1660:'信阳',1671:'周口',1682:'驻马店',1693:'济源'},1694:{1695:'武汉',1709:'黄石',1716:'十堰',1725:'宜昌',1739:'襄阳',1749:'鄂州',1753:'荆门',1759:'孝感',1767:'荆州',1776:'黄冈',1787:'咸宁',1794:'随州',1798:'恩施',1807:'仙桃',1808:'潜江',1809:'天门',1810:'神农架'},1811:{1812:'长沙',1822:'株洲',1832:'湘潭',1838:'衡阳',1851:'邵阳',1864:'岳阳',1874:'常德',1884:'张家界',1889:'益阳',1896:'郴州',1908:'永州',1920:'怀化',1933:'娄底',1939:'湘西'},1948:{1949:'广州',1962:'韶关',1973:'深圳',1980:'珠海',1984:'汕头',1992:'佛山',1998:'江门',2006:'湛江',2016:'茂名',2023:'肇庆',2032:'惠州',2038:'梅州',2047:'汕尾',2052:'河源',2059:'阳江',2064:'清远',2073:'东莞',2075:'中山',2077:'潮州',2081:'揭阳',2087:'云浮'},2093:{2094:'南宁',2107:'柳州',2118:'桂林',2136:'梧州',2144:'北海',2149:'防城港',2154:'钦州',2159:'贵港',2165:'玉林',2172:'百色',2185:'贺州',2190:'河池',2202:'来宾',2209:'崇左'},2217:{2218:'海口',2223:'三亚',2224:'三沙',2225:'五指山',2226:'琼海',2227:'儋州',2228:'文昌',2229:'万宁',2230:'东方',2231:'定安',2232:'屯昌',2233:'澄迈',2234:'临高',2235:'白沙',2236:'昌江',2237:'乐东',2238:'陵水',2239:'保亭',2240:'琼中'},2241:{2242:'万州',2243:'涪陵',2244:'渝中',2245:'大渡口',2246:'江北',2247:'沙坪坝',2248:'九龙坡',2249:'南岸',2250:'北碚',2251:'两江新区',2252:'万盛',2253:'双桥',2254:'渝北',2255:'巴南',2256:'长寿',2257:'綦江',2258:'潼南',2259:'铜梁',2260:'大足',2261:'荣昌',2262:'璧山',2263:'梁平',2264:'城口',2265:'丰都',2266:'垫江',2267:'武隆',2268:'忠县',2269:'开县',2270:'云阳',2271:'奉节',2272:'巫山',2273:'巫溪',2274:'黔江',2275:'石柱',2276:'秀山',2277:'酉阳',2278:'彭水',2279:'江津',2280:'合川',2281:'永川',2282:'南川'},2283:{2284:'成都',2304:'自贡',2311:'攀枝花',2317:'泸州',2325:'德阳',2332:'绵阳',2342:'广元',2350:'遂宁',2356:'内江',2362:'乐山',2374:'南充',2384:'眉山',2391:'宜宾',2402:'广安',2408:'达州',2416:'雅安',2425:'巴中',2430:'资阳',2435:'阿坝',2449:'甘孜',2468:'凉山'},2486:{2487:'贵阳',2498:'六盘水',2503:'遵义',2518:'安顺',2525:'铜仁',2536:'黔西南',2545:'毕节',2554:'黔东南',2571:'黔南'},2584:{2585:'昆明',2600:'曲靖',2610:'玉溪',2620:'保山',2626:'昭通',2638:'丽江',2644:'普洱',2655:'临沧',2664:'楚雄',2675:'红河',2689:'文山',2698:'西双版纳',2702:'大理',2715:'德宏',2721:'怒江',2726:'迪庆'},2730:{2731:'拉萨',2740:'昌都',2752:'山南',2765:'日喀则',2784:'那曲',2795:'阿里',2803:'林芝'},2811:{2812:'西安',2826:'铜川',2831:'宝鸡',2844:'咸阳',2859:'渭南',2871:'延安',2885:'汉中',2897:'榆林',2910:'安康',2921:'商洛'},2929:{2930:'兰州市',2939:'嘉峪关',2941:'金昌',2944:'白银',2950:'天水',2958:'武威',2963:'张掖',2970:'平凉',2978:'酒泉',2986:'庆阳',2995:'定西',3003:'陇南',3013:'临夏',3022:'甘南'},3031:{3032:'西宁',3040:'海东',3047:'海北',3052:'黄南',3057:'海南',3063:'果洛',3070:'玉树',3077:'海西'},3083:{3084:'银川',3091:'石嘴山',3095:'吴忠',3101:'固原',3107:'中卫'},3111:{3112:'乌鲁木齐',3121:'克拉玛依',3126:'吐鲁番',3130:'哈密',3134:'昌吉',3142:'博尔塔拉',3146:'巴音郭楞',3156:'阿克苏',3166:'克孜勒苏',3171:'喀什',3184:'和田',3193:'伊犁',3204:'塔城',3212:'阿勒泰',3220:'石河子',3221:'阿拉尔',3222:'图木舒克',3223:'五家渠',3224:'北屯'},3225:{3226:'台北市',3227:'高雄市',3228:'基隆市',3229:'台中市',3230:'台南市',3231:'新竹市',3232:'嘉义市',3233:'台北县',3234:'宜兰县',3235:'桃园县',3236:'新竹县',3237:'苗栗县',3238:'台中县',3239:'彰化县',3240:'南投县',3241:'云林县',3242:'嘉义县',3243:'台南县',3244:'高雄县',3245:'屏东县',3246:'台东县',3247:'花莲县',3248:'澎湖县'},3249:{3250:'中西区',3251:'东区',3252:'九龙城区',3253:'观塘区',3254:'南区',3255:'深水埗区',3256:'黄大仙区',3257:'湾仔区',3258:'油尖旺区',3259:'离岛区',3260:'葵青区',3261:'北区',3262:'西贡区',3263:'沙田区',3264:'屯门区',3265:'大埔区',3266:'荃湾区',3267:'元朗区'},3268:{3269:'花地玛堂区',3270:'圣安多尼堂区',3271:'大堂区',3272:'望德堂区',3273:'风顺堂区',3274:'氹仔',3275:'路环'},37:{38:'长安区',39:'桥东区',40:'桥西区',41:'新华区',42:'井陉矿区',43:'裕华区',44:'井陉县',45:'正定县',46:'栾城县',47:'行唐县',48:'灵寿县',49:'高邑县',50:'深泽县',51:'赞皇县',52:'无极县',53:'平山县',54:'元氏县',55:'赵县',56:'辛集市',57:'藁城市',58:'晋州市',59:'新乐市',60:'鹿泉市'},61:{62:'路南区',63:'路北区',64:'古冶区',65:'开平区',66:'丰南区',67:'丰润区',68:'曹妃甸区',69:'滦　县',70:'滦南县',71:'乐亭县',72:'迁西县',73:'玉田县',74:'遵化市',75:'迁安市'},76:{77:'海港区',78:'山海关区',79:'北戴河区',80:'青龙满族自治县',81:'昌黎县',82:'抚宁县',83:'卢龙县'},84:{85:'邯山区',86:'丛台区',87:'复兴区',88:'峰峰矿区',89:'邯郸县',90:'临漳县',91:'成安县',92:'大名县',93:'涉　县',94:'磁　县',95:'肥乡县',96:'永年县',97:'邱　县',98:'鸡泽县',99:'广平县',100:'馆陶县',101:'魏　县',102:'曲周县',103:'武安市'},104:{105:'桥东区',106:'桥西区',107:'邢台县',108:'临城县',109:'内丘县',110:'柏乡县',111:'隆尧县',112:'任　县',113:'南和县',114:'宁晋县',115:'巨鹿县',116:'新河县',117:'广宗县',118:'平乡县',119:'威　县',120:'清河县',121:'临西县',122:'南宫市',123:'沙河市'},124:{125:'新市区',126:'北市区',127:'南市区',128:'满城县',129:'清苑县',130:'涞水县',131:'阜平县',132:'徐水县',133:'定兴县',134:'唐　县',135:'高阳县',136:'容城县',137:'涞源县',138:'望都县',139:'安新县',140:'易　县',141:'曲阳县',142:'蠡　县',143:'顺平县',144:'博野县',145:'雄　县',146:'涿州市',147:'定州市',148:'安国市',149:'高碑店市'},150:{151:'桥东区',152:'桥西区',153:'宣化区',154:'下花园区',155:'宣化县',156:'张北县',157:'康保县',158:'沽源县',159:'尚义县',160:'蔚　县',161:'阳原县',162:'怀安县',163:'万全县',164:'怀来县',165:'涿鹿县',166:'赤城县',167:'崇礼县'},168:{169:'双桥区',170:'双滦区',171:'鹰手营子矿区',172:'承德县',173:'兴隆县',174:'平泉县',175:'滦平县',176:'隆化县',177:'丰宁满族自治县',178:'宽城满族自治县',179:'围场满族蒙古族自治县'},180:{181:'新华区',182:'运河区',183:'沧　县',184:'青　县',185:'东光县',186:'海兴县',187:'盐山县',188:'肃宁县',189:'南皮县',190:'吴桥县',191:'献　县',192:'孟村回族自治县',193:'泊头市',194:'任丘市',195:'黄骅市',196:'河间市'},197:{198:'安次区',199:'广阳区',200:'固安县',201:'永清县',202:'香河县',203:'大城县',204:'文安县',205:'大厂回族自治县',206:'霸州市',207:'三河市'},208:{209:'桃城区',210:'枣强县',211:'武邑县',212:'武强县',213:'饶阳县',214:'安平县',215:'故城县',216:'景　县',217:'阜城县',218:'冀州市',219:'深州市'},221:{222:'小店区',223:'迎泽区',224:'杏花岭区',225:'尖草坪区',226:'万柏林区',227:'晋源区',228:'清徐县',229:'阳曲县',230:'娄烦县',231:'古交市'},232:{233:'城　区',234:'矿　区',235:'南郊区',236:'新荣区',237:'阳高县',238:'天镇县',239:'广灵县',240:'灵丘县',241:'浑源县',242:'左云县',243:'大同县'},244:{245:'城　区',246:'矿　区',247:'郊　区',248:'平定县',249:'盂　县'},250:{251:'城　区',252:'郊　区',253:'长治县',254:'襄垣县',255:'屯留县',256:'平顺县',257:'黎城县',258:'壶关县',259:'长子县',260:'武乡县',261:'沁　县',262:'沁源县',263:'潞城市'},264:{265:'城　区',266:'沁水县',267:'阳城县',268:'陵川县',269:'泽州县',270:'高平市'},271:{272:'朔城区',273:'平鲁区',274:'山阴县',275:'应　县',276:'右玉县',277:'怀仁县'},278:{279:'榆次区',280:'榆社县',281:'左权县',282:'和顺县',283:'昔阳县',284:'寿阳县',285:'太谷县',286:'祁　县',287:'平遥县',288:'灵石县',289:'介休市'},290:{291:'盐湖区',292:'临猗县',293:'万荣县',294:'闻喜县',295:'稷山县',296:'新绛县',297:'绛　县',298:'垣曲县',299:'夏　县',300:'平陆县',301:'芮城县',302:'永济市',303:'河津市'},304:{305:'忻府区',306:'定襄县',307:'五台县',308:'代　县',309:'繁峙县',310:'宁武县',311:'静乐县',312:'神池县',313:'五寨县',314:'岢岚县',315:'河曲县',316:'保德县',317:'偏关县',318:'原平市'},319:{320:'尧都区',321:'曲沃县',322:'翼城县',323:'襄汾县',324:'洪洞县',325:'古　县',326:'安泽县',327:'浮山县',328:'吉　县',329:'乡宁县',330:'大宁县',331:'隰　县',332:'永和县',333:'蒲　县',334:'汾西县',335:'侯马市',336:'霍州市'},337:{338:'离石区',339:'文水县',340:'交城县',341:'兴　县',342:'临　县',343:'柳林县',344:'石楼县',345:'岚　县',346:'方山县',347:'中阳县',348:'交口县',349:'孝义市',350:'汾阳市'},352:{353:'新城区',354:'回民区',355:'玉泉区',356:'赛罕区',357:'土默特左旗',358:'托克托县',359:'和林格尔县',360:'清水河县',361:'武川县'},362:{363:'东河区',364:'昆都仑区',365:'青山区',366:'石拐区',367:'白云鄂博矿区',368:'九原区',369:'土默特右旗',370:'固阳县',371:'达尔罕茂明安联合旗'},372:{373:'海勃湾区',374:'海南区',375:'乌达区'},376:{377:'红山区',378:'元宝山区',379:'松山区',380:'阿鲁科尔沁旗',381:'巴林左旗',382:'巴林右旗',383:'林西县',384:'克什克腾旗',385:'翁牛特旗',386:'喀喇沁旗',387:'宁城县',388:'敖汉旗'},389:{390:'科尔沁区',391:'科尔沁左翼中旗',392:'科尔沁左翼后旗',393:'开鲁县',394:'库伦旗',395:'奈曼旗',396:'扎鲁特旗',397:'霍林郭勒市'},398:{399:'东胜区',400:'达拉特旗',401:'准格尔旗',402:'鄂托克前旗',403:'鄂托克旗',404:'杭锦旗',405:'乌审旗',406:'伊金霍洛旗'},407:{408:'海拉尔区',409:'阿荣旗',410:'莫力达瓦达斡尔族自治旗',411:'鄂伦春自治旗',412:'鄂温克族自治旗',413:'陈巴尔虎旗',414:'新巴尔虎左旗',415:'新巴尔虎右旗',416:'满洲里市',417:'牙克石市',418:'扎兰屯市',419:'额尔古纳市',420:'根河市'},421:{422:'临河区',423:'五原县',424:'磴口县',425:'乌拉特前旗',426:'乌拉特中旗',427:'乌拉特后旗',428:'杭锦后旗'},429:{430:'集宁区',431:'卓资县',432:'化德县',433:'商都县',434:'兴和县',435:'凉城县',436:'察哈尔右翼前旗',437:'察哈尔右翼中旗',438:'察哈尔右翼后旗',439:'四子王旗',440:'丰镇市'},441:{442:'乌兰浩特市',443:'阿尔山市',444:'科尔沁右翼前旗',445:'科尔沁右翼中旗',446:'扎赉特旗',447:'突泉县'},448:{449:'二连浩特市',450:'锡林浩特市',451:'阿巴嘎旗',452:'苏尼特左旗',453:'苏尼特右旗',454:'东乌珠穆沁旗',455:'西乌珠穆沁旗',456:'太仆寺旗',457:'镶黄旗',458:'正镶白旗',459:'正蓝旗',460:'多伦县'},461:{462:'阿拉善左旗',463:'阿拉善右旗',464:'额济纳旗'},466:{467:'和平区',468:'沈河区',469:'大东区',470:'皇姑区',471:'铁西区',472:'苏家屯区',473:'东陵区',474:'沈北新区',475:'于洪区',476:'辽中县',477:'康平县',478:'法库县',479:'新民市'},480:{481:'中山区',482:'西岗区',483:'沙河口区',484:'甘井子区',485:'旅顺口区',486:'金州区',487:'长海县',488:'瓦房店市',489:'普兰店市',490:'庄河市'},491:{492:'铁东区',493:'铁西区',494:'立山区',495:'千山区',496:'台安县',497:'岫岩满族自治县',498:'海城市'},499:{500:'新抚区',501:'东洲区',502:'望花区',503:'顺城区',504:'抚顺县',505:'新宾满族自治县',506:'清原满族自治县'},507:{508:'平山区',509:'溪湖区',510:'明山区',511:'南芬区',512:'本溪满族自治县',513:'桓仁满族自治县'},514:{515:'元宝区',516:'振兴区',517:'振安区',518:'宽甸满族自治县',519:'东港市',520:'凤城市'},521:{522:'古塔区',523:'凌河区',524:'太和区',525:'黑山县',526:'义　县',527:'凌海市',528:'北镇市'},529:{530:'站前区',531:'西市区',532:'鲅鱼圈区',533:'老边区',534:'盖州市',535:'大石桥市'},536:{537:'海州区',538:'新邱区',539:'太平区',540:'清河门区',541:'细河区',542:'阜新蒙古族自治县',543:'彰武县'},544:{545:'白塔区',546:'文圣区',547:'宏伟区',548:'弓长岭区',549:'太子河区',550:'辽阳县',551:'灯塔市'},552:{553:'双台子区',554:'兴隆台区',555:'大洼县',556:'盘山县'},557:{558:'银州区',559:'清河区',560:'铁岭县',561:'西丰县',562:'昌图县',563:'调兵山市',564:'开原市'},565:{566:'双塔区',567:'龙城区',568:'朝阳县',569:'建平县',570:'喀喇沁左翼蒙古族自治县',571:'北票市',572:'凌源市'},573:{574:'连山区',575:'龙港区',576:'南票区',577:'绥中县',578:'建昌县',579:'兴城市'},581:{582:'南关区',583:'宽城区',584:'朝阳区',585:'二道区',586:'绿园区',587:'双阳区',588:'农安县',589:'九台市',590:'榆树市',591:'德惠市'},592:{593:'昌邑区',594:'龙潭区',595:'船营区',596:'丰满区',597:'永吉县',598:'蛟河市',599:'桦甸市',600:'舒兰市',601:'磐石市'},602:{603:'铁西区',604:'铁东区',605:'梨树县',606:'伊通满族自治县',607:'公主岭市',608:'双辽市'},609:{610:'龙山区',611:'西安区',612:'东丰县',613:'东辽县'},614:{615:'东昌区',616:'二道江区',617:'通化县',618:'辉南县',619:'柳河县',620:'梅河口市',621:'集安市'},622:{623:'八道江区',624:'江源区',625:'抚松县',626:'靖宇县',627:'长白朝鲜族自治县',628:'临江市'},629:{630:'宁江区',631:'前郭尔罗斯蒙古族自治县',632:'长岭县',633:'乾安县',634:'扶余县'},635:{636:'洮北区',637:'镇赉县',638:'通榆县',639:'洮南市',640:'大安市'},641:{642:'延吉市',643:'图们市',644:'敦化市',645:'珲春市',646:'龙井市',647:'和龙市',648:'汪清县',649:'安图县'},651:{652:'道里区',653:'南岗区',654:'道外区',655:'平房区',656:'松北区',657:'香坊区',658:'呼兰区',659:'阿城区',660:'依兰县',661:'方正县',662:'宾　县',663:'巴彦县',664:'木兰县',665:'通河县',666:'延寿县',667:'双城市',668:'尚志市',669:'五常市'},670:{671:'龙沙区',672:'建华区',673:'铁锋区',674:'昂昂溪区',675:'富拉尔基区',676:'碾子山区',677:'梅里斯达斡尔族区',678:'龙江县',679:'依安县',680:'泰来县',681:'甘南县',682:'富裕县',683:'克山县',684:'克东县',685:'拜泉县',686:'讷河市'},687:{688:'鸡冠区',689:'恒山区',690:'滴道区',691:'梨树区',692:'城子河区',693:'麻山区',694:'鸡东县',695:'虎林市',696:'密山市'},697:{698:'向阳区',699:'工农区',700:'南山区',701:'兴安区',702:'东山区',703:'兴山区',704:'萝北县',705:'绥滨县'},706:{707:'尖山区',708:'岭东区',709:'四方台区',710:'宝山区',711:'集贤县',712:'友谊县',713:'宝清县',714:'饶河县'},715:{716:'萨尔图区',717:'龙凤区',718:'让胡路区',719:'红岗区',720:'大同区',721:'肇州县',722:'肇源县',723:'林甸县',724:'杜尔伯特蒙古族自治县'},725:{726:'伊春区',727:'南岔区',728:'友好区',729:'西林区',730:'翠峦区',731:'新青区',732:'美溪区',733:'金山屯区',734:'五营区',735:'乌马河区',736:'汤旺河区',737:'带岭区',738:'乌伊岭区',739:'红星区',740:'上甘岭区',741:'嘉荫县',742:'铁力市'},743:{744:'向阳区',745:'前进区',746:'东风区',747:'郊　区',748:'桦南县',749:'桦川县',750:'汤原县',751:'抚远县',752:'同江市',753:'富锦市'},754:{755:'新兴区',756:'桃山区',757:'茄子河区',758:'勃利县'},759:{760:'东安区',761:'阳明区',762:'爱民区',763:'西安区',764:'东宁县',765:'林口县',766:'绥芬河市',767:'海林市',768:'宁安市',769:'穆棱市'},770:{771:'爱辉区',772:'嫩江县',773:'逊克县',774:'孙吴县',775:'北安市',776:'五大连池市'},777:{778:'北林区',779:'望奎县',780:'兰西县',781:'青冈县',782:'庆安县',783:'明水县',784:'绥棱县',785:'安达市',786:'肇东市',787:'海伦市'},788:{789:'呼玛县',790:'塔河县',791:'漠河县'},812:{813:'玄武区',814:'白下区',815:'秦淮区',816:'建邺区',817:'鼓楼区',818:'下关区',819:'浦口区',820:'栖霞区',821:'雨花台区',822:'江宁区',823:'六合区',824:'溧水县',825:'高淳县'},826:{827:'崇安区',828:'南长区',829:'北塘区',830:'锡山区',831:'惠山区',832:'滨湖区',833:'江阴市',834:'宜兴市'},835:{836:'鼓楼区',837:'云龙区',838:'九里区',839:'贾汪区',840:'泉山区',841:'丰　县',842:'沛　县',843:'铜山县',844:'睢宁县',845:'新沂市',846:'邳州市'},847:{848:'天宁区',849:'钟楼区',850:'戚墅堰区',851:'新北区',852:'武进区',853:'溧阳市',854:'金坛市'},855:{856:'姑苏区',857:'虎丘区',858:'吴中区',859:'相城区',860:'吴江区',861:'常熟市',862:'张家港市',863:'昆山市',864:'太仓市'},865:{866:'崇川区',867:'港闸区',868:'海安县',869:'如东县',870:'启东市',871:'如皋市',872:'通州市',873:'海门市'},874:{875:'连云区',876:'新浦区',877:'海州区',878:'赣榆县',879:'东海县',880:'灌云县',881:'灌南县'},882:{883:'清河区',884:'淮安区',885:'淮阴区',886:'清浦区',887:'涟水县',888:'洪泽县',889:'盱眙县',890:'金湖县'},891:{892:'亭湖区',893:'盐都区',894:'响水县',895:'滨海县',896:'阜宁县',897:'射阳县',898:'建湖县',899:'东台市',900:'大丰市'},901:{902:'广陵区',903:'邗江区',904:'维扬区',905:'宝应县',906:'仪征市',907:'高邮市',908:'江都市'},909:{910:'京口区',911:'润州区',912:'丹徒区',913:'丹阳市',914:'扬中市',915:'句容市'},916:{917:'海陵区',918:'高港区',919:'兴化市',920:'靖江市',921:'泰兴市',922:'姜堰市'},923:{924:'宿城区',925:'宿豫区',926:'沭阳县',927:'泗阳县',928:'泗洪县'},930:{931:'上城区',932:'下城区',933:'江干区',934:'拱墅区',935:'西湖区',936:'滨江区',937:'萧山区',938:'余杭区',939:'桐庐县',940:'淳安县',941:'建德市',942:'富阳市',943:'临安市'},944:{945:'海曙区',946:'江东区',947:'江北区',948:'北仑区',949:'镇海区',950:'鄞州区',951:'象山县',952:'宁海县',953:'余姚市',954:'慈溪市',955:'奉化市'},956:{957:'鹿城区',958:'龙湾区',959:'瓯海区',960:'洞头县',961:'永嘉县',962:'平阳县',963:'苍南县',964:'文成县',965:'泰顺县',966:'瑞安市',967:'乐清市'},968:{969:'南湖区',970:'秀洲区',971:'嘉善县',972:'海盐县',973:'海宁市',974:'平湖市',975:'桐乡市'},976:{977:'吴兴区',978:'南浔区',979:'德清县',980:'长兴县',981:'安吉县'},982:{983:'越城区',984:'绍兴县',985:'新昌县',986:'诸暨市',987:'上虞市',988:'嵊州市'},989:{990:'婺城区',991:'金东区',992:'武义县',993:'浦江县',994:'磐安县',995:'兰溪市',996:'义乌市',997:'东阳市',998:'永康市'},999:{1000:'柯城区',1001:'衢江区',1002:'常山县',1003:'开化县',1004:'龙游县',1005:'江山市'},1006:{1007:'定海区',1008:'普陀区',1009:'岱山县',1010:'嵊泗县'},1011:{1012:'椒江区',1013:'黄岩区',1014:'路桥区',1015:'玉环县',1016:'三门县',1017:'天台县',1018:'仙居县',1019:'温岭市',1020:'临海市'},1021:{1022:'莲都区',1023:'青田县',1024:'缙云县',1025:'遂昌县',1026:'松阳县',1027:'云和县',1028:'庆元县',1029:'景宁畲族自治县',1030:'龙泉市'},1032:{1033:'瑶海区',1034:'庐阳区',1035:'蜀山区',1036:'包河区',1037:'长丰县',1038:'肥东县',1039:'肥西县',1040:'庐江县',1041:'巢湖市'},1042:{1043:'镜湖区',1044:'弋江区',1045:'鸠江区',1046:'三山区',1047:'芜湖县',1048:'繁昌县',1049:'南陵县',1050:'无为县'},1051:{1052:'龙子湖区',1053:'蚌山区',1054:'禹会区',1055:'淮上区',1056:'怀远县',1057:'五河县',1058:'固镇县'},1059:{1060:'大通区',1061:'田家庵区',1062:'谢家集区',1063:'八公山区',1064:'潘集区',1065:'凤台县'},1066:{1067:'花山区',1068:'雨山区',1069:'博望区',1070:'当涂县',1071:'含山县',1072:'和县'},1073:{1074:'杜集区',1075:'相山区',1076:'烈山区',1077:'濉溪县'},1078:{1079:'铜官山区',1080:'狮子山区',1081:'郊　区',1082:'铜陵县'},1083:{1084:'迎江区',1085:'大观区',1086:'宜秀区',1087:'怀宁县',1088:'枞阳县',1089:'潜山县',1090:'太湖县',1091:'宿松县',1092:'望江县',1093:'岳西县',1094:'桐城市'},1095:{1096:'屯溪区',1097:'黄山区',1098:'徽州区',1099:'歙　县',1100:'休宁县',1101:'黟　县',1102:'祁门县'},1103:{1104:'琅琊区',1105:'南谯区',1106:'来安县',1107:'全椒县',1108:'定远县',1109:'凤阳县',1110:'天长市',1111:'明光市'},1112:{1113:'颍州区',1114:'颍东区',1115:'颍泉区',1116:'临泉县',1117:'太和县',1118:'阜南县',1119:'颍上县',1120:'界首市'},1121:{1122:'埇桥区',1123:'砀山县',1124:'萧　县',1125:'灵璧县',1126:'泗　县'},1127:{1128:'金安区',1129:'裕安区',1130:'寿　县',1131:'霍邱县',1132:'舒城县',1133:'金寨县',1134:'霍山县'},1135:{1136:'谯城区',1137:'涡阳县',1138:'蒙城县',1139:'利辛县'},1140:{1141:'贵池区',1142:'东至县',1143:'石台县',1144:'青阳县'},1145:{1146:'宣州区',1147:'郎溪县',1148:'广德县',1149:'泾　县',1150:'绩溪县',1151:'旌德县',1152:'宁国市'},1154:{1155:'鼓楼区',1156:'台江区',1157:'仓山区',1158:'马尾区',1159:'晋安区',1160:'闽侯县',1161:'连江县',1162:'罗源县',1163:'闽清县',1164:'永泰县',1165:'平潭县',1166:'福清市',1167:'长乐市'},1168:{1169:'思明区',1170:'海沧区',1171:'湖里区',1172:'集美区',1173:'同安区',1174:'翔安区'},1175:{1176:'城厢区',1177:'涵江区',1178:'荔城区',1179:'秀屿区',1180:'仙游县'},1181:{1182:'梅列区',1183:'三元区',1184:'明溪县',1185:'清流县',1186:'宁化县',1187:'大田县',1188:'尤溪县',1189:'沙　县',1190:'将乐县',1191:'泰宁县',1192:'建宁县',1193:'永安市'},1194:{1195:'鲤城区',1196:'丰泽区',1197:'洛江区',1198:'泉港区',1199:'惠安县',1200:'安溪县',1201:'永春县',1202:'德化县',1203:'金门县',1204:'石狮市',1205:'晋江市',1206:'南安市'},1207:{1208:'芗城区',1209:'龙文区',1210:'云霄县',1211:'漳浦县',1212:'诏安县',1213:'长泰县',1214:'东山县',1215:'南靖县',1216:'平和县',1217:'华安县',1218:'龙海市'},1219:{1220:'延平区',1221:'顺昌县',1222:'浦城县',1223:'光泽县',1224:'松溪县',1225:'政和县',1226:'邵武市',1227:'武夷山市',1228:'建瓯市',1229:'建阳市'},1230:{1231:'新罗区',1232:'长汀县',1233:'永定县',1234:'上杭县',1235:'武平县',1236:'连城县',1237:'漳平市'},1238:{1239:'蕉城区',1240:'霞浦县',1241:'古田县',1242:'屏南县',1243:'寿宁县',1244:'周宁县',1245:'柘荣县',1246:'福安市',1247:'福鼎市'},1249:{1250:'东湖区',1251:'西湖区',1252:'青云谱区',1253:'湾里区',1254:'青山湖区',1255:'南昌县',1256:'新建县',1257:'安义县',1258:'进贤县'},1259:{1260:'昌江区',1261:'珠山区',1262:'浮梁县',1263:'乐平市'},1264:{1265:'安源区',1266:'湘东区',1267:'莲花县',1268:'上栗县',1269:'芦溪县'},1270:{1271:'庐山区',1272:'浔阳区',1273:'九江县',1274:'武宁县',1275:'修水县',1276:'永修县',1277:'德安县',1278:'星子县',1279:'都昌县',1280:'湖口县',1281:'彭泽县',1282:'瑞昌市'},1283:{1284:'渝水区',1285:'分宜县'},1286:{1287:'月湖区',1288:'余江县',1289:'贵溪市'},1290:{1291:'章贡区',1292:'赣　县',1293:'信丰县',1294:'大余县',1295:'上犹县',1296:'崇义县',1297:'安远县',1298:'龙南县',1299:'定南县',1300:'全南县',1301:'宁都县',1302:'于都县',1303:'兴国县',1304:'会昌县',1305:'寻乌县',1306:'石城县',1307:'瑞金市',1308:'南康市'},1309:{1310:'吉州区',1311:'青原区',1312:'吉安县',1313:'吉水县',1314:'峡江县',1315:'新干县',1316:'永丰县',1317:'泰和县',1318:'遂川县',1319:'万安县',1320:'安福县',1321:'永新县',1322:'井冈山市'},1323:{1324:'袁州区',1325:'奉新县',1326:'万载县',1327:'上高县',1328:'宜丰县',1329:'靖安县',1330:'铜鼓县',1331:'丰城市',1332:'樟树市',1333:'高安市'},1334:{1335:'临川区',1336:'南城县',1337:'黎川县',1338:'南丰县',1339:'崇仁县',1340:'乐安县',1341:'宜黄县',1342:'金溪县',1343:'资溪县',1344:'东乡县',1345:'广昌县'},1346:{1347:'信州区',1348:'上饶县',1349:'广丰县',1350:'玉山县',1351:'铅山县',1352:'横峰县',1353:'弋阳县',1354:'余干县',1355:'鄱阳县',1356:'万年县',1357:'婺源县',1358:'德兴市'},1360:{1361:'历下区',1362:'市中区',1363:'槐荫区',1364:'天桥区',1365:'历城区',1366:'长清区',1367:'平阴县',1368:'济阳县',1369:'商河县',1370:'章丘市'},1371:{1372:'市南区',1373:'市北区',1374:'四方区',1375:'黄岛区',1376:'崂山区',1377:'李沧区',1378:'城阳区',1379:'胶州市',1380:'即墨市',1381:'平度市',1382:'胶南市',1383:'莱西市'},1384:{1385:'淄川区',1386:'张店区',1387:'博山区',1388:'临淄区',1389:'周村区',1390:'桓台县',1391:'高青县',1392:'沂源县'},1393:{1394:'市中区',1395:'薛城区',1396:'峄城区',1397:'台儿庄区',1398:'山亭区',1399:'滕州市'},1400:{1401:'东营区',1402:'河口区',1403:'垦利县',1404:'利津县',1405:'广饶县'},1406:{1407:'芝罘区',1408:'福山区',1409:'牟平区',1410:'莱山区',1411:'长岛县',1412:'龙口市',1413:'莱阳市',1414:'莱州市',1415:'蓬莱市',1416:'招远市',1417:'栖霞市',1418:'海阳市'},1419:{1420:'潍城区',1421:'寒亭区',1422:'坊子区',1423:'奎文区',1424:'临朐县',1425:'昌乐县',1426:'青州市',1427:'诸城市',1428:'寿光市',1429:'安丘市',1430:'高密市',1431:'昌邑市'},1432:{1433:'市中区',1434:'任城区',1435:'微山县',1436:'鱼台县',1437:'金乡县',1438:'嘉祥县',1439:'汶上县',1440:'泗水县',1441:'梁山县',1442:'曲阜市',1443:'兖州市',1444:'邹城市'},1445:{1446:'泰山区',1447:'岱岳区',1448:'宁阳县',1449:'东平县',1450:'新泰市',1451:'肥城市'},1452:{1453:'环翠区',1454:'文登市',1455:'荣成市',1456:'乳山市'},1457:{1458:'东港区',1459:'岚山区',1460:'五莲县',1461:'莒　县'},1462:{1463:'莱城区',1464:'钢城区'},1465:{1466:'兰山区',1467:'罗庄区',1468:'河东区',1469:'沂南县',1470:'郯城县',1471:'沂水县',1472:'苍山县',1473:'费　县',1474:'平邑县',1475:'莒南县',1476:'蒙阴县',1477:'临沭县'},1478:{1479:'德城区',1480:'陵　县',1481:'宁津县',1482:'庆云县',1483:'临邑县',1484:'齐河县',1485:'平原县',1486:'夏津县',1487:'武城县',1488:'乐陵市',1489:'禹城市'},1490:{1491:'东昌府区',1492:'阳谷县',1493:'莘　县',1494:'茌平县',1495:'东阿县',1496:'冠　县',1497:'高唐县',1498:'临清市'},1499:{1500:'滨城区',1501:'惠民县',1502:'阳信县',1503:'无棣县',1504:'沾化县',1505:'博兴县',1506:'邹平县'},1507:{1508:'牡丹区',1509:'曹　县',1510:'单　县',1511:'成武县',1512:'巨野县',1513:'郓城县',1514:'鄄城县',1515:'定陶县',1516:'东明县'},1518:{1519:'中原区',1520:'二七区',1521:'管城回族区',1522:'金水区',1523:'上街区',1524:'惠济区',1525:'中牟县',1526:'巩义市',1527:'荥阳市',1528:'新密市',1529:'新郑市',1530:'登封市'},1531:{1532:'龙亭区',1533:'顺河回族区',1534:'鼓楼区',1535:'禹王台区',1536:'金明区',1537:'杞　县',1538:'通许县',1539:'尉氏县',1540:'开封县',1541:'兰考县'},1542:{1543:'老城区',1544:'西工区',1545:'瀍河回族区',1546:'涧西区',1547:'吉利区',1548:'洛龙区',1549:'孟津县',1550:'新安县',1551:'栾川县',1552:'嵩　县',1553:'汝阳县',1554:'宜阳县',1555:'洛宁县',1556:'伊川县',1557:'偃师市'},1558:{1559:'新华区',1560:'卫东区',1561:'石龙区',1562:'湛河区',1563:'宝丰县',1564:'叶　县',1565:'鲁山县',1566:'郏　县',1567:'舞钢市',1568:'汝州市'},1569:{1570:'文峰区',1571:'北关区',1572:'殷都区',1573:'龙安区',1574:'安阳县',1575:'汤阴县',1576:'滑　县',1577:'内黄县',1578:'林州市'},1579:{1580:'鹤山区',1581:'山城区',1582:'淇滨区',1583:'浚　县',1584:'淇　县'},1585:{1586:'红旗区',1587:'卫滨区',1588:'凤泉区',1589:'牧野区',1590:'新乡县',1591:'获嘉县',1592:'原阳县',1593:'延津县',1594:'封丘县',1595:'长垣县',1596:'卫辉市',1597:'辉县市'},1598:{1599:'解放区',1600:'中站区',1601:'马村区',1602:'山阳区',1603:'修武县',1604:'博爱县',1605:'武陟县',1606:'温　县',1607:'沁阳市',1608:'孟州市'},1609:{1610:'华龙区',1611:'清丰县',1612:'南乐县',1613:'范　县',1614:'台前县',1615:'濮阳县'},1616:{1617:'魏都区',1618:'许昌县',1619:'鄢陵县',1620:'襄城县',1621:'禹州市',1622:'长葛市'},1623:{1624:'源汇区',1625:'郾城区',1626:'召陵区',1627:'舞阳县',1628:'临颍县'},1629:{1630:'湖滨区',1631:'渑池县',1632:'陕　县',1633:'卢氏县',1634:'义马市',1635:'灵宝市'},1636:{1637:'宛城区',1638:'卧龙区',1639:'南召县',1640:'方城县',1641:'西峡县',1642:'镇平县',1643:'内乡县',1644:'淅川县',1645:'社旗县',1646:'唐河县',1647:'新野县',1648:'桐柏县',1649:'邓州市'},1650:{1651:'梁园区',1652:'睢阳区',1653:'民权县',1654:'睢　县',1655:'宁陵县',1656:'柘城县',1657:'虞城县',1658:'夏邑县',1659:'永城市'},1660:{1661:'浉河区',1662:'平桥区',1663:'罗山县',1664:'光山县',1665:'新　县',1666:'商城县',1667:'固始县',1668:'潢川县',1669:'淮滨县',1670:'息　县'},1671:{1672:'川汇区',1673:'扶沟县',1674:'西华县',1675:'商水县',1676:'沈丘县',1677:'郸城县',1678:'淮阳县',1679:'太康县',1680:'鹿邑县',1681:'项城市'},1682:{1683:'驿城区',1684:'西平县',1685:'上蔡县',1686:'平舆县',1687:'正阳县',1688:'确山县',1689:'泌阳县',1690:'汝南县',1691:'遂平县',1692:'新蔡县'},1695:{1696:'江岸区',1697:'江汉区',1698:'硚口区',1699:'汉阳区',1700:'武昌区',1701:'青山区',1702:'洪山区',1703:'东西湖区',1704:'汉南区',1705:'蔡甸区',1706:'江夏区',1707:'黄陂区',1708:'新洲区'},1709:{1710:'黄石港区',1711:'西塞山区',1712:'下陆区',1713:'铁山区',1714:'阳新县',1715:'大冶市'},1716:{1717:'茅箭区',1718:'张湾区',1719:'郧　县',1720:'郧西县',1721:'竹山县',1722:'竹溪县',1723:'房　县',1724:'丹江口市'},1725:{1726:'西陵区',1727:'伍家岗区',1728:'点军区',1729:'猇亭区',1730:'夷陵区',1731:'远安县',1732:'兴山县',1733:'秭归县',1734:'长阳土家族自治县',1735:'五峰土家族自治县',1736:'宜都市',1737:'当阳市',1738:'枝江市'},1739:{1740:'襄城区',1741:'樊城区',1742:'襄州区',1743:'南漳县',1744:'谷城县',1745:'保康县',1746:'老河口市',1747:'枣阳市',1748:'宜城市'},1749:{1750:'梁子湖区',1751:'华容区',1752:'鄂城区'},1753:{1754:'东宝区',1755:'掇刀区',1756:'京山县',1757:'沙洋县',1758:'钟祥市'},1759:{1760:'孝南区',1761:'孝昌县',1762:'大悟县',1763:'云梦县',1764:'应城市',1765:'安陆市',1766:'汉川市'},1767:{1768:'沙市区',1769:'荆州区',1770:'公安县',1771:'监利县',1772:'江陵县',1773:'石首市',1774:'洪湖市',1775:'松滋市'},1776:{1777:'黄州区',1778:'团风县',1779:'红安县',1780:'罗田县',1781:'英山县',1782:'浠水县',1783:'蕲春县',1784:'黄梅县',1785:'麻城市',1786:'武穴市'},1787:{1788:'咸安区',1789:'嘉鱼县',1790:'通城县',1791:'崇阳县',1792:'通山县',1793:'赤壁市'},1794:{1795:'曾都区',1796:'随县',1797:'广水市'},1798:{1799:'恩施市',1800:'利川市',1801:'建始县',1802:'巴东县',1803:'宣恩县',1804:'咸丰县',1805:'来凤县',1806:'鹤峰县'},1812:{1813:'芙蓉区',1814:'天心区',1815:'岳麓区',1816:'开福区',1817:'雨花区',1818:'长沙县',1819:'望城区',1820:'宁乡县',1821:'浏阳市'},1822:{1823:'荷塘区',1824:'芦淞区',1825:'石峰区',1826:'天元区',1827:'株洲县',1828:'攸　县',1829:'茶陵县',1830:'炎陵县',1831:'醴陵市'},1832:{1833:'雨湖区',1834:'岳塘区',1835:'湘潭县',1836:'湘乡市',1837:'韶山市'},1838:{1839:'珠晖区',1840:'雁峰区',1841:'石鼓区',1842:'蒸湘区',1843:'南岳区',1844:'衡阳县',1845:'衡南县',1846:'衡山县',1847:'衡东县',1848:'祁东县',1849:'耒阳市',1850:'常宁市'},1851:{1852:'双清区',1853:'大祥区',1854:'北塔区',1855:'邵东县',1856:'新邵县',1857:'邵阳县',1858:'隆回县',1859:'洞口县',1860:'绥宁县',1861:'新宁县',1862:'城步苗族自治县',1863:'武冈市'},1864:{1865:'岳阳楼区',1866:'云溪区',1867:'君山区',1868:'岳阳县',1869:'华容县',1870:'湘阴县',1871:'平江县',1872:'汨罗市',1873:'临湘市'},1874:{1875:'武陵区',1876:'鼎城区',1877:'安乡县',1878:'汉寿县',1879:'澧　县',1880:'临澧县',1881:'桃源县',1882:'石门县',1883:'津市市'},1884:{1885:'永定区',1886:'武陵源区',1887:'慈利县',1888:'桑植县'},1889:{1890:'资阳区',1891:'赫山区',1892:'南　县',1893:'桃江县',1894:'安化县',1895:'沅江市'},1896:{1897:'北湖区',1898:'苏仙区',1899:'桂阳县',1900:'宜章县',1901:'永兴县',1902:'嘉禾县',1903:'临武县',1904:'汝城县',1905:'桂东县',1906:'安仁县',1907:'资兴市'},1908:{1909:'零陵区',1910:'冷水滩区',1911:'祁阳县',1912:'东安县',1913:'双牌县',1914:'道　县',1915:'江永县',1916:'宁远县',1917:'蓝山县',1918:'新田县',1919:'江华瑶族自治县'},1920:{1921:'鹤城区',1922:'中方县',1923:'沅陵县',1924:'辰溪县',1925:'溆浦县',1926:'会同县',1927:'麻阳苗族自治县',1928:'新晃侗族自治县',1929:'芷江侗族自治县',1930:'靖州苗族侗族自治县',1931:'通道侗族自治县',1932:'洪江市'},1933:{1934:'娄星区',1935:'双峰县',1936:'新化县',1937:'冷水江市',1938:'涟源市'},1939:{1940:'吉首市',1941:'泸溪县',1942:'凤凰县',1943:'花垣县',1944:'保靖县',1945:'古丈县',1946:'永顺县',1947:'龙山县'},1949:{1950:'荔湾区',1951:'越秀区',1952:'海珠区',1953:'天河区',1954:'白云区',1955:'黄埔区',1956:'番禺区',1957:'花都区',1958:'南沙区',1959:'萝岗区',1960:'增城市',1961:'从化市'},1962:{1963:'武江区',1964:'浈江区',1965:'曲江区',1966:'始兴县',1967:'仁化县',1968:'翁源县',1969:'乳源瑶族自治县',1970:'新丰县',1971:'乐昌市',1972:'南雄市'},1973:{1974:'罗湖区',1975:'福田区',1976:'南山区',1977:'宝安区',1978:'龙岗区',1979:'盐田区'},1980:{1981:'香洲区',1982:'斗门区',1983:'金湾区'},1984:{1985:'龙湖区',1986:'金平区',1987:'濠江区',1988:'潮阳区',1989:'潮南区',1990:'澄海区',1991:'南澳县'},1992:{1993:'禅城区',1994:'南海区',1995:'顺德区',1996:'三水区',1997:'高明区'},1998:{1999:'蓬江区',2000:'江海区',2001:'新会区',2002:'台山市',2003:'开平市',2004:'鹤山市',2005:'恩平市'},2006:{2007:'赤坎区',2008:'霞山区',2009:'坡头区',2010:'麻章区',2011:'遂溪县',2012:'徐闻县',2013:'廉江市',2014:'雷州市',2015:'吴川市'},2016:{2017:'茂南区',2018:'茂港区',2019:'电白县',2020:'高州市',2021:'化州市',2022:'信宜市'},2023:{2024:'端州区',2025:'鼎湖区',2026:'广宁县',2027:'怀集县',2028:'封开县',2029:'德庆县',2030:'高要市',2031:'四会市'},2032:{2033:'惠城区',2034:'惠阳区',2035:'博罗县',2036:'惠东县',2037:'龙门县'},2038:{2039:'梅江区',2040:'梅　县',2041:'大埔县',2042:'丰顺县',2043:'五华县',2044:'平远县',2045:'蕉岭县',2046:'兴宁市'},2047:{2048:'城　区',2049:'海丰县',2050:'陆河县',2051:'陆丰市'},2052:{2053:'源城区',2054:'紫金县',2055:'龙川县',2056:'连平县',2057:'和平县',2058:'东源县'},2059:{2060:'江城区',2061:'阳西县',2062:'阳东县',2063:'阳春市'},2064:{2065:'清城区',2066:'佛冈县',2067:'阳山县',2068:'连山壮族瑶族自治县',2069:'连南瑶族自治县',2070:'清新县',2071:'英德市',2072:'连州市'},2073:{2074:'东莞市'},2075:{2076:'中山市'},2077:{2078:'湘桥区',2079:'潮安县',2080:'饶平县'},2081:{2082:'榕城区',2083:'揭东县',2084:'揭西县',2085:'惠来县',2086:'普宁市'},2087:{2088:'云城区',2089:'新兴县',2090:'郁南县',2091:'云安县',2092:'罗定市'},2094:{2095:'兴宁区',2096:'青秀区',2097:'江南区',2098:'西乡塘区',2099:'良庆区',2100:'邕宁区',2101:'武鸣县',2102:'隆安县',2103:'马山县',2104:'上林县',2105:'宾阳县',2106:'横　县'},2107:{2108:'城中区',2109:'鱼峰区',2110:'柳南区',2111:'柳北区',2112:'柳江县',2113:'柳城县',2114:'鹿寨县',2115:'融安县',2116:'融水苗族自治县',2117:'三江侗族自治县'},2118:{2119:'秀峰区',2120:'叠彩区',2121:'象山区',2122:'七星区',2123:'雁山区',2124:'阳朔县',2125:'临桂县',2126:'灵川县',2127:'全州县',2128:'兴安县',2129:'永福县',2130:'灌阳县',2131:'龙胜各族自治县',2132:'资源县',2133:'平乐县',2134:'荔浦县',2135:'恭城瑶族自治县'},2136:{2137:'万秀区',2138:'蝶山区',2139:'长洲区',2140:'苍梧县',2141:'藤　县',2142:'蒙山县',2143:'岑溪市'},2144:{2145:'海城区',2146:'银海区',2147:'铁山港区',2148:'合浦县'},2149:{2150:'港口区',2151:'防城区',2152:'上思县',2153:'东兴市'},2154:{2155:'钦南区',2156:'钦北区',2157:'灵山县',2158:'浦北县'},2159:{2160:'港北区',2161:'港南区',2162:'覃塘区',2163:'平南县',2164:'桂平市'},2165:{2166:'玉州区',2167:'容　县',2168:'陆川县',2169:'博白县',2170:'兴业县',2171:'北流市'},2172:{2173:'右江区',2174:'田阳县',2175:'田东县',2176:'平果县',2177:'德保县',2178:'靖西县',2179:'那坡县',2180:'凌云县',2181:'乐业县',2182:'田林县',2183:'西林县',2184:'隆林各族自治县'},2185:{2186:'八步区',2187:'昭平县',2188:'钟山县',2189:'富川瑶族自治县'},2190:{2191:'金城江区',2192:'南丹县',2193:'天峨县',2194:'凤山县',2195:'东兰县',2196:'罗城仫佬族自治县',2197:'环江毛南族自治县',2198:'巴马瑶族自治县',2199:'都安瑶族自治县',2200:'大化瑶族自治县',2201:'宜州市'},2202:{2203:'兴宾区',2204:'忻城县',2205:'象州县',2206:'武宣县',2207:'金秀瑶族自治县',2208:'合山市'},2209:{2210:'江洲区',2211:'扶绥县',2212:'宁明县',2213:'龙州县',2214:'大新县',2215:'天等县',2216:'凭祥市'},2218:{2219:'秀英区',2220:'龙华区',2221:'琼山区',2222:'美兰区'},2284:{2285:'锦江区',2286:'青羊区',2287:'金牛区',2288:'武侯区',2289:'成华区',2290:'龙泉驿区',2291:'青白江区',2292:'新都区',2293:'温江区',2294:'金堂县',2295:'双流县',2296:'郫　县',2297:'大邑县',2298:'蒲江县',2299:'新津县',2300:'都江堰市',2301:'彭州市',2302:'邛崃市',2303:'崇州市'},2304:{2305:'自流井区',2306:'贡井区',2307:'大安区',2308:'沿滩区',2309:'荣　县',2310:'富顺县'},2311:{2312:'东　区',2313:'西　区',2314:'仁和区',2315:'米易县',2316:'盐边县'},2317:{2318:'江阳区',2319:'纳溪区',2320:'龙马潭区',2321:'泸　县',2322:'合江县',2323:'叙永县',2324:'古蔺县'},2325:{2326:'旌阳区',2327:'中江县',2328:'罗江县',2329:'广汉市',2330:'什邡市',2331:'绵竹市'},2332:{2333:'涪城区',2334:'游仙区',2335:'三台县',2336:'盐亭县',2337:'安　县',2338:'梓潼县',2339:'北川羌族自治县',2340:'平武县',2341:'江油市'},2342:{2343:'市中区',2344:'元坝区',2345:'朝天区',2346:'旺苍县',2347:'青川县',2348:'剑阁县',2349:'苍溪县'},2350:{2351:'船山区',2352:'安居区',2353:'蓬溪县',2354:'射洪县',2355:'大英县'},2356:{2357:'市中区',2358:'东兴区',2359:'威远县',2360:'资中县',2361:'隆昌县'},2362:{2363:'市中区',2364:'沙湾区',2365:'五通桥区',2366:'金口河区',2367:'犍为县',2368:'井研县',2369:'夹江县',2370:'沐川县',2371:'峨边彝族自治县',2372:'马边彝族自治县',2373:'峨眉山市'},2374:{2375:'顺庆区',2376:'高坪区',2377:'嘉陵区',2378:'南部县',2379:'营山县',2380:'蓬安县',2381:'仪陇县',2382:'西充县',2383:'阆中市'},2384:{2385:'东坡区',2386:'仁寿县',2387:'彭山县',2388:'洪雅县',2389:'丹棱县',2390:'青神县'},2391:{2392:'翠屏区',2393:'宜宾县',2394:'南溪县',2395:'江安县',2396:'长宁县',2397:'高　县',2398:'珙　县',2399:'筠连县',2400:'兴文县',2401:'屏山县'},2402:{2403:'广安区',2404:'岳池县',2405:'武胜县',2406:'邻水县',2407:'华蓥市'},2408:{2409:'通川区',2410:'达　县',2411:'宣汉县',2412:'开江县',2413:'大竹县',2414:'渠　县',2415:'万源市'},2416:{2417:'雨城区',2418:'名山县',2419:'荥经县',2420:'汉源县',2421:'石棉县',2422:'天全县',2423:'芦山县',2424:'宝兴县'},2425:{2426:'巴州区',2427:'通江县',2428:'南江县',2429:'平昌县'},2430:{2431:'雁江区',2432:'安岳县',2433:'乐至县',2434:'简阳市'},2435:{2436:'汶川县',2437:'理　县',2438:'茂　县',2439:'松潘县',2440:'九寨沟县',2441:'金川县',2442:'小金县',2443:'黑水县',2444:'马尔康县',2445:'壤塘县',2446:'阿坝县',2447:'若尔盖县',2448:'红原县'},2449:{2450:'康定县',2451:'泸定县',2452:'丹巴县',2453:'九龙县',2454:'雅江县',2455:'道孚县',2456:'炉霍县',2457:'甘孜县',2458:'新龙县',2459:'德格县',2460:'白玉县',2461:'石渠县',2462:'色达县',2463:'理塘县',2464:'巴塘县',2465:'乡城县',2466:'稻城县',2467:'得荣县'},2468:{2469:'西昌市',2470:'木里藏族自治县',2471:'盐源县',2472:'德昌县',2473:'会理县',2474:'会东县',2475:'宁南县',2476:'普格县',2477:'布拖县',2478:'金阳县',2479:'昭觉县',2480:'喜德县',2481:'冕宁县',2482:'越西县',2483:'甘洛县',2484:'美姑县',2485:'雷波县'},2487:{2488:'南明区',2489:'云岩区',2490:'花溪区',2491:'乌当区',2492:'白云区',2493:'小河区',2494:'开阳县',2495:'息烽县',2496:'修文县',2497:'清镇市'},2498:{2499:'钟山区',2500:'六枝特区',2501:'水城县',2502:'盘　县'},2503:{2504:'红花岗区',2505:'汇川区',2506:'遵义县',2507:'桐梓县',2508:'绥阳县',2509:'正安县',2510:'道真仡佬族苗族自治县',2511:'务川仡佬族苗族自治县',2512:'凤冈县',2513:'湄潭县',2514:'余庆县',2515:'习水县',2516:'赤水市',2517:'仁怀市'},2518:{2519:'西秀区',2520:'平坝县',2521:'普定县',2522:'镇宁布依族苗族自治县',2523:'关岭布依族苗族自治县',2524:'紫云苗族布依族自治县'},2525:{2526:'铜仁市',2527:'江口县',2528:'玉屏侗族自治县',2529:'石阡县',2530:'思南县',2531:'印江土家族苗族自治县',2532:'德江县',2533:'沿河土家族自治县',2534:'松桃苗族自治县',2535:'万山特区'},2536:{2537:'兴义市',2538:'兴仁县',2539:'普安县',2540:'晴隆县',2541:'贞丰县',2542:'望谟县',2543:'册亨县',2544:'安龙县'},2545:{2546:'毕节市',2547:'大方县',2548:'黔西县',2549:'金沙县',2550:'织金县',2551:'纳雍县',2552:'威宁彝族回族苗族自治县',2553:'赫章县'},2554:{2555:'凯里市',2556:'黄平县',2557:'施秉县',2558:'三穗县',2559:'镇远县',2560:'岑巩县',2561:'天柱县',2562:'锦屏县',2563:'剑河县',2564:'台江县',2565:'黎平县',2566:'榕江县',2567:'从江县',2568:'雷山县',2569:'麻江县',2570:'丹寨县'},2571:{2572:'都匀市',2573:'福泉市',2574:'荔波县',2575:'贵定县',2576:'瓮安县',2577:'独山县',2578:'平塘县',2579:'罗甸县',2580:'长顺县',2581:'龙里县',2582:'惠水县',2583:'三都水族自治县'},2585:{2586:'五华区',2587:'盘龙区',2588:'官渡区',2589:'西山区',2590:'东川区',2591:'呈贡县',2592:'晋宁县',2593:'富民县',2594:'宜良县',2595:'石林彝族自治县',2596:'嵩明县',2597:'禄劝彝族苗族自治县',2598:'寻甸回族彝族自治县',2599:'安宁市'},2600:{2601:'麒麟区',2602:'马龙县',2603:'陆良县',2604:'师宗县',2605:'罗平县',2606:'富源县',2607:'会泽县',2608:'沾益县',2609:'宣威市'},2610:{2611:'红塔区',2612:'江川县',2613:'澄江县',2614:'通海县',2615:'华宁县',2616:'易门县',2617:'峨山彝族自治县',2618:'新平彝族傣族自治县',2619:'元江哈尼族彝族傣族自治县'},2620:{2621:'隆阳区',2622:'施甸县',2623:'腾冲县',2624:'龙陵县',2625:'昌宁县'},2626:{2627:'昭阳区',2628:'鲁甸县',2629:'巧家县',2630:'盐津县',2631:'大关县',2632:'永善县',2633:'绥江县',2634:'镇雄县',2635:'彝良县',2636:'威信县',2637:'水富县'},2638:{2639:'古城区',2640:'玉龙纳西族自治县',2641:'永胜县',2642:'华坪县',2643:'宁蒗彝族自治县'},2644:{2645:'思茅区',2646:'宁洱哈尼族彝族自治县',2647:'墨江哈尼族自治县',2648:'景东彝族自治县',2649:'景谷傣族彝族自治县',2650:'镇沅彝族哈尼族拉祜族自治县',2651:'江城哈尼族彝族自治县',2652:'孟连傣族拉祜族佤族自治县',2653:'澜沧拉祜族自治县',2654:'西盟佤族自治县'},2655:{2656:'临翔区',2657:'凤庆县',2658:'云　县',2659:'永德县',2660:'镇康县',2661:'双江拉祜族佤族布朗族傣族自治县',2662:'耿马傣族佤族自治县',2663:'沧源佤族自治县'},2664:{2665:'楚雄市',2666:'双柏县',2667:'牟定县',2668:'南华县',2669:'姚安县',2670:'大姚县',2671:'永仁县',2672:'元谋县',2673:'武定县',2674:'禄丰县'},2675:{2676:'个旧市',2677:'开远市',2678:'蒙自县',2679:'屏边苗族自治县',2680:'建水县',2681:'石屏县',2682:'弥勒县',2683:'泸西县',2684:'元阳县',2685:'红河县',2686:'金平苗族瑶族傣族自治县',2687:'绿春县',2688:'河口瑶族自治县'},2689:{2690:'文山县',2691:'砚山县',2692:'西畴县',2693:'麻栗坡县',2694:'马关县',2695:'丘北县',2696:'广南县',2697:'富宁县'},2698:{2699:'景洪市',2700:'勐海县',2701:'勐腊县'},2702:{2703:'大理市',2704:'漾濞彝族自治县',2705:'祥云县',2706:'宾川县',2707:'弥渡县',2708:'南涧彝族自治县',2709:'巍山彝族回族自治县',2710:'永平县',2711:'云龙县',2712:'洱源县',2713:'剑川县',2714:'鹤庆县'},2715:{2716:'瑞丽市',2717:'潞西市',2718:'梁河县',2719:'盈江县',2720:'陇川县'},2721:{2722:'泸水县',2723:'福贡县',2724:'贡山独龙族怒族自治县',2725:'兰坪白族普米族自治县'},2726:{2727:'香格里拉县',2728:'德钦县',2729:'维西傈僳族自治县'},2731:{2732:'城关区',2733:'林周县',2734:'当雄县',2735:'尼木县',2736:'曲水县',2737:'堆龙德庆县',2738:'达孜县',2739:'墨竹工卡县'},2740:{2741:'昌都县',2742:'江达县',2743:'贡觉县',2744:'类乌齐县',2745:'丁青县',2746:'察雅县',2747:'八宿县',2748:'左贡县',2749:'芒康县',2750:'洛隆县',2751:'边坝县'},2752:{2753:'乃东县',2754:'扎囊县',2755:'贡嘎县',2756:'桑日县',2757:'琼结县',2758:'曲松县',2759:'措美县',2760:'洛扎县',2761:'加查县',2762:'隆子县',2763:'错那县',2764:'浪卡子县'},2765:{2766:'日喀则市',2767:'南木林县',2768:'江孜县',2769:'定日县',2770:'萨迦县',2771:'拉孜县',2772:'昂仁县',2773:'谢通门县',2774:'白朗县',2775:'仁布县',2776:'康马县',2777:'定结县',2778:'仲巴县',2779:'亚东县',2780:'吉隆县',2781:'聂拉木县',2782:'萨嘎县',2783:'岗巴县'},2784:{2785:'那曲县',2786:'嘉黎县',2787:'比如县',2788:'聂荣县',2789:'安多县',2790:'申扎县',2791:'索　县',2792:'班戈县',2793:'巴青县',2794:'尼玛县'},2795:{2796:'普兰县',2797:'札达县',2798:'噶尔县',2799:'日土县',2800:'革吉县',2801:'改则县',2802:'措勤县'},2803:{2804:'林芝县',2805:'工布江达县',2806:'米林县',2807:'墨脱县',2808:'波密县',2809:'察隅县',2810:'朗　县'},2812:{2813:'新城区',2814:'碑林区',2815:'莲湖区',2816:'灞桥区',2817:'未央区',2818:'雁塔区',2819:'阎良区',2820:'临潼区',2821:'长安区',2822:'蓝田县',2823:'周至县',2824:'户　县',2825:'高陵县'},2826:{2827:'王益区',2828:'印台区',2829:'耀州区',2830:'宜君县'},2831:{2832:'渭滨区',2833:'金台区',2834:'陈仓区',2835:'凤翔县',2836:'岐山县',2837:'扶风县',2838:'眉　县',2839:'陇　县',2840:'千阳县',2841:'麟游县',2842:'凤　县',2843:'太白县'},2844:{2845:'秦都区',2846:'杨凌区',2847:'渭城区',2848:'三原县',2849:'泾阳县',2850:'乾　县',2851:'礼泉县',2852:'永寿县',2853:'彬　县',2854:'长武县',2855:'旬邑县',2856:'淳化县',2857:'武功县',2858:'兴平市'},2859:{2860:'临渭区',2861:'华　县',2862:'潼关县',2863:'大荔县',2864:'合阳县',2865:'澄城县',2866:'蒲城县',2867:'白水县',2868:'富平县',2869:'韩城市',2870:'华阴市'},2871:{2872:'宝塔区',2873:'延长县',2874:'延川县',2875:'子长县',2876:'安塞县',2877:'志丹县',2878:'吴起县',2879:'甘泉县',2880:'富　县',2881:'洛川县',2882:'宜川县',2883:'黄龙县',2884:'黄陵县'},2885:{2886:'汉台区',2887:'南郑县',2888:'城固县',2889:'洋　县',2890:'西乡县',2891:'勉　县',2892:'宁强县',2893:'略阳县',2894:'镇巴县',2895:'留坝县',2896:'佛坪县'},2897:{2898:'榆阳区',2899:'神木县',2900:'府谷县',2901:'横山县',2902:'靖边县',2903:'定边县',2904:'绥德县',2905:'米脂县',2906:'佳　县',2907:'吴堡县',2908:'清涧县',2909:'子洲县'},2910:{2911:'汉滨区',2912:'汉阴县',2913:'石泉县',2914:'宁陕县',2915:'紫阳县',2916:'岚皋县',2917:'平利县',2918:'镇坪县',2919:'旬阳县',2920:'白河县'},2921:{2922:'商州区',2923:'洛南县',2924:'丹凤县',2925:'商南县',2926:'山阳县',2927:'镇安县',2928:'柞水县'},2930:{2931:'城关区',2932:'七里河区',2933:'西固区',2934:'安宁区',2935:'红古区',2936:'永登县',2937:'皋兰县',2938:'榆中县'},2939:{2940:'嘉峪关市'},2941:{2942:'金川区',2943:'永昌县'},2944:{2945:'白银区',2946:'平川区',2947:'靖远县',2948:'会宁县',2949:'景泰县'},2950:{2951:'秦州区',2952:'麦积区',2953:'清水县',2954:'秦安县',2955:'甘谷县',2956:'武山县',2957:'张家川回族自治县'},2958:{2959:'凉州区',2960:'民勤县',2961:'古浪县',2962:'天祝藏族自治县'},2963:{2964:'甘州区',2965:'肃南裕固族自治县',2966:'民乐县',2967:'临泽县',2968:'高台县',2969:'山丹县'},2970:{2971:'崆峒区',2972:'泾川县',2973:'灵台县',2974:'崇信县',2975:'华亭县',2976:'庄浪县',2977:'静宁县'},2978:{2979:'肃州区',2980:'金塔县',2981:'瓜州县',2982:'肃北蒙古族自治县',2983:'阿克塞哈萨克族自治县',2984:'玉门市',2985:'敦煌市'},2986:{2987:'西峰区',2988:'庆城县',2989:'环　县',2990:'华池县',2991:'合水县',2992:'正宁县',2993:'宁　县',2994:'镇原县'},2995:{2996:'安定区',2997:'通渭县',2998:'陇西县',2999:'渭源县',3000:'临洮县',3001:'漳　县',3002:'岷　县'},3003:{3004:'武都区',3005:'成　县',3006:'文　县',3007:'宕昌县',3008:'康　县',3009:'西和县',3010:'礼　县',3011:'徽　县',3012:'两当县'},3013:{3014:'临夏市',3015:'临夏县',3016:'康乐县',3017:'永靖县',3018:'广河县',3019:'和政县',3020:'东乡族自治县',3021:'积石山保安族东乡族撒拉族自治县'},3022:{3023:'合作市',3024:'临潭县',3025:'卓尼县',3026:'舟曲县',3027:'迭部县',3028:'玛曲县',3029:'碌曲县',3030:'夏河县'},3032:{3033:'城东区',3034:'城中区',3035:'城西区',3036:'城北区',3037:'大通回族土族自治县',3038:'湟中县',3039:'湟源县'},3040:{3041:'平安县',3042:'民和回族土族自治县',3043:'乐都县',3044:'互助土族自治县',3045:'化隆回族自治县',3046:'循化撒拉族自治县'},3047:{3048:'门源回族自治县',3049:'祁连县',3050:'海晏县',3051:'刚察县'},3052:{3053:'同仁县',3054:'尖扎县',3055:'泽库县',3056:'河南蒙古族自治县'},3057:{3058:'共和县',3059:'同德县',3060:'贵德县',3061:'兴海县',3062:'贵南县'},3063:{3064:'玛沁县',3065:'班玛县',3066:'甘德县',3067:'达日县',3068:'久治县',3069:'玛多县'},3070:{3071:'玉树县',3072:'杂多县',3073:'称多县',3074:'治多县',3075:'囊谦县',3076:'曲麻莱县'},3077:{3078:'格尔木市',3079:'德令哈市',3080:'乌兰县',3081:'都兰县',3082:'天峻县'},3084:{3085:'兴庆区',3086:'西夏区',3087:'金凤区',3088:'永宁县',3089:'贺兰县',3090:'灵武市'},3091:{3092:'大武口区',3093:'惠农区',3094:'平罗县'},3095:{3096:'利通区',3097:'红寺堡区',3098:'盐池县',3099:'同心县',3100:'青铜峡市'},3101:{3102:'原州区',3103:'西吉县',3104:'隆德县',3105:'泾源县',3106:'彭阳县'},3107:{3108:'沙坡头区',3109:'中宁县',3110:'海原县'},3112:{3113:'天山区',3114:'沙依巴克区',3115:'新市区',3116:'水磨沟区',3117:'头屯河区',3118:'达坂城区',3119:'米东区',3120:'乌鲁木齐县'},3121:{3122:'独山子区',3123:'克拉玛依区',3124:'白碱滩区',3125:'乌尔禾区'},3126:{3127:'吐鲁番市',3128:'鄯善县',3129:'托克逊县'},3130:{3131:'哈密市',3132:'巴里坤哈萨克自治县',3133:'伊吾县'},3134:{3135:'昌吉市',3136:'阜康市',3137:'呼图壁县',3138:'玛纳斯县',3139:'奇台县',3140:'吉木萨尔县',3141:'木垒哈萨克自治县'},3142:{3143:'博乐市',3144:'精河县',3145:'温泉县'},3146:{3147:'库尔勒市',3148:'轮台县',3149:'尉犁县',3150:'若羌县',3151:'且末县',3152:'焉耆回族自治县',3153:'和静县',3154:'和硕县',3155:'博湖县'},3156:{3157:'阿克苏市',3158:'温宿县',3159:'库车县',3160:'沙雅县',3161:'新和县',3162:'拜城��',3163:'乌什县',3164:'阿瓦提县',3165:'柯坪县'},3166:{3167:'阿图什市',3168:'阿克陶县',3169:'阿合奇县',3170:'乌恰县'},3171:{3172:'喀什市',3173:'疏附县',3174:'疏勒县',3175:'英吉沙县',3176:'泽普县',3177:'莎车县',3178:'叶城县',3179:'麦盖提县',3180:'岳普湖县',3181:'伽师县',3182:'巴楚县',3183:'塔什库尔干塔吉克自治县'},3184:{3185:'和田市',3186:'和田县',3187:'墨玉县',3188:'皮山县',3189:'洛浦县',3190:'策勒县',3191:'于田县',3192:'民丰县'},3193:{3194:'伊宁市',3195:'奎屯市',3196:'伊宁县',3197:'察布查尔锡伯自治县',3198:'霍城县',3199:'巩留县',3200:'新源县',3201:'昭苏县',3202:'特克斯县',3203:'尼勒克县'},3204:{3205:'塔城市',3206:'乌苏市',3207:'额敏县',3208:'沙湾县',3209:'托里县',3210:'裕民县',3211:'和布克赛尔蒙古自治县'},3212:{3213:'阿勒泰市',3214:'布尔津县',3215:'富蕴县',3216:'福海县',3217:'哈巴河县',3218:'青河县',3219:'吉木乃县'}  };

  if (typeof window !== 'undefined') {
    window.ChineseDistricts = ChineseDistricts;
  }

  return ChineseDistricts;

});