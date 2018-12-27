package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcDecorateCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "装修案例模块接口")
public class DecorateCaseController {

    @Autowired
    private SrvcDecorateCaseService srvcDecorateCaseService;

    /**
     * 查询首页装修案例展示数
     * @return
     */
    @RequestMapping(value = "/page/case",method = RequestMethod.POST)
    @ApiOperation("查询首页装修案例展示数")
    public Result queryPageCase() {
        List<SrvcDecorateCase> list =null;
        try {
            list = srvcDecorateCaseService.selectPageCase();

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
        }
        return Result.success(list);
    }

    /**
     * 查询楼盘情况及图片信息列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/cases",method = RequestMethod.POST)
    @ApiOperation("查询所有装修案例信息列表")
    public Result casesQuery(@RequestBody Map<String,Object> map) {
        List<SrvcDecorateCase> list =null;
        try {
            list = srvcDecorateCaseService.selectDecorateCaseByParams(map);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

    /**
     * 查询楼盘情况及图片信息列表
     * @param id
     * @return
     */
    @RequestMapping(value = "/cases/{id}",method = RequestMethod.GET)
    @ApiOperation("根据id查询装修案例信息列表")
    public Result queryById(@PathVariable Integer id) {
        List<SrvcDecorateCase> list =null;
        try {
            list = srvcDecorateCaseService.selectDecorateCaseById(id);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

}
