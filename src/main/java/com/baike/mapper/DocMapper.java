package com.baike.mapper;

import com.baike.entity.DocEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by dongliangyu on 2018/8/15.
 */
public interface DocMapper {
    public DocEntity findByTitle(String docTitle);
}
