
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 楼盘情况异常常量类
 *
 * @author rain
 */
public interface HousesErrorCode {

    /**
     * 首页
     */
    String SRVC_HOUSES = "5440";


    /**
     * 新建楼盘系统异常
     */
    String SRVC_HOUSES_SAVE_APP_ERROR_CODE = SRVC_HOUSES + "1";
    String SRVC_HOUSES_SAVE_APP_ERROR_MESSAGE = "新建楼盘情况出现系统异常";

    /**
     * 新建楼盘情况根异常
     */
    String SRVC_HOUSES_SAVE_ERROR_CODE = SRVC_HOUSES + "2";
    String SRVC_HOUSES_SAVE_ERROR_MESSAGE = "新建楼盘情况出现根异常";

    /**
     * 更新楼盘情况系统异常
     */
    String SRVC_HOUSES_UPDATE_APP_ERROR_CODE = SRVC_HOUSES + "3";
    String SRVC_HOUSES_UPDATE_APP_ERROR_MESSAGE = "更新楼盘情况出现系统异常";

    /**
     * 更新楼盘情况根异常
     */
    String SRVC_HOUSES_UPDATE_ERROR_CODE = SRVC_HOUSES + "4";
    String SRVC_HOUSES_UPDATE_ERROR_MESSAGE = "更新楼盘情况出现根异常";

}
