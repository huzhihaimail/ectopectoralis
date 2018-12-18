package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.BannerErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcBanner;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcBannerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * banner图管理控制器
 *
 * @author rain
 * @date 2018/11/16 10:46
 **/
@RestController
@RequestMapping("/srvc/banner")
public class BannerCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;
    @Autowired
    private SrvcBannerService srvcBannerService;

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
        PageInfo<SrvcBanner> result=null;
        try {
            Query queryParam = new Query(params);
            result = srvcBannerService.queryList(queryParam, pageNumber, pageSize);
            List<SrvcBanner> list = result.getList();
            for (SrvcBanner srvcBanner : list) {
                String imagePath = appCommonProperties.getImagesPrefix()+ srvcBanner.getImgUrl();
                srvcBanner.setImgUrl(imagePath);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_SELECT_ERROR_CODE,BannerErrorCode.SRVC_BANNER_SELECT_ERROR_MESSAGE);
        }

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        SrvcBanner model=null;
        try {
            //  参数校验
            if (id == null || id.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            model = srvcBannerService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SrvcBanner();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_SELECT_ERROR_CODE,BannerErrorCode.SRVC_BANNER_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcBanner 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcBanner srvcBanner) {

        try {
            // 校验参数
            String title = srvcBanner.getTitle();
            String imgUrl = srvcBanner.getImgUrl();
            String linkUrl = srvcBanner.getLinkUrl();
            if (title == null || title.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            if (imgUrl == null || imgUrl.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            if (linkUrl == null || linkUrl.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            srvcBannerService.insert(srvcBanner);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_SAVE_APP_ERROR_CODE, BannerErrorCode.SRVC_BANNER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_SAVE_ERROR_CODE, BannerErrorCode.SRVC_BANNER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcBanner 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcBanner srvcBanner) {

        try {
            // 校验参数
            String title = srvcBanner.getTitle();
            String imgUrl = srvcBanner.getImgUrl();
            String linkUrl = srvcBanner.getLinkUrl();
            if (title == null || title.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            if (imgUrl == null || imgUrl.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            if (linkUrl == null || linkUrl.length() <= 0) {
                return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
            }
            // 执行修改
            srvcBannerService.update(srvcBanner);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_UPDATE_APP_ERROR_CODE, BannerErrorCode.SRVC_BANNER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(BannerErrorCode.SRVC_BANNER_UPDATE_ERROR_CODE, BannerErrorCode.SRVC_BANNER_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            // 校验参数
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_CODE, BannerErrorCode.SRVC_BANNER_PARAMS_ERROR_MESSAGE);
                }
            }
            srvcBannerService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
