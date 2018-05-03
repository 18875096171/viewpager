package com.ziyuan.vp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager vp;
    private TextView music, video;
    private ArrayList<View> arrayList;
 //vp 具有页面滑动事件的监听
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //加载布局
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.vpone, null);
        View view2 = inflater.inflate(R.layout.vptwo, null);
        //放入容器
        arrayList.add(view1);
        arrayList.add(view2);
        //启动适配器
        vp.setAdapter(new MyPagerAdapter());
        music.setOnClickListener(this);
        video.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.music:vp.setCurrentItem(0); break;
            case R.id.video:vp.setCurrentItem(1);break;
        }
    }

    public class MyPagerAdapter extends PagerAdapter {
        //一定要实现前3个方法
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(arrayList.get(position));
            return arrayList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(arrayList.get(position));
        }
    }

    private void initView() {
        music = (TextView) findViewById(R.id.music);
        video = (TextView) findViewById(R.id.video);
        vp = (ViewPager) findViewById(R.id.vp);
        arrayList = new ArrayList<View>();
    }
}
