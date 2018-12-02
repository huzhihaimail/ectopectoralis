package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据id查询设计师及其案例作品详情
     * @param id
     * @return
     */
    List<SrvcDesigner> selectDesignerById(Integer id);

    /**
     * 根据条件查询所有设计师 用于楼盘模块调用
     * @param map
     * @return
     */
    List<SrvcDesigner> queryDesigners(Map<String,Object> map);
}
