package com.cache.eshop.inventory.service.impl;

import com.cache.eshop.inventory.request.Request;
import com.cache.eshop.inventory.request.RequestQueue;
import com.cache.eshop.inventory.service.RequestAsyncProcessService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @program: eshop
 * @description: 请求异步执行service实例
 * @author: Mr.Wang
 * @create: 2018-08-04 18:27
 */
@Service("requestAsyncProcessService")
public class RequestAsyncProcessServiceImpl implements RequestAsyncProcessService {
    @Override
    public void process(Request request) {
        try {
            ArrayBlockingQueue<Request> queue = getRoutingQueue(request.getProductId());
            // 将请求放入对应的队列中，完成路由操作
            queue.put(request);
        } catch (Exception e) {


        }
    }

    private ArrayBlockingQueue<Request> getRoutingQueue(Integer productId) {
        RequestQueue requestQueue = RequestQueue.getInstance();
        String key = String.valueOf(productId);
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (requestQueue.queueSize() - 1) & hash;
        System.out.println("===========日志===========: 路由内存队列，商品id=" + productId + ", 队列索引=" + index);
        return requestQueue.getQueue(index);

    }
}
