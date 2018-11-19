package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;

/**
 * 三大模块子模块实体类
 * @author rain
 * @date 2018/11/17 20:11
 **/
@Data
public class SrvcCompanyDescSub extends BaseModel {

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
    /**
     * 关联srvc_companydesc
     */
    private Integer companyDescId;

}
