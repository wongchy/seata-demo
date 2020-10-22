package com.example.seata.service.impl;

import com.example.seata.entity.TAsset;
import com.example.seata.mapper.TAssetMapper;
import com.example.seata.service.ITAssetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
@Service
@Component
public class TAssetServiceImpl extends ServiceImpl<TAssetMapper, TAsset> implements ITAssetService {

    /**
     * The constant LOGGER.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(TAssetServiceImpl.class);

    /**
     * The constant ASSET_ID.
     */
    public static final String ASSET_ID = "DF001";

    @Override
    public int increase() {
        LOGGER.info("Asset Service Begin ... xid: " + RootContext.getXID() + "\n");
        TAsset asset = baseMapper.selectById(ASSET_ID);
        asset.setAmount(asset.getAmount().add(new BigDecimal("1")));
        baseMapper.updateById(asset);
        throw new RuntimeException("test exception for seata, your transaction should be rollbacked,asset=" + asset);
    }

}
