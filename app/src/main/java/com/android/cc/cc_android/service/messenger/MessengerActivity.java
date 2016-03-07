package com.android.cc.cc_android.service.messenger;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import com.android.cc.cc_android.R;
import com.android.cc.cc_android.log.FSLogcat;

/**
 * Created by chenchao on 2016-3-1.
 */
public class MessengerActivity extends Activity{
    protected static final String TAG = "Messenger";
    private  Messenger messenger;
    private Messenger reply;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        mTextView = (TextView)findViewById(R.id.send_text);
        View sendView = findViewById(R.id.send);
        sendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendText = mTextView.getText().toString();
                if (!sendText.isEmpty()) {
                    sendMessage(sendText);
                }
            }
        });

        reply = new Messenger(handler);
        Intent intent = new Intent(this, MessengerService.class);
        // 绑定服务
        bindService(intent, new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
                FSLogcat.d(TAG, "onServiceDisconnected");
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                FSLogcat.d(TAG, "onServiceConnected");
                messenger = new Messenger(service);
            }
        }, Context.BIND_AUTO_CREATE);

    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            FSLogcat.d(TAG, "clien recieve msg:");
        }

    };

    public void sendMessage(String sendText) {
        Message msg = Message.obtain();
        msg.replyTo = reply;
        Bundle bundle = new Bundle();
        bundle.putString("cmd", "client send");
        msg.setData(bundle);
        try {
            FSLogcat.d(TAG, "clien send:" + sendText);
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
