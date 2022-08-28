package teleDemo.util;
import javafx.util.Pair;
import teleDemo.entities.Location;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class area_policy {
    /*
    weight:感染和密接权值
    level_value:评判风险等级的值
    bias:疫情区划分范围
    */
    private static int weight=10;
    private static int level_value=15;
    private static BigDecimal bias=new BigDecimal("0.0001");
    public enum level {
        LOW, MEDIUM, HIGH
    }
    public static String judge_level(int infected_count,int closedcount) {
        level res;
        int level_num=infected_count*weight+closedcount;
        if(level_num>level_value)
        {
            res = level.HIGH;
        }
        else if(level_num>level_value/2){
            res = level.MEDIUM;
        }
        else
        {
            res = level.LOW;
        }
        return res.toString();
    }
    public static List<Pair<Double,Double>> generate_location(Location location,String status,int cluster_num) {
        List<Pair<Double,Double>> surround=new ArrayList<>();
        BigDecimal bd_lat = new BigDecimal(String.valueOf((double) (location.getLat())/cluster_num));
        BigDecimal bd_lon = new BigDecimal(String.valueOf((double) (location.getLon())/cluster_num));
        Pair<Double,Double> a1=new Pair<>(bd_lat.subtract(bias).doubleValue(),bd_lon.subtract(bias).doubleValue());
        Pair<Double,Double> a2=new Pair<>(bd_lat.subtract(bias).doubleValue(),bd_lon.add(bias).doubleValue());
        Pair<Double,Double> a3=new Pair<>(bd_lat.add(bias).doubleValue(),bd_lon.add(bias).doubleValue());
        Pair<Double,Double> a4=new Pair<>(bd_lat.add(bias).doubleValue(),bd_lon.subtract(bias).doubleValue());
        if(status.equals(level.HIGH.toString()))
        {
            surround.add(a1);
            surround.add(a2);
            surround.add(a3);
            surround.add(a4);
        }
        else if(status.equals(level.MEDIUM.toString())){
            surround.add(a1);
            surround.add(a2);
            surround.add(a3);
            surround.add(a4);
        }
        else{
            surround.add(a1);
            surround.add(a2);
            surround.add(a3);
            surround.add(a4);
        }
        return surround;
    }

}