package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;

import java.util.List;
import java.util.Map;

/**
 * 三大模块数据访问层接口
 * @author rain
 * @date 2018/11/17 20:57
 **/
public interface SrvcCompanyDescDao extends BaseDao<SrvcCompanyDesc> {

    /**
     * backend 查询三大模块信息列表
     * @param map
     * @return
     */
    List<SrvcCompanyDesc> selectCompanyDescList(Map<String,Object> map);
    /**
     * api查询三大模块信息
     * @param name
     * @return
     */
    List<SrvcCompanyDesc> selectCompanyDescInfo(String name);

}
