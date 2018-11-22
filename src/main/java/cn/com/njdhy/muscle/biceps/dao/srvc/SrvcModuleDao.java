package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModule;

import java.util.List;
import java.util.Map;

/**
 * 十大模块数据访问层接口
 * @author rain
 * @date 2018/11/17 22:48
 **/
public interface SrvcModuleDao extends BaseDao<SrvcModule> {

    /**
     * 后台查询十大模块及其子模块信息
     * @param map
     * @return
     */
    List<SrvcModule> selectModuleList(Map<String,Object> map);

    /**
     * api 十大模块
     * @param moduleName
     * @return
     */
    List<SrvcModule> selectModuleInfo(String moduleName);
}
