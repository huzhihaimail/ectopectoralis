
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 楼盘施工情况异常常量类
 *
 * @author rain
 */
public interface HousesSubErrorCode {

    /**
     * 首页
     */
    String SRVC_HOUSESSUB = "5550";

    /**
     * 新建楼盘施工情况系统异常
     */
    String SRVC_HOUSESSUB_SAVE_APP_ERROR_CODE = SRVC_HOUSESSUB + "1";
    String SRVC_HOUSESSUB_SAVE_APP_ERROR_MESSAGE = "新建楼盘施工情况出现系统异常";

    /**
     * 新建楼盘施工情况根异常
     */
    String SRVC_HOUSESSUB_SAVE_ERROR_CODE = SRVC_HOUSESSUB + "2";
    String SRVC_HOUSESSUB_SAVE_ERROR_MESSAGE = "新建楼盘施工情况出现根异常";

    /**
     * 更新楼盘施工情况系统异常
     */
    String SRVC_HOUSESSUB_UPDATE_APP_ERROR_CODE = SRVC_HOUSESSUB + "3";
    String SRVC_HOUSESSUB_UPDATE_APP_ERROR_MESSAGE = "更新楼盘施工情况出现系统异常";

    /**
     * 更新楼盘施工情况根异常
     */
    String SRVC_HOUSESSUB_UPDATE_ERROR_CODE = SRVC_HOUSESSUB + "4";
    String SRVC_HOUSESSUB_UPDATE_ERROR_MESSAGE = "更新楼盘施工情况出现根异常";

}
