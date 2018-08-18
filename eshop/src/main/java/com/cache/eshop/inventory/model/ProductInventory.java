package com.cache.eshop.inventory.model;

/**
 * @program: eshop
 * @description: 庫存
 * @author: Mr.Wang
 * @create: 2018-08-04 13:36
 */
public class ProductInventory {
   private Integer productId;
   private Long InventoryNum;

    public ProductInventory() {
    }

    public ProductInventory(Integer productId, Long inventoryNum) {
        this.productId = productId;
        InventoryNum = inventoryNum;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getInventoryNum() {
        return InventoryNum;
    }

    public void setInventoryNum(Long inventoryNum) {
        InventoryNum = inventoryNum;
    }
}
