package com.cache.eshop.product.controller;


import com.cache.eshop.product.mapper.ShopInfoMapper;
import com.cache.eshop.product.model.ShopInfo;
import com.cache.eshop.product.vo.Response;

import javax.annotation.Resource;

@Controller
public class ShopInfoController {
    @Resource
    private ShopInfoMapper shopInfoMapper;

    @RequestMapping("/updateShopInfo")
    @ResponseBody
    public Response updateShopInfo(ShopInfo shopInfo) {
        try {
            shopInfoMapper.updateShopInfo(shopInfo);
            return new Response(Response.SUCCESS);
        } catch (Exception e) {
            return new Response(Response.FAILURE);
        }

    }

    @RequestMapping("/findShopInfo")
    @ResponseBody
    public ShopInfo findShopInfo(long shopId) {
        return shopInfoMapper.findShopInfo(shopId);
    }

}
