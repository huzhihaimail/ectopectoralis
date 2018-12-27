package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcDecorateCaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/11/30 11:26
 **/
@Service
public class SrvcDecorateCaseServiceImpl extends BaseServiceImpl<SrvcDecorateCaseDao,SrvcDecorateCase> implements SrvcDecorateCaseService{

    @Autowired
    private SrvcDecorateCaseDao srvcDecorateCaseDao;

    @Override
    public PageInfo<SrvcDecorateCase> selectDecorateCaseList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<SrvcDecorateCase>(srvcDecorateCaseDao.selectDecorateCaseList(map));
    }

    @Override
    public List<SrvcDecorateCase> selectDecorateCaseByParams(Map<String, Object> map) {
        return srvcDecorateCaseDao.selectDecorateCaseByParams(map);
    }

    @Override
    public List<SrvcDecorateCase> selectDecorateCaseParams(Map<String, Object> map) {
        return srvcDecorateCaseDao.selectDecorateCaseParams(map);
    }

    @Override
    public List<SrvcDecorateCase> selectDecorateCaseById(Integer id) {
        return srvcDecorateCaseDao.selectDecorateCaseById(id);
    }

    @Override
    public List<SrvcDecorateCase> selectPageCase() {
        return srvcDecorateCaseDao.selectPageCase();
    }
}
