package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CustomerErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "顾客模块接口")
public class CustomerController {

    @Autowired
    private SrvcCustomerService srvcCustomerService;

    /**
     * 保存顾客的信息
     * @param srvcCustomer 请求数据对象
     * @return 结果对象
     */
    @ApiOperation(value = "保存顾客的信息")
    @RequestMapping(value = "/customer/insert",method = RequestMethod.POST)
    public Result insert( @ApiParam(value = "顾客手机号，房屋面积参数" ,required=true ) @RequestBody SrvcCustomer srvcCustomer) {

        try {
            //参数校验
            String mobile = srvcCustomer.getMobile();
            if(mobile == null || mobile.length()<=0){
                return Result.error(CustomerErrorCode.SRVC_CUSTOMER_PARAMS_ERROR_CODE,CustomerErrorCode.SRVC_CUSTOMER_PARAMS_ERROR_MESSAGE);
            }
            srvcCustomerService.insert(srvcCustomer);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_MESSAGE);
        }

        return Result.success("SUCCESS");
    }


}
