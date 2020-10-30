package com.ruoyi.mapper;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.IndexVo;
import com.ruoyi.domain.JcProductType;
import com.ruoyi.domain.ProductVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/21 20:12
 */
public interface AppletMapper {

    @Select({"SELECT p.id productId,a.id attrId,p.product_no productNo,p.`name` poductName,a.discount_price price,a.size size,c.number num," +
            "  (SELECT adjunct_path from jc_adjunct where relation_type = 1 and adjunct_type = 0 and dflag=0 AND relation_id = p.id limit 1) img,1 brand" +
            " from jc_cart c LEFT JOIN jc_product_attr a on c.product_attr_id = a.id LEFT JOIN jc_product p on a.product_id = p.id" +
            " where c.user_id = #{id}"})
    List<CartVo> getCartList(Long userId);

    @Select({"SELECT * from jc_product_type ORDER BY remark asc"})
    List<JcProductType> getType();

    @Select({"SELECT p.id,p.product_no productNo,p.name,a.adjunct_path img  from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id" +
            "  where p.type = #{typeId} and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 GROUP BY p.id ORDER BY p.`status` ASC limit 3"})
    List<IndexVo.ProductInfo> getProductInfoByType(Long typeId);

    @Select({"SELECT p.*,GROUP_CONCAT(a.adjunct_path) img,pa.discount_price minPrice from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id LEFT JOIN jc_product_attr pa on p.id=pa.product_id " +
            " where p.`status` != 3 and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 " +
            " and  p.type = #{typeId} GROUP BY p.id ORDER BY p.`status`,pa.discount_price "})
    List<ProductVo> getProduct(Long typeId);

    @Select({"SELECT p.*,GROUP_CONCAT(a.adjunct_path) img,pa.discount_price minPrice from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id LEFT JOIN jc_product_attr pa on p.id=pa.product_id " +
            " where p.`status` != 3 and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 " +
            " and  p.id= #{id} GROUP BY p.id ORDER BY p.`status`,pa.discount_price "})
    ProductVo getProductById(Long id);

    @Select({"SELECT * from jc_product_attr where product_id = #{pId}"})
    List<ProductVo.PAttr> getPattr(Long pId);
 }
