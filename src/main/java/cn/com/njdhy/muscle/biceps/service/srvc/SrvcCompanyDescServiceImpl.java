package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcCompanyDescDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 三大模块业务层实现类
 * @author rain
 * @date 2018/11/17 23:27
 **/
@Service
public class SrvcCompanyDescServiceImpl extends BaseServiceImpl<SrvcCompanyDescDao,SrvcCompanyDesc> implements SrvcCompanyDescService{

    @Autowired
    private SrvcCompanyDescDao srvcCompanyDescDao;

    @Override
    public List<SrvcCompanyDesc> queryByType(Integer type) {
        return srvcCompanyDescDao.queryByType(type);
    }
}
