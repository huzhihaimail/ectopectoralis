package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 在施工地进度图片实体类
 * @author rain
 * @date 2018/11/17 20:31
 **/
@Setter
@Getter
public class SrvcPlaceImg extends BaseModel {

    /**
     * 在施工地id
     */
    private Integer placeId;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 图片说明
     */
    private String imageExplain;
}
