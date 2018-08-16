package com.baike.controller;

import com.baike.entity.DocEntity;
import com.baike.service.DocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dongliangyu on 2018/8/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private DocServiceImpl docServiceImpl;

    @RequestMapping("/{docTitle}")
    @ResponseBody
    public DocEntity index(@PathVariable String docTitle){
        System.out.println("start");
        DocEntity result =  docServiceImpl.findByTitle(docTitle);
        return result;
    }

}
