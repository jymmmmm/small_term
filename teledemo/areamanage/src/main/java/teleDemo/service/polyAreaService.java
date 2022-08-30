package teleDemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import teleDemo.entities.*;
import teleDemo.mapper.polyAreaMapper;
import teleDemo.mapper.riskyAreaMapper;
import teleDemo.util.conversion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import static teleDemo.util.area_policy.generate_location;
import static teleDemo.util.conversion.string_to_pair;

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

    public List<poly_list> Calculate_polyarea(){
        List<riskyPersonArea> area=riskyAreaMapper.riskyarea_from_database();
        List<poly_list> poly_list_data = new ArrayList<>();
        for(riskyPersonArea a : area){
            Location location = new Location();
            BigDecimal bd_lat = new BigDecimal(String.valueOf(a.getLat()));
            BigDecimal bd_lon = new BigDecimal(String.valueOf(a.getLon()));
            BigDecimal bd_cluster = new BigDecimal(String.valueOf(riskyAreaService.getCluster_num()));
            int x = bd_lat.multiply(bd_cluster).intValue();
            int y = bd_lon.multiply(bd_cluster).intValue();
            location.setLon(y).setLat(x);
            poly_list poly_list=new poly_list(a.getPoly_id(),a.getStatus(),generate_location(location,a.getStatus(),riskyAreaService.getCluster_num()));
            poly_list_data.add(poly_list);
        }
        return poly_list_data;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Boolean polyarea_to_database(List<poly_list> polylist_data ){
        polyAreaMapper.create_polyarea_table();
        ConcurrentHashMap<String,String> polylist_map=new ConcurrentHashMap<>();
        List<poly_string> polyarea = polyAreaMapper.getAllPolyArea();
        List<riskyPersonArea> area=riskyAreaMapper.riskyarea_from_database();
        if(polyarea.size() == 0){
            for(poly_list poly: polylist_data){
                tableService.insert_info_table(poly);
            }
        }
        else{
            for(riskyPersonArea a:area){
                polylist_map.put(a.getPoly_id(),a.getStatus());
            }
            for(poly_string ar: polyarea){
                if(polylist_map.containsKey(ar.getId()))
                {
                    if(!polylist_map.get(ar.getId()).equals(ar.getStatus())){
                        poly_string b=new poly_string(ar.getId(),polylist_map.get(ar.getId()),ar.getStr_data());
                        poly_list pl = conversion.ps_to_pl(b);
                        tableService.update_info_table(pl);
                    }
                    polylist_map.remove(ar.getId());
                }
                else{
                    tableService.delete_info_table(ar);
                }
            }
            for(String key:polylist_map.keySet()){
                Pair<Integer,Integer> pair=string_to_pair(key);
                Location location=new Location().setLon(pair.getValue()).setLat(pair.getKey());//经纬度赋值相反
                poly_list poly_list=new poly_list(key,polylist_map.get(key),generate_location(location,polylist_map.get(key), riskyAreaService.getCluster_num()));
                tableService.insert_info_table(poly_list);
            }
        }
        return true;
    }

    public List<poly_list> polyarea_operation(){
        List<poly_list> polyarea=Calculate_polyarea();
        polyarea_to_database(polyarea);
        return polyarea;
    }

}
