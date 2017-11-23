package com.wangkeke.mvptwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SampleContract.View {

    private SampleContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new SamplePresenterImpl(this);
        mPresenter.login("admin","123456");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onLoginSuccessView(String data) {
        Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailView(String data) {
        Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void dismissLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }
}
