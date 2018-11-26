package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CustomerErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCustomer;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCustomerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 顾客管理控制器
 * @author rain
 * @date 2018/11/17 22:21
 **/
@RestController
@RequestMapping("/srvc/customer")
public class CustomerCtl {

    @Autowired
    private SystemConstant systemConstant;

    @Autowired
    private SrvcCustomerService srvcCustomerService;

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
        PageInfo<SrvcCustomer> result = srvcCustomerService.queryList(queryParam, pageNumber, pageSize);

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

        SrvcCustomer model = srvcCustomerService.queryById(id);

        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcCustomer();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcCustomer 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcCustomer srvcCustomer) {

        try {

            // 执行入库操作
            srvcCustomerService.insert(srvcCustomer);
        } catch (ApplicationException e) {
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcCustomer 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcCustomer srvcCustomer) {

        try {
            // 校验参数
            // TODO: 2018/3/14

            // 执行修改
            srvcCustomerService.update(srvcCustomer);
        } catch (RuntimeException e) {
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_UPDATE_APP_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_UPDATE_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_UPDATE_ERROR_MESSAGE);
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
            srvcCustomerService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
