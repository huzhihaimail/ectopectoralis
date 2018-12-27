package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcBuildingPlaceService;
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
@Api(tags = "在施工地模块接口")
public class BuildingPlaceController {

    @Autowired
    private SrvcBuildingPlaceService srvcBuildingPlaceService;

    /**
     * 首页查询在施工地
     * @return
     */

    @RequestMapping(value = "/page/place",method = RequestMethod.POST)
    @ApiOperation("首页查询在施工地")
    public Result pagePlaceQuery (){
        List<SrvcBuildingPlace> list =null;
        try {

            list = srvcBuildingPlaceService.selectPageBuildingImg();

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

    /**
     * 查询在施工地及图片信息列表
     * @return
     */
    @RequestMapping(value = "/places",method = RequestMethod.POST)
    @ApiOperation("查询在施工地及图片信息列表")
    public Result placeQuery(@RequestBody Map<String,Object> map) {
        List<SrvcBuildingPlace> list =null;
        try {

            list = srvcBuildingPlaceService.selectBuildingPlaceParams(map);

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
    @RequestMapping(value = "/places/{id}",method = RequestMethod.GET)
    @ApiOperation("根据id查询在施工地进度详情")
    public Result queryById(@PathVariable Integer id) {
        List<SrvcBuildingPlace> list =null;
        try {
            list = srvcBuildingPlaceService.selectBuildingPlaceById(id);

        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

    @RequestMapping(value = "/count/{id}",method = RequestMethod.GET)
    @ApiOperation("根据id查询在施工地进度个数")
    public int queryCountById(@PathVariable Integer id) {
        Integer number = null;
        try {
            number   =  srvcBuildingPlaceService.selectBuildingCountById(id);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return number;
    }
}
