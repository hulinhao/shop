package com.ruoyi.domain;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/28 10:34
 */
@Data
public class IndexVo {
    private List<JcProductType> typeList;
    private ProductVo productVo;
}
