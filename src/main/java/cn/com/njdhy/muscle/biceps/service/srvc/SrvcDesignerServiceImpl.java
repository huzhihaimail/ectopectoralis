package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcDesignerDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    /**
     * 根据id查询设计师及其案例作品详情
     * @param id
     * @return
     */
    @Override
    public List<SrvcDesigner> selectDesignerById(Integer id) {
        return srvcDesignerDao.selectDesignerById(id);
    }

    /**
     * 根据条件查询所有设计师 用于楼盘模块调用
     * @param map
     * @return
     */
    @Override
    public List<SrvcDesigner> queryDesigners(Map<String, Object> map) {
        return srvcDesignerDao.queryDesigners(map);
    }
}
