package test.wangkeke.com.androidmvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import test.wangkeke.com.androidmvpdemo.mvp.MvpActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Intent intent = new Intent(MainActivity.this, MvpActivity.class);
        startActivity(intent);

        return super.onTouchEvent(event);
    }
}
