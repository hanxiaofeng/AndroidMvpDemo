package test.wangkeke.com.androidmvpdemo.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import test.wangkeke.com.androidmvpdemo.mvp.presenter.BasePresenter;

/**
 * Created by jay on 2016/5/27.
 */
public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends AppCompatActivity
{
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.dettach();
    }

    //实例化presenter
    public abstract T initPresenter();
}
