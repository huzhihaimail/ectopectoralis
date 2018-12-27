package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 三大模块公司介绍
 * @author rain
 * @date 2018/11/17 19:58
 **/
@Getter
@Setter
public class SrvcCompanyDesc extends BaseModel{

    /**
     * 模块标题
     */
    private String title;

    /**
     * 模块图片地址
     */
    private String imageUrl;

    /**
     * 内容
     */
    private Integer type;

    /**
     * 图片排序
     */
    private Integer orderNum;
}
