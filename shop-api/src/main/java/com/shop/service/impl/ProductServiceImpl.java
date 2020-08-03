package com.shop.service.impl;


import com.shop.entity.vo.ProductVo;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import com.shop.utils.MyBeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linhaoHu
 * @date 2019/8/29 16:28
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Override
    public List<ProductVo> findAll() {
        return productRepository.findProductVo();
    }
}
