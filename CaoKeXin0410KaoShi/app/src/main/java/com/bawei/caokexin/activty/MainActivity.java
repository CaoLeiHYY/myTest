package com.bawei.caokexin.activty;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.bawei.caokexin.R;
import com.bawei.caokexin.view.ProgressView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private ProgressView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleView = (ProgressView) findViewById(R.id.circleView);

    }

    int progress = 0;

    public void start(View v) {
        // 1000公里
        circleView.setMax(100);
        progress=0;
        new Thread() {
            public void run() {
                while (true) {
                    progress = progress + 1;
                    String text = progress + "%";
                    circleView.setProgressAndText(progress, text);
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (progress == 100) {
                        break;
                    }
                }
            };
        }.start();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },30000);
    }
    public void reset(View v){
        circleView.setMax(100);
        progress=0;
        new Thread(){
            @Override
            public void run() {
                circleView.setProgressAndText(0,"0%");
            }
        }.start();
    }

}
