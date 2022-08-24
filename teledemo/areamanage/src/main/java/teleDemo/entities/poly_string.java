package teleDemo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: poly_string
 * @Author: Jia Yiming
 * @Data:2022/8/24 14:33
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_string extends poly{
    private String str_data;

    public poly_string(int id, String status, String poly_to_string) {
        this.setStr_data(poly_to_string);
        this.setId(id);
        this.setStatus(status);
    }
}
