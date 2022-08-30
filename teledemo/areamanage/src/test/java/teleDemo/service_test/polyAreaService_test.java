package teleDemo.service_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import teleDemo.service.polyAreaService;
import java.util.List;
import teleDemo.entities.*;


public class polyAreaService_test {
    @Autowired
    polyAreaService  polyAreaService ;

    @Test
    public void return_location() {

        List<poly_list> area = polyAreaService.getpolyArea();
        System.out.println(area);

    }
}
