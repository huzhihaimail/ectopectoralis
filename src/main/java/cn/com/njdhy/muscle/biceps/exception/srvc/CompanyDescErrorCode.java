
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> BANNER异常常量类
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
    String SRVC_COMPANYDESC_SAVE_APP_ERROR_MESSAGE = "新建banner图出现系统异常";

    /**
     * 新建用户根异常
     */
    String SRVC_COMPANYDESC_SAVE_ERROR_CODE = SRVC_COMPANYDESC + "2";
    String SRVC_COMPANYDESC_SAVE_ERROR_MESSAGE = "新建banner图出现根异常";

    /**
     * 更新用户系统异常
     */
    String SRVC_COMPANYDESC_UPDATE_APP_ERROR_CODE = SRVC_COMPANYDESC + "3";
    String SRVC_COMPANYDESC_UPDATE_APP_ERROR_MESSAGE = "更新banner图出现系统异常";

    /**
     * 更新用户根异常
     */
    String SRVC_COMPANYDESC_UPDATE_ERROR_CODE = SRVC_COMPANYDESC + "4";
    String SRVC_COMPANYDESC_UPDATE_ERROR_MESSAGE = "更新banner图出现根异常";

}
