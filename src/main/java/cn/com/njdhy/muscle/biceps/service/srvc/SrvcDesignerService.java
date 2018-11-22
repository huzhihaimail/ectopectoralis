package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * 设计师业务层接口
 * @author rain
 * @date 2018/11/17 23:12
 **/
public interface SrvcDesignerService extends BaseService<SrvcDesigner> {

    /**
     * 查询所有的设计师信息
     * @return
     */
    List<SrvcDesigner> selectDesignerList();
}
