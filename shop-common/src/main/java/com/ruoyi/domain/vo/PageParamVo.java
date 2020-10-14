package com.ruoyi.domain.vo;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 19:55
 */
public class PageParamVo<T> {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页显示数量
     */
    private int pageSize;
    /**
     * 排序列
     */
    private String orderByColumn;

    private T t;

    PageParamVo(){

    }
}
