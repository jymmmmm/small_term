package teleDemo.entities_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.poly_string;
/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */


public class poly_string_test {
    public poly_string return_pair(){
         String str_data = "yyh";
        poly_string poly_string = new poly_string("1","A",str_data);

        System.out.println(poly_string);
        return poly_string;



    }
    @Test
    public void test_poly(){
        Assertions.assertEquals("poly_string(str_data=yyh)", return_pair().toString());
    }
}
