package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcGuideDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcGuide;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 装修指南业务层实现类
 * @author rain
 * @date 2018/11/17 23:20
 **/
@Service
public class SrvcGuideServiceImpl extends BaseServiceImpl<SrvcGuideDao,SrvcGuide> implements SrvcGuideService {
    @Autowired
    private SrvcGuideDao srvcGuideDao;
    @Override
    public PageInfo<SrvcGuide> selectGuideList(Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(srvcGuideDao.selectGuideList(type));
    }

    @Override
    public List<SrvcGuide> selectGuideListById(Integer id) {
        return srvcGuideDao.selectGuideListById(id);
    }
}
