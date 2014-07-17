<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context=".MyActivity">


    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/numero1"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="54dp"
        android:inputType="datetime"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true" />

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/numero2"
        android:layout_below="@+id/numero1"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_alignRight="@+id/numero1"
        android:layout_alignEnd="@+id/numero1" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Somar"
        android:id="@+id/buttonSomar"
        android:layout_below="@+id/numero2"
        android:layout_alignRight="@+id/numero2"
        android:layout_alignEnd="@+id/numero2"
        android:layout_marginTop="47dp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:text="App de soma"
        android:id="@+id/textView"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true" />
</RelativeLayout>

------------------------------------------------------------------------------------------------------------------------------------------------

package com.example.wesleialves.aula4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity {

    private EditText numero1;
    private EditText numero2;
    private Button buttonSomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        setUpFindViewByIds();
        setUpListeners();
    }

    private void setUpFindViewByIds() {
        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);
        buttonSomar = (Button) findViewById(R.id.buttonSomar);
    }

    private void setUpListeners() {
        buttonSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soma = Integer.valueOf(numero1.getText().toString()) + Integer.valueOf(numero2.getText().toString());
                Toast.makeText(getApplicationContext(), soma + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

