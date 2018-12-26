package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.BannerErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.BuildingPlaceErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesSubErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcPlaceImg;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcBuildingPlaceService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcPlaceImgService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 施工工进度情况控制器
 * @author rain
 * @date 2018/11/17 22:14
 **/
@RestController
@RequestMapping("/srvc/place")
public class BuildingPlaceCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcBuildingPlaceService srvcBuildingPlaceService;
    @Autowired
    private SrvcPlaceImgService srvcPlaceImgService;

    /**
     * 查询施工进度图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcBuildingPlace> result=null;
        try {
            Query queryParam = new Query(params);
            result = srvcBuildingPlaceService.selectBuildingPlaceList(queryParam, pageNumber, pageSize);
            List<SrvcBuildingPlace> list = result.getList();
            for (SrvcBuildingPlace srvcBuildingPlace : list) {
                String s = appCommonProperties.getImagesPrefix() + srvcBuildingPlace.getImageUrl();
                srvcBuildingPlace.setImageUrl(s);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_SELECT_ERROR_CODE,BuildingPlaceErrorCode.SRVC_BUILDING_SELECT_ERROR_MESSAGE);
        }
        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {

        SrvcBuildingPlace model=null;
        try {
            if(id ==null || id.length() <= 0){
                return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_PARAMS_ERROR_CODE,BuildingPlaceErrorCode.SRVC_BUILDING_PARAMS_ERROR_MESSAGE);
            }
            model = srvcBuildingPlaceService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcBuildingPlace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_SELECT_ERROR_CODE,BuildingPlaceErrorCode.SRVC_BUILDING_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcBuildingPlace 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public Result insert(@RequestBody SrvcBuildingPlace srvcBuildingPlace) {

        try {

            // 执行入库操作
            srvcBuildingPlaceService.insert(srvcBuildingPlace);
            SrvcPlaceImg srvcPlaceImg = new SrvcPlaceImg();
            srvcPlaceImg.setPlaceId(srvcBuildingPlace.getId());
            srvcPlaceImg.setImageUrl(srvcBuildingPlace.getImageUrl());
            srvcPlaceImg.setImageExplain(srvcBuildingPlace.getImageExplain());
            srvcPlaceImgService.insert(srvcPlaceImg);
        } catch (ApplicationException e) {
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_SAVE_APP_ERROR_CODE, BuildingPlaceErrorCode.SRVC_BUILDING_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_SAVE_ERROR_CODE, BuildingPlaceErrorCode.SRVC_BUILDING_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcBuildingPlace 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcBuildingPlace srvcBuildingPlace) {

        try {

            srvcBuildingPlaceService.update(srvcBuildingPlace);
            SrvcPlaceImg srvcPlaceImg = new SrvcPlaceImg();
            srvcPlaceImg.setId(srvcBuildingPlace.getImgId());
            srvcPlaceImg.setImageUrl(srvcBuildingPlace.getImageUrl());
            srvcPlaceImg.setImageExplain(srvcBuildingPlace.getImageExplain());
            srvcPlaceImgService.update(srvcPlaceImg);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_UPDATE_APP_ERROR_CODE, BuildingPlaceErrorCode.SRVC_BUILDING_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_UPDATE_ERROR_CODE, BuildingPlaceErrorCode.SRVC_BUILDING_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(BuildingPlaceErrorCode.SRVC_BUILDING_PARAMS_ERROR_CODE, BuildingPlaceErrorCode.SRVC_BUILDING_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcBuildingPlaceService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
