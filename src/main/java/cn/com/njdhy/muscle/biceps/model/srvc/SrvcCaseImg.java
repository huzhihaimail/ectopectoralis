package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 装修案例房屋位置图片实体类
 * @author rain
 * @date 2018/11/17 20:31
 **/
@Setter
@Getter
public class SrvcCaseImg extends BaseModel {

    /**
     * 装修案例id
     */
    private Integer caseId;
    /**
     * 图片地址
     */
    private String imageUrl;
}
