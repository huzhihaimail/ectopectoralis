package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.common.SystemConstant;
import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.model.srvc.*;
import cn.com.njdhy.muscle.biceps.service.srvc.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Api(tags = "装修指南模块接口")
public class GuideController {

    @Autowired
    private SystemConstant systemConstant;
    @Autowired
    private SrvcDecorateGuideService srvcDecorateGuideService;

    /**
     * 查询装修指南列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 装修指南列表
     */
    @RequestMapping(value = "/guides",method = RequestMethod.POST)
    @ApiOperation("查询装修指南列表")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        Query queryParam = new Query(params);
        PageInfo<SrvcDecorateGuide> result = srvcDecorateGuideService.queryList(queryParam, pageNumber, pageSize);
        List<SrvcDecorateGuide> list = result.getList();
        for (SrvcDecorateGuide srvcDecorateGuide : list) {
            String s = systemConstant.getDomain() + srvcDecorateGuide.getImageUrl();
            srvcDecorateGuide.setImageUrl(s);
        }
        result.setList(list);
        return Result.success(result.getTotal(), result.getList());
    }

}
