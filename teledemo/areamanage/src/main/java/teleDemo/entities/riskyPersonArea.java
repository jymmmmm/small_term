package teleDemo.entities;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class riskyPersonArea implements Serializable {
    private double lat;
    private double lon;
    private int userId;
    private String status;
}
