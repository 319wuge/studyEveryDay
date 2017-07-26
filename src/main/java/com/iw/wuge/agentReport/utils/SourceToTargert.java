package com.iw.wuge.agentReport.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by kehui on 2015/4/2.
 */
public class SourceToTargert<S extends Object, T extends Object> {

    /**
     *
     * @param targetList 目标集合
     * @param sourceList 源集合
     * @param fromSourceBy 源集合中的关联字段名
     * @param toTargetBy 目标集合中的关联字段名
     * @param fillFromSourceField 源集合中的需要被拿值的字段名
     * @param fillToTargetField 目标集合中需要被填充值的字段名
     */
    public void convert(List<S> sourceList, List<T> targetList, String fromSourceBy, String toTargetBy,
                                      String fillFromSourceField, String fillToTargetField) {
        if (CollectionUtils.isEmpty(targetList) || CollectionUtils.isEmpty(sourceList))
            return;
        try {
            for (S souce : sourceList) {
                //源关联值
                String fromSourceByValue = BeanUtils.getProperty(souce, fromSourceBy);
                //源被填充值
                String fillFromSourceFieldValue = BeanUtils.getProperty(souce, fillFromSourceField);
                if (StringUtils.isBlank(fromSourceByValue))
                    continue;
                for (T t : targetList) {
                    //目标关联值
                    String toTargetByValue = BeanUtils.getProperty(t, toTargetBy);
                    if (StringUtils.isBlank(toTargetByValue))
                        continue;
                    //如果源关联值等于目标关联值，则将源被填充值，填充目标被填充字段的值。
                    if (fromSourceByValue.equals(toTargetByValue)) {
                        BeanUtils.setProperty(t, fillToTargetField, fillFromSourceFieldValue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            return;
        } catch (InvocationTargetException e) {
            return;
        } catch (NoSuchMethodException e) {
            return;
        }
    }

}
