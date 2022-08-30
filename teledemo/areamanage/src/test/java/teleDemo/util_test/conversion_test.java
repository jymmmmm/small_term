package teleDemo.util_test;

import org.apache.http.util.TextUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import teleDemo.util.area_policy;
import teleDemo.util.conversion;
import teleDemo.entities.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Project Name:MSHD
 * @Description: 测试controller层，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */
public class conversion_test {
    @Autowired
    conversion conversion;
    public List set_poly() {
        List<Pair<Double, Double>> poly = new ArrayList<Pair<Double, Double>>();
        Double source = 99.0;
        Double  placementKey = 98.0;

           poly.add(new Pair<Double, Double>(source, placementKey));

        return poly;
    }
    public List set_post() {
        List<List<Double>> post= new ArrayList<List<Double>>();
        post.add(new LinkedList<>());  //先添加层数
        post.get(0).add(99.8);          //后在指定层数进行添值:list.get(layers).add(value);
        post.add(new LinkedList<>());
        post.get(1).add(98.8);

        return post;
    }
    @Test
    public void poly_to_string_test() {
        Assertions.assertEquals("99.0_98.0_", conversion.poly_to_string(set_poly()));

    }
    @Test
    public void string_to_poly_test() {
        Assertions.assertEquals("[Pair(key=98.8, value=99.0)]", conversion.string_to_poly("98.8_99.0_").toString());

    }
    @Test
    public void post_to_list_test() {
        Assertions.assertEquals("[]", conversion.post_to_list(set_post()).toString());

    }
}
