package teleDemo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.riskyPersonArea;
import teleDemo.entities.tbuser;

import java.util.List;

@Mapper
public interface riskyAreaMapper {
    @Select("select distinct u.id,u.status,i.lat,i.lon from teledata.tb_user as u inner join teledata.tb_info as i \n" +
            "where u.id = i.user_id and u.status = 2 or u.status = 3;")
    @Results(id = "areaMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lat", property = "lat", jdbcType = JdbcType.DOUBLE),
            @Result(column = "lon", property = "lon", jdbcType = JdbcType.DOUBLE)
    })
    List<riskyPersonArea> getAllArea();

}
