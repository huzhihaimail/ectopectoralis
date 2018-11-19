
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 十大模块异常常量类
 *
 * @author rain
 */
public interface ModuleErrorCode {

    /**
     * 首页
     */
    String SRVC_MODULE = "5660";


    /**
     * 新建十大模块系统异常
     */
    String SRVC_MODULE_SAVE_APP_ERROR_CODE = SRVC_MODULE + "1";
    String SRVC_MODULE_SAVE_APP_ERROR_MESSAGE = "新建十大模块出现系统异常";

    /**
     * 新建十大模块根异常
     */
    String SRVC_MODULE_SAVE_ERROR_CODE = SRVC_MODULE + "2";
    String SRVC_MODULE_SAVE_ERROR_MESSAGE = "新建十大模块出现根异常";

    /**
     * 更新十大模块系统异常
     */
    String SRVC_MODULE_UPDATE_APP_ERROR_CODE = SRVC_MODULE + "3";
    String SRVC_MODULE_UPDATE_APP_ERROR_MESSAGE = "更新十大模块出现系统异常";

    /**
     * 更新十大模块根异常
     */
    String SRVC_MODULE_UPDATE_ERROR_CODE = SRVC_MODULE + "4";
    String SRVC_MODULE_UPDATE_ERROR_MESSAGE = "更新十大模块出现根异常";

}
