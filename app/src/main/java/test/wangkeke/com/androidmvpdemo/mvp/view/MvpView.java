package test.wangkeke.com.androidmvpdemo.mvp.view;

import java.util.List;

/**
 * Created by jay on 2016/5/27.
 */
public interface MvpView
{
    //显示loading progress
    void showLoading();
    //隐藏loading progress
    void hideLoading();
    //listView的初始化
    void setListItem(List<String> data);
    //Toast消息
    void showMessage(String msg);
}
