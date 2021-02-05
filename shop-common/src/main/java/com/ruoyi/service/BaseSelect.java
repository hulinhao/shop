package com.ruoyi.service;

import com.ruoyi.domain.JcProductType;
import com.ruoyi.mapper.BaseSelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2021/2/3 15:15
 */
@Service("baseSelect")
public class BaseSelect {

    @Autowired
    private BaseSelectMapper baseSelectMapper;
    /**
     * 查詢所有产品类型
     * @return
     */
    public List<Map<Long,String>> getProductType(){
        return baseSelectMapper.getProductType();
    }
}
