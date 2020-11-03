package com.huont.cloud.admin.common.conf;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口返回参数
 */
public class Result {


    private int code;

    /**
     * 结果描述
     */
    private String desc;

    /**
     * 消息体
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    public Result(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Result() {
    }


    public static Result getSuccessInstance(String msg) {
        return new Result(RETURN_CODE.SUCCESS.getVal(), msg);
    }

    public static Result getSuccessInstance() {
        return new Result(RETURN_CODE.SUCCESS.getVal(), RETURN_CODE.SUCCESS.getMsg());
    }

    public static Result getFailedInstance(String msg) {
        return new Result(RETURN_CODE.FAILED.getVal(), msg);
    }

    public static Result getFailedInstance() {
        return new Result(RETURN_CODE.FAILED.getVal(), RETURN_CODE.FAILED.getMsg());
    }

    public Result put(String key, Object obj) {
        data.put(key, obj);
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Result setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Object setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    enum RETURN_CODE {
        SUCCESS(200, "成功"), FAILED(-999, "失败");

        private int val;

        private String msg;

        RETURN_CODE(int val, String msg) {
            this.val = val;
            this.msg = msg;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
