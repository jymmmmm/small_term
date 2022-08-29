package teleDemo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.poly_string;

import java.util.List;


@Mapper
public interface polyAreaMapper {
    @Select("select distinct u.id, u.status, u.str_data from teledata.polyarea as u;")
    @Results(id = "polyarea", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_data", property = "str_data", jdbcType = JdbcType.VARCHAR),

    })
    List<poly_string> getAllPolyArea();

    @Insert("insert into polyarea (id,status,str_data) values (#{poly_string.id},#{poly_string.status},#{poly_string.str_data});")
    void insert_info_table(@Param("poly_string") poly_string poly_string) throws RuntimeException;

    @Update("update polyarea set status=#{poly.status},str_data=#{poly.str_data} where id=#{poly.id};")
    void update_info_table(@Param("poly") poly_string poly_string) throws RuntimeException;

    @Delete("delete from polyarea where id=#{poly.id};")
    void delete_info_table(@Param("poly") poly_string poly_string) throws RuntimeException;

    @Insert("create table if not exists polyarea (id varchar(50) not null,status varchar(10) not null,str_data varchar(255) not null,primary key(id));")
    void create_polyarea_table();
}
