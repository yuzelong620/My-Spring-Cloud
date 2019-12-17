package com.yzl.goods.dao;

import com.yzl.goods.bean.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by sunjingjia  on 2019/12/16.
 */
@FeignClient(value = "provider")
public interface FeignProviderClient {

    @GetMapping("/goods/findAll")
    public List<Goods> findAll();

    @GetMapping("/goods/findById/{id}")
    public Goods findById(@PathVariable("id") int id);
}
