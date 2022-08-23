package teleDemo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import teleDemo.entities.tbInfo;
import teleDemo.entities.tbuser;

import java.util.List;

@Mapper
public interface userInfoMapper {
    @Select("SELECT * FROM eqe.tb_user;")
    @Results(id="tbUserMap",value={
            @Result(column = "id",property = "id",jdbcType = JdbcType.INTEGER,id = true),
            @Result(column = "phone_number",property = "phoneNumber",jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "status",property = "status",jdbcType = JdbcType.VARCHAR),
    })
    List<tbuser> getAlltbUser();

    @Select("select * from eqe.tb_user limit #{pageNum}, #{limit};")
    @ResultMap(value = "tbUserMap")
    List<tbuser> gettbUserByPage(@Param("pageNum") int pageNum, @Param("limit")int limit);
}
