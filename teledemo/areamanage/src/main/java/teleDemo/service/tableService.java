package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teleDemo.entities.poly_list;
import teleDemo.entities.poly_string;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.polyAreaMapper;
import teleDemo.mapper.riskyAreaMapper;
import static teleDemo.util.conversion.pl_to_ps;

@Service
public class tableService {

    @Autowired
    polyAreaMapper polyAreaMapper;

    @Autowired
    riskyAreaMapper riskyAreaMapper;

    public void insert_info_table(poly_list poly_list){
        poly_string poly_string=pl_to_ps(poly_list);
        polyAreaMapper.insert_info_table(poly_string);
    }

    public void insert_info_table(riskyPersonArea r){
        riskyAreaMapper.insert_info_table(r);
    }

    public void update_info_table(poly_list poly_list){
        poly_string poly_string=pl_to_ps(poly_list);
        polyAreaMapper.update_info_table(poly_string);
    }

    public void delete_info_table(riskyPersonArea riskyPersonArea){
        riskyAreaMapper.delete_info_table(riskyPersonArea);
    }
    public void delete_info_table(poly_string poly_string){
        polyAreaMapper.delete_info_table(poly_string);
    }
}
