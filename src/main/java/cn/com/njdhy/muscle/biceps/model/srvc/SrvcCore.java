package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * Description：
 * <功能简介>--家装服务核心优势模块实体类
 *
 * @author rain
 * @date 2018/12/11 15:14
 **/
@Getter
@Setter
public class SrvcCore extends BaseModel{

    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 模块类型 1六大精英设计风格  2、5h关注工程  3、装修好管家
     */
    private Integer type;
}
