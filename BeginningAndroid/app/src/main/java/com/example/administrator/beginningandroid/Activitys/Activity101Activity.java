package com.example.administrator.beginningandroid.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.administrator.beginningandroid.R;

public class Activity101Activity extends Activity {
    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_activity101);

        Log.d(tag,"In the onCreate() event");
    }

    public void onStart(){
        super.onStart();
        Log.d(tag,"In the onStart() event");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(tag,"In the OnRestart() event");
    }

    public void onResume(){
        super.onResume();
        Log.d(tag,"In the onResume() event");
    }

    public void onPause(){
        super.onPause();
        Log.d(tag,"In the onPause() event");
    }

    public void onStop(){
        super.onStop();
        Log.d(tag,"In the onStop() event");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"In the OnDestroy() event");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity101, menu);
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
