package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcModuleDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcModule;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 十大模块业务层实现类
 * @author rain
 * @date 2018/11/17 23:24
 **/
@Service
public class SrvcModuleServiceImpl extends BaseServiceImpl<SrvcModuleDao,SrvcModule> implements SrvcModuleService{

    @Autowired
    private SrvcModuleDao srvcModuleDao;

    /**
     * backend 十大模块查询
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SrvcModule> selectModuleList(Map<String, Object> map, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<SrvcModule>(srvcModuleDao.selectModuleList(map));
    }

    /**
     * api 十大模块查询
     * @param moduleName
     * @return
     */
    @Override
    public List<SrvcModule> selectModuleInfo(String moduleName,Integer imageType) {
        return srvcModuleDao.selectModuleInfo(moduleName,imageType);
    }
}
