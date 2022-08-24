package teleDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import teleDemo.entities.GetVo;
import teleDemo.entities.poly;
import teleDemo.entities.poly_list;
import teleDemo.entities.riskyPersonArea;
import teleDemo.service.riskyAreaService;
import teleDemo.service.polyAreaService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class areaController {
    @Resource
    riskyAreaService riskyAreaService;

    @Resource
    polyAreaService polyAreaService;

    @ResponseBody
    @GetMapping("/v1/area")
    public GetVo getRiskyArea(){
        List<riskyPersonArea> areas= riskyAreaService.getRiskyArea();
        GetVo<riskyPersonArea> getVo=new GetVo<>(0,"获取数据成功！",1,areas);
        return getVo;
    }
    @ResponseBody
    @GetMapping("/v1/poly")
    public GetVo getRiskyPoly(){
        List<poly_list> polyarea = polyAreaService.getpolyArea();
        GetVo<poly_list> getVo = new GetVo<>(0,"获取数据成功！",1,polyarea);
        return getVo;
    }


}
