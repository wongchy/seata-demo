package com.example.seata.controller;


import com.example.seata.entity.TAssetAssign;
import com.example.seata.service.ITAssetAssignService;
import com.example.seata.service.impl.TAssetAssignServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/t-asset")
public class TAssetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TAssetController.class);

    final String ASSET_ID = "14070e0e3cfe403098fa9ca37e8e7e76";

    @Autowired
    private ITAssetAssignService tAssetAssignService;

    @RequestMapping(value = "/asset/assign")
    @ResponseBody
    public String assetAssign() {
        LOGGER.info("welcome to deposit");

        String result;
        try {
            TAssetAssign assetAssign = tAssetAssignService.increaseAmount(
                    ASSET_ID);
            result = assetAssign.toString();
        } catch (Exception e) {
            result = e.getMessage();

        }
        return result;
    }
}
