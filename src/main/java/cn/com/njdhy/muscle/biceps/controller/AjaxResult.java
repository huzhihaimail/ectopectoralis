package cn.com.njdhy.muscle.biceps.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Ajax DTO
 * @author
 */
public class AjaxResult {

    /** 返回结果 */
    private boolean success;
    /** 返回信息 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /** 返回数据 */
    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AjaxResult(boolean success) {
        super();
        this.success = success;
    }

    public AjaxResult(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public AjaxResult(boolean success, Object data) {
        super();
        this.success = success;
        this.data = data;
    }

    public AjaxResult(boolean success, String message, Object data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

