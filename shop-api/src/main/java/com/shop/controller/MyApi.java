package com.shop.controller;

import com.shop.utils.FileUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author linhaoHu
 * @date 2019/7/26 17:03
 */
@RestController
@RequestMapping("api")
//标注swagger管理此controller 前端访问页面http://localhost:8081/swagger-ui.html
@EnableSwagger2
@Api(value = "静态数据接口",description = "提供静态数据,供前端调试",tags = { "Api" })
public class MyApi {

    @ApiOperation(value = "店铺信息",notes = "index", produces = "application/json; charset=utf-8")
    @RequestMapping(value = "index",method = RequestMethod.POST)
    public String getIndex(@RequestParam("type")Integer type){
        return type == 1 ? "type is 1" : FileUtil.getApi("index.json");
    }

    @ApiOperation(value = "书品种类",notes = "catalog", produces = "application/json; charset=utf-8")
    @RequestMapping(value = "catalog",method = RequestMethod.POST)
    public String catalog(){
        return FileUtil.getApi("catalog.json");
    }


    @ApiOperation(value = "商品列表",notes = "goods", produces = "application/json; charset=utf-8")
    @RequestMapping(value = "goods",method = RequestMethod.POST)
    public String goods() throws JSONException {
        return FileUtil.getApi("goods.json");
    }

    // 模拟分页请求
    @ApiOperation(value = "模拟分页",notes = "getPage", produces = "application/json; charset=utf-8")
    @RequestMapping(value = "getPage",method = RequestMethod.POST)
    public List<String> getPage(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        List data = new ArrayList();
        for(int i = 0;i<pageSize;i++){
            data.add("我是第"+pageNum+"页,第"+(i+1)+"条数据。");
        }
        return data;
    }

}
