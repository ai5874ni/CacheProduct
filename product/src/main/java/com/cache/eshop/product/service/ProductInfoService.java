package com.cache.eshop.product.service;

import com.cache.eshop.product.model.ProductInfo;

public interface ProductInfoService {
    void updateProductInfo(long productId);
    ProductInfo getProductInfo(long productId);
}
