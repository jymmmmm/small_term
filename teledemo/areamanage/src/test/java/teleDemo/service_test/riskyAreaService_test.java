package teleDemo.service_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teleDemo.areaManage10003;
import teleDemo.entities.riskyPersonArea;
import teleDemo.service.riskyAreaService;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import teleDemo.util.area_policy;

@SpringBootTest(classes = areaManage10003.class)
public class riskyAreaService_test {
    @Autowired
    riskyAreaService  riskyAreaService;

    @Test
    public void testCalculateRiskyArea(){
        List<riskyPersonArea> areaOriginal = new ArrayList<>();
        for (int i=0;i<10;i++){
            riskyPersonArea riskyPersonArea = new riskyPersonArea();
            riskyPersonArea.setLat(1.0);
            riskyPersonArea.setLon(2.0);
            riskyPersonArea.setStatus("3");
            riskyPersonArea.setClosed_count(2);
            riskyPersonArea.setInfected_count(2);
            riskyPersonArea.setPoly_id("123");
            areaOriginal.add(riskyPersonArea);
        }
        List<riskyPersonArea> areas = this.riskyAreaService.CalculateRiskyArea(areaOriginal);
        List<riskyPersonArea> testAreas = new ArrayList<>();
        testAreas.add(new riskyPersonArea().setLat(1.0).setLon(2.0).setStatus("HIGH")
                .setInfected_count(10).setClosed_count(0).setPoly_id("100_200"));
        Assertions.assertEquals(areas,testAreas);
    }
    @Test
    public void riskyAreaService(){
        Assertions.assertEquals("HIGH", area_policy.judge_level(1000, 0));
        Assertions.assertEquals("MEDIUM", area_policy.judge_level(0, 10));
        Assertions.assertEquals("LOW", area_policy.judge_level(0, 1));

    }
}
