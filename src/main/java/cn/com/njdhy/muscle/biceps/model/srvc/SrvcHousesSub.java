package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;

/**
 * 楼盘施工情况实体类
 * @author rain
 * @date 2018/11/17 20:31
 **/
@Data
public class SrvcHousesSub extends BaseModel {

    /**
     * 关联srvc_houses
     */
    private Integer housesId;

    /**
     * 图片地址
     */
    private String imageUrl;
}
