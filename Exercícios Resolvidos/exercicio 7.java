<?xml version="1.0" encoding="utf-8"?>

<RelativeLayout
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:text="Large Text"
        android:id="@+id/textViewName"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="19dp"
        android:textColor="#F07241"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true" />

    <TextView
        android:textColor="#E7D448"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:text="Large Text"
        android:id="@+id/textViewYear"
        android:layout_marginRight="23dp"
        android:layout_alignTop="@+id/textViewName"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true"
        android:paddingBottom="22px"/>
</RelativeLayout>

------------------------------------------------------------------------------------------------------------------------------
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MyActivity"
    android:background="#383846">


    <ListView
        android:layout_width="500px"
        android:layout_height="500px"
        android:id="@+id/listView"
        android:layout_below="@+id/relativeLayout"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentBottom="true"
        android:layout_alignRight="@+id/relativeLayout"
        android:layout_alignEnd="@+id/relativeLayout" />

    <RelativeLayout
        android:layout_width="fill_parent"
        android:layout_height="110px"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:background="#DDDDDD"
        android:id="@+id/relativeLayout">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="#383846"
            android:textAppearance="?android:attr/textAppearanceLarge"
            android:text="Minhas bandas preferidas"
            android:id="@+id/textView"
            android:layout_centerVertical="true"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"
            android:layout_marginLeft="17dp" />
    </RelativeLayout>
</RelativeLayout>

------------------------------------------------------------------------------------------------------------------------------

package com.example.wesleialves.aula6.model;

/**
 * Created by weslei.alves on 17/07/2014.
 */
public class Band {
    private String name;
    private int year;

    public Band(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

--------------------------------------------------------------------------------------------------------------------------------


package com.example.wesleialves.aula6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wesleialves.aula6.R;
import com.example.wesleialves.aula6.model.Band;

import java.util.ArrayList;

/**
 * Created by weslei.alves on 17/07/2014.
 */
public class BandsAdapter extends BaseAdapter {
    private ArrayList<Band> bands;
    private Context context;

    public BandsAdapter(ArrayList<Band> bands, Context context) {
        this.bands = bands;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bands.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_band, null);

        Band bandTemp = bands.get(position);

        TextView nameTextView = (TextView) view.findViewById(R.id.textViewName);
        TextView yearTextView = (TextView) view.findViewById(R.id.textViewYear);

        nameTextView.setText(bandTemp.getName());
        yearTextView.setText(bandTemp.getYear() + "");

        return view;
    }
}


-------------------------------------------------------------------------------------------------------------------------------

package com.example.wesleialves.aula6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wesleialves.aula6.adapter.BandsAdapter;
import com.example.wesleialves.aula6.model.Band;

import java.util.ArrayList;


public class MyActivity extends Activity {

    private ListView listView;
    private ArrayList<Band> bands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        prepareData();
        setUpFindViewByIds();
        setUpListView();
        setUpListeners();

    }

    private void prepareData() {
        bands = new ArrayList<Band>();

        Band band1 = new Band("Legião Urbana", 1980);
        Band band2 = new Band("Jota Quest", 1982);
        Band band3 = new Band("Cazuza", 1980);

        bands.add(band1);
        bands.add(band2);
        bands.add(band3);
    }

    private void setUpFindViewByIds() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void setUpListView() {
        BandsAdapter bandsAdapter = new BandsAdapter(bands, getApplicationContext());
        listView.setAdapter(bandsAdapter);
    }

    private void setUpListeners() {

    }
}

