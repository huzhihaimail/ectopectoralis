package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
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
@Api(tags = "十大模块接口")
public class ModuleController {

    @Autowired
    private SrvcModuleService srvcModuleService;


    /**
     * 查询十大模块信息列表
     * @return
     */
    @RequestMapping(value = "/modules",method = RequestMethod.POST)
    @ApiOperation("查询首页十大模块列表")
    public Result moduleQuery(@RequestParam String moduleName,Integer imageType) {
        List<SrvcModule> list =null;
        try {
            if(moduleName == null || moduleName.length()<=0){
                return Result.error(ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_CODE,ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_MESSAGE);
            }
            if(imageType == null){
                return Result.error(ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_CODE,ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_MESSAGE);
            }
            list = srvcModuleService.selectModuleInfo(moduleName,imageType);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(ModuleErrorCode.SRVC_MODULE_SELECT_ERROR_CODE, ModuleErrorCode.SRVC_MODULE_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }


}
