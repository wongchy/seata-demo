package com.example.seata.service;

import com.example.seata.entity.TAsset;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
public interface ITAssetService extends IService<TAsset> {

    public int increase();
}
