package com.ableandroid.materialmotion;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AwareActivity extends DrawerActivity  {
    private static final String TAG = "AwareActivity";

    public static final int VIEW_HEIGHT_SM = 448;
    public static final int VIEW_HEIGHT_LG = 548;
    private View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_aware);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Aware");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        final Button txtVisBtn = (Button)findViewById(R.id.btn_text_visible);
        final TextView yesTextVis = (TextView) findViewById(R.id.yes_text_visible);
        final TextView noTextVis = (TextView) findViewById(R.id.no_text_visible);
        txtVisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentVisibility = yesTextVis.getVisibility();
                if (currentVisibility == View.VISIBLE) {
                    yesTextVis.setVisibility(View.INVISIBLE);
                    noTextVis.setVisibility(View.INVISIBLE);
                } else {
                    yesTextVis.setVisibility(View.VISIBLE);
                    noTextVis.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button txtGoneBtn = (Button)findViewById(R.id.btn_text_gone);
        final TextView yesTextGone = (TextView) findViewById(R.id.yes_text_gone);
        final TextView noTextGone = (TextView) findViewById(R.id.no_text_gone);
        txtGoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentVisibility = yesTextGone.getVisibility();
                if (currentVisibility == View.VISIBLE) {
                    yesTextGone.setVisibility(View.GONE);
                    noTextGone.setVisibility(View.GONE);
                } else {
                    yesTextGone.setVisibility(View.VISIBLE);
                    noTextGone.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button viewVisBtn = (Button)findViewById(R.id.btn_view_visible);
        final View yesViewVis = (View) findViewById(R.id.yes_view_visible);
        final View noViewVis = (View) findViewById(R.id.no_view_visible);
        viewVisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentVisibility = yesViewVis.getVisibility();
                if (currentVisibility == View.VISIBLE) {
                    yesViewVis.setVisibility(View.INVISIBLE);
                    noViewVis.setVisibility(View.INVISIBLE);
                } else {
                    yesViewVis.setVisibility(View.VISIBLE);
                    noViewVis.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button viewGoneBtn = (Button)findViewById(R.id.btn_view_gone);
        final View yesViewGone = (View) findViewById(R.id.yes_view_gone);
        final View noViewGone = (View) findViewById(R.id.no_view_gone);
        viewGoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentVisibility = yesViewGone.getVisibility();
                if (currentVisibility == View.VISIBLE) {
                    yesViewGone.setVisibility(View.GONE);
                    noViewGone.setVisibility(View.GONE);
                } else {
                    yesViewGone.setVisibility(View.VISIBLE);
                    noViewGone.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button viewElevBtn = (Button)findViewById(R.id.btn_view_elevation);
        viewElevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) yesViewVis.getLayoutParams();

                Log.d(TAG, "onClick() called with " + "view = [" + view + "]");
                Log.d(TAG, "onClick " + params.height);
                if (params.height == VIEW_HEIGHT_SM) {
                    params.height = VIEW_HEIGHT_LG;
                    yesViewVis.setLayoutParams(params);
                } else {
                    params.height = VIEW_HEIGHT_SM;
                    yesViewVis.setLayoutParams(params);
                }
//
//
//                int currentVisibility = yesViewGone.getVisibility();
//                if (currentVisibility == View.VISIBLE) {
//                    yesViewGone.setLayoutParams();
//
//
//
//                    yesViewGone.setVisibility(View.GONE);
//                    noViewGone.setVisibility(View.GONE);
//                } else {
//                    yesViewGone.setVisibility(View.VISIBLE);
//                    noViewGone.setVisibility(View.VISIBLE);
//                }
            }
        });

    }

}
