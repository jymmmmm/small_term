package teleDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import teleDemo.entities.GetVo;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;
import teleDemo.mapper.userInfoMapper;
import teleDemo.service.riskyAreaService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class areaController {
    @Autowired
    riskyAreaService riskyAreaService;

    @Resource

    riskyAreaMapper riskyAreaMapper;

    @ResponseBody
    @RequestMapping ("/v1/area")
    public GetVo<?> getRiskyArea(){

        return new GetVo<riskyPersonArea>(200,"success",0,riskyAreaService.getRiskyArea());
    }
}
