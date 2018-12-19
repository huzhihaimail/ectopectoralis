package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.CaseErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCaseImg;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDecorateCase;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcHouses;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcCaseImgService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcDecorateCaseService;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcHousesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 装修案例房屋位置及图片控制器
 *
 * @author rain
 * @date 2018/11/17 22:11
 **/
@RestController
@RequestMapping("/srvc/case")
public class DecorateCaseCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;

    @Autowired
    private SrvcDecorateCaseService srvcDecorateCaseService;

    @Autowired
    private SrvcCaseImgService srvcCaseImgService;
    @Autowired
    private SrvcHousesService srvcHousesService;


    /**
     * 查询banner图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SrvcDecorateCase> result=null;
        try {
            Query queryParam = new Query(params);
            result = srvcDecorateCaseService.selectDecorateCaseList(queryParam, pageNumber, pageSize);
            List<SrvcDecorateCase> list = result.getList();
            for (SrvcDecorateCase srvcDecorateCase : list) {
                String s = appCommonProperties.getImagesPrefix() + srvcDecorateCase.getImageUrl();
                srvcDecorateCase.setImageUrl(s);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_SELECT_ERROR_CODE,CaseErrorCode.SRVC_CASE_SELECT_ERROR_MESSAGE);
        }

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        SrvcDecorateCase model=null;
        try {
            if (null == id) {
                return Result.error(CaseErrorCode.SRVC_CASE_SELECT_ERROR_CODE,CaseErrorCode.SRVC_CASE_SELECT_ERROR_MESSAGE);
            }
            model = srvcDecorateCaseService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcDecorateCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_PARAMS_ERROR_CODE, CaseErrorCode.SRVC_CASE_PARAMS_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcDecorateCase 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public Result insert(@RequestBody SrvcDecorateCase srvcDecorateCase) {

        try {
            String imageUrl = srvcDecorateCase.getImageUrl();
            if (imageUrl==null ) {
                return Result.error(CaseErrorCode.SRVC_CASE_PARAMS_ERROR_CODE, CaseErrorCode.SRVC_CASE_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            srvcDecorateCaseService.insert(srvcDecorateCase);
            SrvcCaseImg srvcCaseImg = new SrvcCaseImg();
            srvcCaseImg.setCaseId(srvcDecorateCase.getId());
            srvcCaseImg.setImageUrl(imageUrl);
            srvcCaseImgService.insert(srvcCaseImg);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_UPDATE_APP_ERROR_CODE, CaseErrorCode.SRVC_CASE_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_UPDATE_ERROR_CODE, CaseErrorCode.SRVC_CASE_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcDecorateCase 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcDecorateCase srvcDecorateCase) {

        try {
            Integer id = srvcDecorateCase.getImgId();
            String imageUrl = srvcDecorateCase.getImageUrl();
            if (id == null || imageUrl==null ) {
                return Result.error(CaseErrorCode.SRVC_CASE_PARAMS_ERROR_CODE, CaseErrorCode.SRVC_CASE_PARAMS_ERROR_MESSAGE);
            }
            srvcDecorateCaseService.update(srvcDecorateCase);
            SrvcCaseImg srvcCaseImg = new SrvcCaseImg();
            srvcCaseImg.setId(id);
            srvcCaseImg.setImageUrl(imageUrl);
            srvcCaseImgService.update(srvcCaseImg);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_UPDATE_APP_ERROR_CODE, CaseErrorCode.SRVC_CASE_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CaseErrorCode.SRVC_CASE_UPDATE_ERROR_CODE, CaseErrorCode.SRVC_CASE_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(CaseErrorCode.SRVC_CASE_PARAMS_ERROR_CODE, CaseErrorCode.SRVC_CASE_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcDecorateCaseService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }

    /**
     * 查询所有楼盘名
     * @param map
     * @return
     */
    @RequestMapping("/houses")
    public Result queryHouses(@RequestParam Map<String,Object> map) {

        List<SrvcHouses> houses =null;
        try {

            houses = srvcHousesService.queryHouses(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success().put("houses", houses);
    }
}
