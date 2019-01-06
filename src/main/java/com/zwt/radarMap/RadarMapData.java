package com.zwt.radarMap;

/**
 * 雷达图外围文字图片数据Bean
 * @author zwt
 *
 */
public class RadarMapData {
	//数值
	private String value;
	//该维度数值最大值
	private String maxValue;
	//分组
	private String group;
	//文字
	private String textValue;
	//图片路径
	private String picPath;
	
	
	public RadarMapData(String value, String maxValue, String group, String textValue, String picPath) {
		super();
		this.value = value;
		this.maxValue = maxValue;
		this.group = group;
		this.textValue = textValue;
		this.picPath = picPath;
	}
	public RadarMapData() {
		super();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	
	
}
