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
    private Long typeId;
    private String name;
    private String img;
    private List<ProductInfo> pList;

    @Data
   public static class ProductInfo {
        private Long id;
        private String productNo;
        private String name;
        private String img;
    }
}
