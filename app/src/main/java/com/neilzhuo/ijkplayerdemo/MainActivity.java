package com.neilzhuo.ijkplayerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tv.danmaku.ijk.media.sample.activities.VideoActivity;
import tv.danmaku.ijk.media.sample.activities.FileExplorerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandlerOfPlayInNativeView(View source)
    {
        VideoActivity.intentTo(this, "/mnt/sdcard/test.mp4", "test");
    }

    public void clickHandlerOfPlayInPrivateView(View source)
    {
        PlayerActivity.intentTo(this, "/mnt/sdcard/test.mp4", "test");
    }

    public void clickHandlerOfOpenIjkplayer(View source)
    {
        Intent intent = new Intent(this, FileExplorerActivity.class);
        startActivity(intent);
    }
}
