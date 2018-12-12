package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCore;


/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/11 15:21
 **/
public interface SrvcCoreDao extends BaseDao<SrvcCore> {

    /**
     * 根据模块类型查询
     * @param type
     * @return
     */
    SrvcCore queryByType(Integer type);
}
