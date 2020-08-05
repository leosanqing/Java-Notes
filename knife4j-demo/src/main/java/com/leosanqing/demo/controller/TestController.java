package com.leosanqing.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rtliu
 * @Date: 2020/6/5 上午9:33
 * @Package: com.leosanqing.demo.controller
 * @Description: 测试
 * @Version: 1.0
 */
@RestController
@Api(value = "购物车相关接口api", tags = {"用于购物车相关操作"})
public class TestController {

    @GetMapping("/app")
    @ApiOperation(value = "查询购物车", notes = "查询购物车", httpMethod = "GET")

    public String queryData(@RequestParam String cartId){
            return cartId;
    }

    @PostMapping("cart")
    @ApiOperation(value = "添加购物车", notes = "添加购物车", httpMethod = "POST")

    public void updateCart(){

    }
}
