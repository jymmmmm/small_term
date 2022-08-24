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
        HashMap<Location,Integer> countMap = new HashMap<>();
        for(riskyPersonArea a : area){
            Location location = new Location();
            int x = (int)a.getLat();
            int y = (int)a.getLon();
            String s = a.getStatus();
            location.setLon(y).setLat(x).setStatus(s);
            if (map.containsKey(location)){
                countMap.put(location,countMap.get(location) + 1);
                continue;
            }
            map.put(location,a.getId());
            countMap.put(location,1);
        }
        List<riskyPersonArea> numArea = new ArrayList<>();
        for (Location key : map.keySet() ){
            riskyPersonArea r = new riskyPersonArea().setLat(key.getLat())
                    .setLon(key.getLon())
                    .setStatus(key.getStatus())
                    .setId(0)
                    .setCount(countMap.get(key));
            numArea.add(r);
        }
        return numArea;
    }
}
