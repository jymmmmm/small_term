package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import teleDemo.entities.poly_list;
import teleDemo.entities.poly_string;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.polyAreaMapper;
import teleDemo.mapper.riskyAreaMapper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import static teleDemo.util.conversion.pl_to_ps;

@Service
public class tableService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    polyAreaMapper polyAreaMapper;

    @Autowired
    riskyAreaMapper riskyAreaMapper;

    public void createTable(JdbcTemplate jt,String tableName){
        StringBuffer sb = new StringBuffer();
        if(tableName.equals("polyarea")){
            sb.append("create table polyarea");
            sb.append("(id int not null,");
            sb.append("status varchar(20) not null,");
            sb.append("str_data varchar(255) not null);");
        }
        if(tableName.equals("riskyarea")){
            sb.append("create table riskyarea(");
            sb.append("lat double,lon double,");
            sb.append("status varchar(20) not null,");
            sb.append("infected_count int not null,");
            sb.append("closed_count int not null,");
            sb.append("poly_id int not null,");
            sb.append("primary key(lat,lon));");
        }
        try {
            jt.update(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test_table(String tableName){
        try {
            if(getAllTableName(jdbcTemplate,tableName)){
            }
            else{
                createTable(jdbcTemplate,tableName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  boolean getAllTableName(JdbcTemplate jt,String tableName) throws Exception {
        Connection conn = jt.getDataSource().getConnection();
        ResultSet tabs = null;
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String[]   types  =   { "TABLE" };
            tabs = dbMetaData.getTables(null, null, tableName, types);
            if (tabs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            tabs.close();
            conn.close();
        }
        return false;
    }

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
}
