
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述>三大模块异常常量类
 *
 * @author rain
 */
public interface CompanyDescErrorCode {

    /**
     * 首页
     */
    String SRVC_COMPANYDESC = "4440";


    /**
     * 新建用户系统异常
     */
    String SRVC_COMPANYDESC_SAVE_APP_ERROR_CODE = SRVC_COMPANYDESC + "1";
    String SRVC_COMPANYDESC_SAVE_APP_ERROR_MESSAGE = "新建三大模块出现系统异常";

    /**
     * 新建用户根异常
     */
    String SRVC_COMPANYDESC_SAVE_ERROR_CODE = SRVC_COMPANYDESC + "2";
    String SRVC_COMPANYDESC_SAVE_ERROR_MESSAGE = "新建三大模块出现根异常";

    /**
     * 更新用户系统异常
     */
    String SRVC_COMPANYDESC_UPDATE_APP_ERROR_CODE = SRVC_COMPANYDESC + "3";
    String SRVC_COMPANYDESC_UPDATE_APP_ERROR_MESSAGE = "更新三大模块出现系统异常";

    /**
     * 更新用户根异常
     */
    String SRVC_COMPANYDESC_UPDATE_ERROR_CODE = SRVC_COMPANYDESC + "4";
    String SRVC_COMPANYDESC_UPDATE_ERROR_MESSAGE = "更新三大模块出现根异常";

    /**
     * 入参校验
     */
    String SRVC_COMPANYDESC_PARAMS_ERROR_CODE = SRVC_COMPANYDESC + "5";
    String SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE = "入参校验出现异常";

    /**
     * 查询三大模块
     */
    String SRVC_COMPANYDESC_SELECT_ERROR_CODE = SRVC_COMPANYDESC + "6";
    String SRVC_COMPANYDESC_SELECT_ERROR_MESSAGE = "查询三大模块出现异常";

}
