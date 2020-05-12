package com.hyl.study.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyl.study.api.entity.Product;
import com.hyl.study.api.mapper.ProductMapper;
import com.hyl.study.api.service.ProductService;
import com.hyl.study.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hyl
 * on 2020/4/16.
 */
@Service
public class ProductServiceImpl  extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public ProductVo findById(@RequestParam("id") Long pid) {
        Product product = this.selectById(pid);
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product,productVo);
        return productVo;
    }

    @Override
    @Transactional
    public void deductionQuantity(Long pid, Long quantity) {
        Product product = this.selectById(pid);
        product.setQuantity(product.getQuantity()-quantity);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.updateById(product);
    }


}
