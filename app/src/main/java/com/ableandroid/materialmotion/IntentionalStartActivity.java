package com.ableandroid.materialmotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.Transition;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IntentionalStartActivity extends DrawerActivity {
    private Activity mActivity;
    private View mView;


    //scenes to transition
    private Scene scene1, scene2, scene3;
    //transition to move between scenes
    private Transition transition;
    //flag to swap between scenes
    private boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_intentionalstart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mView =  ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        getSupportActionBar().setTitle("Intentional");

        mActivity = this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        setupViews();
    }

    private void setupViews() {
        final ImageView transGoodBtn = (ImageView) findViewById(R.id.nat_btn_1);
        final ImageView transCautionBtn = (ImageView) findViewById(R.id.nat_btn_2);
        final ImageView transBadBtn = (ImageView) findViewById(R.id.nat_btn_3);

        final ImageView livestreamIcon = (ImageView) findViewById(R.id.icon_livestream);
        final ImageView heroImg1 = (ImageView) findViewById(R.id.hero_img1);
        final TextView textLivestream = (TextView) findViewById(R.id.motion_text_livestream);

        final ImageView designIcon = (ImageView) findViewById(R.id.icon_design);
        final ImageView heroImg2 = (ImageView) findViewById(R.id.hero_img2);
        final TextView textDesign = (TextView) findViewById(R.id.motion_text_design);

        final TextView glyphText = (TextView) findViewById(R.id.glyph_text);
        final ImageView glyphIcon = (ImageView) findViewById(R.id.glyph_img);

        final TextView motionTitle = (TextView) findViewById(R.id.viewab_title);

        final String transLivestream = getResources().getString(R.string.trans_livestream);
        final String transHero = getResources().getString(R.string.trans_hero1);
        final String transText = getResources().getString(R.string.trans_mat_text);
        final String transGlyphText = getResources().getString(R.string.trans_glyph_text);
        final String transTitleText = getResources().getString(R.string.trans_mat_title);
        final String transGlyphIcon = getResources().getString(R.string.trans_mat_title);

        //Top 3 demo buttons
        transGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)heroImg1, transHero);

                startActivity(intent, options.toBundle());
            }
        });

        transCautionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);

                Pair<View, String> p1 = Pair.create((View)livestreamIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textLivestream, transText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2);

                startActivity(intent, options.toBundle());
            }
        });

        transBadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);

                Pair<View, String> p1 = Pair.create((View)livestreamIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textLivestream, transText);
                Pair<View, String> p3 = Pair.create((View)heroImg1, transHero);
                Pair<View, String> p4 = Pair.create((View)glyphIcon, transGlyphIcon);
                Pair<View, String> p5= Pair.create((View)glyphText, transGlyphText);
                Pair<View, String> p6 = Pair.create((View)motionTitle, transTitleText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2, p3, p4, p5, p6);

                startActivity(intent, options.toBundle());
            }
        });

        // Hero Images
        heroImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_LIVESTREAM);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)heroImg1, transHero);

                startActivity(intent, options.toBundle());
            }
        });

        heroImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_DESIGN);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)heroImg2, transHero);

                startActivity(intent, options.toBundle());
            }
        });


        // Livestream pair
        livestreamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_LIVESTREAM);

                Pair<View, String> p1 = Pair.create((View)livestreamIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textLivestream, transText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2);

                startActivity(intent, options.toBundle());
            }
        });

        textLivestream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_LIVESTREAM);

                Pair<View, String> p1 = Pair.create((View)livestreamIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textLivestream, transText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2);

                startActivity(intent, options.toBundle());
            }
        });

        // Design pair
        designIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_DESIGN);

                Pair<View, String> p1 = Pair.create((View)designIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textDesign, transText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2);

                startActivity(intent, options.toBundle());
            }
        });

        textLivestream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);
                intent.putExtra(IntentionalEndActivity.XTRA_INTENTIONAL_KEY, IntentionalEndActivity.XTRA_DESIGN);

                Pair<View, String> p1 = Pair.create((View)designIcon, transLivestream);
                Pair<View, String> p2 = Pair.create((View)textDesign, transText);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, p1, p2);

                startActivity(intent, options.toBundle());
            }
        });

        // Glyph Icon and Text
        // Design pair
        glyphIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentionalEndActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mActivity, (View)glyphIcon, transGlyphIcon);

                startActivity(intent, options.toBundle());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_layout_info) {
            Log.d("MSW", "-------&%&^%^&%&^%Jhjhkjhadgf;oia78ksdhf");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
