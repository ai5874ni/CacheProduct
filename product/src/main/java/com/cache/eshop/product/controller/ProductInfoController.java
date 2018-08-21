package com.cache.eshop.product.controller;


import com.cache.eshop.product.model.ProductInfo;
import com.cache.eshop.product.service.ProductInfoService;
import com.cache.eshop.product.vo.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ProductInfoController {
    @Resource
    private ProductInfoService productInfoService;

    @RequestMapping("/updateProductInfo")
    @ResponseBody
    public Response updateProductInfo(ProductInfo productInfo) {
        try {
            productInfoService.updateProductInfo(productInfo);
            return new Response(Response.SUCCESS);
        } catch (Exception e) {
            return new Response(Response.FAILURE);
        }
    }
    @RequestMapping("/findProductInfo")
    @ResponseBody
    public ProductInfo findProductInfo(long productId){
        return productInfoService.getProductInfo(productId);
    }

}
