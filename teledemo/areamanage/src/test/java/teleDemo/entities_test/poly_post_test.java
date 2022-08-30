package teleDemo.entities_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.Pair;
import teleDemo.entities.poly_post;
import java.util.List;
import teleDemo.entities.poly_list;
/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */


public class poly_post_test {
    public poly_post poly_post_return(){
        List<Pair<Double,Double>> list_data = null;
        poly_post poly_Post = new poly_post("1","one",list_data);

        return poly_Post;
    }
    @Test
    public void test_poly(){
        Assertions.assertEquals("poly_post(list_data=null)", poly_post_return().toString());
    }
}
