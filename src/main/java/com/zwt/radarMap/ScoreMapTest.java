package com.zwt.radarMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: zwt
 * @Description: 总分雷达图
 * @Name: ScoreMapTest
 * @Date: 2019/1/5 11:49 PM
 * @Version: 1.0
 */
public class ScoreMapTest {
    private static final String [] names = {"小一","小二","小三","小四","小五","小六","小七","小八","小九","小十"};
    //随机分数使用
    private static int randomValue(int maxValue){
        Random random = new Random();
        return random.nextInt(maxValue);
    }
    public static void drawMapPic(){
        for(String name:names){
            List<RadarMapData> dataList = new ArrayList<RadarMapData>();
            RadarMapData map1 = new RadarMapData(randomValue(150)+"","150", "", "数学", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map2 = new RadarMapData(randomValue(150)+"","150", "", "语文", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map3 = new RadarMapData(randomValue(150)+"","150", "", "英语", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map4 = new RadarMapData(randomValue(100)+"","100", "", "物理", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map5 = new RadarMapData(randomValue(100)+"","100", "", "化学", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map6 = new RadarMapData(randomValue(100)+"","100","", "生物", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map7 = new RadarMapData(randomValue(100)+"","100", "", "历史", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map8 = new RadarMapData(randomValue(100)+"","100", "", "政治", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map9 = new RadarMapData(randomValue(100)+"","100", "", "地理", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map10 = new RadarMapData(randomValue(100)+"","100", "", "音乐", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map11 = new RadarMapData(randomValue(100)+"","100", "", "体育", "/Users/zhangwentong/Desktop/book.png");
            RadarMapData map12 = new RadarMapData(randomValue(100)+"","100", "", "美术", "/Users/zhangwentong/Desktop/book.png");

            dataList.add(map1);
            dataList.add(map2);
            dataList.add(map3);
            dataList.add(map4);
            dataList.add(map5);
            dataList.add(map6);
            dataList.add(map7);
            dataList.add(map8);
            dataList.add(map9);
            dataList.add(map10);
            dataList.add(map11);
            dataList.add(map12);

            int lineMaxValue = 0;
            int currentValue = 0;

            for(RadarMapData data:dataList){
                lineMaxValue+=Integer.valueOf(data.getMaxValue());
                currentValue+=Integer.valueOf(data.getValue());
            }

            RadarMapInit init = new RadarMapInit();
            init.setCirNum(5);//20分一档，可以自己设置
            init.setCenText(currentValue+"分");
            init.setSpeLineText(name);
            init.setSpeLineValue("80%");//这个数可以计算，我这儿就不计算了（因为分数是随机的，计算比较蛋疼）
            init.setImgPath("/Users/zhangwentong/Desktop/map/image"+name+".jpg");
            init.setLineCurVal(currentValue);
            init.setLineMaxVal(lineMaxValue);
            RadarMap test = new RadarMap(dataList, init);
            test.createImage();
        }
    }
    public static void main(String[] args) {
        drawMapPic();
    }
}
