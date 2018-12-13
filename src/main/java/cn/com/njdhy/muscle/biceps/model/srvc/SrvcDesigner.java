package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 设计师实体类
 * @author rain
 * @date 2018/11/17 17:54
 **/
@Getter
@Setter
public class SrvcDesigner extends BaseModel{


    /**
     * 设计师头像
     */
    private String headUrl;
    /**
     * 设计师名字
     */
    private String name;
    /**
     * 职位
     */
    private String position;
    /**
     * 个人简介
     */
    private String introduce;

    /**
     * 从业经验
     */
    private Integer workingExperience;
    /**
     * 设计风格
     */
    private String style;


    //以下是关联表的字段
    /**
     * 楼盘名称
     */
    private Integer housesId;
    /**
     * 楼盘名称
     */
    private String houseName;
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
    private String houseStyle;
    /**
     * 楼盘所在区域
     */
    private String area;
    /**
     *
     */
    private String imageUrl;
}
