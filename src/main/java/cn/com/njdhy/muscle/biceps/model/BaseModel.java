
package cn.com.njdhy.muscle.biceps.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <类功能简述> 通用数据表字段
 *
 * @author 胡志海
 */
@Getter
@Setter
public class BaseModel implements Serializable {

    /**
     * 数据行ID
     */
    private Integer id;

    /**
     * 逻辑删除标志
     */
    private String deleteFlag;

    /**
     * 创建日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;

    /**
     * 修改日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;

}
