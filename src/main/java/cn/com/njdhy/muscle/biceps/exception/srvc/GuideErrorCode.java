
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 装修指南异常常量类
 *
 * @author rain
 */
public interface GuideErrorCode {

    /**
     * 首页
     */
    String SRVC_DECORATEGUIDE = "5110";


    /**
     * 新建装修指南系统异常
     */
    String SRVC_DECORATEGUIDE_SAVE_APP_ERROR_CODE = SRVC_DECORATEGUIDE + "1";
    String SRVC_DECORATEGUIDE_SAVE_APP_ERROR_MESSAGE = "新建装修指南出现系统异常";

    /**
     * 新建装修指南根异常
     */
    String SRVC_DECORATEGUIDE_SAVE_ERROR_CODE = SRVC_DECORATEGUIDE + "2";
    String SRVC_DECORATEGUIDE_SAVE_ERROR_MESSAGE = "新建装修指南出现根异常";

    /**
     * 更新装修指南系统异常
     */
    String SRVC_DECORATEGUIDE_UPDATE_APP_ERROR_CODE = SRVC_DECORATEGUIDE + "3";
    String SRVC_DECORATEGUIDE_UPDATE_APP_ERROR_MESSAGE = "更新装修指南出现系统异常";

    /**
     * 更新装修指南根异常
     */
    String SRVC_DECORATEGUIDE_UPDATE_ERROR_CODE = SRVC_DECORATEGUIDE + "4";
    String SRVC_DECORATEGUIDE_UPDATE_ERROR_MESSAGE = "更新装修指南出现根异常";

    /**
     * 查询装修指南异常
     */
    String SRVC_DECORATEGUIDE_SELECT_ERROR_CODE = SRVC_DECORATEGUIDE + "5";
    String SRVC_DECORATEGUIDE_SELECT_ERROR_MESSAGE = "查询装修指南出现异常";

    /**
     * 装修指南入参校验异常
     */
    String SRVC_DECORATEGUIDE_PARAMS_ERROR_CODE = SRVC_DECORATEGUIDE + "5";
    String SRVC_DECORATEGUIDE_PARAMS_ERROR_MESSAGE = "装修指南参数出现异常";
}
