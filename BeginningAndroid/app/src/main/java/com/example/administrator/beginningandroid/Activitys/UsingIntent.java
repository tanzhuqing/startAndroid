package com.example.administrator.beginningandroid.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.beginningandroid.R;

public class UsingIntent extends Activity {
    int reuqest_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_intent);
    }

    public void onClick(View v){
       // startActivity(new Intent("com.example.administrator.beginningandroid.Activitys.SecondActivity"));
        startActivityForResult(new Intent("com.example.administrator.beginningandroid.Activitys.SecondActivity"),reuqest_Code);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode == reuqest_Code){
            if (resultCode == RESULT_OK){
                Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_using_intent, menu);
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
