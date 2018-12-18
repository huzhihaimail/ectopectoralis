
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 顾客模块异常常量类
 *
 * @author rain
 */
public interface CustomerErrorCode {

    /**
     * 首页
     */
    String SRVC_CUSTOMER = "5000";


    /**
     * 新建用户系统异常
     */
    String SRVC_CUSTOMER_SAVE_APP_ERROR_CODE = SRVC_CUSTOMER + "1";
    String SRVC_CUSTOMER_SAVE_APP_ERROR_MESSAGE = "新建顾客出现系统异常";

    /**
     * 新建用户根异常
     */
    String SRVC_CUSTOMER_SAVE_ERROR_CODE = SRVC_CUSTOMER + "2";
    String SRVC_CUSTOMER_SAVE_ERROR_MESSAGE = "新建顾客出现根异常";

    /**
     * 更新用户系统异常
     */
    String SRVC_CUSTOMER_UPDATE_APP_ERROR_CODE = SRVC_CUSTOMER + "3";
    String SRVC_CUSTOMER_UPDATE_APP_ERROR_MESSAGE = "更新顾客出现系统异常";

    /**
     * 更新用户根异常
     */
    String SRVC_CUSTOMER_UPDATE_ERROR_CODE = SRVC_CUSTOMER + "4";
    String SRVC_CUSTOMER_UPDATE_ERROR_MESSAGE = "更新顾客出现根异常";

    /**
     * 入参校验
     */
    String SRVC_CUSTOMER_PARAMS_ERROR_CODE = SRVC_CUSTOMER + "5";
    String SRVC_CUSTOMER_PARAMS_ERROR_MESSAGE = "入参校验出现异常";

    /**
     * 查询用户异常
     */
    String SRVC_CUSTOMER_SELECT_ERROR_CODE = SRVC_CUSTOMER + "6";
    String SRVC_CUSTOMER_SELECT_ERROR_MESSAGE = "查询顾客出现根异常";

}
