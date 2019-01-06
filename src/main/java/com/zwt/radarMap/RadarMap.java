package com.zwt.radarMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * 雷达图主要工具类
 * 
 * @author zwt
 *
 */
public class RadarMap {

	// 日志记录
	private Logger logger = LoggerFactory.getLogger(RadarMap.class);

	// 数据集合
	private List<RadarMapData> dataList;
	// 初始化参数
	private RadarMapInit init;

	public RadarMap() {
		super();
	}

	public RadarMap(List<RadarMapData> dataList, RadarMapInit init) {
		super();
		this.dataList = dataList;
		this.init = init;
	}

	public List<RadarMapData> getDataList() {
		return dataList;
	}

	public void setDataList(List<RadarMapData> dataList) {
		this.dataList = dataList;
	}

	public RadarMapInit getInit() {
		return init;
	}

	public void setInit(RadarMapInit init) {
		this.init = init;
	}

	/**
	 * 画圆环
	 * 
	 */
	private void drawCircles() {
		Graphics2D g = init.getG();
		// 根据圆心，半径，画出同心圆
		g.setColor(init.getCirColor());
		// 获取圆心
		int x = init.getPoint().x;
		int y = init.getPoint().y;
		// 获取各个圆的直径并画圆环
		for (int i = 1; i <= init.getCirNum(); i++) {
			int d = 2 * i * init.getR() / init.getCirNum();
			g.drawOval(x - d / 2, y - d / 2, d, d);
		}
	}

	/**
	 * 以圆心画射线
	 * 
	 */
	private void drawSpokes() {
		Graphics2D g = init.getG();
		Point point = init.getPoint();
		// 解析数组
		int num = dataList.size();
		// 设置颜色
		g.setColor(init.getSpoColor());
		// 每个角度
		float angle = init.getStartAngle();
		float angleStep = 360 / num;

		for (int i = 1; i <= num; i++) {
			Point pt = getMappedPoint(init.getR(), angle, point);
			g.drawLine(point.x, point.y, pt.x, pt.y);
			addCirWordPic(dataList.get(i - 1).getTextValue(), pt, angle, dataList.get(i - 1).getPicPath());
			g.setColor(init.getSpoColor());
			angle += angleStep;
		}

		// 获取各个点的坐标
		Polygon p = new Polygon();
		g.setColor(init.getFillColor());
		float angle1 = init.getStartAngle();
		Point ptNext = new Point();
		for (int i = 1; i <= num; i++) {
			int myR = (int)(Double.parseDouble(dataList.get(i - 1).getValue())*(double)init.getR()/Double.parseDouble(dataList.get(i - 1).getMaxValue()));
			Point pt = getMappedPoint(myR, angle1, point);
			p.addPoint(pt.x, pt.y);
			if (i < num) {
				angle1 += angleStep;
				int myRNext = (int)(Double.parseDouble(dataList.get(i).getValue())*(double)init.getR()/Double.parseDouble(dataList.get(i).getMaxValue()));
				ptNext = getMappedPoint(myRNext, angle1, point);
			} else {
				angle1 += angleStep;
				int myRNext = (int)(Double.parseDouble(dataList.get(0).getValue())*(double)init.getR()/Double.parseDouble(dataList.get(0).getMaxValue()));
				ptNext = getMappedPoint(myRNext, angle1, point);
			}
			//g.drawLine(pt.x, pt.y, ptNext.x, ptNext.y);
		}
		g.drawPolygon(p);
		g.fillPolygon(p);
	}

	/**
	 * 根据点，角度，半径获取另一个点坐标
	 * 
	 * @param r
	 * @param angle
	 * @param point
	 * @return
	 */
	private Point getMappedPoint(int r, float angle, Point point) {
		// 计算坐标
		Point pt = new Point();
		pt.x = (int) (r * Math.cos(angle * Math.PI / 180) + point.x);
		pt.y = (int) (r * Math.sin(angle * Math.PI / 180) + point.y);
		return pt;
	}

