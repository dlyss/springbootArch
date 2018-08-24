package com.baike.controller;

import com.baike.entity.ChannelEntity;
import com.baike.entity.DocEntity;
import com.baike.service.ChannelServiceImpl;
import com.baike.service.DocServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by dongliangyu on 2018/8/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private DocServiceImpl docServiceImpl;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ChannelServiceImpl channelServiceImpl;

    @RequestMapping("/{docTitle}")
    @ResponseBody
    public Map index(@PathVariable String docTitle) throws UnsupportedEncodingException {
        HashMap resultMap = new HashMap();
        //test log
        logger.debug("test debug log");
        logger.info("test info log");
        logger.error("test error log");
        System.out.println("start");
        String redisKey = DigestUtils.md5DigestAsHex(docTitle.getBytes("UTF-8"));

        DocEntity result = docServiceImpl.findByTitle(docTitle);
        //redis temp
        ValueOperations<String, DocEntity> operations = redisTemplate.opsForValue();
        //ª∫¥Ê¥Ê‘⁄
        boolean hasKey = redisTemplate.hasKey(redisKey);
        if (hasKey) {
            logger.error("get key from redis");

        }
        operations.set(redisKey, result, 1000);
        logger.error("set key into redis");

        ChannelEntity channelResult = channelServiceImpl.findChannelByName("test");

        resultMap.put("1", result);
        resultMap.put("2", channelResult);
        return resultMap;
    }

    /**
     * jsp index ≤‚ ‘
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/jsp")
    public String jsp(Map<String, Object> model) throws UnsupportedEncodingException {
        model.put("time", new Date());
        model.put("message", "this is  a message");
        return "Index";
    }

}
