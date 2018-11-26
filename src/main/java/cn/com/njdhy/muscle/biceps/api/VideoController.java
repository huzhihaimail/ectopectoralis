package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CompanyDescErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.CustomerErrorCode;
import cn.com.njdhy.muscle.biceps.exception.srvc.ModuleErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@RequestMapping("/api")
@Slf4j
@Api(tags = "视频模块接口")
public class VideoController {

    @Autowired
    private SystemConstant systemConstant;
    @Autowired
    private SrvcVideoService srvcVideoService;

    /**
     * 查询video视频列表
     * @return
     */
    @RequestMapping(value = "/videos",method = RequestMethod.POST)
    @ApiOperation("查询video视频列表")
    public Result videoQuery() {
        List<SrvcVideo> list =null;
        try {
            list = srvcVideoService.selectVideoList();
            for (SrvcVideo srvcVideo : list) {
                String video = systemConstant.getDomain()+srvcVideo.getVideoUrl();
                srvcVideo.setVideoUrl(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.success(list);
    }


}
