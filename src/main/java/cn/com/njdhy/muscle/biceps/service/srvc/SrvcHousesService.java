package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 楼盘情况业务层接口
 * @author rain
 * @date 2018/11/17 23:21
 **/
public interface SrvcHousesService extends BaseService<SrvcHouses>{

    /**
     * backend 查询所有楼盘情及其设计师列表
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<SrvcHouses> selectHousesList(Map<String, Object> map, Integer pageNumber, Integer pageSize);

    /**
     * 根据条件查询所有楼盘名，用于装修案例模块和在施工地模块调用
     * @param map
     * @return
     */
    List<SrvcHouses> queryHouses(Map<String,Object> map);
}
