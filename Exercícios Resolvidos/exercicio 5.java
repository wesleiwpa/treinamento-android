

<uses-permission android:name="android.permission.INTERNET" />
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@+id/relativeLayout"
        android:layout_alignParentTop="true" />

    <RelativeLayout
        android:id="@+id/relativeLayout"
        android:visibility="gone"
        android:layout_width="match_parent"
        android:layout_height="100px"
        android:layout_alignParentBottom="true"
        android:background="#ff83db48">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Reload"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:id="@+id/realoadbutton" />

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Back"
            android:id="@+id/backbutton"
            android:layout_centerVertical="true"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true" />

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Forward"
            android:id="@+id/forwardbutton"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_alignParentEnd="true" />
    </RelativeLayout>
</RelativeLayout>


-----------------------------------------------------------------------------------------------------------------------------------------------

package com.example.wesleialves.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MyActivity extends Activity {

    private WebView webView;
    private Button back;
    private Button reload;
    private Button forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        setUpFindViewByIds();
        setUpWebView();
        setUpListeners();

    }

    private void setUpFindViewByIds() {
        webView = (WebView) findViewById(R.id.webView);
        back = (Button) findViewById(R.id.backbutton);
        reload = (Button) findViewById(R.id.realoadbutton);
        forward = (Button) findViewById(R.id.forwardbutton);
    }

    private void setUpWebView() {
        webView.loadUrl("http://www.android.com/");
        webView.setWebViewClient(new WebViewClient());
    }

    private void setUpListeners() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView.canGoBack()){
                    webView.goBack();
                }
            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.reload();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoForward()){
                    webView.goForward();
                }
            }
        });
    }

}
