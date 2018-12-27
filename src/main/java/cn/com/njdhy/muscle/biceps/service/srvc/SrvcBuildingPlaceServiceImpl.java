package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcBuildingPlaceDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBuildingPlace;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description：
 * <功能简介>--施工进度模块业务层实现类
 *
 * @author rain
 * @date 2018/11/30 12:52
 **/
@Service
public class SrvcBuildingPlaceServiceImpl extends BaseServiceImpl<SrvcBuildingPlaceDao,SrvcBuildingPlace> implements SrvcBuildingPlaceService{

    @Autowired
    private SrvcBuildingPlaceDao srvcBuildingPlaceDao;

    /**
     * 查询施工进度详情列表
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SrvcBuildingPlace> selectBuildingPlaceList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<SrvcBuildingPlace>(srvcBuildingPlaceDao.selectBuildingPlaceList(map));
    }

    @Override
    public List<SrvcBuildingPlace> selectBuildingPlaceParams(Map<String, Object> map) {
        return srvcBuildingPlaceDao.selectBuildingPlaceParams(map);
    }

    @Override
    public List<SrvcBuildingPlace> selectBuildingPlaceById(Integer id) {
        return srvcBuildingPlaceDao.selectBuildingPlaceById(id);
    }

    @Override
    public int selectBuildingCountById(Integer id) {
        return srvcBuildingPlaceDao.selectBuildingCountById(id);
    }

    @Override
    public List<SrvcBuildingPlace> selectPageBuildingImg() {
        return srvcBuildingPlaceDao.selectPageBuildingImg();
    }
}
