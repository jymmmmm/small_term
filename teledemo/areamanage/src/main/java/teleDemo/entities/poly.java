package teleDemo.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class poly implements Serializable {
    private String id;
    private String status;
}

