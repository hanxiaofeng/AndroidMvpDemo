package com.wangkeke.mvptwo;

/**
 * Created by wangkeke on 2017/11/23.
 */

public interface SampleContract {

    interface Presenter extends BasePresenter{

        void login(String userName,String pwd);

        void onDestory();

    }

    interface View extends BaseView<Presenter>{

        void showLoading();

        void onLoginSuccessView(String data);

        void onLoginFailView(String data);

        void dismissLoading();
    }
}
