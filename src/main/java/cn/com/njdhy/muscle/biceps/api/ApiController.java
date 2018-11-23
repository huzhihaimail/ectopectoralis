package cn.com.njdhy.muscle.biceps.api;

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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "各模块相关接口")
public class ApiController {


    @Autowired
    private SrvcCustomerService srvcCustomerService;
    @Autowired
    private SrvcBannerService srvcBannerService;
    @Autowired
    private SrvcVideoService srvcVideoService;
    @Autowired
    private SrvcDesignerService srvcDesignerService;
    @Autowired
    private SrvcDecorateGuideService srvcDecorateGuideService;
    @Autowired
    private SrvcModuleService srvcModuleService;
    @Autowired
    private SrvcCompanyDescService srvcCompanyDescService;
    @Autowired
    private SrvcHousesService srvcHousesService;


    /**
     * 保存顾客的信息
     * @param srvcCustomer 请求数据对象
     * @return 结果对象
     */
    @ApiOperation("保存顾客的信息")
    @RequestMapping("/customer/insert")
    public Result insert(@RequestBody SrvcCustomer srvcCustomer) {

        try {
            //参数校验
            String mobile = srvcCustomer.getMobile();
            if(mobile == null || mobile.length()<=0){
                return Result.error(CustomerErrorCode.SRVC_CUSTOMER_PARAMS_ERROR_CODE,CustomerErrorCode.SRVC_CUSTOMER_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            srvcCustomerService.insert(srvcCustomer);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_CODE, CustomerErrorCode.SRVC_CUSTOMER_SAVE_ERROR_MESSAGE);
        }

        return Result.success("SUCCESS");
    }

    /**
     * 查询banner图列表
     * @return
     */
    @RequestMapping("/banner/query")
    @ApiOperation("查询banner图列表")
    public List<SrvcBanner> bannerQuery() {

        List<SrvcBanner> list = srvcBannerService.selectBannerList();

        return list;
    }

    /**
     * 查询video视频列表
     * @return
     */
    @RequestMapping("/video/query")
    @ApiOperation("查询video视频列表")
    public List<SrvcVideo> videoQuery() {

        List<SrvcVideo> list = srvcVideoService.selectVideoList();

        return list;
    }

    /**
     * 查询设计师信息列表
     * @return
     */
    @RequestMapping("/designer/query")
    @ApiOperation("查询设计师信息列表")
    public List<SrvcDesigner> designerQuery() {

        List<SrvcDesigner> list = srvcDesignerService.selectDesignerList();

        return list;
    }

    /**
     * 查询装修指南列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 装修指南列表
     */
    @RequestMapping("/decorate/guide/list")
    @ApiOperation("查询装修指南列表")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        Query queryParam = new Query(params);
        PageInfo<SrvcDecorateGuide> result = srvcDecorateGuideService.queryList(queryParam, pageNumber, pageSize);

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 查询十大模块信息列表
     * @return
     */
    @RequestMapping("/module/list")
    @ApiOperation("查询十大模块信息列表")
    public Result moduleQuery(@RequestParam String moduleName) {
        List<SrvcModule> list =null;
        try {
            if(moduleName == null || moduleName.length()<=0){
                return Result.error(ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_CODE,ModuleErrorCode.SRVC_MODULE_PARAMS_ERROR_MESSAGE);
            }
            list = srvcModuleService.selectModuleInfo(moduleName);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success(list);
    }

    /**
     * 查询三大模块信息列表
     * @return
     */
//    @RequestMapping("/company/desc/list")
//    @ApiOperation("查询banner图列表")
//    public Result companyDescQuery(@RequestParam Map<String,Object> map,Integer pageNumber,Integer pageSize) {
//        List<SrvcCompanyDesc> list =null;
//        try {
//            if(name == null || name.length()<=0){
//                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
//            }
//            list = srvcCompanyDescService.queryList(map,pageNumber,pageSize);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return Result.success(list);
//    }

    /**
     * 查询楼盘情况及图片信息列表
     * @return
     */
    @RequestMapping("/houses/list")
    @ApiOperation("查询楼盘情况及图片信息列表")
    public Result housesQuery(@RequestParam Integer progressTitle) {
        List<SrvcHouses> list =null;
        try {
            if(progressTitle == null ){
                return Result.error(CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_CODE,CompanyDescErrorCode.SRVC_COMPANYDESC_PARAMS_ERROR_MESSAGE);
            }
            list = srvcHousesService.selectHousesInfo(progressTitle);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success(list);
    }

}
