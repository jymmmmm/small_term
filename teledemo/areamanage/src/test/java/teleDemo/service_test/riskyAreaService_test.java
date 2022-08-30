package teleDemo.service_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import teleDemo.entities.riskyPersonArea;
import teleDemo.service.riskyAreaService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import teleDemo.util.area_policy;

public class riskyAreaService_test {
    @Autowired
    riskyAreaService  riskyAreaService ;


    public List<riskyPersonArea> return_riskyAreaService() {

        List<riskyPersonArea> area = riskyAreaService.CalculateRiskyArea();
        System.out.println(area);
        return area;

    }
    @Test
    public void riskyAreaService(){
        Assertions.assertEquals("a", area_policy.judge_level(1000, 0));
    }
}
