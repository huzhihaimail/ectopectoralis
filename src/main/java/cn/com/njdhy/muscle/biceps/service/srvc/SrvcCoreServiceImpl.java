package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcCoreDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCore;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/11 15:25
 **/
@Service
public class SrvcCoreServiceImpl extends BaseServiceImpl<SrvcCoreDao,SrvcCore> implements SrvcCoreService{
    @Autowired
    private SrvcCoreDao srvcCoreDao;

    @Override
    public SrvcCore queryByType(Integer type) {
        return srvcCoreDao.queryByType(type);
    }
}
