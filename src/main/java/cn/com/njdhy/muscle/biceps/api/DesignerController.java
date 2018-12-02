package cn.com.njdhy.muscle.biceps.api;

import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.srvc.DesignerErrorCode;
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
@Api(tags = "设计师模块接口")
public class DesignerController {

    @Autowired
    private SrvcDesignerService srvcDesignerService;

    /**
     * 查询设计师信息列表
     * @return
     */
    @RequestMapping(value = "/designers",method = RequestMethod.GET)
    @ApiOperation("查询所有设计师列表")
    public Result designerQuery() {
        List<SrvcDesigner> list=null;
        try {
            list = srvcDesignerService.selectDesignerList();

        }catch (Exception e){
           e.printStackTrace();
            return Result.error(DesignerErrorCode.SRVC_DESIGNER_SELECT_ERROR_CODE, DesignerErrorCode.SRVC_DESIGNER_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

    /**
     * 根据id查询设计师及其案例作品信息详情
     * @return
     */
    @RequestMapping(value = "/designers/{id}",method = RequestMethod.GET)
    @ApiOperation("根据id查询设计师及其案例作品信息详情")
    public Result designerInfoQuery(@PathVariable Integer id) {
        List<SrvcDesigner> list=null;
        try {
            list = srvcDesignerService.selectDesignerById(id);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(DesignerErrorCode.SRVC_DESIGNER_SELECT_ERROR_CODE, DesignerErrorCode.SRVC_DESIGNER_SELECT_ERROR_MESSAGE);
        }

        return Result.success(list);
    }

}
