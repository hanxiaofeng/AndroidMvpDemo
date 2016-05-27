package test.wangkeke.com.androidmvpdemo.mvp.model;

import java.util.ArrayList;

/**
 * Created by jay on 2016/5/27.
 */
public class RequestBizIml implements RequestBiz
{
    @Override
    public void requestForData(final OnRequestListener listener)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                try
                {
                    Thread.sleep(2000);
                    ArrayList<String> data = new ArrayList<String>();
                    for (int i=1;i<8;i++)
                    {
                        data.add("item"+i);
                    }
                    if(null != listener)
                    {
                        listener.onSuccess(data);
                    }
                    else
                    {
                        listener.onFailed();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
