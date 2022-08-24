package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.poly;
import teleDemo.entities.poly_list;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;

import java.util.List;

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
        return null;
    }
}
