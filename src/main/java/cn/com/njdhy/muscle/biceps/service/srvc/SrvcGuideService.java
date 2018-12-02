package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcGuide;
import cn.com.njdhy.muscle.biceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 装修指南业务层接口
 * @author rain
 * @date 2018/11/17 23:20
 **/
public interface SrvcGuideService extends BaseService<SrvcGuide>{

    /**
     * 根据装修指南类型查询所有信息
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SrvcGuide> selectGuideList(Integer type, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询装修指南详情
     * @param id
     * @return
     */
    List<SrvcGuide> selectGuideListById(Integer id);
}
