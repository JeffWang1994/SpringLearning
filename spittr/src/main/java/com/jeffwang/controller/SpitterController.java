package com.jeffwang.controller;

import com.jeffwang.Spitter;
import com.jeffwang.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    /**
     * 自动装配SpittleRepository Bean
     * @param spitterRepository
     */
    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    /**
     * 展示注册页面
     * 指定路径: /spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    /**
     * 输入注册表单信息，并且存储到仓库中
     * @param spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegisteration(
            @Valid Spitter spitter,
            Errors errors){

        // 如果校验Spitter输入出现错误，则返回表单，重新填写。
        if (errors.hasErrors()){
            return "registerForm";
        }

        spitterRepository.save(spitter);
        // 重定向至基本信息页
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
