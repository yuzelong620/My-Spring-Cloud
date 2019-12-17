package com.yzl.goods.web;


import com.netflix.ribbon.proxy.annotation.Http;
import com.yzl.goods.bean.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
@RestController
@RequestMapping("/ribbon")
public class GoodsController {

    @Autowired
    private RestTemplate restTemplate;

   @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(restTemplate.getForObject("http://provider/goods/findAll", List.class),HttpStatus.OK) ;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return  new ResponseEntity<>(restTemplate.getForObject("http://provider/goods/findById/{id}", Goods.class,id),HttpStatus.OK);
    }


}
