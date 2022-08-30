package teleDemo.mapper_test;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.poly_string;


public interface TestPolyAreaMapper {
    @Select("select distinct * from polyarea where status=#{poly.status} and str_data=#{poly.str_data} and id=#{poly.id}")
    @Results(id = "polyarea", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "str_data", property = "str_data", jdbcType = JdbcType.VARCHAR),

    })
    poly_string getPolyArea(@Param("poly") poly_string poly_string);
}
