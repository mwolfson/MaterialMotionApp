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
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends DrawerActivity  {
    private static final String TAG = "HomeActivity";

    public static int VIEW_HEIGHT_UNEXPAND = 0;
    public static int VIEW_HEIGHT_SM = 0;
    public static int VIEW_HEIGHT_MD = 0;
    public static int VIEW_HEIGHT_LG = 0;

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

        VIEW_HEIGHT_SM = getResources().getDimensionPixelSize(R.dimen.card_size_expand_sm);
        VIEW_HEIGHT_MD = getResources().getDimensionPixelSize(R.dimen.card_size_expand_md);
        VIEW_HEIGHT_UNEXPAND = getResources().getDimensionPixelSize(R.dimen.card_size_unexpand);
        VIEW_HEIGHT_LG = getResources().getDimensionPixelSize(R.dimen.card_size_expand_lg);
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
        final LinearLayout l1 = (LinearLayout) findViewById(R.id.matcharac_layout1);
        final TextView text1 = (TextView) findViewById(R.id.matcharac_text1) ;
        final String transChar1 = getResources().getString(R.string.trans_charac1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), ResponsiveActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)text1, transChar1);

                startActivity(intent1, options.toBundle());

            }
        });
        final ImageView moreBtn1 = (ImageView) findViewById(R.id.matcharac_morebtn1);
        moreBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) l1.getLayoutParams();
                if (params.height == VIEW_HEIGHT_UNEXPAND) {
                    params.height = VIEW_HEIGHT_MD;
                    text1.setMaxLines(10);
                    l1.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_right);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn1.startAnimation(sampleFadeAnimation);
                } else {
                    params.height = VIEW_HEIGHT_UNEXPAND;
                    text1.setMaxLines(1);
                    l1.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_left);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn1.startAnimation(sampleFadeAnimation);
                }
            }
        });


        final LinearLayout l2 = (LinearLayout) findViewById(R.id.matcharac_layout2);
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
        final ImageView moreBtn2 = (ImageView) findViewById(R.id.matcharac_morebtn2);
        moreBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) l2.getLayoutParams();
                if (params.height == VIEW_HEIGHT_UNEXPAND) {
//                    params.height = VIEW_HEIGHT_LG;
//                    text2.setMaxLines(10);
//                    l2.setLayoutParams(params);
//                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_right);
//                    sampleFadeAnimation.setFillAfter(true);
//                    moreBtn2.startAnimation(sampleFadeAnimation);

                    expand(l2);
//                } else {
//                    params.height = VIEW_HEIGHT_UNEXPAND;
//                    text2.setMaxLines(1);
//                    l2.setLayoutParams(params);
//                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_left);
//                    sampleFadeAnimation.setFillAfter(true);
//                    moreBtn2.startAnimation(sampleFadeAnimation);

                    collapse(l2);
                }
            }
        });



        final LinearLayout l3 = (LinearLayout) findViewById(R.id.matcharac_layout3);
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
        final ImageView moreBtn3 = (ImageView) findViewById(R.id.matcharac_morebtn3);
        moreBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) l3.getLayoutParams();
                if (params.height == VIEW_HEIGHT_UNEXPAND) {
                    params.height = VIEW_HEIGHT_SM;
                    text3.setMaxLines(10);
                    l3.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_right);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn3.startAnimation(sampleFadeAnimation);
                } else {
                    params.height = VIEW_HEIGHT_UNEXPAND;
                    text3.setMaxLines(1);
                    l3.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_left);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn3.startAnimation(sampleFadeAnimation);
                }
            }
        });

        final LinearLayout l4 = (LinearLayout) findViewById(R.id.matcharac_layout4);
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
        final ImageView moreBtn4 = (ImageView) findViewById(R.id.matcharac_morebtn4);
        moreBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) l4.getLayoutParams();
                if (params.height == VIEW_HEIGHT_UNEXPAND) {
                    params.height = VIEW_HEIGHT_SM;
                    text4.setMaxLines(10);
                    l4.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_right);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn4.startAnimation(sampleFadeAnimation);
                } else {
                    params.height = VIEW_HEIGHT_UNEXPAND;
                    text4.setMaxLines(1);
                    l4.setLayoutParams(params);
                    Animation sampleFadeAnimation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate_left);
                    sampleFadeAnimation.setFillAfter(true);
                    moreBtn4.startAnimation(sampleFadeAnimation);
                }
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


    public static void expand(final View v) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
