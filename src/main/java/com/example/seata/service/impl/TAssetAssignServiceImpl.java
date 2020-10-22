package com.example.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seata.entity.TAssetAssign;
import com.example.seata.mapper.TAssetAssignMapper;
import com.example.seata.service.ITAssetAssignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seata.service.ITAssetService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
@Slf4j
@Service
public class TAssetAssignServiceImpl extends ServiceImpl<TAssetAssignMapper, TAssetAssign> implements ITAssetAssignService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TAssetAssignServiceImpl.class);

    @Autowired
    private ITAssetService itAssetService;

    @Override
    @Transactional
    @GlobalTransactional
    public TAssetAssign increaseAmount(String id) {
        LOGGER.info("Assign Service Begin ... xid: " + RootContext.getXID() + "\n");
        TAssetAssign assetAssign = baseMapper.selectOne(new QueryWrapper<TAssetAssign>().eq("id","14070e0e3cfe403098fa9ca37e8e7e76"));
        log.info("ccc");
        assetAssign.setStatus("4");
        log.info("eee");
        baseMapper.updateById(assetAssign);

        // remote call asset service
        itAssetService.increase();
        return assetAssign;
    }

}
