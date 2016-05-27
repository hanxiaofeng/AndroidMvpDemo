package test.wangkeke.com.androidmvpdemo.mvp.model;

import java.util.List;

/**
 * Created by jay on 2016/5/27.
 */
public interface OnRequestListener
{
    void onSuccess(List<String> data);
    void onFailed();
}
