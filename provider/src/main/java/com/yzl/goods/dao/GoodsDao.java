package com.yzl.goods.dao;

import com.yzl.goods.bean.Goods;

import java.util.Collection;

/**
 * Created by sunjingjia  on 2019/12/13.
 */
public interface GoodsDao {


    public Collection<Goods> findAll();

    public Goods findById(int id);

    public void saveOrUpdate(Goods goods);

    public void deleteById(int id);
}
