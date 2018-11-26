package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModule;
import cn.com.njdhy.muscle.biceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 十大模块业务层接口
 * @author rain
 * @date 2018/11/17 23:24
 **/
public interface SrvcModuleService extends BaseService<SrvcModule>{

    /**
     * 十大模块后台显示查询
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<SrvcModule> selectModuleList(Map<String,Object> map, Integer pageNumber, Integer pageSize);

    /**
     * 查询十大模块及其子模块信息
     * @param moduleName
     * @return
     */
    List<SrvcModule> selectModuleInfo(String moduleName,Integer ImageType);
}
