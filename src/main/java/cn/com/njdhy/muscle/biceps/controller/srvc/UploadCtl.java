package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.AjaxResult;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadCtl.class);

    /**
     * 文件存储路径
     */
    @Value("app.file.upload.dir")
    private String fileUploadDir;

    /**
     * 服务端ip地址
     */
    @Value("server.address")
    private String host;

    /**
     * 服务端端口号
     */
    @Value("server.port")
    private String port;


    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public AjaxResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult(true);
        String tag = "/images";
        tag = replace(tag);

//        String paths = request.getSession().getServletContext().getRealPath("/");
//
//        LOGGER.debug("param is path =============>{}",paths);
        String filename = uploadFile(file, tag);
        filename = filename.replace("\\", "/");
        JSONObject data = new JSONObject();
        data.put("path", filename);
        ajaxResult.setData(data);
        return ajaxResult;
    }

//
//
//    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public JSONObject uploadImg(@RequestParam("img")MultipartFile file, HttpServletRequest request){
//
//        JSONObject result = new JSONObject();
//
//        String tag = "/product/";
//        try {
//            String filename = uploadFile(file, tag);
//            JSONObject data = new JSONObject();
//            data.put("url", SystemConstant.SYSTEM_CONSTANT +  filename);
//            data.put("path", filename);
//            result.put("data", data);
//            result.put("result",0);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            result.put("message", e.getMessage());
//            result.put("result", -1);
//        }
//
//        return result;
//    }


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
        String filePath = fileUploadDir + File.separator + type + fileName;
        String tempDirPath = fileUploadDir + File.separator + type;
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
