package com.huont.cloud.admin.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huont.cloud.admin.common.conf.Result;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 转换工具类
 */
public class ConvertUtils {

    public static final String DATA_LIST = "dataList";

    public static final String CURRENT = "current";

    public static final String TOTAL = "total";

    public static final String SIZE = "size";

    public static final String PAGE = "page";

    static {
        registerDateConverter();
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成List.
     *
     * @param collection   来源集合.
     * @param propertyName 要提取的属性名.
     */
    public static List convertElementPropertyToList(final Collection collection, final String propertyName) {
        List list = new ArrayList();

        try {
            for (Object obj : collection) {
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception e) {
            convertReflectionExceptionToUnchecked(e);
        }

        return list;
    }

    /**
     * 提取集合中对象的指定属性等于给定val值得对象组成新的结合
     * @param collection
     * @param propertyName
     * @param val
     * @return
     */
    public static List convertElementWithValToList(final Collection collection, final String propertyName, final String val) {
        List list = new ArrayList();

        try {
            for (Object obj : collection) {
                Object objPv = PropertyUtils.getProperty(obj, propertyName);
                if(objPv.equals(val)) {
                    list.add(obj);
                }
            }
        } catch (Exception e) {
            convertReflectionExceptionToUnchecked(e);
        }

        return list;
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成Map.
     *
     * @param collection 来源集合.
     * @param key        要提取的属性名.
     * @param value      要提取的属性名.
     */
    public static Map convertElementPropertyToMap(final Collection collection, final String key, final String value) {
        Map map = new HashMap();
        try {
            for (Object obj : collection) {
                map.put(PropertyUtils.getProperty(obj, key), PropertyUtils.getProperty(obj, value));
            }
        } catch (Exception e) {
            convertReflectionExceptionToUnchecked(e);
        }

        return map;
    }

    /**
     * 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串.
     *
     * @param collection   来源集合.
     * @param propertyName 要提取的属性名.
     * @param separator    分隔符.
     */
    public static String convertElementPropertyToString(final Collection collection, final String propertyName,
                                                        final String separator) {
        List list = convertElementPropertyToList(collection, propertyName);
        return StringUtils.join(list, separator);
    }

    /**
     * 转换字符串到相应类型.
     *
     * @param value  待转换的字符串.
     * @param toType 转换目标类型.
     */
    public static Object convertStringToObject(String value, Class<?> toType) {
        try {
            return org.apache.commons.beanutils.ConvertUtils.convert(value, toType);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 定义日期Converter的格式: yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     */
    private static void registerDateConverter() {
        DateConverter dc = new DateConverter();
        dc.setUseLocaleFormat(true);
        dc.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
        org.apache.commons.beanutils.ConvertUtils.register(dc, Date.class);
    }

    public static List convertListObject(List list, Class beanClass, String[] ignoreProperties) {
        List<Object> newlist = null;
        Object bean = null;
        if (list != null && list.size() > 0) {
            newlist = new ArrayList();
            for (Object obj : list) {
                try {
                    bean = beanClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BeanUtils.copyProperties(obj, bean, ignoreProperties);
                newlist.add(bean);
            }
        }
        return newlist;
    }


    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException("Reflection Exception.", e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    public static Result convertIpage2Result(IPage ipage) {
        Result result = Result.getSuccessInstance();
        result.put(ConvertUtils.DATA_LIST, ipage.getRecords());
        result.put(ConvertUtils.CURRENT, ipage.getCurrent());
        result.put(ConvertUtils.TOTAL, ipage.getTotal());
        result.put(ConvertUtils.SIZE, ipage.getSize());
        result.put(ConvertUtils.PAGE, ipage.getPages());
        return result;
    }

}
