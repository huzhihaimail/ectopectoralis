package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.GuideErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import com.github.pagehelper.PageInfo;
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
@Api(tags = "装修指南模块接口")
public class GuideController {

    @Autowired
    private SrvcGuideService srvcGuideService;

    /**
     * 查询装修指南列表
     *
     * @param type     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 装修指南列表
     */
    @RequestMapping(value = "/guides",method = RequestMethod.POST)
    @ApiOperation("查询装修指南列表")
    public Result guide(@RequestParam Integer type, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcGuide> result = srvcGuideService.selectGuideList(type, pageNumber, pageSize);

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询设计师及其案例作品信息详情
     * @return
     */
    @RequestMapping(value = "/guides/{id}",method = RequestMethod.GET)
    @ApiOperation("根据id查询装修指南信息详情")
    public Result guideQuery(@PathVariable Integer id) {
        List<SrvcGuide> list=null;
        try {
            list = srvcGuideService.selectGuideListById(id);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(GuideErrorCode.SRVC_DECORATEGUIDE_SELECT_ERROR_CODE, GuideErrorCode.SRVC_DECORATEGUIDE_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

}
