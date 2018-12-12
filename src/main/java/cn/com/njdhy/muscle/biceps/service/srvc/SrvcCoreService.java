package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCore;
import cn.com.njdhy.muscle.biceps.service.BaseService;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/11 15:24
 **/
public interface SrvcCoreService extends BaseService<SrvcCore>{

    /**
     * 根据模块类型查询
     * @param type
     * @return
     */
    SrvcCore queryByType(Integer type);
}
