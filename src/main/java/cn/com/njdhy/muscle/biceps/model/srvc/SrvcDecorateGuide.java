package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 装修指南（多个板块）
 * @author rain
 * @date 2018/11/17 20:44
 **/
@Getter
@Setter
public class SrvcDecorateGuide extends BaseModel {

    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 文章类型 1:企业新闻 2：装修科普
     */
    private String type;
}
