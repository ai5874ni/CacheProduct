package com.cache.eshop.product.mapper;

import com.cache.eshop.product.model.ShopInfo;

public interface ShopInfoMapper {
    void updateShopInfo(ShopInfo shopInfo);

    ShopInfo findShopInfo(long shopId);
}
