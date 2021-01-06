package com.ruoyi.web.controller.backstage;

import java.util.List;

import com.ruoyi.domain.bo.ProductInfoBo;
import com.ruoyi.service.JcProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.JcProduct;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author linhao Hu
 * @date 2020-10-12
 */
@Controller
@RequestMapping("/system/product")
public class JcProductController extends BaseController
{
    private String prefix = "backstage/product";

    @Autowired
    private JcProductService jcProductService;

    @RequiresPermissions("system:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("system:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JcProduct jcProduct)
    {
        startPage();
        List<JcProduct> list = jcProductService.selectJcProductList(jcProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("system:product:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JcProduct jcProduct)
    {
        List<JcProduct> list = jcProductService.selectJcProductList(jcProduct);
        ExcelUtil<JcProduct> util = new ExcelUtil<JcProduct>(JcProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("system:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JcProduct jcProduct)
    {
        return toAjax(jcProductService.insertJcProduct(jcProduct));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JcProduct jcProduct = jcProductService.selectJcProductById(id);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("system:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JcProduct jcProduct)
    {
        return toAjax(jcProductService.updateJcProduct(jcProduct));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("system:product:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jcProductService.deleteJcProductByIds(ids));
    }


    @PostMapping( "/getProductInfo")
    @ResponseBody
    public TableDataInfo getProductInfo(@RequestBody ProductInfoBo productInfoBo){

        return null;
    }
}
