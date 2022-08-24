package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.Location;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class riskyAreaService {
    @Autowired
    riskyAreaMapper riskyAreaMapper;

    public List<riskyPersonArea> getRiskyArea(){
        List<riskyPersonArea> area = riskyAreaMapper.getAllArea();
        HashMap<Location,Integer> map = new HashMap<>();
        HashMap<Location,Integer> count_infected_Map = new HashMap<>();
        HashMap<Location,Integer> count_closed_Map = new HashMap<>();
        for(riskyPersonArea a : area){
            Location location = new Location();
            int x = (int)a.getLat();
            int y = (int)a.getLon();
            String s =a.getStatus();
            location.setLon(y).setLat(x).setStatus(s);
            if (map.containsKey(location)){
                if(location.getStatus().equals("3")){
                count_infected_Map.put(location,count_infected_Map.get(location) + 1);
                }
                else{
                    count_closed_Map.put(location,count_closed_Map.get(location) + 1);
                }
                continue;
            }
            map.put(location,a.getId());
            if(location.getStatus().equals("3"))
            {
                count_infected_Map.put(location,1);
                System.out.println(count_infected_Map);
            }
            else{
                count_closed_Map.put(location,1);
            }
        }
        List<riskyPersonArea> numArea = new ArrayList<>();
        for (Location key : map.keySet() ){
            riskyPersonArea r = new riskyPersonArea().setLat(key.getLat())
                    .setLon(key.getLon())
                    .setId(0)
                    .setStatus(null);
            if(key.getStatus().equals("3"))
            {
                r.setInfected_count(count_infected_Map.get(key));
            }
            else{
                r.setClosed_count(count_closed_Map.get(key));
            }
            numArea.add(r);
        }
        return numArea;
    }
}
