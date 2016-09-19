package com.ableandroid.materialmotion;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends DrawerActivity  {
    private static final String TAG = "AwareActivity";

    public static final int VIEW_HEIGHT_SM = 448;
    public static final int VIEW_HEIGHT_LG = 548;
    private View mainView;

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Material Motion");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mActivity = this;
        setupViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_layout_info) {
            Log.d("MSW", "-------------------+++++++++++++++;lkhasdfhajksdhf");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViews() {
        LinearLayout l1 = (LinearLayout) findViewById(R.id.matcharac_layout1);
        final TextView text1 = (TextView) findViewById(R.id.matcharac_text1) ;
        final String transChar1 = getResources().getString(R.string.trans_charac1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), TouchFeedbackActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)text1, transChar1);

                startActivity(intent1, options.toBundle());

            }
        });

        LinearLayout l2 = (LinearLayout) findViewById(R.id.matcharac_layout2);
        final TextView text2 = (TextView) findViewById(R.id.matcharac_text2) ;
        final String transChar2 = getResources().getString(R.string.trans_charac2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), AwareActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)text2, transChar2);

                startActivity(intent1, options.toBundle());

            }
        });

        LinearLayout l3 = (LinearLayout) findViewById(R.id.matcharac_layout3);
        final TextView text3 = (TextView) findViewById(R.id.matcharac_text3) ;
        final String transChar3 = getResources().getString(R.string.trans_charac3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), NaturalMotionActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)text3, transChar3);

                startActivity(intent1, options.toBundle());

            }
        });

        LinearLayout l4 = (LinearLayout) findViewById(R.id.matcharac_layout4);
        final TextView text4 = (TextView) findViewById(R.id.matcharac_text4) ;
        final String transChar4 = getResources().getString(R.string.trans_mat_title);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), IntentionalStartActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)text4, transChar4);

                startActivity(intent1, options.toBundle());
            }
        });

        TextView matLink = (TextView) findViewById(R.id.matmotion_learnmorelink);
        matLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://material.google.com/motion")));
            }
        });

        ImageView matVid = (ImageView) findViewById(R.id.mat_motion_vid);
        matVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=cQzien5H2Do")));

            }
        });
    }

}