	/**
	 * 添加圆心文字
	 * 
	 */
	private void addWord() {
		Graphics2D g = init.getG();
		String value = init.getCenText();
		if (value == null || "".equals(value)) {
			logger.info("雷达图没有配置圆心文字，不添加圆心文字");
			return;
		}
		FontRenderContext context = g.getFontRenderContext();
		Font font = init.getCenFont();
		g.setColor(init.getCenColor());
		g.setFont(font);
		Rectangle2D bounds = font.getStringBounds(value, context);
		double x = (bounds.getWidth()) / 2;
		double y = (bounds.getHeight()) / 2;
		g.drawString(value, (int) (init.getPoint().x - x), (int) (init.getPoint().y + y - 10));
	}

	/**
	 * 添加圆外文字图片
	 *
	 * @param point
	 *            绘制起始点
	 * @param picValue
	 *            图片路径
	 */
	private void addCirWordPic(String wordValue, Point point, float angle, String picValue) {
		Graphics2D g = init.getG();
		double x = 0;
		double y = 0;
		double dx = 0;
		double dy = 0;
		if (wordValue == null || "".equals(wordValue)) {
			logger.info(angle + "角度的点没有配置圆外文字");
			Map<String, Double> map = setDxDy(angle, x, y, dx, dy);
			dx = map.get("dx");
			dy = map.get("dy");
		} else {
			FontRenderContext context = g.getFontRenderContext();
			Font font = init.getOutFont();
			g.setColor(init.getOutColor());
			g.setFont(font);
			Rectangle2D bounds = font.getStringBounds(wordValue, context);
			x = (bounds.getWidth()) / 2;
			y = (bounds.getHeight()) / 2;
			Map<String, Double> map = setDxDy(angle, x, y, dx, dy);
			dx = map.get("dx");
			dy = map.get("dy");
			g.drawString(wordValue, (int) (point.x + dx), (int) (point.y + dy));

		}

		if (picValue == null || "".equals(picValue)) {
			logger.info(angle + "角度的点没有配置圆外图片");
			return;
		}

		// 图片放到文字上面
		ImageIcon imgIcon = new ImageIcon(picValue);
		Image img = imgIcon.getImage();
		g.drawImage(img, (int) (point.x + dx), (int) (point.y + dy - 5 * y), null);
	}

	/**
	 * 设置偏移量 圈外文字及图片使用
	 * 
	 * @param dx
	 * @param dy
	 */
	private Map<String, Double> setDxDy(float angle, double x, double y, double dx, double dy) {
		double cosVal = Math.cos(angle * Math.PI / 180);
		double sinVal = Math.sin(angle * Math.PI / 180);
		if (cosVal > 0 && sinVal > 0) {
			dx = 5;
			dy = 2 * y + 20; // 第一象限额外偏移15用于放置图片
		} else if (cosVal > 0 && sinVal < 0) {
			dx = 5;
			dy = -5; // 第三象限
		} else if (cosVal < 0 && sinVal > 0) {
			dx = -2 * x - 5;
			dy = 2 * y + 20; // 第二象限额外偏移15用于放置图片
		} else if (cosVal < 0 && sinVal < 0) {
			dx = -2 * x - 5;
			dy = 5; // 第四象限
		}
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("dx", dx);
		map.put("dy", dy);
		return map;
	}
	
	/**
	 * 添加雷达图下面的线
	 */
	private void drawLineAndWord() {
		int curVal=init.getLineCurVal();
		//-1为开始设置的值，默认为没有填写，直接跳过线条打印
		if(curVal==-1) {
			return;
		}
		int staVal=init.getLineStaVal();
		int maxVal=init.getLineMaxVal();
		Graphics2D g = init.getG();
		int width=init.getPicWidth();
		//图片定的为 600*700  目前 雷达图占地 500 * 500  这边从y=600开始画  r+pointy+100
		//可以将这些参数改为变量，目前不想改
		
		//x方向前后都要空100单位
		int shiftX=init.getShiftX();
		//y方向距离雷达图100单位
		int shiftY=init.getR()+init.getPoint().y+init.getShiftY();
		//起点
		Point point=new Point(shiftX,shiftY);
		//两边空50  实际绘图区域为500
		int lineCur=(width-2*shiftX)*curVal/maxVal;
		int lineMax=(width-2*shiftX)*maxVal/maxVal;
		Point p1=getMappedPoint(lineCur,0,point);
		Point p2=getMappedPoint(lineMax,0,point);
		g.setColor(init.getLineArrColor());
		g.setStroke(init.getLineStroke());
		g.drawLine(point.x,point.y,p1.x,p1.y);
		g.setColor(init.getLineNotArrColor());
		g.drawLine(p1.x,p1.y,p2.x,p2.y);
		
		//画完线后标记起点和结束点
		drawWord(g,init.getGenLineFont(),init.getGenTextColor(),point,staVal+"",-10,0);
		drawWord(g,init.getGenLineFont(),init.getGenTextColor(),p2,maxVal+"",20,0);
		drawWord(g,init.getGenLineFont(),init.getSpeTextColor(),p1,curVal+"",0,15);
		//画小箭头
		drawArrow(g,init.getLineArrColor(),p1);
		//写文字
		//特殊文字起点
		Point speTextP=new Point(shiftX-5,shiftY+60);
		drawWordNormal(g,init.getSpeLineFont(),init.getGenTextColor(),init.getSpeTextColor(),speTextP,init.getSpeLineText()+"的分数击败了全班",init.getSpeLineValue(),"的童鞋！");
	}
	
