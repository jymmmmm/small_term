package teleDemo.entities_test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.entities.Location;
import teleDemo.entities.Pair;
/**
 * @Project Name:MSHD
 * @Description: 测试实体类，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */

public class Pair_test {
    public Pair return_pair(){

        Pair pair = new Pair(1,"one");

        System.out.println(pair);
        return pair;



    }
    @Test
    public void test_location(){
        Assertions.assertEquals("Pair(key=1, value=one)",return_pair().toString());
    }
}
