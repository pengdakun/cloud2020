package com.peng.springcloud.service.impl;

import com.peng.springcloud.dao.StorageDao;
import com.peng.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @Override
    public void decrease(String productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
