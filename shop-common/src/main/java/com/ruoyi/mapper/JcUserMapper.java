package com.ruoyi.mapper;

import java.util.List;

import com.ruoyi.domain.JcUser;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户Mapper接口
 * 
 * @author hlinhao Hu
 * @date 2020-10-19
 */
public interface JcUserMapper extends Mapper<JcUser>
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public JcUser selectJcUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param jcUser 用户
     * @return 用户集合
     */
    public List<JcUser> selectJcUserList(JcUser jcUser);

    /**
     * 新增用户
     * 
     * @param jcUser 用户
     * @return 结果
     */
    public int insertJcUser(JcUser jcUser);

    /**
     * 修改用户
     * 
     * @param jcUser 用户
     * @return 结果
     */
    public int updateJcUser(JcUser jcUser);

    /**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteJcUserById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcUserByIds(String[] ids);
}
