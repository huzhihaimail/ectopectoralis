package cn.com.njdhy.muscle.biceps.controller;

import cn.com.njdhy.muscle.biceps.model.WangEditor;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/10 19:15
 **/
@RestController
public class WangEditorController {


    @Autowired
    private AppCommonProperties appCommonProperties;
    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/wangEditor/upload",method= RequestMethod.POST)
    @ResponseBody
    public WangEditor uploadFile(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request) {

        String tag = "/images";
        tag = replace(tag);
        String filename = uploadFile(file, tag);
        filename = filename.replace("\\", "/");
        filename = appCommonProperties.getImagesPrefix()+filename;
        String [] str = {filename};
        WangEditor we = new WangEditor(str);
        return we;

    }

    private String replace(String type) {
        if (type == null || "".equals(type)) {
            return "";
        }
        return type.replace("/", File.separator) + File.separator;
    }

    private String uploadFile(MultipartFile file, String tag) {
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String randomFileName = UUID.randomUUID().toString().replace("-", "");
            saveFile(tag, randomFileName + suffix, file);
            return tag + randomFileName + suffix;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private void saveFile(String type, String fileName, MultipartFile file) {
        String filePath = appCommonProperties.getFileUrl() + File.separator + type + fileName;
        String tempDirPath = appCommonProperties.getFileUrl() + File.separator + type;
        final File targetFile = new File(filePath);
        final File tempDir = new File(tempDirPath);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
