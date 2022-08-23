package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;

import java.util.List;

@Service
public class riskyAreaService {
    @Autowired
    riskyAreaMapper riskyAreaMapper;

    public List<riskyPersonArea> getRiskyArea(){
        List<riskyPersonArea> area = riskyAreaMapper.getAllArea();
        return area;
    }
}
