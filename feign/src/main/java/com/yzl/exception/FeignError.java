package com.yzl.exception;

import com.yzl.goods.bean.Goods;
import com.yzl.goods.dao.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sunjingjia  on 2019/12/17.
 */
@Component
public class FeignError implements FeignProviderClient {
    @Override
    public List<Goods> findAll() {
        return null;
    }

    @Override
    public Goods findById(int id) {
        return null;
    }
}
