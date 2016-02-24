package com.android.cc.cc_android.listmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.cc.cc_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchao on 2016-1-24.
 */
public class FloatingContextMenuActivity extends ListActivity {

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

        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listview, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                Toast.makeText(this, "delete " + info.position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_up:
                Toast.makeText(this, "up " + info.targetView.hashCode(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_down:
                Toast.makeText(this, "down " + info.id, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
