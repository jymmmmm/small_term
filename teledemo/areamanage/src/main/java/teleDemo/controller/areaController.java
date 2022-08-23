package teleDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import teleDemo.entities.GetVo;
import teleDemo.entities.riskyPersonArea;
import teleDemo.mapper.riskyAreaMapper;
import teleDemo.service.riskyAreaService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class areaController {
    @Resource
    riskyAreaMapper riskyAreaMapper;

    @GetMapping("/area")
    public GetVo getRiskyArea(HttpServletRequest request){
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        int size = riskyAreaMapper.getAllArea().size();
        System.out.println("1");
        List<riskyPersonArea> areas=riskyAreaMapper.getAllAreaByPage((page-1)*limit,limit);
        GetVo<riskyPersonArea> getVo=new GetVo<>(0,"获取数据成功！",size,areas);
        return getVo;
    }
}
