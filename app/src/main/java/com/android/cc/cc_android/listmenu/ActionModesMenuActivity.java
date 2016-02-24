package com.android.cc.cc_android.listmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.cc.cc_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchao on 2016-1-24.
 */
public class ActionModesMenuActivity extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_modes_activity);
        mListView = (ListView)findViewById(R.id.data_list);
        List<String> datas = new ArrayList<>();
        datas.add("item0");
        datas.add("item1");
        datas.add("item2");
        datas.add("item3");
        datas.add("item4");
        datas.add("item5");
        datas.add("item6");
        datas.add("item7");
        datas.add("item8");
        datas.add("item9");
        datas.add("item10");
        datas.add("item11");
        datas.add("item12");
        datas.add("item13");
        datas.add("item14");
        datas.add("item15");
        datas.add("item16");
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));

        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                if (checked) {
                    Toast.makeText(ActionModesMenuActivity.this, "select " + position + "|" + id, Toast.LENGTH_SHORT).show();
                } else  {
                    Toast.makeText(ActionModesMenuActivity.this, "unselect " + position + "|" + id, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_up:
                        Toast.makeText(ActionModesMenuActivity.this, "up ", Toast.LENGTH_SHORT).show();
                        mode.finish(); // Action picked, so close the contextual menu
                        return true;
                    case R.id.action_delete:
                        Toast.makeText(ActionModesMenuActivity.this, "delete ", Toast.LENGTH_SHORT).show();
                        mode.finish(); // Action picked, so close the contextual menu
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_listview, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
    }
}
