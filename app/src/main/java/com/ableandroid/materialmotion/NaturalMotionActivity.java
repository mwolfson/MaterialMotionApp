package com.ableandroid.materialmotion;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class NaturalMotionActivity extends DrawerActivity {
    private View mainView;
    private Activity mActivity;

    public static final float LARGE_SCALE = 1.5f;
    public static final float NORMAL_SCALE = 1f;
    private boolean symmetric = true;
    private boolean small = true;
    private CardView card;

    private ImageView bigRedBall;
    private SeekBar durationSeek;
    private TextView currentDur;
    private int durInt = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_naturalmotion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mActivity = this;

        getSupportActionBar().setTitle("Natural Motion");

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
        bigRedBall = (ImageView) findViewById(R.id.big_red_ball);
        durationSeek = (SeekBar) findViewById(R.id.millisSeekBar);
        currentDur = (TextView) findViewById(R.id.curentValue);
        durationSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentDur.setText(" " + i);
                durInt = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Arrow buttons
        ImageView exitGood = (ImageView) findViewById(R.id.nat_btn_1);
        exitGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim1 = AnimationUtils.loadAnimation(mActivity, R.anim.slideup_in);
                // Good - correct interpolator for items leaving screen
                Interpolator interpFosi = AnimationUtils.loadInterpolator(mActivity, android.R.interpolator.fast_out_slow_in);
                anim1.setInterpolator(interpFosi);
                anim1.setDuration(durInt);
                bigRedBall.startAnimation(anim1);
            }
        });

        ImageView enterGood = (ImageView) findViewById(R.id.nat_btn_2);
        enterGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim2 = AnimationUtils.loadAnimation(mActivity, R.anim.slidedown_out);
                // Good - correct interpolator for items entering
                Interpolator interpFoli = AnimationUtils.loadInterpolator(mActivity, android.R.interpolator.fast_out_linear_in);
                anim2.setInterpolator(interpFoli);
                anim2.setDuration(durInt);
                bigRedBall.startAnimation(anim2);
            }
        });

        ImageView exitBad = (ImageView) findViewById(R.id.nat_btn_3);
        exitBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bad - no interpolator, will default to Linear
                Animation anim3 = AnimationUtils.loadAnimation(mActivity, R.anim.slideup_in);
                anim3.setDuration(durInt);
                bigRedBall.startAnimation(anim3);
            }
        });

        ImageView enterBad = (ImageView) findViewById(R.id.nat_btn_4);
        enterBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim3 = AnimationUtils.loadAnimation(mActivity, R.anim.slidedown_out);
                anim3.setDuration(durInt);
                bigRedBall.startAnimation(anim3);
            }
        });


        ImageView exitCaution = (ImageView) findViewById(R.id.nat_btn_5);
        exitCaution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim5 = AnimationUtils.loadAnimation(mActivity, R.anim.slideup_in);
                Interpolator interpBounce = AnimationUtils.loadInterpolator(mActivity, android.R.interpolator.bounce);
                anim5.setInterpolator(interpBounce);
                anim5.setDuration(durInt);
                bigRedBall.startAnimation(anim5);
            }
        });
    }

}
