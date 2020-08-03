package com.shop.entity.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author linhaoHu
 * @date 2019/8/29 11:48
 */
@Data
@Entity
public class ProductVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cardId;
    private Date createTime;
    private Date updateTime;
    private String attr;
    private String attrValue;
    private String img;
    private String tag;
}
