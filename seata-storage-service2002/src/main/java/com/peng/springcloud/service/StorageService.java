package com.peng.springcloud.service;

public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    void decrease(String productId, Integer count);
}
