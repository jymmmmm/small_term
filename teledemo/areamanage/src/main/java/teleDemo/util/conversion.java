
/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: conversion
 * @Author: Jia Yiming
 * @Data:2022/8/24 11:38
 */
package teleDemo.util;

import javafx.util.Pair;
import teleDemo.entities.poly_list;
import teleDemo.entities.poly_string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class conversion {

    public static String poly_to_string(List<Pair<Float, Float>> poly) {
        StringBuilder sb = new StringBuilder();
        for (Pair<Float, Float> item :
                poly) {
            sb.append(item.getKey());
            sb.append("_");
            sb.append(item.getValue());
            sb.append("_");
        }
        return sb.toString();
    }

    public static List<Pair<Float, Float>> string_to_poly(String res){
        StringTokenizer st = new StringTokenizer(res, "_");
        List<Pair<Float, Float>> poly = new LinkedList<>();
        while(st.hasMoreTokens()){
            Float lat = Float.valueOf(st.nextToken());
            Float lon = Float.valueOf(st.nextToken());
            poly.add(new Pair<>(lat,lon));
        }
        return poly;
    }

    public static poly_string pl_to_ps(poly_list pl){
        return new poly_string(pl.getId(),pl.getStatus(),poly_to_string(pl.getList_data()));
    }

    public static poly_list ps_to_pl(poly_string ps){
        return new poly_list(ps.getId(),ps.getStatus(),string_to_poly(ps.getStr_data()));

    }

    public static void main(String[] args) {
        System.out.println(string_to_poly("122.3_145.3_122.5_145.5"));
    }
}
