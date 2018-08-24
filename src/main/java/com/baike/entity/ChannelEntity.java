package com.baike.entity;

import java.io.Serializable;

/**
 * Created by dongliangyu on 2018/8/22.
 */
public class ChannelEntity implements Serializable{
    public String channelId;

    public String channelName;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
