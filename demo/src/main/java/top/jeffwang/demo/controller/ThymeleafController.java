package top.jeffwang.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jeffwang.demo.domain.ServerSettings;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private ServerSettings setting;

    @GetMapping("hello")
    public String index(){
        return "index";
    }

    @GetMapping("info")
    public String info(ModelMap modelMap){
        setting.setName("SpringBoot");
        modelMap.addAttribute("setting", setting);
        return "admin/info";
    }

}
