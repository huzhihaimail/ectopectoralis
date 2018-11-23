package cn.com.njdhy.muscle.biceps.service.srvc;

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
     * backend查询楼盘情况列表
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<SrvcHouses> selectHousesList(Map<String, Object> map, Integer pageNumber, Integer pageSize);

    /**
     * 查询楼盘情况及图片
     * @param progressTitle
     * @return
     */
    List<SrvcHouses> selectHousesInfo(Integer progressTitle);
}
