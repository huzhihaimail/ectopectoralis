
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 装修案例异常常量类
 *
 * @author 胡志海
 */
public interface CaseErrorCode {

    /**
     * 首页
     */
    String SRVC_CASE= "4660";


    /**
     * 新建用户系统异常
     */
    String SRVC_CASE_SAVE_APP_ERROR_CODE = SRVC_CASE + "1";
    String SRVC_CASE_SAVE_APP_ERROR_MESSAGE = "新建装修案例出现系统异常";

    /**
     * 新建用户根异常
     */
    String SRVC_CASE_SAVE_ERROR_CODE = SRVC_CASE + "2";
    String SRVC_CASE_SAVE_ERROR_MESSAGE = "新建装修案例出现根异常";

    /**
     * 更新用户系统异常
     */
    String SRVC_CASE_UPDATE_APP_ERROR_CODE = SRVC_CASE + "3";
    String SRVC_CASE_UPDATE_APP_ERROR_MESSAGE = "更新装修案例出现系统异常";

    /**
     * 更新用户根异常
     */
    String SRVC_CASE_UPDATE_ERROR_CODE = SRVC_CASE + "4";
    String SRVC_CASE_UPDATE_ERROR_MESSAGE = "更新装修案例出现根异常";

    /**
     * 入参校验
     */
    String SRVC_CASE_PARAMS_ERROR_CODE = SRVC_CASE + "5";
    String SRVC_CASE_PARAMS_ERROR_MESSAGE = "入参校验出现异常";

    /**
     * 查询装修案例列表
     */
    String SRVC_CASE_SELECT_ERROR_CODE = SRVC_CASE + "6";
    String SRVC_CASE_SELECT_ERROR_MESSAGE = "查询装修案例列表出现异常";
}
