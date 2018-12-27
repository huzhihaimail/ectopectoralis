package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 装修案例房屋位置实体类
 * @author rain
 * @date 2018/11/17 20:18
 **/
@Getter
@Setter
public class SrvcDecorateCase extends BaseModel{

    /**
     * 房屋id
     */
    private Integer housesId;
    /**
     * 房屋方位：（主卧，客厅，卫生间等）
     */
    private String houseLocation;

    /**
     * 房屋名字 关联srvc_houses表
     */
    private String name;
    /**
     * id 关联srvc_case_img表
     */
    private Integer imgId;
    /**
     * 图片地址 关联srvc_case_img表
     */
    private String imageUrl;

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
     * 设计师名字
     */
    private String designerName;
    /**
     * 设计师职位
     */
    private String position;
    /**
     * 设计师头像
     */
    private String headUrl;
    /**
     * 房屋设计理念设计理念
     */
    private String concept;
}
