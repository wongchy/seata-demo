package com.example.seata.service;

import com.example.seata.entity.TAssetAssign;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
public interface ITAssetAssignService extends IService<TAssetAssign> {
    /**
     * Increase amount asset assign.
     *
     * @param id the id
     * @return the asset assign
     */
    TAssetAssign increaseAmount(String id);
}
