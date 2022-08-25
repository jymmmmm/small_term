package teleDemo.util;

import javafx.util.Pair;
import teleDemo.entities.Location;

import java.util.ArrayList;
import java.util.List;

public class area_policy {
    public static String judge_level(int infected_count,int closedcount) {
        String statement=new String();
        int level_num=infected_count*10+closedcount;
        if(level_num>100)
        {
            statement="a";
        }
        else if(level_num<=100&&level_num>10){
            statement="b";
        }
        else
        {
            statement="c";
        }
        return statement;
    }
    public static List<Pair<Float,Float>> generate_location(Location location) {
        List<Pair<Float, Float>> surround=new ArrayList<>();
        float lat=location.getLat();
        float lon=location.getLon();
        float bias= (float) 0.001;
        Pair<Float,Float> a1=new Pair<>(lat-bias,lon-bias);
        Pair<Float,Float> a2=new Pair<>(lat-bias,lon+bias);
        Pair<Float,Float> a3=new Pair<>(lat+bias,lon+bias);
        Pair<Float,Float> a4=new Pair<>(lat+bias,lon-bias);
        if(location.getStatus().equals("a"))
        {
            surround.add(a1);
            surround.add(a2);
            surround.add(a3);
            surround.add(a4);
        }
        else if(location.getStatus().equals("b")){
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