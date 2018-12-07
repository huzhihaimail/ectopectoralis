package cn.com.njdhy.muscle.biceps.controller;

import cn.com.njdhy.muscle.biceps.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/6 9:48
 **/
@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UeditorController  {
     @RequestMapping(value = "/exec")
     @ResponseBody
     public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
               request.setCharacterEncoding("utf-8");
               String rootPath = request.getRealPath("/");
               return new ActionEnter( request, rootPath).exec();
     }
 }
