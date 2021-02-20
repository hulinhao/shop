package com.ruoyi.domain.vo;/**
 * @Author linhao Hu
 * @Date 2021/1/6 20:16
 */

import lombok.Data;

/**
 *
 * @Author linhao Hu
 * @Date 2021/1/6 20:16
 *
 */
@Data
public class ProductInfoVo {
    private Long pId;
    private String pNo;
    private String pName;
    private String content;
    private Integer type;
    private String tNo;
    private String tName;
    private String tImg;
    private Integer pStatus;
    private String pRemark;

}
