package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * 三大模块业务处理接口
 * @author rain
 * @date 2018/11/17 23:27
 **/
public interface SrvcCompanyDescService extends BaseService<SrvcCompanyDesc>{

    /**
     * 查询三大模块信息
     * @param name
     * @return
     */
    List<SrvcCompanyDesc> selectCompanyDescInfo(String name);



}
