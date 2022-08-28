package teleDemo.entities;

import javafx.util.Pair;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_list extends poly{
    List<Pair<Double,Double>> list_data;

    public poly_list(String id,String status,List<Pair<Double,Double>> string_to_poly) {
        this.setId(id);
        this.setStatus(status);
        this.setList_data(string_to_poly);
    }

}
