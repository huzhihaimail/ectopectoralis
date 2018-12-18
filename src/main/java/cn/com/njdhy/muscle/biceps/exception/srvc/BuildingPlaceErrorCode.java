
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> 在施工地异常常量类
 *
 * @author 胡志海
 */
public interface BuildingPlaceErrorCode {

    /**
     * 首页
     */
    String SRVC_BUILDING = "4330";


    /**
     * 新建用户系统异常
     */
    String SRVC_BUILDING_SAVE_APP_ERROR_CODE = SRVC_BUILDING + "1";
    String SRVC_BUILDING_SAVE_APP_ERROR_MESSAGE = "新建在施工地出现系统异常";

    /**
     * 新建用户根异常
     */
    String SRVC_BUILDING_SAVE_ERROR_CODE = SRVC_BUILDING + "2";
    String SRVC_BUILDING_SAVE_ERROR_MESSAGE = "新建在施工地出现根异常";

    /**
     * 更新用户系统异常
     */
    String SRVC_BUILDING_UPDATE_APP_ERROR_CODE = SRVC_BUILDING + "3";
    String SRVC_BUILDING_UPDATE_APP_ERROR_MESSAGE = "更新在施工地出现系统异常";

    /**
     * 更新用户根异常
     */
    String SRVC_BUILDING_UPDATE_ERROR_CODE = SRVC_BUILDING + "4";
    String SRVC_BUILDING_UPDATE_ERROR_MESSAGE = "更新在施工地出现根异常";

    /**
     * 入参校验
     */
    String SRVC_BUILDING_PARAMS_ERROR_CODE = SRVC_BUILDING + "5";
    String SRVC_BUILDING_PARAMS_ERROR_MESSAGE = "入参校验出现异常";

    /**
     * 查询在施工地列表
     */
    String SRVC_BUILDING_SELECT_ERROR_CODE = SRVC_BUILDING + "6";
    String SRVC_BUILDING_SELECT_ERROR_MESSAGE = "查询在施工地列表出现异常";
}
