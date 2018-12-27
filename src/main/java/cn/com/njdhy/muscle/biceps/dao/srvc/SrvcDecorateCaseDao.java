package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;

import java.util.List;
import java.util.Map;

/**
 * 装修案例数据访问层接口
 * @author rain
 * @date 2018/11/17 22:51
 **/
public interface SrvcDecorateCaseDao extends BaseDao<SrvcDecorateCase> {

    /**
     * 查询装修案例详情列表
     * @param map
     * @return
     */
    List<SrvcDecorateCase> selectDecorateCaseList(Map<String, Object> map);

    /**
     * 根据条件查询所有的案例数据
     * @param map
     * @return
     */
    List<SrvcDecorateCase> selectDecorateCaseByParams(Map<String, Object> map);
    /**
     * 根据条件查询所有的案例数据 api首页搜索接口
     * @param map
     * @return
     */
    List<SrvcDecorateCase> selectDecorateCaseParams(Map<String, Object> map);


    /**
     * 根据id查询所有的案例数据
     * @param id
     * @return
     */
    List<SrvcDecorateCase> selectDecorateCaseById(Integer id);

    /**
     * api 查询首页装修案例展示5条
     * @return
     */
    List<SrvcDecorateCase> selectPageCase();
}
