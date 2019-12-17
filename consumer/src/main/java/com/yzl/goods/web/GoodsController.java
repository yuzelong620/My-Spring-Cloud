package com.yzl.goods.web;

import com.yzl.goods.bean.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
@RestController
public class GoodsController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/findAll")
    public List<Goods> findAll(){
        List list = restTemplate.getForObject("http://localhost:9001/goods/findAll", List.class);
        return list;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        ResponseEntity<Goods> goods = restTemplate.getForEntity("http://localhost:9001/goods/findById/{id}", Goods.class, id);
        return goods;
    }
    @GetMapping("findById2/{id}")
    public ResponseEntity<?> findById2(int id){
        Goods goods = restTemplate.getForObject("http://localhost:9001/goods/findById/{id}", Goods.class, id);

        return new ResponseEntity<>(goods,HttpStatus.OK);
    }
    /**
     * restTemplate 中存在GET,POST,PUT,DELETE四种方式
     *
     * GET：
     *  restTemplate.getForObject(url,实体类型,参数)  返回值：ResponseEntity<>    可以用getBody方法转为实体类型
     *  restTemplate.getForEntity(url,实体类型,参数)  返回值：实体类型
     *
     *  POST:
     *  restTemplate，postForObject(url,参数,实体类型)     返回值：ResponseEntity<>    可以用getBody方法转为实体类型
     *  restTemplate，postForEntity(url,参数,实体类型)     返回值：实体类型
     *
     *  PUT:
     *   restTemplate.put(url,参数)
     *
     *   DELETE：
     *    restTemplate.delete(url,参数);
     */
}
