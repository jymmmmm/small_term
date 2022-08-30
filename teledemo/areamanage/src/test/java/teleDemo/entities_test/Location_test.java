package teleDemo.entities_test;

/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */

import org.junit.jupiter.api.Test;
import teleDemo.entities.Location;
import org.junit.jupiter.api.Assertions;
import teleDemo.util.area_policy;

public class Location_test {


    public Location return_location(){

        Location location = new Location();
        location.setLon(99);
        location.setLat(108);
        System.out.println(location);
        return location;



    }
    @Test
    public void test_location(){
        Assertions.assertEquals("Location(lat=108, lon=99)", return_location().toString());
    }

}
