package teleDemo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class poly_string extends poly{
    private String str_data;

    public poly_string(String id,String status,String poly_to_string) {
        this.setStr_data(poly_to_string);
        this.setStatus(status);
        this.setId(id);
    }
}
