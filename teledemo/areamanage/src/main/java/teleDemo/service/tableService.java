package teleDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import teleDemo.entities.poly_string;
import teleDemo.mapper.polyAreaMapper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Service
public class tableService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    polyAreaMapper polyAreaMapper;

    public  void createTable(JdbcTemplate jt){
        StringBuffer sb = new StringBuffer("");
        sb.append("create table polyarea");
        sb.append("(id int not null,");
        sb.append("status varchar(20) not null,");
        sb.append("str_data varchar(255) not null);");
        try {
            jt.update(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test_table(){
        try {
            if(getAllTableName(jdbcTemplate,"polyarea")){
            }
            else{
                createTable(jdbcTemplate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean getAllTableName(JdbcTemplate jt,String tableName) throws Exception {
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

    public void insert_info_table(poly_string poly_string){
        test_table();
        polyAreaMapper.insert_info_table(poly_string);
    }
    public void update_info_table(poly_string poly_string){
        polyAreaMapper.update_info_table(poly_string);
    }
}
