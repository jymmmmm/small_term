package teleDemo.mapper_test;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.riskyPersonArea;

public interface TestRiskyAreaMapper {

    @Select("select distinct * from riskyarea where lat=#{risky.lat} and lon=#{risky.lon} and status=#{risky.status} and " +
            " infected_count=#{risky.infected_count} and closed_count=#{risky.closed_count}and poly_id=#{risky.poly_id})")
    @Results(id = "riskyarea", value = {
            @Result(column = "lat", property = "lat", jdbcType = JdbcType.DOUBLE,id = true),
            @Result(column = "lon", property = "lon", jdbcType = JdbcType.DOUBLE,id = true),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "infected_count", property = "infected_count", jdbcType = JdbcType.INTEGER),
            @Result(column = "closed_count", property = "closed_count", jdbcType = JdbcType.INTEGER),
            @Result(column = "poly_id", property = "poly_id", jdbcType = JdbcType.VARCHAR)

    })
    riskyPersonArea getRiskyArea(@Param("risky") riskyPersonArea riskyPersonArea);
}
