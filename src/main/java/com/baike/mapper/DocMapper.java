package com.baike.mapper;

import com.baike.entity.DocEntity;

import java.util.List;

/**
 * Created by dongliangyu on 2018/8/15.
 */
public interface DocMapper {
    public List<DocEntity> findByTitle(String docTitle);
}
