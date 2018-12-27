package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Description：
 * <功能简介>--装修案例业务层
 *
 * @author rain
 * @date 2018/11/30 11:25
 **/
public interface SrvcDecorateCaseService extends BaseService<SrvcDecorateCase>{

    /**
     * 查询装修案例详情列表
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SrvcDecorateCase> selectDecorateCaseList(Map<String, Object> map, Integer pageNum, Integer pageSize);

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
     * 查询首页装修案例展示数
     * @return
     */
    List<SrvcDecorateCase> selectPageCase();
}
