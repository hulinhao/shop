package com.ruoyi.mapper;

import com.ruoyi.domain.CartVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/21 20:12
 */
public interface CartMapper {

    @Select({"SELECT p.id productId,a.id attrId,p.product_no productNo,p.`name` poductName,a.discount_price price,a.size size,c.number num," +
            "  (SELECT adjunct_path from jc_adjunct where relation_type = 1 and adjunct_type = 0 and dflag=0 AND relation_id = p.id limit 1) img,1 brand" +
            " from jc_cart c LEFT JOIN jc_product_attr a on c.product_attr_id = a.id LEFT JOIN jc_product p on a.product_id = p.id" +
            " where c.user_id = #{id}"})
    List<CartVo> getCartList(Long userId);
}
