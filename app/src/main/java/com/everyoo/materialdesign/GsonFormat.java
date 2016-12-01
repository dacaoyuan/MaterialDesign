package com.everyoo.materialdesign;

/**
 * Created by abc on 2016/12/1.
 */

public class GsonFormat {


    /**
     * gatewayid : 49161600002
     * msg : {"file_name":"2016-11-29"}
     * type : 18
     * userid : 0821674F-7001-CD6D-1FCD-5E0E8233E346
     */

    private String gatewayid;
    private MsgBean msg;
    private int type;
    private String userid;

    public String getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(String gatewayid) {
        this.gatewayid = gatewayid;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public static class MsgBean {
        /**
         * file_name : 2016-11-29
         */

        private String file_name;

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }
    }
}
