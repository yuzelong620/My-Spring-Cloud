package com.yzl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String name;
    private String cate_name;
    private String brand_name;
    private Double price;
}
