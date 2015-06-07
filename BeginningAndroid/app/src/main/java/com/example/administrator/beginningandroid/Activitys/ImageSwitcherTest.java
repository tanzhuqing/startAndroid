package com.example.administrator.beginningandroid.Activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.administrator.beginningandroid.R;

public class ImageSwitcherTest extends Activity  implements ViewSwitcher.ViewFactory{
    Integer[] imageIDs = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
    };

    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_test);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.switcher1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        Gallery gallery = (Gallery)findViewById(R.id.gallery2);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imageIDs[position]);
            }
        });
    }

    public View makeView(){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0XFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
      return  imageView;
    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context c){
            context = c;

            TypedArray a = obtainStyledAttributes(R.styleable.Gallery2);
            itemBackground = a.getResourceId(R.styleable.Gallery2_android_galleryItemBackground,0);
            a.recycle();
        }
        public  int getCount(){
            return imageIDs.length;
        }

        public  Object getItem(int position){
            return  position;
        }

        public long getItemId(int position){
            return position;
        }

        public View getView(int position,View convertViewm,ViewGroup parent){
            ImageView imageView = new ImageView(context);

            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
          //  imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
            imageView.setBackgroundResource(itemBackground);

            return imageView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_switcher_test, menu);
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
