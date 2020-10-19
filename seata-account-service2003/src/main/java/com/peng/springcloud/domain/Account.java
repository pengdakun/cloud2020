package com.peng.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 金额
     */
    private Integer money;
}
