package com.huont.cloud.admin.common.conf;

public class DataProperty {

    public enum Status {
        VALID("1", "有效"), IN_VALID("0", "无效");
        private String val;

        private String msg;

        Status(String val, String msg) {
            this.val = val;
            this.msg = msg;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public enum DelFlag {
        DEL("1","删除"),NO_DEL("0","不删除");

        private String val;

        private String msg;

        DelFlag(String val, String msg) {
            this.val = val;
            this.msg = msg;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
