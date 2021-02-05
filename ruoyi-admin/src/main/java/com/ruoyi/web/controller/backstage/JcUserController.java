package com.ruoyi.web.controller.backstage;

import java.util.List;


import com.ruoyi.service.JcUserService;
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
import com.ruoyi.domain.JcUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author hlinhao Hu
 * @date 2020-10-19
 */
@Controller
@RequestMapping("/ruoyi/user")
public class JcUserController extends BaseController
{
    private String prefix = "backstage/user";

    @Autowired
    private JcUserService jcUserService;

    @RequiresPermissions("ruoyi:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("ruoyi:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JcUser jcUser)
    {
        startPage();
        List<JcUser> list = jcUserService.selectJcUserList(jcUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("ruoyi:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JcUser jcUser)
    {
        List<JcUser> list = jcUserService.selectJcUserList(jcUser);
        ExcelUtil<JcUser> util = new ExcelUtil<JcUser>(JcUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("ruoyi:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JcUser jcUser)
    {
        return toAjax(jcUserService.insertJcUser(jcUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JcUser jcUser = jcUserService.selectJcUserById(id);
        mmap.put("jcUser", jcUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("ruoyi:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JcUser jcUser)
    {
        return toAjax(jcUserService.updateJcUser(jcUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("ruoyi:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jcUserService.deleteJcUserByIds(ids));
    }
}
