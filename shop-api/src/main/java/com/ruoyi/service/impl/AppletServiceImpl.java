package com.ruoyi.service.impl;

import com.ruoyi.domain.*;
import com.ruoyi.domain.vo.AddressVo;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.ShopEnum;
import com.ruoyi.mapper.*;
import com.ruoyi.service.AppletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Resource
    private JcUserAddressMapper addressMapper;
    @Resource
    private JcOrderMapper orderMapper;
    @Resource
    private JcOrderDetailMapper orderDetailMapper;

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

    @Override
    public RestResultVo updateCart(Long id, Long num) {
        JcCart jcCart = cartMapper.selectJcCartById(id);
        if(jcCart == null)
            return RestResultVo.FAIL("查无此单");
        
        jcCart.setNumber(num);
        jcCart.setUpdateTime(new Date());
        
        return cartMapper.updateJcCart(jcCart)>0?RestResultVo.SUCCESS():RestResultVo.ERROR();
    }

    @Override
    public RestResultVo delCart(Long id) {
        JcCart jcCart = cartMapper.selectJcCartById(id);
        if(jcCart == null)
            return RestResultVo.FAIL("查无此单");

        jcCart.setDflag(1L);
        jcCart.setUpdateTime(new Date());
        jcCart.setRemark("删除商品");
        return cartMapper.updateJcCart(jcCart)>0?RestResultVo.SUCCESS():RestResultVo.ERROR();
    }

    @Override
    public RestResultVo clearCart(Long userId) {
        JcCart jcCart = new JcCart();
        jcCart.setUserId(userId);
        jcCart.setDflag(0L);
        List<JcCart> list = cartMapper.selectJcCartList(jcCart);
        for (JcCart j : list){
            j.setDflag(1L);
            j.setUpdateTime(new Date());
            j.setRemark("清空购物车");
            cartMapper.updateJcCart(j);
        }
        return RestResultVo.SUCCESS();
    }

    @Override
    public List<AddressVo> getAllAddr(Long userId) {
        
        return appletMapper.getAllAddr(userId);
    }

    @Override
    @Transactional
    public JcOrder createOrder(OrderVo orderVo,JcUser user) {
        JcOrder order = new JcOrder();
        order.setUserId(user.getId());
        order.setAddress(orderVo.getAddress());
        order.setName(orderVo.getName());
        order.setPaidPrice(orderVo.getPaidPrice());
        order.setPhone(orderVo.getPhone());
        order.setStatus(ShopEnum.order_status.DAIZHIFU.getCode());
        order.setRemark(orderVo.getRemark());
        order.setTime(new Date());
        order.setCreateTime(new Date());
        if(orderMapper.insertJcOrder(order)>0){
            for (CartVo c : orderVo.getPlist()){
                JcOrderDetail d = new JcOrderDetail();
                d.setOrderId(order.getId());
                d.setProductId(c.getProductId());
                d.setName(c.getPoductName());
                d.setNumber(c.getNum());
                d.setImg(c.getImg());
                d.setPrice(c.getPrice());
                d.setSize(c.getSize());
                d.setRemark(order.getRemark());
                d.setCreateTime(new Date());
                orderDetailMapper.insertJcOrderDetail(d);
                //修改购物车商品状态
                JcCart cart = cartMapper.selectJcCartById(c.getCartId());
                cart.setUpdateTime(new Date());
                cart.setRemark("已生成订单");
                cart.setDflag(2L);
                cartMapper.updateJcCart(cart);
            }
        }
        return order;
    }


}
