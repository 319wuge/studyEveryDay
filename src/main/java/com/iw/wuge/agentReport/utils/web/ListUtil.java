package com.iw.wuge.agentReport.utils.web;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhubin on 2015/12/22 0022.
 */
public class ListUtil {
    public static <T> List<List<T>> split(List<T> list, int pageSize) {
        List<List<T>> result = new ArrayList<>(list.size() / pageSize + 1);
        for (int i = 0, next, max = list.size(); i < max; i = next) {
            next = i + pageSize;
            if (next > max) next = max;
            result.add(list.subList(i, next));
        }
        return result;
    }

    public static List<Byte> converyToByteList(String str){
        List<Byte> rs = new ArrayList<>();
        for(String patten:str.split(",")){
            if(StringUtils.isNotEmpty(patten)){
                rs.add(Byte.valueOf(patten));
            }
        }
        return rs;
    }
}
