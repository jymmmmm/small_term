package teleDemo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.poly_string;

import java.util.List;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: polyAreaMapper
 * @Author: Jia Yiming
 * @Data:2022/8/24 14:47
 */

@Mapper
public interface polyAreaMapper {
    @Select("select distinct u.id, u.status, u.str_data from teledata.polyarea as u;")
    @Results(id = "polyarea", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_data", property = "str_data", jdbcType = JdbcType.VARCHAR),

    })
    List<poly_string> getAllArea();

    @Insert("insert into polyarea (id,status,str_data) values (#{poly_string.id},#{poly_string.status},#{poly_string.str_data});")
    void insert_info_table(@Param("poly_string") poly_string poly_string) throws RuntimeException;

    @Update("update polyarea set status=#{poly_string.status},str_data=#{poly_string.str_data} where id=#{poly_string.id} limit #{poly_string.id};")
    void update_info_table(@Param("poly_string") poly_string poly_string) throws RuntimeException;


}
