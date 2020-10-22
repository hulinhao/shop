package com.ruoyi.service.impl;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.JcUser;
import com.ruoyi.mapper.CartMapper;
import com.ruoyi.mapper.JcUserMapper;
import com.ruoyi.service.AppletService;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
    private CartMapper cartMapper;

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
        return cartMapper.getCartList(userId);
    }
}
