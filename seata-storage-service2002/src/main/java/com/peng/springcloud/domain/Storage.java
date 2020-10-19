package com.peng.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private String id;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 总库存
     */
    private Integer count;

}
