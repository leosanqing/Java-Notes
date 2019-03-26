package com.swu.leosanqing.resthome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/template")
    public class TemplateController {
      @RequestMapping("/")
      public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://www.turingdi.com");
        // return模板文件的名称，对应resources/templates/temp.html
        return "demo";
      }
    }