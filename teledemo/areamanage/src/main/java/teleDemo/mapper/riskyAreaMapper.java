package teleDemo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.poly_string;
import teleDemo.entities.riskyPersonArea;

import java.util.List;

@Mapper
public interface riskyAreaMapper {
    @Select("select distinct u.id,u.status,i.lat,i.lon from teledata.tb_user as u inner join teledata.tb_info as i \n" +
            "where u.id = i.user_id and u.status = 2 or u.status = 3;")
    @Results(id = "areaMap", value = {
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "lat", property = "lat", jdbcType = JdbcType.DOUBLE),
            @Result(column = "lon", property = "lon", jdbcType = JdbcType.DOUBLE)
    })
    List<riskyPersonArea> calculate_riskyarea();

    @Select("select r.lat,r.lon,r.status,r.infected_count,r.closed_count,r.poly_id from riskyarea as r;")
    @Results(id = "riskyarea", value = {
            @Result(column = "lat", property = "lat", jdbcType = JdbcType.DOUBLE,id = true),
            @Result(column = "lon", property = "lon", jdbcType = JdbcType.DOUBLE,id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "infected_count", property = "infected_count", jdbcType = JdbcType.INTEGER),
            @Result(column = "closed_count", property = "closed_count", jdbcType = JdbcType.INTEGER),
            @Result(column = "poly_id", property = "poly_id", jdbcType = JdbcType.VARCHAR)

    })
    List<riskyPersonArea> riskyarea_from_database();

    @Insert("insert into riskyarea (lat,lon,status,infected_count" +
            ",closed_count,poly_id) values (#{risky.lat},#{risky.lon},#{risky.status}" +
            ",#{risky.infected_count},#{risky.closed_count},#{risky.poly_id});")
    void insert_info_table(@Param("risky") riskyPersonArea riskyPersonArea) throws RuntimeException;

    @Delete("delete from riskyarea where lat=#{risky.lat} and lon=#{risky.lon}")
    void delete_info_table(@Param("risky") riskyPersonArea riskyPersonArea) throws RuntimeException;
}
