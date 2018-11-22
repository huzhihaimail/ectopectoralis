package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;

import java.util.List;

/**
 * 设计师管理数据访问层接口
 * @author rain
 * @date 2018/11/17 22:52
 **/
public interface SrvcDesignerDao extends BaseDao<SrvcDesigner> {

    /**
     * 查询所有的设计师信息
     * @return
     */
    List<SrvcDesigner> selectDesignerList();
}
