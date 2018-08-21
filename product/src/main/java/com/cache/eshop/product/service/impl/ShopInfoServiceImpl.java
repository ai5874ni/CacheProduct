package com.cache.eshop.product.service.impl;

import com.cache.eshop.product.mapper.ShopInfoMapper;
import com.cache.eshop.product.model.ShopInfo;
import com.cache.eshop.product.service.ShopInfoService;

import javax.annotation.Resource;

@Service("shopInfoServiceImpl")
public class ShopInfoServiceImpl implements ShopInfoService {
    @Resource
    private ShopInfoMapper shopInfoMapper;
    @Override
    public void updateShopInfo(ShopInfo shopInfo) {
        shopInfoMapper.updateShopInfo(shopInfo);
    }

    @Override
    public ShopInfo findShopInfo(long shopId) {
        return shopInfoMapper.findShopInfo(shopId);
    }
}
