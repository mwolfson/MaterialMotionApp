package com.ableandroid.materialmotion;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by mwolfson on 8/19/16.
 */
public class DrawerActivity  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String EXTRA_DEMO_TYPE = "xtraDemoTypeKey";

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aware) {
            Intent animIntent =  new Intent(this, AwareActivity.class);
            startActivity(animIntent);
        } else if (id == R.id.nav_intentional) {
            Intent sceneIntent =  new Intent(this, IntentionalStartActivity.class);
            startActivity(sceneIntent);
        } else if (id == R.id.nav_responsive) {
            Intent touchFeedbackIntent =  new Intent(this, TouchFeedbackActivity.class);
            startActivity(touchFeedbackIntent );
        } else if (id == R.id.nav_natmotion) {
            Intent animIntent =  new Intent(this, NaturalMotionActivity.class);
            startActivity(animIntent);
        } else if (id == R.id.nav_playground) {
            Intent animIntent =  new Intent(this, PlaygroundActivity.class);
            animIntent.putExtra(EXTRA_DEMO_TYPE, "playgroundActivity");
            startActivity(animIntent);
        } else if (id == R.id.nav_home) {
            Intent homeIntent =  new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
