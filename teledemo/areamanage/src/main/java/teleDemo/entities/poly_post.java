package teleDemo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_post<T> extends poly{
    List<T> list_data;
    public poly_post(String id,String status,List<T> string_to_poly) {
        this.setId(id);
        this.setStatus(status);
        this.setList_data(string_to_poly);
    }
    public poly_post() {

    }
}
