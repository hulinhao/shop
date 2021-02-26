package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.JcUserAddress;

/**
 * 用户收货地址Mapper接口
 *
 * @author hlinhao Hu
 * @date 2021-02-26
 */
public interface JcUserAddressMapper
{
    /**
     * 查询用户收货地址
     *
     * @param id 用户收货地址ID
     * @return 用户收货地址
     */
    public JcUserAddress selectJcUserAddressById(Long id);

    /**
     * 查询用户收货地址列表
     *
     * @param jcUserAddress 用户收货地址
     * @return 用户收货地址集合
     */
    public List<JcUserAddress> selectJcUserAddressList(JcUserAddress jcUserAddress);

    /**
     * 新增用户收货地址
     *
     * @param jcUserAddress 用户收货地址
     * @return 结果
     */
    public int insertJcUserAddress(JcUserAddress jcUserAddress);

    /**
     * 修改用户收货地址
     *
     * @param jcUserAddress 用户收货地址
     * @return 结果
     */
    public int updateJcUserAddress(JcUserAddress jcUserAddress);

    /**
     * 删除用户收货地址
     *
     * @param id 用户收货地址ID
     * @return 结果
     */
    public int deleteJcUserAddressById(Long id);

    /**
     * 批量删除用户收货地址
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcUserAddressByIds(String[] ids);
}
