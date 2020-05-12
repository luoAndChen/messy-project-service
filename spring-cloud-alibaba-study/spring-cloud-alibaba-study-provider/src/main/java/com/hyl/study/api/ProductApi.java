package com.hyl.study.api;

import com.hyl.study.api.service.ProductService;
import com.hyl.study.clients.ProductClient;
import com.hyl.study.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hyl
 * on 2020/4/16.
 */
@RestController
public class ProductApi implements ProductClient {

    @Autowired
    private ProductService productService;

    @Override
    public ProductVo findById(@RequestParam("pid") Long pid) {
        return productService.findById(pid);

    }

    @Override
    public void deductionQuantity(@RequestParam("pid") Long pid, @RequestParam("quantity") Long quantity) {
        productService.deductionQuantity(pid,quantity);

    }
}
