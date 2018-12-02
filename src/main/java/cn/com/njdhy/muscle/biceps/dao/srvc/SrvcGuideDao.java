package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcGuide;

import java.util.List;
import java.util.Map;

/**
 * 装修指南管理数据访问层接口
 * @author rain
 * @date 2018/11/17 22:49
 **/
public interface SrvcGuideDao extends BaseDao<SrvcGuide> {

    /**
     * 根据装修指南类型查询所有信息
     * @param type
     * @return
     */
    List<SrvcGuide> selectGuideList(Integer type);

    /**
     * 根据id查询装修指南详情
     * @param id
     * @return
     */
    List<SrvcGuide> selectGuideListById(Integer id);
}
