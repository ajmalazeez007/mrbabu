package com.greycodes.mrbabudriver;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.greycodes.mrbabudriver.fragments.HomeFragment;
import com.greycodes.mrbabudriver.fragments.SearchDialog;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;
    View guillotineMenu;
    FragmentTransaction fragmentTransaction;
    CanaroTextView delivery,onrack,search,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

          guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);
          delivery = (CanaroTextView) guillotineMenu.findViewById(R.id.delivery);
          onrack = (CanaroTextView) guillotineMenu.findViewById(R.id.onrack);
          search = (CanaroTextView) guillotineMenu.findViewById(R.id.search);
          logout = (CanaroTextView) guillotineMenu.findViewById(R.id.logout);

        delivery.setOnClickListener(this);
        onrack.setOnClickListener(this);
        search.setOnClickListener(this);
        logout.setOnClickListener(this);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,new HomeFragment()).commit();
        animate();



    }
    private void animate(){
        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .build();
//        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, delivery, contentHamburger)
//                .setStartDelay(RIPPLE_DURATION)
//                .setActionBarViewForAnimation(toolbar)
//                .build();
//        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, onrack, contentHamburger)
//                .setStartDelay(RIPPLE_DURATION)
//                .setActionBarViewForAnimation(toolbar)
//                .build();
//        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, search, contentHamburger)
//                .setStartDelay(RIPPLE_DURATION)
//                .setActionBarViewForAnimation(toolbar)
//                .build();
//        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, logout, contentHamburger)
//                .setStartDelay(RIPPLE_DURATION)
//                .setActionBarViewForAnimation(toolbar)
//                .build();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.delivery:
                guillotineMenu.findViewById(R.id.guillotine_hamburger).performClick();
                break;
            case R.id.onrack:
                guillotineMenu.findViewById(R.id.guillotine_hamburger).performClick();
                break;
            case R.id.search:
                guillotineMenu.findViewById(R.id.guillotine_hamburger).performClick();
                SearchDialog searchDialog = new SearchDialog();
                searchDialog.show(getFragmentManager(), "search");
                Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_LONG).show();

                break;
            case R.id.logout:

                guillotineMenu.findViewById(R.id.guillotine_hamburger).performClick();
                break;
        }
    }
}
