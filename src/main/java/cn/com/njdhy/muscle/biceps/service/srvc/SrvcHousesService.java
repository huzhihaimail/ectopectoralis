package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * 楼盘情况业务层接口
 * @author rain
 * @date 2018/11/17 23:21
 **/
public interface SrvcHousesService extends BaseService<SrvcHouses>{


    /**
     * 查询楼盘情况及图片
     * @param progressTitle
     * @return
     */
    List<SrvcHouses> selectHousesInfo(Integer progressTitle);
}
