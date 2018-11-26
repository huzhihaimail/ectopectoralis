package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 三大模块业务处理接口
 * @author rain
 * @date 2018/11/17 23:27
 **/
public interface SrvcCompanyDescService extends BaseService<SrvcCompanyDesc>{

    /**
     * 根据模块类型查询
     * @param type
     * @return
     */
    List<SrvcCompanyDesc>queryByType(Integer type);
}
