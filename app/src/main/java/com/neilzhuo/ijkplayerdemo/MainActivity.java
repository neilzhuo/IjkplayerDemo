package com.neilzhuo.ijkplayerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tv.danmaku.ijk.media.sample.activities.VideoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View source)
    {
        VideoActivity.intentTo(this, "/mnt/sdcard/test.mp4", "test");
    }
}
