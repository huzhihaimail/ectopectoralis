package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.GuideErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.HousesErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.VideoErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcDesignerService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcHousesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 视频管理控制器
 * @author rain
 * @date 2018/11/17 22:22
 **/
@RestController
@RequestMapping("/srvc/houses")
public class HousesCtl {


    @Autowired
    private SrvcHousesService srvcHousesService;
    @Autowired
    private SrvcDesignerService srvcDesignerService;

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
        PageInfo<SrvcHouses> result=null;
        try {
            Query queryParam = new Query(params);
            result = srvcHousesService.selectHousesList(queryParam, pageNumber, pageSize);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
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
        SrvcHouses model=null;
        try {
            if (null == id) {
                return Result.error(HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_MESSAGE);
            }
            model = srvcHousesService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcHouses();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_SELECT_ERROR_MESSAGE);
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
    public Result insert(@RequestBody SrvcHouses srvcHouses) {

        try {
            // 校验参数
            if(null==srvcHouses){
                return Result.error(HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            srvcHousesService.insert(srvcHouses);
        } catch (ApplicationException e) {
            e.printStackTrace();
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
            if(null==srvcHouses){
                return Result.error(HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_MESSAGE);
            }
            // 执行修改
            srvcHousesService.update(srvcHouses);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(HousesErrorCode.SRVC_HOUSES_UPDATE_APP_ERROR_CODE, HousesErrorCode.SRVC_HOUSES_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
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
            // 校验参数
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_CODE,HousesErrorCode.SRVC_HOUSES_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcHousesService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }

    /**
     * 查询所有设计师
     * @param map
     * @return
     */
    @RequestMapping("/designers")
    public Result queryDesigner(@RequestParam Map<String, Object> map) {
        List<SrvcDesigner> srvcDesigners = null;
        try {
            srvcDesigners = srvcDesignerService.queryDesigners(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success().put("designers",srvcDesigners);
    }
}
