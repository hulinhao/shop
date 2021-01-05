package com.ruoyi.web.controller.backstage;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.JcOrder;
import com.ruoyi.service.IJcOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
@Controller
@RequestMapping("/ruoyi/order")
public class JcOrderController extends BaseController
{
    private String prefix = "backstage/order";

    @Autowired
    private IJcOrderService jcOrderService;

    @RequiresPermissions("ruoyi:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单管理列表
     */
    @RequiresPermissions("ruoyi:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JcOrder jcOrder)
    {
        startPage();
        List<JcOrder> list = jcOrderService.selectJcOrderList(jcOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @RequiresPermissions("ruoyi:order:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JcOrder jcOrder)
    {
        List<JcOrder> list = jcOrderService.selectJcOrderList(jcOrder);
        ExcelUtil<JcOrder> util = new ExcelUtil<JcOrder>(JcOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单管理
     */
    @RequiresPermissions("ruoyi:order:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JcOrder jcOrder)
    {
        return toAjax(jcOrderService.insertJcOrder(jcOrder));
    }

    /**
     * 修改订单管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JcOrder jcOrder = jcOrderService.selectJcOrderById(id);
        mmap.put("jcOrder", jcOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单管理
     */
    @RequiresPermissions("ruoyi:order:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JcOrder jcOrder)
    {
        return toAjax(jcOrderService.updateJcOrder(jcOrder));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("ruoyi:order:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jcOrderService.deleteJcOrderByIds(ids));
    }
}
