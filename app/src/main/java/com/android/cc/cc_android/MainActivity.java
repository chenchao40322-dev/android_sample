package com.android.cc.cc_android;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.cc.cc_android.eventbus.EventBusActivity;
import com.android.cc.cc_android.greendao.GreenDaoActivity;
import com.android.cc.cc_android.listmenu.ListViewMenuActivity;
import com.android.cc.cc_android.service.messenger.MessengerActivity;
import com.android.cc.cc_android.viewPager.CCViewPagerActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[]{"title"},
                new int[]{android.R.id.text1}));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData() {
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();

        HashMap<String, Object> map = null;

        map = new HashMap<String, Object>();
        map.put("title", "greendao");
        map.put("class", GreenDaoActivity.class);
        myData.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "viewpager");
        map.put("class", CCViewPagerActivity.class);
        myData.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "listview_menu");
        map.put("class", ListViewMenuActivity.class);
        myData.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "eventbus");
        map.put("class", EventBusActivity.class);
        myData.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "messenger");
        map.put("class", MessengerActivity.class);
        myData.add(map);

        return myData;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>)l.getItemAtPosition(position);

        Class<Activity> tmpClass = (Class<Activity>)map.get("class");
        Intent intent = new Intent(this, tmpClass);
        startActivity(intent);
    }

    protected Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }


}