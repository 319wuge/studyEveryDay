package com.iw.wuge.agentReport.utils.web;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by kehui on 2014/12/16.
 */
public class DictUtils {

    private static final String packageBase = "com.manyi.iw.agent.report.model.dict.enums";

    /**
     * 获取字典的所有枚举项
     * @param className 类名
     * @param <T>  反射对象类型
     * @return 字典的所有枚举项
     * 枚举类中，必须有getAllEnum方法，否则getData返回空
     */
    public static <T>List<T> getData(String className) {
        return getDataByMethod(className, "getAllEnum");
    }

    /**
     * 获取字典的所有枚举项
     * @param className 类名
     * @param methodName 反射的方法名
     * @param <T>  反射对象类型
     * @return 字典的所有枚举项
     * 枚举类中，必须有getAllEnum方法，否则getData返回空
     */
    public static <T>List<T> getDataByMethod(String className, String methodName) {
            String completeClazzName = packageBase + "." + className;
           return getDataByCompleteClassName(completeClazzName, methodName);
    }

    /**
     * 获取字典的所有枚举项
     * @param completeClassName 包名+类名
     * @param methodName 反射的方法名
     * @param <T>  反射对象类型
     * @return 字典的所有枚举项
     * 枚举类中，必须有getAllEnum方法，否则getData返回空
     */
    public static <T>List<T> getDataByCompleteClassName(String completeClassName, String methodName) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(completeClassName);
            if (StringUtils.isBlank(methodName)) {
                methodName = "getAllEnum";
            }
            Method[] methods = clazz.getDeclaredMethods();
            Object dicts = null;
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    dicts = method.invoke(null, null);
                    break;
                }
            }
            return dicts == null ? null : (List<T>) dicts;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * 根据引用标记，获得该字典，然后根据方法名，得到方法名返回的文本对象
     * @param completeClassName
     * @param methodName
     * @param <T>
     * @return
     */
    public static <T>String valueOf(String completeClassName, Object id, String methodName) {
        try {
            if (completeClassName.indexOf(".") == -1)
                completeClassName = packageBase + completeClassName;
            Class<T> clazz = (Class<T>) Class.forName(completeClassName);
            Method[] methods = clazz.getDeclaredMethods();
            if (StringUtils.isBlank(methodName)) {
                methodName = "name";
            }
            Object dict = null;
            if(null == id){
                return "";
            }
            for (Method method : methods) {
                if (method.getName().equals("value2Obj")) {
                    dict = method.invoke(null, Integer.valueOf(id.toString()));
                    break;
                }
            }
            String text = BeanUtils.getProperty(dict, methodName);
            return text == null ? "" : String.valueOf(text);
        } catch (ClassNotFoundException e) {
            return "";
        } catch (InvocationTargetException e) {
            return "";
        } catch (IllegalAccessException e) {
            return "";
        } catch (NoSuchMethodException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(DictUtils.valueOf("com.manyi.iw.sale.contract.model.dict.enums.AreaLevel", 30, ""));
    }
}
