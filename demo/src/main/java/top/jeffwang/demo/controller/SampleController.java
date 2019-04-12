package top.jeffwang.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jeffwang.demo.domain.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {
    @RequestMapping("/")
    String home(){
        return "Hello World!";
    }

    @RequestMapping("/test")
    public Map<String, String> testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xdclass");
        return map;
    }

    @RequestMapping("/testjson")
    public Object testjson(){
        return new User(111, "abc123", "110000110", new Date());
    }


}
