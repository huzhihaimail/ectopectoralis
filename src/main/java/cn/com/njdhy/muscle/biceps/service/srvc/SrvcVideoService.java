package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcVideo;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * 视频模块业务层接口
 * @author rain
 * @date 2018/11/17 23:18
 **/
public interface SrvcVideoService extends BaseService<SrvcVideo>{

    /**
     * 查询所有的视频
     * @return
     */
    List<SrvcVideo> selectVideoList();
}
