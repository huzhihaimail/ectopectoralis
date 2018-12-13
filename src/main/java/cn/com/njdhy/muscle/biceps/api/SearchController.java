package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.DesignerErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcDecorateCaseService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcDesignerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Api(tags = "首页搜索接口")
public class SearchController {

    @Autowired
    private SrvcDecorateCaseService srvcDecorateCaseService;
    @Autowired
    private SrvcDesignerService srvcDesignerService;

    @RequestMapping(value = "/search")
    public Result homePageSearch(@RequestBody Map<String,Object> map) {
        Integer param = (Integer)map.get("param");
        try {
            if(param ==1){
                List<SrvcDecorateCase> srvcDecorateCases = srvcDecorateCaseService.selectDecorateCaseParams(map);
                return Result.success(srvcDecorateCases);
            }else if(param == 2){
                List<SrvcDesigner> srvcDesigners = srvcDesignerService.queryDesigners(map);
                return Result.success(srvcDesigners);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Result();
    }
}
