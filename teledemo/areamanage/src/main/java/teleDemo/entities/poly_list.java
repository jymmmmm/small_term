package teleDemo.entities;

import javafx.util.Pair;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Projectname: 项目前后端架构(1)
 * @Filename: poly_list
 * @Author: Jia Yiming
 * @Data:2022/8/24 14:34
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_list extends poly{
    List<Pair<Float,Float>> list_data;

    public poly_list(int id, String status, List<Pair<Float, Float>> string_to_poly) {
        this.setId(id);
        this.setStatus(status);
        this.setList_data(string_to_poly);
    }

    public poly_list() {

    }
}
