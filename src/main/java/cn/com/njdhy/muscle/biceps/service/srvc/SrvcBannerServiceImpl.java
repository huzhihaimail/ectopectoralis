package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcBannerDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBanner;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * banner图管理业务层实现类
 * @author rain
 * @date 2018/11/16 10:21
 **/
@Service
public class SrvcBannerServiceImpl extends BaseServiceImpl<SrvcBannerDao,SrvcBanner> implements SrvcBannerService{

    @Autowired
    private SrvcBannerDao srvcBannerDao;

    @Override
    public List<SrvcBanner> selectBannerList() {
        return srvcBannerDao.selectBannerList();
    }
}
