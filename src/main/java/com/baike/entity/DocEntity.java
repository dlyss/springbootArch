package com.baike.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dongliangyu on 2018/8/15.
 */
public class DocEntity implements Serializable{
    public String docTitle;
    public int docState;
    public Date docCreatedTime;

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public int getDocState() {
        return docState;
    }

    public void setDocState(int docState) {
        this.docState = docState;
    }

    public Date getDocCreatedTime() {
        return docCreatedTime;
    }

    public void setDocCreatedTime(Date docCreatedTime) {
        this.docCreatedTime = docCreatedTime;
    }
}
