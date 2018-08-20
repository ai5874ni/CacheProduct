package com.cache.eshop.product.service;

import com.cache.eshop.product.model.ShopInfo;

public interface ShopInfoService {
    void updateShopInfo(ShopInfo shopInfo);

    ShopInfo findShopInfo(long shopId);
}
