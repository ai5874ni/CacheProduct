package com.cache.eshop.inventory.request;
/**
        *@program:eshop
        *
        *@description:请求接口
        *
        *@author:Mr.Wang
        *
        *@create:2018-08-04 12:15
        **/

public interface Request {
    void process();
    Integer getProductId();
    boolean isForceRefresh();
}
