
/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: conversion
 * @Author: Jia Yiming
 * @Data:2022/8/24 11:38
 */
package teleDemo.util;

import javafx.util.Pair;

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

    public static void main(String[] args) {
        System.out.println(string_to_poly("122.3_145.3_122.5_145.5"));
    }
}
