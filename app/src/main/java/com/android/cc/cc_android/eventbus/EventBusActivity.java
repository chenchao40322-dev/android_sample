package com.android.cc.cc_android.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.cc.cc_android.R;
import com.android.cc.cc_android.log.FSLogcat;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by chenchao on 2016-2-24.
 */
public class EventBusActivity extends Activity {
    private Button btnAdd, btnReduce, btnVisible;
    private ProgressBar pbHor, pbLarge;
    private Thread mThread;
    private int mProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);

        FSLogcat.i("eventbus", "onCreate. thread:" + Thread.currentThread().getId());
        pbHor = (ProgressBar) findViewById(R.id.pbHor);
        findViewById(R.id.btnAdd).setOnClickListener(mClickListner);
        findViewById(R.id.btnReduce).setOnClickListener(mClickListner);

        EventBus.getDefault().register(this);

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                FSLogcat.i("eventbus", "thread run :" + Thread.currentThread().getId());
                try {
                    while (true) {
                        EventBus.getDefault().post(new MessageEvent(mProgress++ * 5));
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });

        mThread.start();
    }

    @Override
    protected void onDestroy() {
        mThread.interrupt();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private View.OnClickListener mClickListner = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    // 如果是增加按钮，因为进度条的最大值限制在100，第一刻度限制在90.
                    // 在此限度内，以1.2倍递增
                    // 使用setProgress()
                    if (pbHor.getProgress() < 90) {
                        pbHor.setProgress((int) (pbHor.getProgress() * 1.2));
                    }
                    if (pbHor.getSecondaryProgress() < 100) {
                        pbHor.setSecondaryProgress((int) (pbHor
                                .getSecondaryProgress() * 1.2));
                    }
                    break;
                case R.id.btnReduce:
                    // 如果是增加按钮，因为进度条的最大值限制在100，第一刻度限制在10.第二刻度限制在20
                    // 在此限度内，以10点为基数进行递减。
                    // 使用incrementXxxProgressBy(int)
                    if (pbHor.getProgress() > 10) {
                        pbHor.incrementProgressBy(-10);
                    }
                    if (pbHor.getSecondaryProgress() > 20) {
                        pbHor.incrementSecondaryProgressBy(-10);
                    }
                    break;
            }
        }
    };

    // This method will be called when a MessageEvent is posted
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event){
        FSLogcat.i("eventbus", "onMessageEvent:" + event.progress + " thread:" + Thread.currentThread().getId());
        pbHor.setProgress(event.progress % 100);
        pbHor.incrementProgressBy(-10);
    }

    public static class MessageEvent {
        public final int progress;

        public MessageEvent(int progress) {
            this.progress = progress;
        }
    }
}
