package test.wangkeke.com.androidmvpdemo.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import test.wangkeke.com.androidmvpdemo.R;
import test.wangkeke.com.androidmvpdemo.mvp.presenter.MvpPresenter;
import test.wangkeke.com.androidmvpdemo.mvp.view.MvpView;

public class MvpActivity extends BaseMvpActivity<MvpView,MvpPresenter> implements AdapterView.OnItemClickListener,MvpView
{
    private ListView mvpListView;

    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        mvpListView = (ListView) findViewById(R.id.mvp_listview);
        mvpListView.setOnItemClickListener(this);
        pb = (ProgressBar) findViewById(R.id.mvp_progress);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        presenter.onItemClick(position);
    }

    @Override
    public void showLoading()
    {
        pb.setVisibility(View.VISIBLE);
        mvpListView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading()
    {
        pb.setVisibility(View.GONE);
        mvpListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListItem(List<String> data)
    {
        ArrayAdapter adapter = new ArrayAdapter(MvpActivity.this,android.R.layout.simple_list_item_1,data);
        mvpListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String msg)
    {
        Toast.makeText(MvpActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public MvpPresenter initPresenter()
    {
        return new MvpPresenter();
    }
}
