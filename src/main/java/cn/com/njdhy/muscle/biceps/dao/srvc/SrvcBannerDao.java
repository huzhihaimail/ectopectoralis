package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBanner;

import java.util.List;

/**
 * banner图管理数据访问层接口
 * @author rain
 * @date 2018/11/15 16:35
 **/
public interface SrvcBannerDao extends BaseDao<SrvcBanner> {

    /**
     * 查询所有的banner图列表
     * @return
     */
    List<SrvcBanner> selectBannerList();
}
