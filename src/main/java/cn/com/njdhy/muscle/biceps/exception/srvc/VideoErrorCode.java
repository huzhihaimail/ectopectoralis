
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 视频模块异常常量类
 *
 * @author rain
 */
public interface VideoErrorCode {

    /**
     * 首页
     */
    String SRVC_VIDEO = "5330";


    /**
     * 新建视频系统异常
     */
    String SRVC_VIDEO_SAVE_APP_ERROR_CODE = SRVC_VIDEO + "1";
    String SRVC_VIDEO_SAVE_APP_ERROR_MESSAGE = "新建视频模块出现系统异常";

    /**
     * 新建视频模块根异常
     */
    String SRVC_VIDEO_SAVE_ERROR_CODE = SRVC_VIDEO + "2";
    String SRVC_VIDEO_SAVE_ERROR_MESSAGE = "新建视频模块出现根异常";

    /**
     * 更新视频模块系统异常
     */
    String SRVC_VIDEO_UPDATE_APP_ERROR_CODE = SRVC_VIDEO + "3";
    String SRVC_VIDEO_UPDATE_APP_ERROR_MESSAGE = "更新视频模块出现系统异常";

    /**
     * 更新视频模块根异常
     */
    String SRVC_VIDEO_UPDATE_ERROR_CODE = SRVC_VIDEO + "4";
    String SRVC_VIDEO_UPDATE_ERROR_MESSAGE = "更新视频模块出现根异常";

    /**
     * 查询视频模块根异常
     */
    String SRVC_VIDEO_SELECT_ERROR_CODE = SRVC_VIDEO + "5";
    String SRVC_VIDEO_SELECT_ERROR_MESSAGE = "查询视频模块出现异常";

    /**
     * 入参校验
     */
    String SRVC_VIDEO_PARAMS_ERROR_CODE = SRVC_VIDEO + "6";
    String SRVC_VIDEO_PARAMS_ERROR_MESSAGE = "视频模块参数出现异常";

}
