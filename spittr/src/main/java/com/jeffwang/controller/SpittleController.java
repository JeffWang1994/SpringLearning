package com.jeffwang.controller;

import com.jeffwang.Spittle;
import com.jeffwang.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    //private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    /**
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
     **/

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
        @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
        @RequestParam(value = "count", defaultValue = "20") int count){
            return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId,
            Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}

