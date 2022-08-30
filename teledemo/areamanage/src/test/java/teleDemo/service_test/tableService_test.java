package teleDemo.service_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import teleDemo.areaManage10003;
import teleDemo.mapper_test.TestPolyAreaMapper;
import teleDemo.mapper_test.TestRiskyAreaMapper;
import teleDemo.service.riskyAreaService;
import teleDemo.service.tableService;

import java.util.ArrayList;
import java.util.List;
import teleDemo.entities.*;

@SpringBootTest(classes = areaManage10003.class)
public class tableService_test {
    @Autowired
    tableService tableService;

    @Autowired
    TestPolyAreaMapper testPolyAreaMapper;

    @Autowired
    TestRiskyAreaMapper testRiskyAreaMapper;

    @Test
    public void testInsertPolyList() {
        Pair<Double,Double> pair = new Pair<>(10.0,10.0);
        List<Pair<Double,Double>> list_data = new ArrayList<>();
        list_data.add(pair);
        poly_list poly_List = new poly_list("1","HIGH",list_data);
        tableService.insert_info_table(poly_List);

        poly_string poly_string = new poly_string("1","HIGH","10.0_10.0");
        poly_string testPoly = testPolyAreaMapper.getPolyArea(poly_string);

        Assertions.assertEquals(testPoly, poly_string);

    }

    @Test
    public void testInsertRiskyPersonArea() {
        riskyPersonArea riskyPersonArea = new riskyPersonArea().setLat(10.0).setLon(10.0)
                .setPoly_id("1").setClosed_count(10).setStatus("HIGH").setInfected_count(20);
        tableService.insert_info_table(riskyPersonArea);

        riskyPersonArea testRiskyPersonArea = testRiskyAreaMapper.getRiskyArea(riskyPersonArea);
        Assertions.assertEquals(testRiskyPersonArea, riskyPersonArea);
    }

    @Test
    public void testUpdatePolyList() {
        Pair<Double,Double> pair = new Pair<>(10.0,10.0);
        List<Pair<Double,Double>> list_data = new ArrayList<>();
        list_data.add(pair);
        poly_list poly_List = new poly_list("1","HIGH",list_data);
        tableService.update_info_table(poly_List);

        poly_string poly_string = new poly_string("1","HIGH","10.0_10.0");
        poly_string testPoly = testPolyAreaMapper.getPolyArea(poly_string);

        Assertions.assertEquals(testPoly, poly_string);
    }

    @Test
    public void testDeletePolyList() {
        riskyPersonArea riskyPersonArea = new riskyPersonArea().setLat(10.0).setLon(10.0)
                .setPoly_id("1").setClosed_count(10).setStatus("HIGH").setInfected_count(20);
        tableService.delete_info_table(riskyPersonArea);

        riskyPersonArea testRiskyPersonArea = testRiskyAreaMapper.getRiskyArea(riskyPersonArea);
        Assertions.assertNull(testRiskyPersonArea);
    }

    @Test
    public void testDeleteRiskyPersonArea() {

        poly_string poly_string = new poly_string("1","HIGH","10.0_10.0");
        tableService.delete_info_table(poly_string);
        poly_string testPoly = testPolyAreaMapper.getPolyArea(poly_string);

        Assertions.assertNull(testPoly);
    }
}
