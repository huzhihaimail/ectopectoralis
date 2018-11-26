package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 视频展示实体类
 * @author rain
 * @date 2018/11/17 20:39
 **/
@Getter
@Setter
public class SrvcVideo extends BaseModel{

    /**
     * 视频标题
     */
    private String title;
    /**
     * 视频地址
     */
    private String videoUrl;
    /**
     * 视频跳转链接
     */
    private String videoLinkUrl;
}
