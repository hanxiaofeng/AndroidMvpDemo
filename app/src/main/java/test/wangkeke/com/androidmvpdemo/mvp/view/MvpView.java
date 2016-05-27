package test.wangkeke.com.androidmvpdemo.mvp.view;

import java.util.List;

/**
 * Created by jay on 2016/5/27.
 */
public interface MvpView extends BaseView
{
    //listView的初始化
    void setListItem(List<String> data);
    //Toast消息
    void showMessage(String msg);
}
