package com.cache.eshop.product.service.impl;

import com.cache.eshop.product.mapper.ProductInfoMapper;
import com.cache.eshop.product.model.ProductInfo;
import com.cache.eshop.product.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {
    @Resource
    private ProductInfoMapper productInfoMapper;

@Override
    public void updateProductInfo(ProductInfo productInfo) {
        productInfoMapper.updateProductInfo(productInfo);
    }
    @Override
    public ProductInfo getProductInfo(long productId) {
        return productInfoMapper.getProductInfo(productId);
    }
}
