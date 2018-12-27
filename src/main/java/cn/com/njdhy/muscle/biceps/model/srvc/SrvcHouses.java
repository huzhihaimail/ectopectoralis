package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 装修案例实体类
 * @author rain
 * @date 2018/11/17 20:18
 **/
@Getter
@Setter
public class SrvcHouses extends BaseModel{

    /**
     * 设计师id 关联srvc_designer表
     */
    private Integer designerId;
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
     * 设计理念
     */
    private String concept;
    /**
     * 首页显示图片
     */
    private String homePageImg;
    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 关联srvc_designer 设计师名字
     */
    private String designerName;

}
