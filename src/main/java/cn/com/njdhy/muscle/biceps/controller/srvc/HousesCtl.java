package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHousesSub;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcHousesService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcHousesSubService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 楼盘情况控制器
 *
 * @author rain
 * @date 2018/11/17 22:11
 **/
@RestController
@RequestMapping("/srvc/houses")
public class HousesCtl {


    @Autowired
    private SrvcHousesService srvcHousesService;
    @Autowired
    private SrvcHousesSubService srvcHousesSubService;

    @Autowired
    private SystemConstant systemConstant;

    /**
     * 查询banner图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        Query queryParam = new Query(params);
        PageInfo<SrvcHouses> result = srvcHousesService.selectHousesList(queryParam, pageNumber, pageSize);
        List<SrvcHouses> list = result.getList();
        for (SrvcHouses srvcHouses : list) {
            String s = systemConstant.getDomain() + srvcHouses.getImageUrl();
            srvcHouses.setImageUrl(s);
        }
        result.setList(list);
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

        // todo 参数校验

        SrvcHouses model = srvcHousesService.queryById(id);
        String img = systemConstant.getDomain() + model.getImageUrl();
        model.setImageUrl(img);
        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcHouses();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcHouses 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public Result insert(@RequestBody SrvcHouses srvcHouses) {

        try {
            // 执行入库操作
            srvcHousesService.insert(srvcHouses);
            SrvcHousesSub srvcHousesSub = new SrvcHousesSub();
            srvcHousesSub.setHousesId(srvcHouses.getId());
            srvcHousesSub.setImageUrl(srvcHouses.getImageUrl());
            srvcHousesSubService.insert(srvcHousesSub);
        } catch (ApplicationException e) {
            return Result.error(HousesErrorCode.SRVC_HOUSES_SAVE_APP_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SAVE_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcHouses 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcHouses srvcHouses) {

        try {
            // 校验参数
            // TODO: 2018/3/14

            // 执行修改
            srvcHousesService.update(srvcHouses);
        } catch (RuntimeException e) {
            return Result.error(HousesErrorCode.SRVC_HOUSES_UPDATE_APP_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(HousesErrorCode.SRVC_HOUSES_UPDATE_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_UPDATE_ERROR_MESSAGE);
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
            // 校验参数 todo
            srvcHousesService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
