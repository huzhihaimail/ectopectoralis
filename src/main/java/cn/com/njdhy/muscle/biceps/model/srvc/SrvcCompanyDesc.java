package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;

/**
 * 三大模块公司介绍
 * @author rain
 * @date 2018/11/17 19:58
 **/
@Data
public class SrvcCompanyDesc extends BaseModel{

    /**
     * 模块标题
     */
    private String name;

    // 以下关联srvc_companydesc_sub表
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 作者
     */
    private String author;
}
