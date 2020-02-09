package com.leosanqing.cart;

import com.leosanqing.enums.CategoryEnum;
import lombok.Data;

/**
 * @Author: leosanqing
 * @Date: 2020/1/16 上午8:23
 * @Package: com.leosanqing.cart
 * @Description: 购物车商品规格对象
 */
@Data
public class Sku {
    private Integer skuId;
    private String name;
    private Double price;
    private Integer totalNum;
    private Double totalPrice;
    private Enum<CategoryEnum> category;
}
