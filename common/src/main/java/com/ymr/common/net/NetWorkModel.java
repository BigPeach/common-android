package com.ymr.common.net;

import com.ymr.common.IModel;
import com.ymr.common.net.params.NetRequestParams;

/**
 * Created by ymr on 15/5/14.
 */
public interface NetWorkModel<T> extends IModel {

    void updateDatas(NetRequestParams params, UpdateListener<T> listener);

    interface UpdateListener<T> {
        void finishUpdate(T result);
        void onError(Error error);
    }

    interface NetworkChangedListener {
        void onNetworkChange();
    }

    class Error {
        private int errorCode = -1;
        private String msg;
        private NetRequestParams netRequestParams;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getNetRequestParams() {
            return netRequestParams;
        }

        public void setNetRequestParams(NetRequestParams netRequestParams) {
            this.netRequestParams = netRequestParams;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "errorCode=" + errorCode +
                    ", msg='" + msg + '\'' +
                    ", netRequestParams=" + netRequestParams +
                    '}';
        }
    }
}
