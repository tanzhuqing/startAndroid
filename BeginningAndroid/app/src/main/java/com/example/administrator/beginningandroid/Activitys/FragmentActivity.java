package com.example.administrator.beginningandroid.Activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.administrator.beginningandroid.Activitys.Fragments.Fragment1;
import com.example.administrator.beginningandroid.Activitys.Fragments.Fragment2;
import com.example.administrator.beginningandroid.R;

public class FragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WindowManager windowManager = getWindowManager();
        Display d = windowManager.getDefaultDisplay();
        if (d.getWidth() > d.getHeight()){
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(android.R.id.content,fragment1);
        }else{
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(android.R.id.content,fragment2);
        }

        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
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
