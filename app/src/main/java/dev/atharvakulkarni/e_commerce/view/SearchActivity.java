package dev.atharvakulkarni.e_commerce.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySearchBinding;
import dev.atharvakulkarni.e_commerce.viewModel.SearchViewModel;

public class SearchActivity extends AppCompatActivity implements SearchViewModel.SearchViewModelCallbacks {
    public static final String EXTRA_QUERY_STRING = "EXTRA_QUERY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String query = getIntent().getStringExtra(EXTRA_QUERY_STRING);
        setContentView(R.layout.activity_search);

        //        setContentView(R.layout.activity_sign_in);
//        ActivitySignInBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
//        SignInViewModel viewModel = new SignInViewModel(this);
//        binding.setSignInViewModel(viewModel);
        ActivitySearchBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_search);
        SearchViewModel viewModel = new SearchViewModel(this);
        binding.setSearchViewModel(viewModel);

//        binding.appBarLayout
    }
}
