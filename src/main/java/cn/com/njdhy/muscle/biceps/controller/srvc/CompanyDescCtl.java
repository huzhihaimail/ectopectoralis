package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.BuildingPlaceErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCompanyDescService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 三大模块控制器
 *
 * @author rain
 * @date 2018/11/17 22:18
 **/
@RestController
@RequestMapping("/srvc/company/desc")
public class CompanyDescCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcCompanyDescService srvcCompanyDescService;

    /**
     * 查询三大模块列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcCompanyDesc> result=null;
        try {
            Query queryParam = new Query(params);
            result = srvcCompanyDescService.queryList(queryParam, pageNumber, pageSize);
            List<SrvcCompanyDesc> list = result.getList();
            for (SrvcCompanyDesc srvcCompanyDesc : list) {
                String imgUrl = appCommonProperties.getImagesPrefix() + srvcCompanyDesc.getImageUrl();
                srvcCompanyDesc.setImageUrl(imgUrl);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
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
        SrvcCompanyDesc model=null;
        try {
            if (id==null){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            model = srvcCompanyDescService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcCompanyDesc();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcCompanyDesc 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcCompanyDesc srvcCompanyDesc) {

        try {
            if(null == srvcCompanyDesc){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            srvcCompanyDescService.insert(srvcCompanyDesc);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SAVE_APP_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_SAVE_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcCompanyDesc 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcCompanyDesc srvcCompanyDesc) {

        try {
            // 校验参数
            if(null == srvcCompanyDesc){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            // 执行修改
            srvcCompanyDescService.update(srvcCompanyDesc);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_ERROR_MESSAGE);
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
                    return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcCompanyDescService.deleteByIds(ids);
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
