package teleDemo.util;

import teleDemo.entities.Location;
import teleDemo.entities.Pair;
import teleDemo.entities.riskyPersonArea;
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
    private static BigDecimal bias=new BigDecimal("0.004");
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
    public static List<Pair<Double,Double>> generate_location(Location location, String status, int cluster_num) {
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
    public static double getearthdistance(riskyPersonArea a,riskyPersonArea b){
        Double EARTH_RADIUS = 6378.137;
        Double distance= 0.00;
        Double lat_distance=Math.toRadians(a.getLat()-b.getLat());
        Double lon_distance=Math.toRadians(a.getLon()-b.getLon());
        distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(lat_distance/2),2)+
                Math.cos(Math.toRadians(a.getLat())) * Math.cos(Math.toRadians(b.getLat())) * Math.pow(Math.sin(lon_distance/2), 2)));
        distance=distance*EARTH_RADIUS;
        return distance;
    }
//    public static void main(String[] args) {
//        riskyPersonArea a=new riskyPersonArea().setLat(39.89).setLon(116.31);
//        riskyPersonArea b=new riskyPersonArea().setLat(38.70).setLon(116.12);
//        double d = getearthdistance(a,b);
//        System.out.println(d);
//    }

}