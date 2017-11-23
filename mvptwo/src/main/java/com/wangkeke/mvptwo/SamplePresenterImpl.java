package com.wangkeke.mvptwo;

/**
 * Created by wangkeke on 2017/11/23.
 */

public class SamplePresenterImpl implements SampleContract.Presenter,SampleInteractor.SampleResult {

    private SampleContract.View mViews;

    SampleInteractorImpl sampleInteractor;

    public SamplePresenterImpl(SampleContract.View mViews){

        this.mViews = mViews;
        sampleInteractor = new SampleInteractorImpl();
    }

    @Override
    public void login(String userName, String pwd) {
        mViews.showLoading();
        sampleInteractor.login(userName,pwd,this);
    }

    @Override
    public void onDestory() {
        //撤销请求
        mViews = null;
        sampleInteractor = null;
    }

    @Override
    public void onLoginSuccess(String data) {
        mViews.dismissLoading();
        mViews.onLoginSuccessView(data);
    }

    @Override
    public void onLoginError(String data) {
        mViews.dismissLoading();
        mViews.onLoginFailView(data);
    }
}
