package com.ableandroid.materialmotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class IntentionalEndActivity extends DrawerActivity {
    private Activity mActivity;
    private View mView;

    public static final String XTRA_INTENTIONAL_KEY = "xtraIntentionalKey";
    public static final String XTRA_DESIGN = "xtraDesign";
    public static final String XTRA_LIVESTREAM = "xtraLivestream";

    private boolean isDesign = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_intentionalend);
        mActivity = this;
        mView = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String xtraStringIn = intent.getStringExtra(XTRA_INTENTIONAL_KEY);

        if (xtraStringIn != null && xtraStringIn.equals(XTRA_DESIGN)) {
            isDesign = true;
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (isDesign) {
            getSupportActionBar().setTitle("Intentional - Detail #2");
        } else {
            getSupportActionBar().setTitle("Intentional - Detail #1");
        }

        setupViews();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first


    }

    private void setupViews() {
        ImageView heroImg = (ImageView) findViewById(R.id.hero_img1);
        ImageView iconImg = (ImageView) findViewById(R.id.icon_livestream);

        if (isDesign) {
            heroImg.setImageDrawable(getResources().getDrawable(R.drawable.dcnyc_keynote));
            iconImg.setImageResource(R.drawable.vct_design);
        } else {
            heroImg.setImageDrawable(getResources().getDrawable(R.drawable.dcnyc_group));
            iconImg.setImageResource(R.drawable.vct_livestream);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }


}
