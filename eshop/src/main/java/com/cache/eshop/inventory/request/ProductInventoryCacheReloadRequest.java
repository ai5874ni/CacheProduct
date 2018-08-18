package com.cache.eshop.inventory.request;

import com.cache.eshop.inventory.model.ProductInventory;
import com.cache.eshop.inventory.service.ProductInventoryService;

/**
 * @program: eshop
 * @description: 从数据库中读取数据，添加到缓存
 * @author: Mr.Wang
 * @create: 2018-08-04 14:10
 */
public class ProductInventoryCacheReloadRequest implements Request {
    private Integer productId;
    private ProductInventoryService productInventoryService;
    /**
     * 是否强制刷新缓存
     */
    private boolean forceRefresh;

    public ProductInventoryCacheReloadRequest(Integer productId,ProductInventoryService productInventoryService,
            boolean forceRefresh) {
        this.productId = productId;
        this.productInventoryService = productInventoryService;
        this.forceRefresh = forceRefresh;
    }

    @Override
    public void process() {
       ;

        //从数据库中读取最新的库存
        // 将最新的商品库存更新到redis缓存中去
        System.out.println("rrrrrrrrrrrrrrrrr:从数据库中读取最新的库存,将最新的商品库存更新到redis缓存中去");
        ProductInventory productInventory = productInventoryService.findProductInventory(productId);
        productInventoryService.setProductInventoryCache(productInventory);

    }

    public Integer getProductId() {
        return productId;
    }
    public boolean isForceRefresh() {
        return forceRefresh;
    }
}
