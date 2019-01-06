package com.zwt.radarMap;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
/**
 * 雷达图数据bean
 * @author zwt
 * ------------------关于雷达图，以下的说明---------------------
 * 默认圆环最大半径为200
 * 生成的图片为  宽600*高700  默认
 * 雷达图中心点的位置为 300,300  默认
 * 线及文字大概占 600*100    默认
 * 这些参数都可以调整，但调整后应尽量保证生成图的美观性
 * -------------------------------------------------------------
 */
public class RadarMapInit {
	// 圆环数量
	private int cirNum=2;
	// 圆的最大半径
	private int r=200;
	// 圆心坐标
	private Point point=new Point(300,300);
	// 圆环颜色
	private Color cirColor=new Color(24,165,255);
	// 射线起始角度 默认顺时针旋转
	private float startAngle=-90;
	// 射线颜色
	private Color spoColor=new Color(0,0,255,100);
	// 绘图参数g   画图时该参数不需要设置，设置了也没用
	private Graphics2D g;
	//填充色
	private Color fillColor=new Color(146,199,234,200);
	//中部文字颜色
	private Color cenColor=Color.WHITE;
	//中部文字
	private String cenText;
	//中部文字字体样式
	private Font cenFont=new Font("宋体", Font.TYPE1_FONT, 50);
	// 外围文字颜色
	private Color outColor=Color.BLUE;
	//外围文字样式 有默认值
	private Font outFont=new Font("宋体", Font.TYPE1_FONT,12);
	//生成图片路径 无默认值，必填
	private String imgPath;
	//生成图片格式 默认jpg  支持 jpg和png  其他格式没测
	private String imgType="jpg";
	//图片大小设置   宽   默认600*700 像素
	private int picWidth=600;
	//图片大小设置   高
	private int picHeight=700;
	//文字及线段的x方向距图片边的距离
	private int shiftX=100;
	//文字距雷达图y方向的距离
	private int shiftY=100;
	//生成的图片的背景颜色  默认白色
	private Color picBackColor=Color.WHITE;
	
