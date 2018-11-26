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
     * 楼盘id关联srvc_houses表
     */
    private Integer housesId;
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
     * 个性签名
     */
    private String motto;
    /**
     * 从业经验
     */
    private Integer workingExperience;
}
