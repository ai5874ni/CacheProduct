package com.cache.eshop.product.service;

import com.cache.eshop.product.model.ProductInfo;

public interface ProductInfoService {
    void updateProductInfo(ProductInfo productInfo);
    ProductInfo getProductInfo(long productId);
}
