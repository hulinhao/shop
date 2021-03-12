package com.ruoyi.mapper;

import com.ruoyi.domain.*;
import com.ruoyi.domain.vo.AddressVo;
import lombok.extern.slf4j.Slf4j;
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

    @Select({"SELECT c.id cartId, p.id productId,a.id attrId,p.product_no productNo,p.`name` poductName,a.discount_price price,a.size size,c.number num," +
            "  (SELECT adjunct_path from jc_adjunct where relation_type = 1 and adjunct_type = 0 and dflag=0 AND relation_id = p.id limit 1) img" +
            " from jc_cart c LEFT JOIN jc_product_attr a on c.product_attr_id = a.id LEFT JOIN jc_product p on a.product_id = p.id" +
            " where c.user_id = #{id}  and c.dflag=0 and c.number>0  ORDER BY c.update_time DESC ,c.create_time DESC"})
    List<CartVo> getCartList(Long userId);

    @Select({"SELECT * from jc_product_type ORDER BY remark asc"})
    List<JcProductType> getType();

    @Select({"SELECT p.*,GROUP_CONCAT(DISTINCT a.adjunct_path) img,pa.discount_price minPrice from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id LEFT JOIN jc_product_attr pa on p.id=pa.product_id ",
            " where p.`status` != 3 and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 ",
            " and  p.type = #{typeId} GROUP BY p.id ORDER BY p.`status`,pa.discount_price "})
    List<ProductVo> getProduct(Integer typeId);

    @Select({"SELECT p.*,GROUP_CONCAT(DISTINCT a.adjunct_path) img,pa.discount_price minPrice from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id LEFT JOIN jc_product_attr pa on p.id=pa.product_id ",
            " where p.`status` != 3 and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 ",
            " and  p.id= #{id} GROUP BY p.id ORDER BY p.`status`,pa.discount_price "})
    ProductVo getProductById(Long id);

    @Select({"SELECT * from jc_product_attr where product_id = #{pId} order by discount_price asc"})
    List<ProductVo.PAttr> getPattr(Long pId);

    @Select({"SELECT p.*,GROUP_CONCAT( DISTINCT a.adjunct_path) img from jc_product p LEFT JOIN jc_adjunct a on p.id = a.relation_id ",
            " where p.`status` = #{status} and a.relation_type=1 and a.adjunct_type=0 and a.dflag = 0 ",
            "  GROUP BY p.id limit 1 "})
    ProductVo getProductByStatus(Integer status);
    
    @Select({"SELECT a.id id,a.user_id userId,a.city_id cityId,c.cityname area,cc.cityname city,ccc.cityname province,a.detail_addr detailAddr,a.accept_phone phone,a.accept_name AS name ",
            " from jc_user_address a LEFT JOIN city c on a.city_id = c.id LEFT JOIN city cc on c.pid = cc.id LEFT JOIN city ccc on cc.pid = ccc.id ",
            " where dflag in(0,1) and user_id = #{userId} ORDER BY dflag"})
    List<AddressVo> getAllAddr(Long userId);
    
 }
