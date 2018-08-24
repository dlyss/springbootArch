package com.baike.mapper.hddoc;

import com.baike.entity.DocEntity;


/**
 * Created by dongliangyu on 2018/8/15.
 */
public interface DocMapper {
    public DocEntity findByTitle(String docTitle);
}
