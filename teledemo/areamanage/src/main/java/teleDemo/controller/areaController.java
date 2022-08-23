package teleDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import teleDemo.entities.GetVo;
import teleDemo.entities.riskyPersonArea;
import teleDemo.service.riskyAreaService;

import java.util.List;

@Controller
public class areaController {
    @Autowired
    riskyAreaService riskyAreaService;

    @GetMapping("/area")
    public GetVo<?> getRiskyArea(){
        return new GetVo<riskyPersonArea>(200,"success",0,riskyAreaService.getRiskyArea());
    }
}
