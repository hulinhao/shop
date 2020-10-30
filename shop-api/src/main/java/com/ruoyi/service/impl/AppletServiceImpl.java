package com.ruoyi.service.impl;

import com.ruoyi.domain.*;
import com.ruoyi.mapper.AppletMapper;
import com.ruoyi.mapper.JcUserMapper;
import com.ruoyi.service.AppletService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public List<IndexVo> getIndex() {
        List<IndexVo> indexVos = new ArrayList<>();
        //查询所有类型
        List<JcProductType> list = appletMapper.getType();
        for (JcProductType m : list){
            IndexVo indexVo = new IndexVo();
            indexVo.setTypeId(m.getId());
            indexVo.setName(m.getName());
            indexVo.setImg(m.getImg());
            //查询商品
            List<IndexVo.ProductInfo> productVos =  appletMapper.getProductInfoByType(m.getId());
            indexVo.setPList(productVos);
            indexVos.add(indexVo);
        }
        return indexVos;
    }

    @Override
    public List<ProductVo> getProductByTypeId(Long typeId) {
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
}
