package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCore;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCompanyDescService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/11 15:50
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "家装服务核心优势模块接口")
public class CoreController {

    @Autowired
    private SrvcCoreService srvcCoreService;


    /**
     * 查询三大模块信息列表
     * @return
     */
    @RequestMapping(value = "/core/{type}",method = RequestMethod.POST)
    @ApiOperation("查询服务核心优势模块文章内容")
    public Result coreQuery(@PathVariable Integer type) {
        SrvcCore srvcCore =null;
        try {
            if(type == null){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            srvcCore = srvcCoreService.queryByType(type);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("data",srvcCore);
    }
}
