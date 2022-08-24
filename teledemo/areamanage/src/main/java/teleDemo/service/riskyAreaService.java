package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.Location;
import teleDemo.entities.poly;
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
        HashMap<Location,Integer> repeat_map=new HashMap<>();
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
            }
            else{
                count_closed_Map.put(location,1);
            }
        }
        List<riskyPersonArea> numArea = new ArrayList<>();
        Location temp_location=new Location();
        Location stored_location=new Location();
        for (Location key:map.keySet() ){
            if(!repeat_map.containsKey(key)){
            riskyPersonArea r = new riskyPersonArea().setLat(key.getLat())
                    .setLon(key.getLon())
                    .setId(0)
                    .setStatus(null);
            if(key.getStatus().equals("3"))
            {
                r.setInfected_count(count_infected_Map.get(key));
                temp_location.setLat(key.getLat()).setLon(key.getLon()).setStatus("2");
                if(map.containsKey(temp_location)){
                    r.setClosed_count(count_closed_Map.get(temp_location));
                    repeat_map.put(stored_location.setLat(temp_location.getLat()).setLon(temp_location.getLon()).setStatus(temp_location.getStatus()),0);
                }
            }
            else{
                r.setClosed_count(count_closed_Map.get(key));
                temp_location.setLat(key.getLat()).setLon(key.getLon()).setStatus("3");
                if(map.containsKey(temp_location)){
                    r.setInfected_count(count_infected_Map.get(temp_location));
                    repeat_map.put(stored_location.setLat(temp_location.getLat()).setLon(temp_location.getLon()).setStatus(temp_location.getStatus()),0);
                }
            }
            numArea.add(r);
            }
        }
        return numArea;

    }
}
