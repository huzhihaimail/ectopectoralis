package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;

import java.util.List;
import java.util.Map;

/**
 * 楼盘情况数据访问层接口
 * @author rain
 * @date 2018/11/17 22:50
 **/
public interface SrvcHousesDao extends BaseDao<SrvcHouses> {

    /**
     * backend 查询所有楼盘情及其设计师列表
     * @param map
     * @return
     */
    List<SrvcHouses> selectHousesList(Map<String,Object> map);

    /**
     * 根据条件查询所有楼盘名，用于装修案例模块和在施工地模块调用
     * @param map
     * @return
     */
    List<SrvcHouses> queryHouses(Map<String,Object> map);
}
