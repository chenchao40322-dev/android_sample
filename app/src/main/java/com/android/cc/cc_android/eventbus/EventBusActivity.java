package com.android.cc.cc_android.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.cc.cc_android.R;

/**
 * Created by chenchao on 2016-2-24.
 */
public class EventBusActivity extends Activity {
    private Button btnAdd, btnReduce, btnVisible;
    private ProgressBar pbHor, pbLarge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);

        pbHor = (ProgressBar) findViewById(R.id.pbHor);
        findViewById(R.id.btnAdd).setOnClickListener(mClickListner);
        findViewById(R.id.btnReduce).setOnClickListener(mClickListner);
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
}
