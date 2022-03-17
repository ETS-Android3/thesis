package dev.atharvakulkarni.e_commerce.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivityMainBinding;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySignInBinding;
import dev.atharvakulkarni.e_commerce.viewModel.MainActivityViewModel;
import dev.atharvakulkarni.e_commerce.viewModel.SignInViewModel;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainActivityViewModel.MainActivityCallbacks {
    Fragment fragment = null;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ActivityMainBinding mActivityMainBinding;
//    ImageView notificationIcon;

    public ActivityMainBinding getActivityMainBinding() {
        return mActivityMainBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_sign_in);
//        ActivitySignInBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
//        SignInViewModel viewModel = new SignInViewModel(this);
//        binding.setSignInViewModel(viewModel);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityViewModel viewModel = new MainActivityViewModel(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mActivityMainBinding.drawerLayout,null,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mActivityMainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //load home fragment
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.drawer_layout_fragment_container,fragment).commit();
//        manager.beginTransaction().replace(R.id.drawer_layout_fragment_container, fragment).commit();
        //TODO: +make drawer

//        LinearLayout lin_lay_add_paynow = (LinearLayout)findViewById(R.id.home_linear_layout);
//
//        View pay_now_view = getLayoutInflater().inflate(R.layout.home, null);
//        lin_lay_add_paynow.addView(pay_now_view);
//        Button button =  pay_now_view.findViewById(R.id.hamburger);
//
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });


        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

      /*  View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions =  View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/

//        Drawable background = getResources().getDrawable(R.drawable.gradient_home,getTheme());
        Drawable background = ContextCompat.getDrawable(MainActivity.this, R.drawable.gradient_home);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//        Window window = getWindow();


//        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent,getTheme()));
        getWindow().setBackgroundDrawable(background);


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        fragment = new HomeFragment();
//                        switchFragment(fragment);
//                        break;
//                    case R.id.cart:
//                        fragment = new CartFragment();
//                        switchFragment(fragment);
//                        break;
//                    case R.id.shopping_bag:
//                        fragment = new ShoppingBagFragment();
//                        switchFragment(fragment);
//                        break;
//
//                    case R.id.message:
//                        fragment = new MessageFragment();
//                        switchFragment(fragment);
//                        break;
//
//                    case R.id.my_account:
//                        fragment = new MyAccountFragment();
//                        switchFragment(fragment);
//                        break;
//
//                }
//
//
//                return false;
//            }
//        });
//
//        if (savedInstanceState == null) {
//            bottomNavigationView.setSelectedItemId(R.id.home); // change to whichever id should be default
//        }
    }

    @Override
    public void onBackPressed() {
        if(mActivityMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mActivityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.all_categories:
                all_category();
                break;
            case R.id.orders:
                my_orders();
                break;
            case R.id.cart:
                cart();
                break;
            case R.id.wishlist:
                break;
            case R.id.account:
                break;
            case R.id.notifications:
                break;
            case R.id.privacy_policy:
                break;
            case R.id.legal:
                break;
            case R.id.report:
                break;
            case R.id.rate:
                break;
            case R.id.share:
                break;
            case R.id.logout:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    void cart() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    void all_category() {
        Intent intent = new Intent(this, AllCategoryActivity.class);
        startActivity(intent);
    }

    void my_orders() {
        Intent intent = new Intent(this, MyOrdersActivity.class);
        startActivity(intent);
    }

//    void switchFragment(Fragment fragment) {
//        FragmentManager manager = getSupportFragmentManager();
//        manager.beginTransaction().replace(R.id.framelayout, fragment).commit();
//    }
}