package com.cache.eshop.inventory.service;

import com.cache.eshop.inventory.model.ProductInventory;

/**
 * @program: eshop
 * @description: Inventory number
 * @author: Mr.Wang
 * @create: 2018-08-04 13:42
 */
public interface ProductInventoryService {
    void updateProductInventory(ProductInventory productInventory);

    void removeProductInventoryCache(ProductInventory productInventory);

    ProductInventory findProductInventory(Integer productId);
    /**
     * 设置商品库存的缓存
     * */
    void setProductInventoryCache(ProductInventory productInventory);


    /**
     * 获取商品库存的缓存
     * @param productId
     * @return
     */
    ProductInventory getProductInventoryCache(Integer productId);
}
