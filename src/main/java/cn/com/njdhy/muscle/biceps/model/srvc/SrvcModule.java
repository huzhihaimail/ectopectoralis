package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;

/**
 * 十大模块实体类
 * @author rain
 * @date 2018/11/17 18:44
 **/
@Data
public class SrvcModule extends BaseModel{

    /**
     * 模块名称
     */
    private String moduleName;

    //以下关联srvc_module_sub表
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
}
