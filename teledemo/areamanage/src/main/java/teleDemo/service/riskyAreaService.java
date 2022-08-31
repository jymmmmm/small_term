package teleDemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import teleDemo.entities.Location;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static teleDemo.util.area_policy.judge_level;

@Service
public class riskyAreaService {
    /*
    cluster_num:聚类的大小
     */
    private static int cluster_num=100;

    @Autowired
    riskyAreaMapper riskyAreaMapper;

    @Autowired
    tableService tableService;

    public List<riskyPersonArea> riskyarea_fromdatabase(){
        List<riskyPersonArea> area = riskyAreaMapper.calculate_riskyarea();
        return area;
    }

    public List<riskyPersonArea> CalculateRiskyArea(List<riskyPersonArea> area){
        int temp_infected,temp_closed;
        int temp_lat1,temp_lon1;
        double temp_lat2,temp_lon2;
        String polyid;
        List<riskyPersonArea> risktotalarea = new ArrayList<>();
        HashMap<Location,String> map = new HashMap<>();
        HashMap<Location,Integer> count_infected_Map = new HashMap<>();
        HashMap<Location,Integer> count_closed_Map = new HashMap<>();
        for(riskyPersonArea a : area){
            temp_lat1=(int) (a.getLat()*cluster_num);
            temp_lon1=(int) (a.getLon()*cluster_num);
            Location location = new Location().setLat(temp_lat1).setLon(temp_lon1);
            if (map.containsKey(location)){
                if(a.getStatus().equals("3")){
                    if(!count_infected_Map.containsKey(location)){
                        count_infected_Map.put(location,0);
                    }
                    count_infected_Map.put(location,count_infected_Map.get(location) + 1);
                }
                else{
                    if(!count_closed_Map.containsKey(location)) {
                        count_closed_Map.put(location,0);
                    }
                    count_closed_Map.put(location,count_closed_Map.get(location) + 1);
                }
                continue;
            }
            polyid=location.getLat()+"_"+location.getLon();
            map.put(location,polyid);
            if(a.getStatus().equals("3"))
            {
                count_infected_Map.put(location,1);
            }
            else{
                count_closed_Map.put(location,1);
            }
        }
        for(Location key:count_infected_Map.keySet()){
            temp_closed=0;
            temp_lat2=(double)(key.getLat())/cluster_num;
            temp_lon2=(double)(key.getLon())/cluster_num;
            riskyPersonArea riskyarea1=new riskyPersonArea().setLat(temp_lat2)
                    .setLon(temp_lon2).setPoly_id(map.get(key));
            temp_infected=count_infected_Map.get(key);
            riskyarea1.setInfected_count(temp_infected);
            if(count_closed_Map.containsKey(key)){
                temp_closed=count_closed_Map.get(key);
                riskyarea1.setClosed_count(temp_closed);
                count_closed_Map.remove(key);
            }
            riskyarea1.setStatus(judge_level(temp_infected,temp_closed));
            risktotalarea.add(riskyarea1);
        }
        return risktotalarea;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Boolean riskyarea_to_database(List<riskyPersonArea> riskyPersonAreas){
        riskyAreaMapper.create_riskyarea_table();
        List<riskyPersonArea> riskyarea_database=riskyAreaMapper.riskyarea_from_database();
        HashMap<riskyPersonArea,Boolean> test_area = new HashMap<>();
        if(riskyarea_database.size()==0)
        {
            for(riskyPersonArea r:riskyPersonAreas){
                tableService.insert_info_table(r);
            }
        }
        else{
            for(riskyPersonArea a : riskyPersonAreas)
            {
                test_area.put(a,true);
            }
            for(riskyPersonArea r1:riskyarea_database)
            {
                if(test_area.containsKey(r1)){
                    test_area.put(r1,false);
                }
            }
            for(riskyPersonArea r2:riskyarea_database){
                if(!test_area.containsKey(r2))
                {
                    tableService.delete_info_table(r2);
                }
            }
            for(riskyPersonArea r3:test_area.keySet()){
                if(test_area.get(r3))
                {
                    tableService.insert_info_table(r3);
                }
            }
        }
        return true;
    }

    public List<riskyPersonArea> riskyarea_operation(){
        List<riskyPersonArea> riskyareas=riskyarea_fromdatabase();
        List<riskyPersonArea> riskyPersonAreas=CalculateRiskyArea(riskyareas);
        riskyarea_to_database(riskyPersonAreas);
        return riskyPersonAreas;
    }

    public  int getCluster_num() {
        return cluster_num;
    }

}
