package com.ruoyi.service;

import com.ruoyi.domain.*;
import com.ruoyi.domain.vo.AddressVo;
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
     * 查询爆款产品，首页展示
     * @return
     */
    IndexVo getIndex();

    /**
     * 查询所有商品
     * @return
     */
    List<ProductVo> getProductByTypeId(Integer typeId);

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

    RestResultVo updateCart(Long id,Long num);
    
    RestResultVo delCart(Long id);
    
    RestResultVo clearCart(Long userId);

    List<AddressVo> getAllAddr(Long userId);

    JcOrder createOrder(OrderVo orderVo,JcUser user);
}
