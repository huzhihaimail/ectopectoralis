package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcVideo;

import java.util.List;

/**
 * 视频管理数据访问层接口
 * @author rain
 * @date 2018/11/17 22:49
 **/
public interface SrvcVideoDao extends BaseDao<SrvcVideo> {

    /**
     * 查询所有的视频
     * @return
     */
    List<SrvcVideo> selectVideoList();
}
