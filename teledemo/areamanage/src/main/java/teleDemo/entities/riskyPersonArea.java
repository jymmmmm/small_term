package teleDemo.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@Data
@Accessors(chain = true)
public class riskyPersonArea implements Serializable {
    private double lat;
    private double lon;
    private String status;
    private int infected_count;
    private int closed_count;
    private String poly_id;
}
