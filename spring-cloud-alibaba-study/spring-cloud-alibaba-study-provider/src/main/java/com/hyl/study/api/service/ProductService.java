package com.hyl.study.api.service;

import com.hyl.study.vo.ProductVo;

/**
 * Created by hyl
 * on 2020/4/16.
 */
public interface ProductService {

    ProductVo findById(Long pid);

    void deductionQuantity(Long pid, Long quantity);
}
