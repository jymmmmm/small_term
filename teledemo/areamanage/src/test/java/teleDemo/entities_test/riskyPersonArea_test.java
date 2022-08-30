package teleDemo.entities_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.riskyPersonArea;

public class riskyPersonArea_test {
    public riskyPersonArea return_riskyPersonArea() {

        riskyPersonArea riskyPersonArea = new riskyPersonArea();
        riskyPersonArea.setLat(1.0);
        riskyPersonArea.setLon(2.0);
        riskyPersonArea.setStatus("A");
        riskyPersonArea.setClosed_count(2);
        riskyPersonArea.setInfected_count(2);
        riskyPersonArea.setPoly_id("123");
        System.out.println(riskyPersonArea);
        return riskyPersonArea;
    }
    @Test
    public void test_riskyPersonArea(){
        Assertions.assertEquals("riskyPersonArea(lat=1.0, lon=2.0, status=A, infected_count=2, closed_count=2, poly_id=123)", return_riskyPersonArea().toString());
    }
}
