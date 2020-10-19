package com.peng.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    /**
     * 减库存
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(String userId, Integer money);
}
