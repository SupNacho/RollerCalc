package ru.supernacho.rollercalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Thirteenth on 19.11.2016.
 */

public class AboutActivity extends Activity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
    }

    public void onMainClick (MenuItem item) {
        Intent intent = new Intent(AboutActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void onPrefClick (MenuItem item) {
        Intent intent = new Intent(AboutActivity.this, PrefActivity.class);
        startActivity(intent);
    }
}
