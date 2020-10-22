package com.ruoyi.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/21 20:03
 */
@Data
public class CartVo {
    private Long productId;
    private Long attrId;
    private String productNo;
    private String poductName;
    private BigDecimal price;
    private String size;
    private Integer num;
    private String img;//图片
    private String brand;
}
