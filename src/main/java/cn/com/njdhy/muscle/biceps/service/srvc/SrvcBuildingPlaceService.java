package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Description：
 * <功能简介>--施工进度模块业务层接口
 *
 * @author rain
 * @date 2018/11/30 12:51
 **/
public interface SrvcBuildingPlaceService extends BaseService<SrvcBuildingPlace>{

    /**
     * 查询施工进度详情列表
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SrvcBuildingPlace> selectBuildingPlaceList(Map<String, Object> map, Integer pageNum, Integer pageSize);

    /**
     * backend 查询施工进度情况及图片列表
     * @param map
     * @return
     */
    List<SrvcBuildingPlace> selectBuildingPlaceParams(Map<String, Object> map);

    /**
     * 更加id查询在施工地进度情况
     * @param id
     * @return
     */
    List<SrvcBuildingPlace> selectBuildingPlaceById(Integer id);

    /**
     * 查询进度记个数
     * @param id
     * @return
     */
    int selectBuildingCountById(Integer id);

    /**
     * api 首页查询在施工地 限制5条
     * @return
     */
    List<SrvcBuildingPlace> selectPageBuildingImg();
}
