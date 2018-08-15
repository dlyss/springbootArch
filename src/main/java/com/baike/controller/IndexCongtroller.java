package com.baike.controller;

import com.baike.service.DocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dongliangyu on 2018/8/15.
 */
@Controller
@RequestMapping("/")
public class IndexCongtroller {
    @Autowired
    private DocServiceImpl docServiceImpl;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
           return "Hello";
    }

}
