package com.zwt.radarMap;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 测试类，可以把生成的图放到Jpanel可视化界面上，便于调试
 * 
 * @author zwt
 *
 */
public class MyTest extends JFrame {
	MyPanel mp = null;

	public static void main(String[] args) {
		MyTest demo01 = new MyTest();
	}

	public MyTest() {
		mp = new MyPanel();
		this.add(mp);

		this.setSize(600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

// 定义一个MyPanel面板，用于绘图区域
class MyPanel extends JPanel {
	// 覆盖JPanel
	// Graphics 是绘图的重要类，可以理解成一支画笔
	public void paint(Graphics g) {
		// 1. 调用父类函数完成初始化任务
		// 这句话不可以少
		super.paint(g);

		List<RadarMapData> dataList = new ArrayList<RadarMapData>();
		RadarMapData map1 = new RadarMapData("100","150", "", "数学", "");
		RadarMapData map2 = new RadarMapData("120","150", "", "语文", "");
		RadarMapData map3 = new RadarMapData("90","150", "", "英语", "");
		RadarMapData map4 = new RadarMapData("80","100", "", "物理", "");
		RadarMapData map5 = new RadarMapData("95","100", "", "化学", "");
		RadarMapData map6 = new RadarMapData("88","100","", "生物", "");
		RadarMapData map7 = new RadarMapData("66","100", "", "历史", "");
		RadarMapData map8 = new RadarMapData("77","100", "", "政治", "");
		RadarMapData map9 = new RadarMapData("45","100", "", "地理", "");
		RadarMapData map10 = new RadarMapData("88","100", "", "音乐", "");
		RadarMapData map11 = new RadarMapData("80","100", "", "体育", "");
		RadarMapData map12 = new RadarMapData("100","100", "", "美术", "");

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
		init.setSpeLineValue("60%");//击败多少童鞋先瞎传一个数
		init.setG((Graphics2D) g);
		//init.setImgPath("/Users/zhangwentong/Desktop/image.jpg");
		init.setLineCurVal(currentValue);
		init.setLineMaxVal(lineMaxValue);
		RadarMap test = new RadarMap(dataList, init);
		test.drawRadarMap();
		//test.createImage();
	}
}