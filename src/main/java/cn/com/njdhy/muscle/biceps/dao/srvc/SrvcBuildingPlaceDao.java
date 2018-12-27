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
public interface SrvcBuildingPlaceDao extends BaseDao<SrvcBuildingPlace> {

    /**
     * backend 查询施工进度情况及图片列表
     * @param map
     * @return
     */
    List<SrvcBuildingPlace> selectBuildingPlaceList(Map<String, Object> map);

    /**
     * backend 查询施工进度情况及图片列表
     * @param map
     * @return
     */
    List<SrvcBuildingPlace> selectBuildingPlaceParams(Map<String, Object> map);

    /**
     * 更加id查询在施工地进度情况
     * @param id
     * @return
     */
    List<SrvcBuildingPlace> selectBuildingPlaceById(Integer id);

    /**
     * 查询进度记个数
     * @param id
     * @return
     */
    int selectBuildingCountById(Integer id);

    /**
     * api 首页查询在施工地 限制5条
     * @return
     */
    List<SrvcBuildingPlace> selectPageBuildingImg();

}
