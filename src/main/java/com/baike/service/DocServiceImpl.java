package com.baike.service;

import com.baike.entity.DocEntity;
import com.baike.mapper.hddoc.DocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dongliangyu on 2018/8/15.
 */
@Service
public class DocServiceImpl {
    @Autowired
    private DocMapper docMapper;
    public DocEntity findByTitle(String docTitle){
        return docMapper.findByTitle(docTitle);
    }
}
