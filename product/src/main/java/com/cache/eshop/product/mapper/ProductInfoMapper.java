package com.cache.eshop.product.mapper;

import com.cache.eshop.product.model.ProductInfo;

public interface ProductInfoMapper {
    void updateProductInfo(ProductInfo productInfo);
    ProductInfo getProductInfo(long productId);
}
