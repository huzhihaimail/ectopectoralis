package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 十大模块子模块实体类
 * @author rain
 * @date 2018/11/17 19:45
 **/
@Getter
@Setter
public class SrvcModuleSub extends BaseModel{

    /**
     * 子标题
     */
    private String title;
    /**
     * 跳转地址
     */
    private String imageUrl;
    /**
     * 类型 1主图 2 辅图
     */
    private Integer imageType;
    /**
     * 父级模块id 关联srvc_module
     */
    private Integer moduleId;

}
