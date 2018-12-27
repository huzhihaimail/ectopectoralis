package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 在施工地进度实体类
 * @author rain
 * @date 2018/11/17 20:18
 **/
@Getter
@Setter
public class SrvcBuildingPlace extends BaseModel{


    /**
     * 房屋id
     */
    private Integer housesId;
    /**
     * 施工进度： 1:开工仪式 2:水电施工 3:木工施工等
     */
    private String progress;

    /**
     * 楼盘名称
     */
    private String name;
    /**
     * 户型
     */
    private String housesType;
    /**
     * 房屋面积
     */
    private Double floorSpace;
    /**
     * 房屋风格
     */
    private String style;
    /**
     * 楼盘所在区域
     */
    private String area;
    /**
     * 房屋展示图
     */
    private String homePageImg;
    /**
     * 图片地址 关联srvc_place_img表
     */
    private String imageUrl;
    /**
     * id 关联srvc_place_img表
     */
    private Integer imgId;
    /**
     * 图片说明 关联srvc_place_img表
     */
    private String imageExplain;


}
