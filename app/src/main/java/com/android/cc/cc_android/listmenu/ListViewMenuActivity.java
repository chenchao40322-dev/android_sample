package com.android.cc.cc_android.listmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.cc.cc_android.R;


/**
 * Created by chenchao on 2016-2-16.
 */
public class ListViewMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewview_menu_activity);
        Button actionmodeButton = (Button)findViewById(R.id.button_actionmode);
        actionmodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewMenuActivity.this, ActionModesMenuActivity.class);
                startActivity(intent);
            }
        });

        Button popupButton = (Button)findViewById(R.id.button_popup);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewMenuActivity.this, PopupMenuMenuActivity.class);
                startActivity(intent);
            }
        });

        Button floatingContextButton = (Button)findViewById(R.id.button_float_context);
        floatingContextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewMenuActivity.this, FloatingContextMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
