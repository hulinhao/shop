package com.shop.service;


import com.shop.entity.vo.ProductVo;

import java.util.List;

/**
 * @author linhaoHu
 * @date 2019/8/29 16:27
 */
public interface ProductService {

    List<ProductVo> findAll();
}
