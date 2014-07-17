<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context=".MyActivity">


    <ListView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/listView"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true" />
</RelativeLayout>

------------------------------------------------------------------------------------------------------------------------------

package com.example.wesleialves.aula6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    private ListView listView;
    private List<String> bands;

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
        bands = new ArrayList<String>();

        bands.add("Legião Urbana");
        bands.add("Skank");
        bands.add("Kid Abelha");
        bands.add("Jota Quest");
        bands.add("Chico buarque");
        bands.add("Engenheiros do Hawaii");
        bands.add("Reginaldo Rossi");
        bands.add("Cazuza");
        bands.add("Ira!");
        bands.add("O Rappa");
        bands.add("Zeca Baleiro");
    }

    private void setUpFindViewByIds() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void setUpListView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                bands);
        listView.setAdapter(arrayAdapter);
    }

    private void setUpListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), bands.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
