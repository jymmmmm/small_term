package teleDemo.entities_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.Pair;
import java.util.List;
import teleDemo.entities.poly_list;
/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */


public class poly_list_test {
    List<Pair<Double,Double>> list_data;


    public poly_list return_pair_list(){

        poly_list poly_List = new poly_list("1","A",list_data);


        return poly_List;



    }
    @Test
    public void test_pair_list(){
        Assertions.assertEquals("poly_list(list_data=null)", return_pair_list().toString());
    }
}
