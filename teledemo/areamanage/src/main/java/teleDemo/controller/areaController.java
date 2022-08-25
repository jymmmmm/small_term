package teleDemo.controller;


import org.springframework.web.bind.annotation.*;
import teleDemo.entities.*;
import teleDemo.service.polyAreaService;
import teleDemo.service.riskyAreaService;
import teleDemo.service.tableService;

import javax.annotation.Resource;
import java.util.List;

import static teleDemo.util.conversion.pp_to_pl;

@RestController
public class areaController {
    @Resource
    riskyAreaService riskyAreaService;
    @Resource
    polyAreaService polyAreaService;
    @Resource
    tableService tableService;

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
        List<poly_list> polyarea =polyAreaService.getpolyArea();
        GetVo<poly_list> getVo = new GetVo<>(0,"获取数据成功！",1,polyarea);
        return getVo;
    }

    @PostMapping("/v1/polyy")
    public poly_post postRiskyArea(@RequestBody poly_post poly_post){
        poly_list poly_list=pp_to_pl(poly_post);
        tableService.update_info_table(poly_list);
        return poly_post;
    }
}
