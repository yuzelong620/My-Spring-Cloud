package com.yzl.goods.web;

import com.yzl.goods.bean.Goods;
import com.yzl.goods.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private RestTemplate restTemplate;

   @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(goodsDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(goodsDao.findById(id), HttpStatus.OK);
    }


}
