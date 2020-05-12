package com.hyl.study.clients;

import com.hyl.study.vo.ProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hyl
 * on 2020/4/16.
 */
@FeignClient(value = "study-provider", contextId = "product")
public interface ProductClient {

    @PostMapping("/find_by_id")
    ProductVo findById(@RequestParam("pid") Long pid);

    @PostMapping("deduction_quantity")
    void deductionQuantity(@RequestParam("pid")Long pid, @RequestParam("quantity")Long quantity);
}
