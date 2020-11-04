package com.ruoyi.service;

import com.ruoyi.domain.*;
import com.ruoyi.domain.vo.RestResultVo;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 18:19
 */
public interface AppletService {

    /**
     * 登录
     * @param user
     * @return
     */
    JcUser login(JcUser user);

    /**
     * 购物车
     * @param userId
     * @return
     */
    List<CartVo> getCartByUserId(Long userId);

    /**
     * 查询首页  每个类型显示3个产品
     * @return
     */
    List<IndexVo> getIndex();

    /**
     * 查询所有商品
     * @return
     */
    List<ProductVo> getProductByTypeId(Long typeId);

    /**
     * 查询所有商品类型
     * @return
     */
    List<JcProductType> getType();

    /**
     * 查询商品详情
     * @param pId
     * @return
     */
    ProductVo getDetail(Long pId);

    RestResultVo addCart(Long pId,Long attrId,Long num,Long userId);
}
