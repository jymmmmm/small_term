package teleDemo.controller_test;

/**
 * @Project Name:MSHD
 * @Description: 测试controller层，。。。。。。
 * @ HISTORY：
 *    Created   2022.8.30  yaoyuhan
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import teleDemo.controller.areaController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Assertions;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = areaController.class)//这里放启动类
public class LoanControllerTest {

    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }

    @Test
    public void should_get_getRiskyArea_success_byGet() throws Exception {
        String result = mockMvc.perform(
                get("/v1/area", "412233333333"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String expected = "{1}";

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void should_get_getRiskyPoly_success_byGet() throws Exception {
        String result = mockMvc.perform(
                get("/v1/poly", "412233333333"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String expected = "{1}";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void should_get_postRiskyArea_success_byPost() throws Exception {
        String result = mockMvc.perform(
                post("/v1/polyy", "412233333333"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String expected = "{1}";

        Assertions.assertEquals(expected, result);
    }
}

