
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 设计师模块异常常量类
 *
 * @author rain
 */
public interface DesignerErrorCode {

    /**
     * 首页
     */
    String SRVC_DESIGNER = "5220";


    /**
     * 新建设计师系统异常
     */
    String SRVC_DESIGNER_SAVE_APP_ERROR_CODE = SRVC_DESIGNER + "1";
    String SRVC_DESIGNER_SAVE_APP_ERROR_MESSAGE = "新建设计师信息出现系统异常";

    /**
     * 新建设计师根异常
     */
    String SRVC_DESIGNER_SAVE_ERROR_CODE = SRVC_DESIGNER + "2";
    String SRVC_DESIGNER_SAVE_ERROR_MESSAGE = "新建设计师信息出现根异常";

    /**
     * 更新设计师系统异常
     */
    String SRVC_DESIGNER_UPDATE_APP_ERROR_CODE = SRVC_DESIGNER + "3";
    String SRVC_DESIGNER_UPDATE_APP_ERROR_MESSAGE = "更新设计师信息出现系统异常";

    /**
     * 更新设计师根异常
     */
    String SRVC_DESIGNER_UPDATE_ERROR_CODE = SRVC_DESIGNER + "4";
    String SRVC_DESIGNER_UPDATE_ERROR_MESSAGE = "更新设计师信息出现根异常";

    /**
     * 查询设计师异常
     */
    String SRVC_DESIGNER_SELECT_ERROR_CODE = SRVC_DESIGNER + "5";
    String SRVC_DESIGNER_SELECT_ERROR_MESSAGE = "查询设计师信息出现异常";

    /**
     * 入参校验异常
     */
    String SRVC_DESIGNER_PARAMS_ERROR_CODE = SRVC_DESIGNER + "6";
    String SRVC_DESIGNER_PARAMS_ERROR_MESSAGE = "设计师参数出现异常";
}
