package teleDemo.util_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teleDemo.util.area_policy;

/**
 * @Project Name:MSHD
 * @File Name: area_policy_test
 * @Description: 测试area_policy逻辑，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.25  HeYujie
 */

public class area_policy_test {
    @Test
    public void testJudgeLevel() {
        Assertions.assertEquals("a", area_policy.judge_level(1000, 0));
        Assertions.assertEquals("c", area_policy.judge_level(0, 0));
        Assertions.assertEquals("b", area_policy.judge_level(0, 50));
    }
}
