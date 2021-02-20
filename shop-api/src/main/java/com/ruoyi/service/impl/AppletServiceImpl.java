package com.ruoyi.service.impl;

import com.ruoyi.domain.*;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.ShopEnum;
import com.ruoyi.mapper.AppletMapper;
import com.ruoyi.mapper.JcCartMapper;
import com.ruoyi.mapper.JcUserMapper;
import com.ruoyi.service.AppletService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/19 15:55
 */
@Service
public class AppletServiceImpl implements AppletService {
    @Resource
    private JcUserMapper userMapper;
    @Resource
    private AppletMapper appletMapper;
    @Resource
    private JcCartMapper cartMapper;

    @Override
    public JcUser login(JcUser user) {
        //查询当前用户
        Example e =new Example(JcUser.class);
        Example.Criteria criteria = e.createCriteria();
        criteria.andEqualTo("wxOpenid",user.getWxOpenid());
        JcUser jcUser = userMapper.selectOneByExample(e);
        if(jcUser == null){ //注册用户
            user.setName(user.getWxNickname());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insertJcUser(user);
        }
        return jcUser == null ? user:jcUser;
    }

    @Override
    public List<CartVo> getCartByUserId(Long userId) {
        return appletMapper.getCartList(userId);
    }

    @Override
    public IndexVo getIndex() {
        IndexVo indexVo = new IndexVo();
        //查询爆款产品
        ProductVo productVo =  appletMapper.getProductByStatus(ShopEnum.product_status.HOT.getCode());
        //查询所有类型
        List<JcProductType> list = appletMapper.getType();
        indexVo.setTypeList(list);
        indexVo.setProductVo(productVo);
        return indexVo;
    }

    @Override
    public List<ProductVo> getProductByTypeId(Integer typeId) {
        return appletMapper.getProduct(typeId);
    }

    @Override
    public  List<JcProductType> getType() {
       return appletMapper.getType();
    }

    @Override
    public ProductVo getDetail(Long pId) {
        //查询商品
        ProductVo productVo = appletMapper.getProductById(pId);
        //查询商品属性
        List<ProductVo.PAttr> attrs = appletMapper.getPattr(pId);
        productVo.setPAttrs(attrs);
        return productVo;
    }

    @Override
    public RestResultVo addCart(Long pId, Long attrId, Long num,Long userId) {
        JcCart cart = new JcCart();
        cart.setProductId(pId);
        cart.setProductAttrId(attrId);
        cart.setNumber(num);
        cart.setDflag(0L);
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());
        cart.setUserId(userId);
        if (cartMapper.insertJcCart(cart)>0)
            return RestResultVo.SUCCESS();

        return RestResultVo.FAIL();
    }
}
