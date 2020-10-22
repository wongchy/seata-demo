package com.example.seata.controller;


import com.example.seata.entity.TAssetAssign;
import com.example.seata.service.ITAssetAssignService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/t-asset-assign")
public class TAssetAssignController {

    @Autowired
    private ITAssetAssignService tAssetAssignService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        TAssetAssign assetAssign = tAssetAssignService.increaseAmount(
                "14070e0e3cfe403098fa9ca37e8e7e76");
        String result = assetAssign.toString();
        log.info("==={}",result);
        return "111";
    }
}
