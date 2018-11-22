package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBanner;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * banner图管理业务处理接口
 * @author rain
 * @date 2018/11/16 10:14
 **/
public interface SrvcBannerService extends BaseService<SrvcBanner>{

    /**
     * 查询banner图列表
     * @return
     */
    List<SrvcBanner> selectBannerList();
}
