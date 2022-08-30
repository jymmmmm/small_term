package teleDemo.entities_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.poly;
/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */


public class poly_test {

    public poly return_poly(){

        poly poly = new poly();
        poly.setId("8");
        poly.setStatus("A");
        System.out.println(poly);
        return poly;



    }
    @Test
    public void test_poly(){
        Assertions.assertEquals("poly(id=8, status=A)", return_poly().toString());
    }
}
