package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
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
     * backend 查询所有楼盘情况图片列表
     * @param map
     * @return
     */
    List<SrvcHouses> selectHousesList(Map<String,Object> map);
    /**
     * api查询楼盘情况及图片
     * @param progressTitle
     * @return
     */
    List<SrvcHouses> selectHousesInfo(Integer progressTitle);
}
