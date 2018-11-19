package cn.com.njdhy.muscle.biceps.controller.srvc;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.controller.sys.RoleCtl;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.srvc.VideoErrorCode;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcVideo;
import cn.com.njdhy.muscle.biceps.service.srvc.SrvcVideoService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 视频管理控制器
 * @author rain
 * @date 2018/11/17 22:22
 **/
@RestController
@RequestMapping("/srvc/video")
public class VideoCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleCtl.class);

    @Autowired
    private SrvcVideoService srvcVideoService;

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
        Query queryParam = new Query(params);
        PageInfo<SrvcVideo> result = srvcVideoService.queryList(queryParam, pageNumber, pageSize);

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

        // todo 参数校验

        SrvcVideo model = srvcVideoService.queryById(id);

        if (ObjectUtils.isEmpty(model)) {
            model = new SrvcVideo();
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param srvcVideo 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SrvcVideo srvcVideo) {

        try {

            // 执行入库操作
            srvcVideoService.insert(srvcVideo);
        } catch (ApplicationException e) {
            return Result.error(VideoErrorCode.SRVC_VIDEO_SAVE_APP_ERROR_CODE, VideoErrorCode.SRVC_VIDEO_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(VideoErrorCode.SRVC_VIDEO_SAVE_ERROR_CODE, VideoErrorCode.SRVC_VIDEO_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param srvcVideo 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SrvcVideo srvcVideo) {

        try {
            // 校验参数
            // TODO: 2018/3/14

            // 执行修改
            srvcVideoService.update(srvcVideo);
        } catch (RuntimeException e) {
            return Result.error(VideoErrorCode.SRVC_VIDEO_UPDATE_APP_ERROR_CODE, VideoErrorCode.SRVC_VIDEO_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(VideoErrorCode.SRVC_VIDEO_UPDATE_ERROR_CODE, VideoErrorCode.SRVC_VIDEO_UPDATE_ERROR_MESSAGE);
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
            // 校验参数 todo
            srvcVideoService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
