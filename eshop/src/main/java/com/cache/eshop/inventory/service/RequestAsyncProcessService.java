package com.cache.eshop.inventory.service;

import com.cache.eshop.inventory.request.Request;

/**
 * @program: eshop
 * @description: 请求异步执行service
 * @author: Mr.Wang
 * @create: 2018-08-04 18:26
 */
public interface RequestAsyncProcessService {
    void process(Request request);
}
