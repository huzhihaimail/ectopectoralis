package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.CustomerErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.ModuleErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "banner图获取接口")
public class BannerController {

    @Autowired
    private SystemConstant systemConstant;
    @Autowired
    private SrvcBannerService srvcBannerService;

    /**
     * 查询banner图列表
     * @return
     */
    @RequestMapping(value ="/banners",method = RequestMethod.GET )
    @ApiOperation(value = "查询banner图列表")
    public Result bannerQuery() {
        List<SrvcBanner> list=null;
        try {
            list = srvcBannerService.selectBannerList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success(list);
    }


}
