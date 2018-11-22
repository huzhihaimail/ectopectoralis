package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcVideoDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcVideo;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频模块业务层实现类
 * @author rain
 * @date 2018/11/17 23:19
 **/
@Service
public class SrvcVideoServiceImpl extends BaseServiceImpl<SrvcVideoDao,SrvcVideo> implements SrvcVideoService{

    @Autowired
    private SrvcVideoDao srvcVideoDao;

    @Override
    public List<SrvcVideo> selectVideoList() {
        return srvcVideoDao.selectVideoList();
    }
}
