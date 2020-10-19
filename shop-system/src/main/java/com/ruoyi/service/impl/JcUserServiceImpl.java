package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.mapper.JcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.domain.JcUser;
import com.ruoyi.service.JcUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author hlinhao Hu
 * @date 2020-10-19
 */
@Service
public class JcUserServiceImpl implements JcUserService
{
    @Autowired
    private JcUserMapper jcUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public JcUser selectJcUserById(Long id)
    {
        return jcUserMapper.selectJcUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param jcUser 用户
     * @return 用户
     */
    @Override
    public List<JcUser> selectJcUserList(JcUser jcUser)
    {
        return jcUserMapper.selectJcUserList(jcUser);
    }

    /**
     * 新增用户
     * 
     * @param jcUser 用户
     * @return 结果
     */
    @Override
    public int insertJcUser(JcUser jcUser)
    {
        jcUser.setCreateTime(DateUtils.getNowDate());
        return jcUserMapper.insertJcUser(jcUser);
    }

    /**
     * 修改用户
     * 
     * @param jcUser 用户
     * @return 结果
     */
    @Override
    public int updateJcUser(JcUser jcUser)
    {
        jcUser.setUpdateTime(DateUtils.getNowDate());
        return jcUserMapper.updateJcUser(jcUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJcUserByIds(String ids)
    {
        return jcUserMapper.deleteJcUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteJcUserById(Long id)
    {
        return jcUserMapper.deleteJcUserById(id);
    }
}