	//又要开始添加参数了(⊙o⊙).....下面的主要是那一道线的参数
	//线的最大值
	private int lineMaxVal=1000;
	//线的当前值
	private int lineCurVal=-1;
	//线的起始值
	private int lineStaVal=0;
	//线的已达到的颜色
	private Color lineArrColor=new Color(24,165,255);
	//线的未达到的颜色
	private Color lineNotArrColor=Color.GRAY;
	//线的粗细
	private BasicStroke lineStroke=new BasicStroke(5.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
	//下面的一般说明字体   一般说明文字写死吧，参数太多了，不想写了....
	private Font genLineFont=new Font("宋体", Font.TYPE1_FONT,12);
	//下面的特殊说明字体
	private Font speLineFont=new Font("宋体", Font.TYPE1_FONT,25);
	//特殊说明字体百分数
	private String speLineValue;
	//特殊说明自己文字
	private String speLineText;
	//一般说明字体颜色
	private Color genTextColor=Color.BLACK;
	//特殊说明字体颜色
	private Color speTextColor=Color.BLUE;

	
	public RadarMapInit(int cirNum, int r, Point point, Color cirColor, float startAngle, Color spoColor, Graphics2D g,
			Color fillColor, Color cenColor, String cenText, Font cenFont, Color outColor, Font outFont, String imgPath,
			String imgType, int picWidth, int picHeight, int shiftX, int shiftY, Color picBackColor, int lineMaxVal,
			int lineCurVal, int lineStaVal, Color lineArrColor, Color lineNotArrColor, BasicStroke lineStroke,
			Font genLineFont, Font speLineFont, String speLineValue,String speLineText, Color genTextColor, Color speTextColor) {
		super();
		this.cirNum = cirNum;
		this.r = r;
		this.point = point;
		this.cirColor = cirColor;
		this.startAngle = startAngle;
		this.spoColor = spoColor;
		this.g = g;
		this.fillColor = fillColor;
		this.cenColor = cenColor;
		this.cenText = cenText;
		this.cenFont = cenFont;
		this.outColor = outColor;
		this.outFont = outFont;
		this.imgPath = imgPath;
		this.imgType = imgType;
		this.picWidth = picWidth;
		this.picHeight = picHeight;
		this.shiftX = shiftX;
		this.shiftY = shiftY;
		this.picBackColor = picBackColor;
		this.lineMaxVal = lineMaxVal;
		this.lineCurVal = lineCurVal;
		this.lineStaVal = lineStaVal;
		this.lineArrColor = lineArrColor;
		this.lineNotArrColor = lineNotArrColor;
		this.lineStroke = lineStroke;
		this.genLineFont = genLineFont;
		this.speLineFont = speLineFont;
		this.speLineValue = speLineValue;
		this.speLineText = speLineText;
		this.genTextColor = genTextColor;
		this.speTextColor = speTextColor;
	}
	public RadarMapInit() {
		super();
	}
	public int getCirNum() {
		return cirNum;
	}
	public void setCirNum(int cirNum) {
		this.cirNum = cirNum;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Color getCirColor() {
		return cirColor;
	}
	public void setCirColor(Color cirColor) {
		this.cirColor = cirColor;
	}
	public float getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(float startAngle) {
		this.startAngle = startAngle;
	}
	public Color getSpoColor() {
		return spoColor;
	}
	public void setSpoColor(Color spoColor) {
		this.spoColor = spoColor;
	}
	public Graphics2D getG() {
		return g;
	}
	public void setG(Graphics2D g) {
		this.g = g;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	public Color getCenColor() {
		return cenColor;
	}
	public void setCenColor(Color cenColor) {
		this.cenColor = cenColor;
	}
	public String getCenText() {
		return cenText;
	}
	public void setCenText(String cenText) {
		this.cenText = cenText;
	}
	public Font getCenFont() {
		return cenFont;
	}
	public void setCenFont(Font cenFont) {
		this.cenFont = cenFont;
	}
	public Color getOutColor() {
		return outColor;
	}
	public void setOutColor(Color outColor) {
		this.outColor = outColor;
	}
	public Font getOutFont() {
		return outFont;
	}
	public void setOutFont(Font outFont) {
		this.outFont = outFont;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public int getLineMaxVal() {
		return lineMaxVal;
	}
	public void setLineMaxVal(int lineMaxVal) {
		this.lineMaxVal = lineMaxVal;
	}
	public int getLineCurVal() {
		return lineCurVal;
	}
	public void setLineCurVal(int lineCurVal) {
		this.lineCurVal = lineCurVal;
	}
	public int getLineStaVal() {
		return lineStaVal;
	}
	public void setLineStaVal(int lineStaVal) {
		this.lineStaVal = lineStaVal;
	}
	public Color getLineArrColor() {
		return lineArrColor;
	}
	public void setLineArrColor(Color lineArrColor) {
		this.lineArrColor = lineArrColor;
	}
	public Color getLineNotArrColor() {
		return lineNotArrColor;
	}
	public void setLineNotArrColor(Color lineNotArrColor) {
		this.lineNotArrColor = lineNotArrColor;
	}
	public Font getGenLineFont() {
		return genLineFont;
	}
	public void setGenLineFont(Font genLineFont) {
		this.genLineFont = genLineFont;
	}
	public Font getSpeLineFont() {
		return speLineFont;
	}
	public void setSpeLineFont(Font speLineFont) {
		this.speLineFont = speLineFont;
	}
	public String getSpeLineValue() {
		return speLineValue;
	}
	public void setSpeLineValue(String speLineValue) {
		this.speLineValue = speLineValue;
	}
	public String getSpeLineText() {
		return speLineText;
	}
	public void setSpeLineText(String speLineText) {
		this.speLineText = speLineText;
	}
	public BasicStroke getLineStroke() {
		return lineStroke;
	}
	public void setLineStroke(BasicStroke lineStroke) {
		this.lineStroke = lineStroke;
	}
	public Color getGenTextColor() {
		return genTextColor;
	}
	public void setGenTextColor(Color genTextColor) {
		this.genTextColor = genTextColor;
	}
	public Color getSpeTextColor() {
		return speTextColor;
	}
	public void setSpeTextColor(Color speTextColor) {
		this.speTextColor = speTextColor;
	}
	public int getPicWidth() {
		return picWidth;
	}
	public void setPicWidth(int picWidth) {
		this.picWidth = picWidth;
	}
	public int getPicHeight() {
		return picHeight;
	}
	public void setPicHeight(int picHeight) {
		this.picHeight = picHeight;
	}
	public int getShiftX() {
		return shiftX;
	}
	public void setShiftX(int shiftX) {
		this.shiftX = shiftX;
	}
	public int getShiftY() {
		return shiftY;
	}
	public void setShiftY(int shiftY) {
		this.shiftY = shiftY;
	}
	public Color getPicBackColor() {
		return picBackColor;
	}
	public void setPicBackColor(Color picBackColor) {
		this.picBackColor = picBackColor;
	}
}
