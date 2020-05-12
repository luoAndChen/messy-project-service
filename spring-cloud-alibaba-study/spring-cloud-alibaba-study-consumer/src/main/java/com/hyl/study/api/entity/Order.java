package com.hyl.study.api.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("db_order")
public class Order implements Serializable{

    //订单id
    @TableId(type= IdType.AUTO)
    private  Long id;

    //商品id
    private Long pId;

    //用户id
    private Long userId;

    //商品名称
    private String pName;

    //数量
    private Long quantity;
}
