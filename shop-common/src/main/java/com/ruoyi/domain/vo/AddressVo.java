package com.ruoyi.domain.vo;

import lombok.Data;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2021/2/26 16:31
 */
@Data
public class AddressVo {
    private Long id;
    private Long userId;
    private Long cityId;
    private String area;
    private String city;
    private String province;
    private String detailAddr;
    private String phone;
    private String name;
    
}
