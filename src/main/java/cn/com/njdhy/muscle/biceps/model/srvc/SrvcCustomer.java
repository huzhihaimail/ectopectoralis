package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 顾客实体类
 * @author rain
 * @date 2018/11/17 18:20
 **/
@Getter
@Setter
public class SrvcCustomer extends BaseModel{
    /**
     * 房屋面积
     */
    private Double floorSpace;
    /**
     * 顾客手机号
     */
    private String mobile;
    /**
     * 顾客选择的模块类型（十大模块）
     */
    private String moduleType;
}
