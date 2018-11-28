package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.VideoErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台所需接口
 * @author rain
 * @date 2018/11/20 9:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "视频模块接口")
public class VideoController {

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

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(VideoErrorCode.SRVC_VIDEO_SELECT_ERROR_CODE, VideoErrorCode.SRVC_VIDEO_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }


}
