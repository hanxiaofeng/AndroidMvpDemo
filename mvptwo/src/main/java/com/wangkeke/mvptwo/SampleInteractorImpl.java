package com.wangkeke.mvptwo;

/**
 * Created by wangkeke on 2017/11/23.
 */

public class SampleInteractorImpl implements SampleInteractor {
    @Override
    public void login(String accout, String pwd, SampleResult loginResult) {

        if(accout.equals("admin") && pwd.equals("123456")){
            loginResult.onLoginSuccess("欢迎你："+accout);
        }else {
            loginResult.onLoginError("获取数据失败");
        }

    }
}
