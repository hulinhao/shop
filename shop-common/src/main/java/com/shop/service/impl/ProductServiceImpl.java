package com.shop.service.impl;

import com.shop.entity.vo.ProductVo;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linhaoHu
 * @date 2019/10/22 10:37
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Override
    public List<ProductVo> getProductVo() {
        return productRepository.findProductVo();
    }
}
