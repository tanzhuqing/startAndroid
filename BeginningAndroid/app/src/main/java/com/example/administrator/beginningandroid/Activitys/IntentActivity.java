package com.example.administrator.beginningandroid.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.beginningandroid.R;

public class IntentActivity extends Activity {
    int request_Code = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void onClickWebBrowser(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
        startActivity(i);
    }

    public void onClickMakeCalls(View view){
        Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+ 651234567"));
        startActivity(i);

    }

    public void onClickShowMap(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.82700,-122.481670"));
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
