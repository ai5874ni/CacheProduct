package com.cache.eshop.inventory.request;

import com.cache.eshop.inventory.model.ProductInventory;
import com.cache.eshop.inventory.service.ProductInventoryService;

/**
 * @program: eshop
 * @description: 数据跟新的请求
 * (1)删除缓存
 * 2）更新数据库
 * @author: Mr.Wang
 * @create: 2018-08-04 13:15
 */
public class ProductInventoryDBUpdateRequest implements Request {

    private ProductInventory productInventory;
    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventory productInventory, ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {

//删除redis中的缓存，修改数据库中的数据

        productInventoryService.removeProductInventoryCache(productInventory);
//为了测试
//        try {
//            System.out.println("wwwwwww;更新数据中。。。。。。");
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        productInventoryService.updateProductInventory(productInventory);
        System.out.println("wwwwwww;修改数据库中的数据成功");
    }

    @Override
    public Integer getProductId() {
        return productInventory.getProductId();
    }

    @Override
    public boolean isForceRefresh() {
        return false;
    }
}
