package com.cache.eshop.inventory.service.impl;

import com.cache.eshop.inventory.dao.RedisDAO;
import com.cache.eshop.inventory.mapper.ProductInventoryMapper;
import com.cache.eshop.inventory.model.ProductInventory;
import com.cache.eshop.inventory.service.ProductInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: eshop
 * @description: 商品庫存实现类
 * @author: Mr.Wang
 * @create: 2018-08-04 13:49
 */
@Service("productInventoryService")
public class ProductInventoryServiceImpl implements ProductInventoryService {
    @Resource
    private ProductInventoryMapper productInventoryMapper;
    @Resource
    private RedisDAO redisDAO;

    @Override
    public void updateProductInventory(ProductInventory productInventory) {
        productInventoryMapper.updateProductInventoryMapper(productInventory);
    }

    @Override
    public void removeProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory" + productInventory.getProductId();
        redisDAO.delete(key);
    }

    @Override
    public ProductInventory findProductInventory(Integer productId) {
        return productInventoryMapper.findProductInventory(productId);
    }

    @Override
    public void setProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory" + productInventory.getProductId();
        redisDAO.set(key, String.valueOf(productInventory.getInventoryNum()));
    }


    /**
     * 获取商品库存的缓存
     *
     * @param productId
     * @return
     */
    @Override
    public ProductInventory getProductInventoryCache(Integer productId) {
        Long productInventory = 0l;
        String key = "product:inventory" + productId;
        String result = redisDAO.get(key);

        if(result != null && !"".equals(result)) {
            try {
                productInventory = Long.valueOf(result);
                return new ProductInventory(productId, productInventory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }
}
