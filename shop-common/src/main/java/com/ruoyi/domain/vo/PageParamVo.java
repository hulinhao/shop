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

    public int getPageNum() {
        if(pageNum < 0)
            return 0;
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if(pageSize<0)
            return 10;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
