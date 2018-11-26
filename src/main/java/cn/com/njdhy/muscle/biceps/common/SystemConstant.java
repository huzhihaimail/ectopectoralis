package cn.com.njdhy.muscle.biceps.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/11/26 9:41
 **/
@Component
@Getter
@Setter
public class SystemConstant {

    @Value("${app.static.images.url.prefix}")
    private String domain;

    @Value("${app.file.upload.dir}")
    private String fileUploadDir;
}
