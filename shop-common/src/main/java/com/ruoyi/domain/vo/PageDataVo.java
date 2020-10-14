package com.ruoyi.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 19:57
 */
@Data
public class PageDataVo<T> {
    /**
     * 总数
     */
    private int count;
    private List<T> list;
}
