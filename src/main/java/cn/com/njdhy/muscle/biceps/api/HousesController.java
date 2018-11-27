package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesErrorCode;
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
@Api(tags = "房屋案例模块接口")
public class HousesController {

    @Autowired
    private SystemConstant systemConstant;

    @Autowired
    private SrvcHousesService srvcHousesService;

    /**
     * 查询楼盘情况及图片信息列表
     * @return
     */
    @RequestMapping(value = "/houses",method = RequestMethod.POST)
    @ApiOperation("查询楼盘情况及图片信息列表")
    public Result housesQuery(@RequestParam Integer progressTitle) {
        List<SrvcHouses> list =null;
        try {
            if(progressTitle == null ){
                return Result.error(HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_MESSAGE);
            }
            list = srvcHousesService.selectHousesInfo(progressTitle);

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success(list);
    }

}
