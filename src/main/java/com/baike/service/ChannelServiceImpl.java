package com.baike.service;

import com.baike.entity.ChannelEntity;
import com.baike.entity.DocEntity;
import com.baike.mapper.hdcms.ChannelMapper;
import com.baike.mapper.hddoc.DocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dongliangyu on 2018/8/15.
 */
@Service
public class ChannelServiceImpl {
    @Autowired
    private ChannelMapper channelMapper;
    public ChannelEntity findChannelByName(String channelName) {
        return channelMapper.findChannelByName(channelName);
    }
}
