package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.GuideErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcGuide;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcGuideService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 装修指南控制器
 *
 * @author rain
 * @date 2018/11/17 22:23
 **/
@RestController
@RequestMapping("/srvc/decorate/guide")
public class GuideCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;

    @Autowired
    private SrvcGuideService srvcGuideService;

    /**
     * 查询banner图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return banner列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        Query queryParam = new Query(params);
        PageInfo<SrvcGuide> result = srvcGuideService.queryList(queryParam, pageNumber, pageSize);
        List<SrvcGuide> list = result.getList();
        for (SrvcGuide srvcGuide : list) {
            String s = appCommonProperties.getImagesPrefix() + srvcGuide.getImageUrl();
            srvcGuide.setImageUrl(s);
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

        SrvcGuide model = srvcGuideService.queryById(id);
        String img =appCommonProperties.getImagesPrefix() + model.getImageUrl();
        model.setImageUrl(img);
        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcGuide();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcGuide 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcGuide srvcGuide) {

        try {

            // 执行入库操作
            srvcGuideService.insert(srvcGuide);
        } catch (ApplicationException e) {
            return Result.error(GuideErrorCode.SRVC_DECORATEGUIDE_SAVE_APP_ERROR_CODE, GuideErrorCode.SRVC_DECORATEGUIDE_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(GuideErrorCode.SRVC_DECORATEGUIDE_SAVE_ERROR_CODE, GuideErrorCode.SRVC_DECORATEGUIDE_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcGuide 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcGuide srvcGuide) {

        try {
            // 校验参数
            // TODO: 2018/3/14

            // 执行修改
            srvcGuideService.update(srvcGuide);
        } catch (RuntimeException e) {
            return Result.error(GuideErrorCode.SRVC_DECORATEGUIDE_UPDATE_APP_ERROR_CODE, GuideErrorCode.SRVC_DECORATEGUIDE_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(GuideErrorCode.SRVC_DECORATEGUIDE_UPDATE_ERROR_CODE, GuideErrorCode.SRVC_DECORATEGUIDE_UPDATE_ERROR_MESSAGE);
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
            srvcGuideService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
