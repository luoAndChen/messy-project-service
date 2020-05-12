package com.hyl.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by hyl
 * on 2020/4/16.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo implements Serializable {

    //商品id
    private Long id;

    //商品名称
    private String name;

    //库存数量
    private Long quantity;


}
