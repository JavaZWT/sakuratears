/**
 * 
 */
package com.zwt.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.TreeMap;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * 
 * @Author: Little Fish
 * @Description: 通过反射获取某个类的信息
 * @Name: GetClassInfoByReflect.java
 * @Date: 2018年7月13日 下午3:42:41
 * @Version: 1.0
 */
public class GetClassInfoByReflect {
	/**
	 * 利用Javassist获取class信息
	 */
	public static void getClassInfoByJavassist(Class clazz) {
	       ClassPool classPool = ClassPool.getDefault();
	        classPool.insertClassPath(new ClassClassPath(clazz));
	        try {
	        	System.out.println("class-->"+clazz.getName());
	        	CtClass ctClass = classPool.get(clazz.getName());
	        	
	        	//获取常量信息
	        	CtField[] fields=ctClass.getDeclaredFields();
	        	for(int i=0;i<fields.length;i++) {
		        	System.out.println("object="+fields[i].getName()+"-->value="+fields[i].getConstantValue()+"-->type="+fields[i].getType().getName());
	        	}
	        	
	        	//获取方法信息
	            CtMethod[] ctMethods = ctClass.getMethods();
	            for (CtMethod ctMethod : ctMethods) {
	            	//排除equals，hash，toString等方法
	                if (!clazz.getName().equals(ctMethod.getDeclaringClass().getName())) {
	                    continue;
	                }
	                MethodInfo methodInfo = ctMethod.getMethodInfo();
	                CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
	                LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
	                if (attr == null) {
	                    // exception
	                }
	                String[] paramNames = new String[ctMethod.getParameterTypes().length];
	                TreeMap<Integer, String> sortMap = new TreeMap<Integer, String>();
	                for (int i = 0; i < attr.tableLength(); i++) 
	                    sortMap.put(attr.index(i), attr.variableName(i));
	                int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
	                paramNames = Arrays.copyOfRange(sortMap.values().toArray(new String[0]), pos, paramNames.length + pos);
	                CtClass[] types=ctMethod.getParameterTypes();
	                for(int i=0;i<paramNames.length;i++) {
	                	System.out.println("class="+clazz.getSimpleName()+"-->method="+ctMethod.getName()+"-->isStatic="+Modifier.isStatic(ctMethod.getModifiers())+"-->paramsType="+types[i].getName()+"-->paramsName="+paramNames[i]);
	                }
	                
	            }        	
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }         
	}
	
	/**
	 * 通过spring里的LocalVariableTableParameterNameDiscoverer获取paramsName，使用jdk自带reflect反射类获取class其他信息
	 * @param clazz
	 */
	public static void getClassInfoBySpringAndReflect(Class clazz) {
		try {
			LocalVariableTableParameterNameDiscoverer u = 
					new LocalVariableTableParameterNameDiscoverer();
				Method[] methods =clazz.getDeclaredMethods();
				Field[] fields=clazz.getDeclaredFields();
	        	for(int i=0;i<fields.length;i++) {
	        		//设置成可以access的，否则get(clazz)报错，无法读取private属性
	        		fields[i].setAccessible(true);
		        	System.out.println("object="+fields[i].getName()+"-->value="+fields[i].get(clazz)+"-->type="+fields[i].getType().getName());
	        	}
				for(Method method:methods) {
					//使用spring LocalVariableTableParameterNameDiscoverer 获取paramsName
					String[] params = u.getParameterNames(method);
					Class<?> [] classType=method.getParameterTypes();
					for (int i = 0; i < params.length; i++) {
	                	System.out.println("class="+clazz.getSimpleName()+"-->method="+method.getName()+"-->isStatic="+Modifier.isStatic(method.getModifiers())+"-->paramsType="+classType[i].getName()+"-->paramsName="+params[i]);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Java8自带的Parameter类获取参数名，使用jdk自带reflect反射类获取class其他信息
	 * @param clazz
	 */
	public static void getClassInfoByJava8AndReflect(Class clazz){
		try {
	        Method[] methods = clazz.getDeclaredMethods();
			Field[] fields=clazz.getDeclaredFields();
	    	for(int i=0;i<fields.length;i++) {
	    		//设置成可以access的，否则get(clazz)报错，无法读取private属性
	    		fields[i].setAccessible(true);
	        	System.out.println("object="+fields[i].getName()+"-->value="+fields[i].get(clazz)+"-->type="+fields[i].getType().getName());
	    	}
	        for (Method method : methods) {
	        	//使用jdk1.8Parameter获取paramsNames
	            Parameter[] params = method.getParameters();
				Class<?> [] classType=method.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
                	System.out.println("class="+clazz.getSimpleName()+"-->method="+method.getName()+"-->isStatic="+Modifier.isStatic(method.getModifiers())+"-->paramsType="+classType[i].getName()+"-->paramsName="+params[i]);
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
	
	public static void main(String[] args) {
		//getClassInfoByJavassist(Demo.class);
		//getClassInfoBySpringAndReflect(Demo.class);
		getClassInfoByJava8AndReflect(Demo.class);
	}
}
