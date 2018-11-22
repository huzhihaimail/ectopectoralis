package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcHousesDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 楼盘情况业务层实现类
 * @author rain
 * @date 2018/11/17 23:21
 **/
@Service
public class SrvcHousesServiceImpl extends BaseServiceImpl<SrvcHousesDao,SrvcHouses> implements SrvcHousesService{

    @Autowired
    private SrvcHousesDao srvcHousesDao;

    @Override
    public List<SrvcHouses> selectHousesInfo(Integer progressTitle) {
        return srvcHousesDao.selectHousesInfo(progressTitle);
    }
}
