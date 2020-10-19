package com.peng.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    private String userId;

    private String productId;

    private Integer count;

    private Integer money;

    /**
     * 订单状态 0:创建中,1:已完结
     */
    private Integer status;
}
