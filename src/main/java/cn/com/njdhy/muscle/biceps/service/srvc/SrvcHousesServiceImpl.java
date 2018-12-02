package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcHousesDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 楼盘情况业务层实现类
 * @author rain
 * @date 2018/11/17 23:21
 **/
@Service
public class SrvcHousesServiceImpl extends BaseServiceImpl<SrvcHousesDao,SrvcHouses> implements SrvcHousesService{

    @Autowired
    private SrvcHousesDao srvcHousesDao;

    /**
     * backend 查询所有楼盘情及其设计师列表
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SrvcHouses> selectHousesList(Map<String, Object> map, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        return new PageInfo<SrvcHouses>(srvcHousesDao.selectHousesList(map));
    }

    /**
     * 根据条件查询所有楼盘名，用于装修案例模块和在施工地模块调用
     * @param map
     * @return
     */
    @Override
    public List<SrvcHouses> queryHouses(Map<String, Object> map) {
        return srvcHousesDao.queryHouses(map);
    }

}
