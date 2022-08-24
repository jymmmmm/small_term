package teleDemo.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Location {
    private int lat;
    private int lon;
    private String status;
}
