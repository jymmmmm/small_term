package teleDemo.entities;

import javafx.util.Pair;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: poly_post
 * @Author: Jia Yiming
 * @Data:2022/8/25 09:21
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_post<T> extends poly{
    List<T> list_data;
    public poly_post(int id, List<T> string_to_poly) {
        this.setId(id);
        this.setList_data(string_to_poly);
    }
    public poly_post() {

    }
}
