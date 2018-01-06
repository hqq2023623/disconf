package com.baidu.disconf.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lzj
 * @date 2018/1/2
 */
@Controller
public class HtmlController {

    @RequestMapping("/")
    public ModelAndView root() {
        return new ModelAndView("index");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("main");
    }

    @RequestMapping("/modifyFile")
    public ModelAndView modifyFile() {
        return new ModelAndView("modifyFile");
    }

    @RequestMapping("/modifypassword")
    public ModelAndView modifypassword() {
        return new ModelAndView("modifypassword");
    }

    @RequestMapping("/newapp")
    public ModelAndView newapp() {
        return new ModelAndView("newapp");
    }

    @RequestMapping("/newconfig")
    public ModelAndView newconfig() {
        return new ModelAndView("newconfig");
    }

    @RequestMapping("/newconfig_file")
    public ModelAndView newconfig_file() {
        return new ModelAndView("newconfig_file");
    }

    @RequestMapping("/newconfig_item")
    public ModelAndView newconfig_item() {
        return new ModelAndView("newconfig_item");
    }


}
