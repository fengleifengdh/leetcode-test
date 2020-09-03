import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Twest {

    public static void main(String[] args) {

        String str = "{\n" +
                "    \"15\":{\n" +
                "        \"440100\":[\n" +
                "            {\n" +
                "                \"areaCode\":440103,\n" +
                "                \"areaName\":\"荔湾区\",\n" +
                "                \"areaNameAbbr\":\"荔湾\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440104,\n" +
                "                \"areaName\":\"越秀区\",\n" +
                "                \"areaNameAbbr\":\"越秀\",\n" +
                "                \"areaNameInitial\":\"Y\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440105,\n" +
                "                \"areaName\":\"海珠区\",\n" +
                "                \"areaNameAbbr\":\"海珠\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440106,\n" +
                "                \"areaName\":\"天河区\",\n" +
                "                \"areaNameAbbr\":\"天河\",\n" +
                "                \"areaNameInitial\":\"T\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440111,\n" +
                "                \"areaName\":\"白云区\",\n" +
                "                \"areaNameAbbr\":\"白云\",\n" +
                "                \"areaNameInitial\":\"B\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440112,\n" +
                "                \"areaName\":\"黄埔区\",\n" +
                "                \"areaNameAbbr\":\"黄埔\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440113,\n" +
                "                \"areaName\":\"番禺区\",\n" +
                "                \"areaNameAbbr\":\"番禺\",\n" +
                "                \"areaNameInitial\":\"F\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440114,\n" +
                "                \"areaName\":\"花都区\",\n" +
                "                \"areaNameAbbr\":\"花都\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440115,\n" +
                "                \"areaName\":\"南沙新区\",\n" +
                "                \"areaNameAbbr\":\"南沙\",\n" +
                "                \"areaNameInitial\":\"N\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":440118,\n" +
                "                \"areaName\":\"增城区\",\n" +
                "                \"areaNameAbbr\":\"增城\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"17\":{\n" +
                "        \"210100\":[\n" +
                "            {\n" +
                "                \"areaCode\":210102,\n" +
                "                \"areaName\":\"和平区\",\n" +
                "                \"areaNameAbbr\":\"和平\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210103,\n" +
                "                \"areaName\":\"沈河区\",\n" +
                "                \"areaNameAbbr\":\"沈河\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210104,\n" +
                "                \"areaName\":\"大东区\",\n" +
                "                \"areaNameAbbr\":\"大东\",\n" +
                "                \"areaNameInitial\":\"D\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210105,\n" +
                "                \"areaName\":\"皇姑区\",\n" +
                "                \"areaNameAbbr\":\"皇姑\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210106,\n" +
                "                \"areaName\":\"铁西区\",\n" +
                "                \"areaNameAbbr\":\"铁西\",\n" +
                "                \"areaNameInitial\":\"T\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210111,\n" +
                "                \"areaName\":\"苏家屯区\",\n" +
                "                \"areaNameAbbr\":\"苏家屯\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210112,\n" +
                "                \"areaName\":\"浑南新区\",\n" +
                "                \"areaNameAbbr\":\"浑南新区\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210113,\n" +
                "                \"areaName\":\"沈北新区\",\n" +
                "                \"areaNameAbbr\":\"沈北新区\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210114,\n" +
                "                \"areaName\":\"于洪区\",\n" +
                "                \"areaNameAbbr\":\"于洪\",\n" +
                "                \"areaNameInitial\":\"Y\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"210200\":[\n" +
                "            {\n" +
                "                \"areaCode\":210202,\n" +
                "                \"areaName\":\"中山区\",\n" +
                "                \"areaNameAbbr\":\"中山\",\n" +
                "                \"areaNameInitial\":\"z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210203,\n" +
                "                \"areaName\":\"西岗区\",\n" +
                "                \"areaNameAbbr\":\"西岗\",\n" +
                "                \"areaNameInitial\":\"X\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210204,\n" +
                "                \"areaName\":\"沙河口区\",\n" +
                "                \"areaNameAbbr\":\"沙河口\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":210211,\n" +
                "                \"areaName\":\"甘井子区\",\n" +
                "                \"areaNameAbbr\":\"甘井子\",\n" +
                "                \"areaNameInitial\":\"G\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"230100\":[\n" +
                "            {\n" +
                "                \"areaCode\":230102,\n" +
                "                \"areaName\":\"道里区\",\n" +
                "                \"areaNameAbbr\":\"道里\",\n" +
                "                \"areaNameInitial\":\"D\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230103,\n" +
                "                \"areaName\":\"南岗区\",\n" +
                "                \"areaNameAbbr\":\"南岗\",\n" +
                "                \"areaNameInitial\":\"N\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230104,\n" +
                "                \"areaName\":\"道外区\",\n" +
                "                \"areaNameAbbr\":\"道外\",\n" +
                "                \"areaNameInitial\":\"D\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230108,\n" +
                "                \"areaName\":\"平房区\",\n" +
                "                \"areaNameAbbr\":\"平房\",\n" +
                "                \"areaNameInitial\":\"P\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230109,\n" +
                "                \"areaName\":\"松北区\",\n" +
                "                \"areaNameAbbr\":\"松北\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230110,\n" +
                "                \"areaName\":\"香坊区\",\n" +
                "                \"areaNameAbbr\":\"香坊\",\n" +
                "                \"areaNameInitial\":\"X\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230111,\n" +
                "                \"areaName\":\"呼兰区\",\n" +
                "                \"areaNameAbbr\":\"呼兰\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230112,\n" +
                "                \"areaName\":\"阿城区\",\n" +
                "                \"areaNameAbbr\":\"阿城\",\n" +
                "                \"areaNameInitial\":\"A\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":230113,\n" +
                "                \"areaName\":\"双城区\",\n" +
                "                \"areaNameAbbr\":\"双城\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"500100\":[\n" +
                "            {\n" +
                "                \"areaCode\":500102,\n" +
                "                \"areaName\":\"涪陵区\",\n" +
                "                \"areaNameAbbr\":\"涪陵\",\n" +
                "                \"areaNameInitial\":\"F\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500103,\n" +
                "                \"areaName\":\"渝中区\",\n" +
                "                \"areaNameAbbr\":\"渝中\",\n" +
                "                \"areaNameInitial\":\"Y\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500104,\n" +
                "                \"areaName\":\"大渡口区\",\n" +
                "                \"areaNameAbbr\":\"大渡口\",\n" +
                "                \"areaNameInitial\":\"D\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500105,\n" +
                "                \"areaName\":\"江北区\",\n" +
                "                \"areaNameAbbr\":\"江北\",\n" +
                "                \"areaNameInitial\":\"J\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500106,\n" +
                "                \"areaName\":\"沙坪坝区\",\n" +
                "                \"areaNameAbbr\":\"沙坪坝\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500107,\n" +
                "                \"areaName\":\"九龙坡区\",\n" +
                "                \"areaNameAbbr\":\"九龙坡\",\n" +
                "                \"areaNameInitial\":\"J\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500108,\n" +
                "                \"areaName\":\"南岸区\",\n" +
                "                \"areaNameAbbr\":\"南岸\",\n" +
                "                \"areaNameInitial\":\"N\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500109,\n" +
                "                \"areaName\":\"北碚区\",\n" +
                "                \"areaNameAbbr\":\"北碚\",\n" +
                "                \"areaNameInitial\":\"B\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500111,\n" +
                "                \"areaName\":\"大足区\",\n" +
                "                \"areaNameAbbr\":\"大足\",\n" +
                "                \"areaNameInitial\":\"D\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500112,\n" +
                "                \"areaName\":\"渝北区\",\n" +
                "                \"areaNameAbbr\":\"渝北\",\n" +
                "                \"areaNameInitial\":\"Y\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500113,\n" +
                "                \"areaName\":\"巴南区\",\n" +
                "                \"areaNameAbbr\":\"巴南\",\n" +
                "                \"areaNameInitial\":\"B\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500115,\n" +
                "                \"areaName\":\"长寿区\",\n" +
                "                \"areaNameAbbr\":\"长寿\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500116,\n" +
                "                \"areaName\":\"江津区\",\n" +
                "                \"areaNameAbbr\":\"江津\",\n" +
                "                \"areaNameInitial\":\"J\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500117,\n" +
                "                \"areaName\":\"合川区\",\n" +
                "                \"areaNameAbbr\":\"合川\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500118,\n" +
                "                \"areaName\":\"永川区\",\n" +
                "                \"areaNameAbbr\":\"永川\",\n" +
                "                \"areaNameInitial\":\"Y\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500151,\n" +
                "                \"areaName\":\"铜梁区\",\n" +
                "                \"areaNameAbbr\":\"铜梁\",\n" +
                "                \"areaNameInitial\":\"T\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":500120,\n" +
                "                \"areaName\":\"璧山区\",\n" +
                "                \"areaNameAbbr\":\"璧山\",\n" +
                "                \"areaNameInitial\":\"B\",\n" +
                "                \"isMunicipality\":\"1\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"18\":{\n" +
                "        \"370100\":[\n" +
                "            {\n" +
                "                \"areaCode\":370117,\n" +
                "                \"areaName\":\"钢城区\",\n" +
                "                \"areaNameAbbr\":\"钢城\",\n" +
                "                \"areaNameInitial\":\"G\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370104,\n" +
                "                \"areaName\":\"槐荫区\",\n" +
                "                \"areaNameAbbr\":\"槐荫\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370125,\n" +
                "                \"areaName\":\"济阳区\",\n" +
                "                \"areaNameAbbr\":\"济阳\",\n" +
                "                \"areaNameInitial\":\"J\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370116,\n" +
                "                \"areaName\":\"莱芜区\",\n" +
                "                \"areaNameAbbr\":\"莱芜\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370112,\n" +
                "                \"areaName\":\"历城区\",\n" +
                "                \"areaNameAbbr\":\"历城\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370102,\n" +
                "                \"areaName\":\"历下区\",\n" +
                "                \"areaNameAbbr\":\"历下\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370124,\n" +
                "                \"areaName\":\"平阴县\",\n" +
                "                \"areaNameAbbr\":\"平阴\",\n" +
                "                \"areaNameInitial\":\"P\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370126,\n" +
                "                \"areaName\":\"商河县\",\n" +
                "                \"areaNameAbbr\":\"商河\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370103,\n" +
                "                \"areaName\":\"市中区\",\n" +
                "                \"areaNameAbbr\":\"市中\",\n" +
                "                \"areaNameInitial\":\"S\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370105,\n" +
                "                \"areaName\":\"天桥区\",\n" +
                "                \"areaNameAbbr\":\"天桥\",\n" +
                "                \"areaNameInitial\":\"T\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370113,\n" +
                "                \"areaName\":\"长清区\",\n" +
                "                \"areaNameAbbr\":\"长清\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370181,\n" +
                "                \"areaName\":\"章丘区\",\n" +
                "                \"areaNameAbbr\":\"章丘\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"370600\":[\n" +
                "            {\n" +
                "                \"areaCode\":370611,\n" +
                "                \"areaName\":\"福山区\",\n" +
                "                \"areaNameAbbr\":\"福山\",\n" +
                "                \"areaNameInitial\":\"F\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370687,\n" +
                "                \"areaName\":\"海阳市\",\n" +
                "                \"areaNameAbbr\":\"海阳\",\n" +
                "                \"areaNameInitial\":\"H\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370613,\n" +
                "                \"areaName\":\"莱山区\",\n" +
                "                \"areaNameAbbr\":\"莱山\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370682,\n" +
                "                \"areaName\":\"莱阳市\",\n" +
                "                \"areaNameAbbr\":\"莱阳\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370683,\n" +
                "                \"areaName\":\"莱州市\",\n" +
                "                \"areaNameAbbr\":\"莱州\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370681,\n" +
                "                \"areaName\":\"龙口市\",\n" +
                "                \"areaNameAbbr\":\"龙口\",\n" +
                "                \"areaNameInitial\":\"L\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370612,\n" +
                "                \"areaName\":\"牟平区\",\n" +
                "                \"areaNameAbbr\":\"牟平\",\n" +
                "                \"areaNameInitial\":\"M\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370614,\n" +
                "                \"areaName\":\"蓬莱区\",\n" +
                "                \"areaNameAbbr\":\"蓬莱\",\n" +
                "                \"areaNameInitial\":\"P\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370686,\n" +
                "                \"areaName\":\"栖霞市\",\n" +
                "                \"areaNameAbbr\":\"栖霞\",\n" +
                "                \"areaNameInitial\":\"Q\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370685,\n" +
                "                \"areaName\":\"招远市\",\n" +
                "                \"areaNameAbbr\":\"招远\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"areaCode\":370602,\n" +
                "                \"areaName\":\"芝罘区\",\n" +
                "                \"areaNameAbbr\":\"芝罘\",\n" +
                "                \"areaNameInitial\":\"Z\",\n" +
                "                \"isMunicipality\":\"0\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        try {
            JSONObject jsonObject = JSONObject.parseObject(str);
            JSONObject bankConfig = jsonObject.getJSONObject(String.valueOf(18));

            Iterator<String> sIterator = bankConfig.keySet().iterator();
            while(sIterator.hasNext()){
                // 获得key
                String key = sIterator.next();
                // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
                JSONArray value = bankConfig.getJSONArray(key);
                System.out.print("key: "+key +":");
//                System.out.println("key: "+key+",value"+value);
                for (int i = 0; i < value.size(); i++) {
                    JSONObject jsonObject1 = value.getJSONObject(i);
                    System.out.print(jsonObject1.get("areaName")+"、");
                }
                System.out.println("");
            }
//            JSONArray cityConfig = bankConfig.getJSONArray(city);
//            result = JSONObject.parseArray(cityConfig.toJSONString(), AreaInfBean.class);
//            return result;
        } catch (Exception e) {
//            log.error("mcc获取发卡城市类型转换异常 cardMetaId={},city={}", cardMetaId, city, e);
//            return new ArrayList<>();
        }
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            int randomTemp = random.nextInt(1);
//            System.out.println(randomTemp);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("123");
//        }
//        String str = "{\"str1\":\"123\"}";
//        JSONObject jsonObject = JSON.parseObject(str);
//        FlEntity jsonObject2 = JSONObject.toJavaObject(jsonObject, FlEntity.class);
//        if(jsonObject2!=null){
//            System.out.println("123");
//        }
//        System.out.println("--");
//        String pattern = "\\d*.\\d*\\.(\\d+)";
//        String key = "1.2.3";
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(key);
//        if (m.find()) {
//            System.out.println("Found value: " + m.group(0));
//            System.out.println("Found value: " + m.group(1));
//        }
//        ReentrantLock
//        ClassLayout
//        StringBuffer
//


//        HashMap<String,String> map = new HashMap();
//
//        map.put("1","1");
//        map.put("2","3");
//        map.put("3","3");
//
//        Iterator<Map.Entry<String,String>>  it = map.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String,String> entry = it.next();
//            // System.out.println("Key="+ entry.getKey()+"，value："entry.getValue());
//            System.out.println(entry.getKey());
//        }
//        Throwable
//                RuntimeException
//        Thread.currentThread().getContextClassLoader()

//        ClassLoader.getSystemClassLoader();
//        DriverManager.get
//        ClassLoader
//        Arrays.sort();sor
    }
}
