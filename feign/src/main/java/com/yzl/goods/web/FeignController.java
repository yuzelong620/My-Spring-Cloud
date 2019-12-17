package com.yzl.goods.web;

import com.yzl.goods.bean.Goods;
import com.yzl.goods.dao.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunjingjia  on 2019/12/16.
 */
@RequestMapping("/feign")
@RestController
public class FeignController {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(feignProviderClient.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return  new ResponseEntity<>(feignProviderClient.findById(id),HttpStatus.OK);
    }
}
