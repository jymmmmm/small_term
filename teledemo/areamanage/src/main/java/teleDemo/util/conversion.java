package teleDemo.util;

import javafx.util.Pair;
import teleDemo.entities.poly_list;
import teleDemo.entities.poly_post;
import teleDemo.entities.poly_string;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class conversion {

    public static String poly_to_string(List<Pair<Double, Double>> poly) {
        StringBuilder sb = new StringBuilder();
        for (Pair<Double, Double> item :
                poly) {
            sb.append(item.getKey());
            sb.append("_");
            sb.append(item.getValue());
            sb.append("_");
        }
        return sb.toString();
    }

    public static List<Pair<Double, Double>> string_to_poly(String res){
        StringTokenizer st = new StringTokenizer(res, "_");
        List<Pair<Double, Double>> poly = new LinkedList<>();
        while(st.hasMoreTokens()){
            Double lat = Double.valueOf(st.nextToken());
            Double lon = Double.valueOf(st.nextToken());
            poly.add(new Pair<>(lat,lon));
        }
        return poly;
    }

    public static List<Pair<Double,Double>> post_to_list(List<List<Double>> post){
        int temp=0;
        List<Pair<Double,Double>> poly = new LinkedList<>();
        for(List<Double>item:post){
            for(int i=0;i<item.size()/2;i++)
            {
                temp=i+1;
                Pair<Double,Double>pair=new Pair<>(item.get(i),item.get(temp));
                poly.add(pair);
            }
        }
        return poly;
    }

    public static poly_string pl_to_ps(poly_list pl){
        return new poly_string(pl.getId(),pl.getStatus(),poly_to_string(pl.getList_data()));
    }

    public static poly_list ps_to_pl(poly_string ps){
        return new poly_list(ps.getId(),ps.getStatus(),string_to_poly(ps.getStr_data()));
    }

    public static poly_list pp_to_pl(poly_post pp){
        return new poly_list(pp.getId(),pp.getStatus(),post_to_list(pp.getList_data()));
    }
    public static Pair<Integer,Integer> string_to_pair(String res){
        StringTokenizer st = new StringTokenizer(res, "_");
        int lat = Integer.parseInt(st.nextToken());
        int lon = Integer.parseInt(st.nextToken());
        return new Pair<>(lat,lon);
    }
}
