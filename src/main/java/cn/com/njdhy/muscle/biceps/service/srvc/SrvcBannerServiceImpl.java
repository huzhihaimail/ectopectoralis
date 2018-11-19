package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcBannerDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBanner;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * banner图管理业务层实现类
 * @author rain
 * @date 2018/11/16 10:21
 **/
@Service
public class SrvcBannerServiceImpl extends BaseServiceImpl<SrvcBannerDao,SrvcBanner> implements SrvcBannerService{

//    /**
//     * 查询banner列表
//     * @param map
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @Override
//    public PageInfo<SrvcBanner> queryBannerList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
//        return null;
//    }
}
