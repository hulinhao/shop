package com.ruoyi.service.impl;

import java.util.List;

import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.domain.bo.ProductInfoBo;
import com.ruoyi.domain.vo.ProductInfoVo;
import com.ruoyi.service.JcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.JcProductMapper;
import com.ruoyi.domain.JcProduct;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author linhao Hu
 * @date 2020-10-12
 */
@Service
public class JcProductServiceImpl implements JcProductService
{
    @Autowired
    private JcProductMapper jcProductMapper;

    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public JcProduct selectJcProductById(Long id)
    {
        return jcProductMapper.selectJcProductById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param jcProduct 商品
     * @return 商品
     */
    @Override
    public List<JcProduct> selectJcProductList(JcProduct jcProduct)
    {
        return jcProductMapper.selectJcProductList(jcProduct);
    }

    /**
     * 新增商品
     * 
     * @param jcProduct 商品
     * @return 结果
     */
    @Override
    public int insertJcProduct(JcProduct jcProduct)
    {
        jcProduct.setCreateTime(DateUtils.getNowDate());
        return jcProductMapper.insertJcProduct(jcProduct);
    }

    /**
     * 修改商品
     * 
     * @param jcProduct 商品
     * @return 结果
     */
    @Override
    public int updateJcProduct(JcProduct jcProduct)
    {
        jcProduct.setUpdateTime(DateUtils.getNowDate());
        return jcProductMapper.updateJcProduct(jcProduct);
    }

    /**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJcProductByIds(String ids)
    {
        return jcProductMapper.deleteJcProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteJcProductById(Long id)
    {
        return jcProductMapper.deleteJcProductById(id);
    }

    @Override
    public List<ProductInfoVo> getProductInfo(ProductInfoBo productInfoBo) {
        List<ProductInfoVo> list = jcProductMapper.getProductInfo(productInfoBo);
        return list;
    }

}
