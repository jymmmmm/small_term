package teleDemo.service_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teleDemo.areaManage10003;
import teleDemo.service.polyAreaService;

import java.util.ArrayList;
import java.util.List;
import teleDemo.entities.*;


@SpringBootTest(classes = areaManage10003.class)
public class polyAreaService_test {
    @Autowired
    polyAreaService  polyAreaService;

    @Test
    public void testCalculate_polyarea(){
        List<riskyPersonArea> areaOriginal = new ArrayList<>();
        riskyPersonArea riskyPersonArea = new riskyPersonArea();
        riskyPersonArea.setLat(1.0);
        riskyPersonArea.setLon(2.0);
        riskyPersonArea.setStatus("3");
        riskyPersonArea.setClosed_count(1);
        riskyPersonArea.setInfected_count(2);
        riskyPersonArea.setPoly_id("123");
        areaOriginal.add(riskyPersonArea);
        List<poly_list> polyLists = this.polyAreaService.Calculate_polyarea(areaOriginal);
        List<Pair<Double,Double>> testPolyListData = new ArrayList<>();
        testPolyListData.add(new Pair<>(0.996,1.996));
        testPolyListData.add(new Pair<>(0.996,2.004));
        testPolyListData.add(new Pair<>(1.004,2.004));
        testPolyListData.add(new Pair<>(1.004,1.996));
        List<poly_list> testPolyLists = new ArrayList<>();
        testPolyLists.add(new poly_list("123","3",testPolyListData));
        Assertions.assertEquals(testPolyLists,polyLists);
    }
}
