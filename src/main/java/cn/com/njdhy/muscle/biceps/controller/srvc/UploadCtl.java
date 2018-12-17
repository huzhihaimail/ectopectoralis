package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.AjaxResult;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Description：
 * <功能简介>--
 * 公共控制器，提供上传文件等功能
 *
 * @author rain
 * @date 2018/11/21 11:02
 **/
@Controller
@RequestMapping("/files")
public class UploadCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public AjaxResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult(true);
        String tag = "/images";
        tag = replace(tag);
        String filename = uploadFile(file, tag);
        filename = filename.replace("\\", "/");
        JSONObject data = new JSONObject();
        data.put("path", filename);
        ajaxResult.setData(data);
        return ajaxResult;
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
