package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
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
@Api(tags = "三大模块接口")
public class CompanyDescController {

    @Autowired
    private SrvcCompanyDescService srvcCompanyDescService;


    /**
     * 查询三大模块信息列表
     * @return
     */
    @RequestMapping(value = "/companys/{type}",method = RequestMethod.POST)
    @ApiOperation("查询三大模块及图片列表")
    public Result companyDescQuery(@PathVariable Integer type) {
        List<SrvcCompanyDesc> list =null;
        try {
            if(type == null){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            list = srvcCompanyDescService.queryByType(type);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }


}
