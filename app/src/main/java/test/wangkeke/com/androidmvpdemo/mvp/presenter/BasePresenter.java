package test.wangkeke.com.androidmvpdemo.mvp.presenter;

/**
 * Created by jay on 2016/5/27.
 */
public class BasePresenter<T>
{
    public T mView;

    /**绑定activity*/
    public void attach(T mView)
    {
        this.mView = mView;
    }

    public void dettach()
    {
        mView = null;
    }
}
