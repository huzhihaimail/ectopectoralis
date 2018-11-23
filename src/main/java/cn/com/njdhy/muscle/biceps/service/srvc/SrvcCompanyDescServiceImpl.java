package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcCompanyDescDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCompanyDesc;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModule;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public PageInfo<SrvcCompanyDesc> selectCompanyDescList(Map<String, Object> map, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<SrvcCompanyDesc>(srvcCompanyDescDao.selectCompanyDescList(map));
    }

    @Override
    public List<SrvcCompanyDesc> selectCompanyDescInfo(String name) {
        return srvcCompanyDescDao.selectCompanyDescInfo(name);
    }
}
