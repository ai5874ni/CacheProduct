package com.cache.eshop.inventory.mapper;

import com.cache.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.Param;

/**
 * @program: eshop
 * @description: 更新库存
 * @author: Mr.Wang
 * @create: 2018-08-04 13:33
 */
public interface ProductInventoryMapper {
    /**
     * 更新庫存數量
     * */
     void updateProductInventoryMapper(ProductInventory productInventory);
     /**
      * 根据商品ID，查询商品库存信息
      * */
    ProductInventory findProductInventory(@Param("productId")Integer productId);
}
