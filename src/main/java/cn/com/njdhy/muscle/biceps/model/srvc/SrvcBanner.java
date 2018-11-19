package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;

/**
 * @author rain
 * @date 2018/11/15 14:01
 **/
@Data
public class SrvcBanner extends BaseModel {

    /**
     * banner标题
     */
    private String title;
    /**
     * banner展示的图片地址
     */
    private String imgUrl;
    /**
     * banner图跳转链接
     */
    private String linkUrl;

}
