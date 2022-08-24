package teleDemo.entities;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: poly
 * @Author: Jia Yiming
 * @Data:2022/8/24 13:07
 */


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class poly {
    private int id;
    private String poly;
}
