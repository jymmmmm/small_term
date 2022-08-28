package teleDemo.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.Location;
import teleDemo.entities.poly_list;
import teleDemo.entities.poly_string;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.polyAreaMapper;
import teleDemo.mapper.riskyAreaMapper;
import teleDemo.util.conversion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static teleDemo.util.area_policy.generate_location;
import static teleDemo.util.conversion.string_to_pair;
import static teleDemo.util.conversion.string_to_poly;

@Service
public class polyAreaService {
    @Autowired
    polyAreaMapper polyAreaMapper;

    @Autowired
    riskyAreaMapper riskyAreaMapper;

    @Autowired
    tableService tableService;

    @Autowired
    riskyAreaService riskyAreaService;

    public List<poly_list> getpolyArea(){
        ConcurrentHashMap<String,String> polylist_map=new ConcurrentHashMap<>();
        List<poly_list> poly_list_data = new ArrayList<>();
        List<riskyPersonArea> area=riskyAreaMapper.riskyarea_from_database();
        tableService.test_table("polyarea");
        List<poly_string> polyarea = polyAreaMapper.getAllPolyArea();
        List<poly_string> error_ployarea= polyAreaMapper.getAllPolyArea();
        if(polyarea.size() == 0){
            for(riskyPersonArea a : area){
                Location location = new Location();
                int x = (int)(a.getLat()*riskyAreaService.getCluster_num());
                int y = (int)(a.getLon()*riskyAreaService.getCluster_num());
                location.setLon(y).setLat(x);
                poly_list poly_list=new poly_list(a.getPoly_id(),a.getStatus(),generate_location(location,a.getStatus(),riskyAreaService.getCluster_num()));
                tableService.insert_info_table(poly_list);
                poly_list_data.add(poly_list);
            }
        }
        else{
            for(riskyPersonArea a:area){
                polylist_map.put(a.getPoly_id(),a.getStatus());
            }
            for(poly_string ar: polyarea){
                if(polylist_map.containsKey(ar.getId()))
                {
                    if(polylist_map.get(ar.getId()).equals(ar.getStatus())){
                        poly_list pl = conversion.ps_to_pl(ar);
                        poly_list_data.add(pl);
                    }
                    else{
                        //可以之后改进风险范围
                        poly_string b=new poly_string(ar.getId(),polylist_map.get(ar.getId()),ar.getStr_data());
                        poly_list pl = conversion.ps_to_pl(b);
                        tableService.update_info_table(pl);
                        poly_list_data.add(pl);
                    }
                    polylist_map.remove(ar.getId());
                }
                else{
                    tableService.delete_info_table(ar);
                }
            }
            for(String key:polylist_map.keySet()){
                Pair<Integer,Integer> pair=string_to_pair(key);
                Location location=new Location().setLon(pair.getKey()).setLat(pair.getValue());
                poly_list poly_list=new poly_list(key,polylist_map.get(key),generate_location(location,polylist_map.get(key), riskyAreaService.getCluster_num()));
                poly_list_data.add(poly_list);
                tableService.insert_info_table(poly_list);
            }
        }
        return poly_list_data;
    }

}
