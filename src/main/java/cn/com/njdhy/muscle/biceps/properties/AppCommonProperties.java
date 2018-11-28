package cn.com.njdhy.muscle.biceps.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/11/28 12:03
 **/
@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppCommonProperties {

    /**
     * 图片显示前缀域名
     */
    private String imagesPrefix;
    /**
     * 图片写入地址
     */
    private String fileUrl;
}
