package dev.atharvakulkarni.e_commerce.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivityShopBinding;
import dev.atharvakulkarni.e_commerce.viewModel.ShopViewModel;

public class ShopActivity extends AppCompatActivity implements ShopViewModel.ShopViewModelCallbacks {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ActivityShopBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_shop);
        ShopViewModel viewModel = new ShopViewModel(this);
        binding.setShopViewModel(viewModel);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(adapter);

        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    return new PopularProductsFragment();
                case 1:
                    return new LatestProductsFragment();
                case 2:
                    return new BestSellingProductsFragment();
                default:
                    return new PopularProductsFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position){
                case 0:
                    title = getResources().getString(R.string.popular_product);
                    break;
                case 1:
                    title = getResources().getString(R.string.latest_product);
                    break;
                case 2:
                    title = getResources().getString(R.string.best_selling_product);
                    break;
            }
            return title;
        }
    }

}
