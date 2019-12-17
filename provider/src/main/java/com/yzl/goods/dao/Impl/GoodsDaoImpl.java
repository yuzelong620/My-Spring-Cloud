package com.yzl.goods.dao.Impl;

import com.yzl.goods.bean.Goods;
import com.yzl.goods.dao.GoodsDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    private Map<Integer,Goods> goodsMap;

    public GoodsDaoImpl(){
        goodsMap = new HashMap<>();
        goodsMap.put(1,new Goods(1,"MAC Pro","笔记本","苹果",18888.0));
        goodsMap.put(2,new Goods(2,"ThinkPad","笔记本","Lenovo",18888.0));
        goodsMap.put(3,new Goods(3,"AOC","台式","Aoc",18888.0));
    }

    @Override
    public Collection<Goods> findAll() {
        return goodsMap.values();
    }

    @Override
    public Goods findById(int id) {
        return goodsMap.get(id);
    }

    @Override
    public void saveOrUpdate(Goods goods) {
        goodsMap.put(goods.getId(),goods);
    }

    @Override
    public void deleteById(int id) {
        goodsMap.remove(id);
    }
}
