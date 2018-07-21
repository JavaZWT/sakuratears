package com.zwt.regExp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Little Fish
 * @Description: 正则表达式校验类
 * @Name: RegUtils.java
 * @Date: 2018年7月21日 下午6:11:53
 * @Version: 1.0
 */
public class RegUtils {
	/**
	 * 正则表达式校验手机号合法性
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		Pattern p = Pattern.compile("^[1][3,5,7,8]+\\d{9}"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
	
	/**
	 * 正则表达式校验邮箱合法性
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
	
	/**
	 * IPv4地址合法性校验
	 * @param str
	 * @return
	 */
	public static boolean isIPv4(String str) {
		Pattern p = Pattern.compile("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
	
	/**
	 * 是不是汉字字符
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]+$"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
	
	/**
	 * QQ号校验
	 * @param str
	 * @return
	 */
	public static boolean isQQ(String str){
		Pattern p = Pattern.compile("[1-9][0-9]{4,13}"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
	
	/**
	 * 身份证号正则校验
	 * @param IDNumber
	 * @return
	 */
	public static boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾


        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {
            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return matches;
    }
	
	/**
	 * 邮编校验
	 * @param str
	 * @return
	 */
	public static boolean isMail(String str) {
		Pattern p = Pattern.compile("[1-9]\\d{5}(?!\\d)"); //正则表达式
		Matcher m = p.matcher(str); //操作的字符串		
		return m.matches();
	}
}
