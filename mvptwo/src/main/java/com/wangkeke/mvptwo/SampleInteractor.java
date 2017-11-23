package com.wangkeke.mvptwo;

/**
 * Created by huanghao on 2016/8/2
 * Email:huanghao@xinshiyun.com
 */
public interface SampleInteractor {

    void login(String accout, String pwd, SampleResult loginResult);

    public interface  SampleResult{
        void onLoginSuccess(String data);
        void onLoginError(String data);
    }
}
