package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcDesignerDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设计师业务层实现类
 * @author rain
 * @date 2018/11/17 23:14
 **/
@Service
public class SrvcDesignerServiceImpl extends BaseServiceImpl<SrvcDesignerDao,SrvcDesigner> implements SrvcDesignerService {

    @Autowired
    private SrvcDesignerDao srvcDesignerDao;

    /**
     * 查询所有的设计师信息
     * @return
     */
    @Override
    public List<SrvcDesigner> selectDesignerList() {
        return srvcDesignerDao.selectDesignerList();
    }
}
