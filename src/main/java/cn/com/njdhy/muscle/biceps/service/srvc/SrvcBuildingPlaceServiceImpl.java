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

    public int countBuilding(Integer id) {
        int number = 0;
        List<SrvcBuildingPlace> buildingPlaceList = srvcBuildingPlaceDao.selectBuildingPlaceById(id);
        if(buildingPlaceList == null){
            return number;
        }
        for (SrvcBuildingPlace srvcBuildingPlace : buildingPlaceList) {
            if(srvcBuildingPlace.getProgress().equals("售后服务")){
                number = 10;
            }
            if(srvcBuildingPlace.getProgress().equals("竣工验收")){
                if(number < 9){
                    number = 9;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("安装项目")){
                if(number < 8){
                    number = 8;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("油工施工")){
                if(number < 7){
                    number = 7;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("木工施工")){
                if(number < 6){
                    number = 6;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("瓦工施工")){
                if(number < 5){
                    number = 5;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("水电施工")){
                if(number < 4){
                    number = 4;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("拆改项目")){
                if(number < 3){
                    number = 3;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("开工仪式")){
                if(number < 2){
                    number = 2;
                }
            }
            if(srvcBuildingPlace.getProgress().equals("形象保护")){
                if(number < 1){
                    number = 1;
                }
            }
        }
        return number;
    }
}