	/**
	 * 写字居中偏移方法
	 * @param g   绘图参数
	 * @param font  字体
	 * @param color  字体颜色
	 * @param point   绘制点
	 * @param value   绘制文本内容
	 * @param dx      x偏移量
	 * @param dy      y偏移量    如果x，y偏移量不设置理论上位于绘点中心
	 */
	private void drawWord(Graphics2D g,Font font,Color color,Point point,String value,double dx,double dy) {
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(value, context);
		g.setFont(font);
		g.setColor(color);
		double x = (bounds.getWidth()) / 2;
		double y = (bounds.getHeight()) / 2;
		g.drawString(value, (int) (point.x - x+dx), (int) (point.y + y+dy));
	}
	
	/**
	 * 特殊文字的文字绘制
	 */
	private void drawWordNormal(Graphics2D g,Font font,Color genColor,Color speColor,Point point,String firstValue,String cenVal,String endValue) {
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds1 = font.getStringBounds(firstValue, context);
		Rectangle2D bounds2 = font.getStringBounds(cenVal, context);
		//Rectangle2D bounds3 = font.getStringBounds(endValue, context);
		double x1 = bounds1.getWidth();
		double x2 = bounds2.getWidth();
		g.setFont(font);
		g.setColor(genColor);
		g.drawString(firstValue, (int) (point.x), (int) (point.y));
		//画完后 再画特殊文字 再补上后面的内容
		g.setColor(speColor);
		g.drawString(cenVal, (int) (point.x+x1), (int) (point.y));
		g.setColor(genColor);
		g.drawString(endValue, (int) (point.x+x1+x2), (int) (point.y));
	}
	
	/**
	 * 绘制小箭头
	 * @param g   绘图参数
	 * @param color   箭头填充色
	 * @param point   箭头顶点
	 */
	private void drawArrow(Graphics2D g,Color color,Point point) {
		g.setColor(color);
		Polygon p = new Polygon();
		p.addPoint(point.x,point.y);
		p.addPoint(point.x-10,point.y-20);
		p.addPoint(point.x,point.y-15);
		p.addPoint(point.x+10,point.y-20);
		g.fillPolygon(p);
	}
	
	
	/**
	 * 画雷达图主方法 这个方法主要是为了显示在jpanel上用，实际中主调
	 */
	public void drawRadarMap() {
		drawCircles();
		drawSpokes();
		addWord();
		drawLineAndWord();
	}

	/**
	 * 生成图片文件
	 */
	public boolean createImage() {
		boolean flag = false;
		try {
			File file = new File(init.getImgPath());
			int width=init.getPicWidth();
			int height=init.getPicHeight();
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = (Graphics2D) bi.getGraphics();
			//设置抗锯齿属性，不然图片锯齿化很模糊
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			g2.setBackground(init.getPicBackColor());
			g2.clearRect(0, 0, width, height);
			init.setG(g2);
			//画圆
			drawCircles();
			//画射线及添加圆边的文字图片
			drawSpokes();
			//添加中心文字
			addWord();
			//添加下面那条线及内容
			drawLineAndWord();
			flag = ImageIO.write(bi, init.getImgType(), file);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
