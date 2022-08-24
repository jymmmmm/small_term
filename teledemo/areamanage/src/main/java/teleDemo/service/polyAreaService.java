package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.Location;
import teleDemo.entities.poly;
import teleDemo.entities.poly_list;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static teleDemo.util.area_policy.generate_location;
import static teleDemo.util.area_policy.judge_level;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: polyAreaService
 * @Author: Jia Yiming
 * @Data:2022/8/24 14:09
 */

@Service
public class polyAreaService {
    @Autowired
    riskyAreaMapper riskyAreaMapper;

    public List<poly_list> getpolyArea(){
        List<riskyPersonArea> area = riskyAreaMapper.getAllArea();
        HashMap<Location,Integer> map = new HashMap<>();
        int poly_id=1;
        for(riskyPersonArea a : area){
            Location location = new Location();
            int x = (int)a.getLat();
            int y = (int)a.getLon();
            String s=judge_level(a.getInfected_count(),a.getClosed_count());
            location.setLon(y).setLat(x).setStatus(s);
            map.put(location,0);
        }
        List<poly_list> poly_lists = new ArrayList<>();
        for(Location key:map.keySet())
        {
            poly_list poly_list=new poly_list().setList_data(generate_location(key));
            poly_list.setId(poly_id);
            poly_list.setStatus(key.getStatus());
            poly_lists.add(poly_list);
            poly_id++;
        }
        return poly_lists;
    }
}
