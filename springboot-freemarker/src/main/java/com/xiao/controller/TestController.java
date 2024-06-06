package com.xiao.controller;/**
 * Created by 小飞 on 2019/8/1.
 */


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 小飞
 * @Auther: 小飞
 * @Date: 2019/8/1 21:48
 * @Description:
 */

@Controller
public class TestController {

    @RequestMapping("/test")
    public String testFreemarker(Model model) {
        model.addAttribute("msg", "this is freemarker");
        return "freemarker";
    }
}
