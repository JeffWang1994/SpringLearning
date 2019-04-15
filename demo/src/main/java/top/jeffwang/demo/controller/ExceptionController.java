package top.jeffwang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jeffwang.demo.domain.MyException;
import top.jeffwang.demo.domain.User;

import java.util.Date;

@RestController
public class ExceptionController {

    /**
     * 功能描述：模拟全局异常
     * @return
     */
    @RequestMapping(value = "/api/v1/test_ext")
    public Object index(){
        int i = 1/0;
        return new User(11, "sfsdasdw", "1000000", new Date());

    }

    /**
     * 功能描述：模拟自定义异常
     * @return
     */
    @RequestMapping("/api/v1/myext")
    public Object myext(){
        throw new MyException("500", "my ext 异常");
    }
}
