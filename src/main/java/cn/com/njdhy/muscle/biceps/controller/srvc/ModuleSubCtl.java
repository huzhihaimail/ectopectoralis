package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.sys.UserErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModuleSub;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcModuleSubService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 十大模块子模块展示控制器
 * @author rain
 * @date 2018/11/17 22:24
 **/
@RestController
@RequestMapping("/srvc/module/sub")
public class ModuleSubCtl {

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
        PageInfo<SrvcModuleSub> result = srvcModuleSubService.queryList(queryParam, pageNumber, pageSize);

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

        SrvcModuleSub model = srvcModuleSubService.queryById(id);

        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcModuleSub();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcModuleSub 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcModuleSub srvcModuleSub) {

        try {
            // 执行入库操作
            srvcModuleSubService.insert(srvcModuleSub);
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcModuleSub 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcModuleSub srvcModuleSub) {

        try {
            // 执行修改
            srvcModuleSubService.update(srvcModuleSub);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(UserErrorCode.SYS_USER_UPDATE_APP_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(UserErrorCode.SYS_USER_UPDATE_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_ERROR_MESSAGE);
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
            srvcModuleSubService.deleteByIds(ids);
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
