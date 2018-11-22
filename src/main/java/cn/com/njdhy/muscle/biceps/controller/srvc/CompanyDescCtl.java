package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCompanyDescService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 三大模块控制器
 * @author rain
 * @date 2018/11/17 22:18
 **/
@RestController
@RequestMapping("/srvc/company/desc")
public class CompanyDescCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyDescCtl.class);

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
        Query queryParam = new Query(params);
        PageInfo<SrvcCompanyDesc> result = srvcCompanyDescService.queryList(queryParam, pageNumber, pageSize);

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

        SrvcCompanyDesc model = srvcCompanyDescService.queryById(id);

        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcCompanyDesc();
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

            // 执行入库操作
            srvcCompanyDescService.insert(srvcCompanyDesc);
        } catch (ApplicationException e) {
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
            // TODO: 2018/3/14

            // 执行修改
            srvcCompanyDescService.update(srvcCompanyDesc);
        } catch (RuntimeException e) {
            return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_CODE, CompanyDescErrorCode.SRVC_COMPANYDESC_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
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
            // 校验参数 todo
            srvcCompanyDescService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
