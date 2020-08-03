package com.shop.repository;


import com.shop.entity.vo.ProductVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linhaoHu
 * @date 2019/8/29 11:55
 */

public interface ProductRepository extends JpaRepository<ProductVo,Long> {

    @Query( value = "select p.id id,p.card_id cardId,p.create_time createTime,p.update_time updateTime, "+
            "group_concat(distinct a.attr_name) attr,group_concat(distinct pm.attr_value) attrValue, "+
            "group_concat(distinct i.img_url) img,group_concat(distinct l.tag) tag "+
            "from sp_product p LEFT JOIN product_card c on p.card_id = c.id "+
            "LEFT JOIN sp_product_attr a on find_in_set(a.id,c.show_attr) "+
            "LEFT JOIN sp_product_param pm on (a.id = pm.attr_id AND pm.product_id = p.id) "+
            "LEFT JOIN sp_product_image i on FIND_IN_SET(i.id,p.image_id) "+
            "LEFT JOIN sp_product_label l on FIND_IN_SET(l.id,p.label_id) "+
            "GROUP BY p.id;",nativeQuery = true)
    List<ProductVo> findProductVo();
}
