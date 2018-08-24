package com.baike.mapper.hdcms;

import com.baike.entity.ChannelEntity;

/**
 * Created by dongliangyu on 2018/8/22.
 */
public interface  ChannelMapper {
    public ChannelEntity findChannelByName(String channelName) ;
}
