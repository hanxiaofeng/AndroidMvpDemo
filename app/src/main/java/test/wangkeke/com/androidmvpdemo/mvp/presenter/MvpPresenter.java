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
public class MvpPresenter extends BasePresenter<MvpView>
{
    RequestBiz requestBiz;
    private Handler mHandler;

    public MvpPresenter()
    {
        requestBiz = new RequestBizIml();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void onResume()
    {
        mView.showLoading();
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
                        mView.hideLoading();
                        mView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed()
            {
                mView.hideLoading();
                mView.showMessage("请求失败");
            }
        });
    }


    public void onItemClick(int position)
    {
        mView.showMessage("position = "+position);
    }

}
