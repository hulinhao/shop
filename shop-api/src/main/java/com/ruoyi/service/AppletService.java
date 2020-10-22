package com.ruoyi.service;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.JcUser;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 18:19
 */
public interface AppletService {

    JcUser login(JcUser user);

    List<CartVo> getCartByUserId(Long userId);
}
