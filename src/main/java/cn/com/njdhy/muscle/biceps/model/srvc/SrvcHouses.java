package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 楼盘情况实体类
 * @author rain
 * @date 2018/11/17 20:18
 **/
@Getter
@Setter
public class SrvcHouses extends BaseModel{

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
     * 案例类型：1装修案例 2施工案例
     */
    private Integer progressTitle;

    //以下关联srvc_houses_sub表
    /**
     * 图片地址
     */
    private String imageUrl;
}
