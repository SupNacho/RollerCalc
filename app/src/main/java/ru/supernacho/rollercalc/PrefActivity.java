package ru.supernacho.rollercalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Thirteenth on 19.11.2016.
 */

public class PrefActivity extends Activity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pref,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref_layout);
    }
    public void onMainClick (MenuItem item) {
        Intent intent = new Intent(PrefActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void onAboutClick (MenuItem item){
        Intent intent = new Intent(PrefActivity.this,AboutActivity.class);
        startActivity(intent);
    }
}
