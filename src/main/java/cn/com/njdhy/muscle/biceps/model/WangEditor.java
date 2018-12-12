package cn.com.njdhy.muscle.biceps.model;


import java.util.Arrays;

/**
 * Description：
 * <功能简介>--
 *
 * @author rain
 * @date 2018/12/10 19:11
 **/

public class WangEditor {

    /**
     * 错误代码，0 表示没有错误。
     */
    private Integer errno;
    /**
     * 已上传的图片路径
     */
    private String[] data;

    public WangEditor() {
        super();
    }
    public WangEditor(String[] data) {
        super();
        this.errno = 0;
        this.data = data;
    }
    public Integer getErrno() {
        return errno;
    }
    public void setErrno(Integer errno) {
        this.errno = errno;
    }
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "WangEditor [errno=" + errno + ", data=" + Arrays.toString(data)
                + "]";
    }

}
