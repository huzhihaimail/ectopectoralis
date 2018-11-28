package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.ModuleErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModule;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModuleSub;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcModuleService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcModuleSubService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 十大模块控制器
 * @author rain
 * @date 2018/11/17 22:24
 **/
@RestController
@RequestMapping("/srvc/module")
public class ModuleCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcModuleService srvcModuleService;
    @Autowired
    private SrvcModuleSubService srvcModuleSubService;


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
        PageInfo<SrvcModule> result = srvcModuleService.selectModuleList(queryParam, pageNumber, pageSize);
        List<SrvcModule> list = result.getList();
        for (SrvcModule srvcModule : list) {
            String image = appCommonProperties.getImagesPrefix() +srvcModule.getImageUrl();
            srvcModule.setImageUrl(image);
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

        SrvcModule model = srvcModuleService.queryById(id);
        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcModule();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcModule 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public Result insert(@RequestBody SrvcModule srvcModule) {

        try {

            // 执行入库操作
            srvcModuleService.insert(srvcModule);
            SrvcModuleSub srvcModuleSub = new SrvcModuleSub();
            srvcModuleSub.setTitle(srvcModule.getTitle());
            srvcModuleSub.setImageUrl(srvcModule.getImageUrl());
            srvcModuleSub.setImageType(srvcModule.getImageType());
            srvcModuleSub.setModuleId(srvcModule.getId());
            srvcModuleSubService.insert(srvcModuleSub);
        } catch (ApplicationException e) {
            return Result.error(ModuleErrorCode.SRVC_MODULE_SAVE_APP_ERROR_CODE, ModuleErrorCode.SRVC_MODULE_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(ModuleErrorCode.SRVC_MODULE_SAVE_ERROR_CODE, ModuleErrorCode.SRVC_MODULE_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcModule 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result update(@RequestBody SrvcModule srvcModule) {

        try {
            // 校验参数
            // TODO: 2018/3/14

            // 执行修改
            srvcModuleService.update(srvcModule);
            SrvcModuleSub srvcModuleSub = new SrvcModuleSub();
            srvcModuleSub.setTitle(srvcModule.getTitle());
            srvcModuleSub.setImageUrl(srvcModule.getImageUrl());
            srvcModuleSub.setImageType(srvcModule.getImageType());
            srvcModuleSub.setId(srvcModule.getModuleSubId());
            srvcModuleSubService.update(srvcModuleSub);
        } catch (RuntimeException e) {
            return Result.error(ModuleErrorCode.SRVC_MODULE_UPDATE_APP_ERROR_CODE, ModuleErrorCode.SRVC_MODULE_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(ModuleErrorCode.SRVC_MODULE_UPDATE_ERROR_CODE, ModuleErrorCode.SRVC_MODULE_UPDATE_ERROR_MESSAGE);
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
            srvcModuleService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
