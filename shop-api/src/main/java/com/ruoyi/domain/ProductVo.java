package com.ruoyi.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/28 14:21
 */
@Data
public class ProductVo {
    private Long id;
    private String productNo;
    private String name;
    private String content;
    private Integer type;
    private Integer status;
    private String remark;
    private String[] img;
    private BigDecimal minPrice;
    private List<PAttr> pAttrs;

    @Data
    public static class PAttr{
        private Long id;
        private String color;
        private String size;
        private BigDecimal originalPrice;
        private BigDecimal discountPrice;
        private BigDecimal discount;
        private Integer inventory;
        private String remark;
    }

    public String[] getImg() {
        return img;
    }

    public void setImg(String img) {
        if(img == null || img ==""){
            this.img = new String[0];
        }else {
            this.img = img.split(",");
        }
    }
}
