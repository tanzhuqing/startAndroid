package com.example.administrator.beginningandroid.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.beginningandroid.R;

public class PassingDataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);
    }


    public void onClick(View view){
        Intent i =  new Intent("com.example.administrator.beginningandroid.Activitys.SActivity");
        i.putExtra("str1","This is a string");
        i.putExtra("age1",25);
        Bundle extras = new Bundle();
        extras.putString("str2","This is another string");
        extras.putInt("age2",35);
        i.putExtras(extras);
        startActivityForResult(i,1);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Toast.makeText(this,Integer.toString(data.getIntExtra("age3",0)),Toast.LENGTH_SHORT).show();

                Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_passing_data, menu);
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
