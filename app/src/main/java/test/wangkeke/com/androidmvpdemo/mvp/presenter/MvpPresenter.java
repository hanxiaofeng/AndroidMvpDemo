package test.wangkeke.com.androidmvpdemo.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import java.util.List;

import test.wangkeke.com.androidmvpdemo.mvp.model.OnRequestListener;
import test.wangkeke.com.androidmvpdemo.mvp.model.RequestBiz;
import test.wangkeke.com.androidmvpdemo.mvp.model.RequestBizIml;
import test.wangkeke.com.androidmvpdemo.mvp.view.MvpView;

/**
 * Created by jay on 2016/5/27.
 */
public class MvpPresenter
{
    private MvpView mvpView;
    RequestBiz requestBiz;
    private Handler mHandler;

    public MvpPresenter(MvpView mvpView)
    {
        requestBiz = new RequestBizIml();
        mHandler = new Handler(Looper.getMainLooper());
        this.mvpView = mvpView;
    }

    public void onResume()
    {
        mvpView.showLoading();
        requestBiz.requestForData(new OnRequestListener()
        {
            @Override
            public void onSuccess(final List<String> data)
            {
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mvpView.hideLoading();
                        mvpView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed()
            {
                mvpView.hideLoading();
                mvpView.showMessage("请求失败");
            }
        });
    }


    public void onItemClick(int position)
    {
        mvpView.showMessage("position = "+position);
    }

}
