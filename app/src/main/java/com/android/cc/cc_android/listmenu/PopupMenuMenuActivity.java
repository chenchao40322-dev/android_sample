package com.android.cc.cc_android.listmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.android.cc.cc_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchao on 2016-1-24.
 */
public class PopupMenuMenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));

        longClick();
    }

    private void longClick() {
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                PopupMenu menu = new PopupMenu(PopupMenuMenuActivity.this, view);
                menu.getMenuInflater().inflate(R.menu.menu_listview, menu.getMenu());
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.action_delete) {
                            Toast.makeText(PopupMenuMenuActivity.this, "delete " + position, Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.action_up) {
                            Toast.makeText(PopupMenuMenuActivity.this, "up " + position, Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }
                });

                return false;
            }
        });
    }
}
