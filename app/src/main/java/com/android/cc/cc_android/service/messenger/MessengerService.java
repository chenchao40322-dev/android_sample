package com.android.cc.cc_android.service.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.android.cc.cc_android.log.FSLogcat;

/**
 * Created by chenchao on 2016-3-1.
 */
public class MessengerService extends Service {
    protected static final String TAG = "Messenger";

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

                    String text = msg.getData().getString("cmd");
                    FSLogcat.d(TAG, "server recieve:" + text);
                    final Messenger callback = msg.replyTo;
                    try {
                        Message replyMsg = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString("cmd", "server send " + text);
                        replyMsg.setData(bundle);
                        callback.send(replyMsg);
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        FSLogcat.d(TAG, "service onCreate:");
    }

    @Override
    public IBinder onBind(Intent intent) {
        FSLogcat.d(TAG, "service onBind:");
        return new Messenger(mHandler).getBinder();
    }
}
