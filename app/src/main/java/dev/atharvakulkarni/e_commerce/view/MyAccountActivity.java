package dev.atharvakulkarni.e_commerce.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivityMyAccountBinding;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySignInBinding;
import dev.atharvakulkarni.e_commerce.viewModel.MyAccountViewModel;
import dev.atharvakulkarni.e_commerce.viewModel.SignInViewModel;

public class MyAccountActivity extends AppCompatActivity implements MyAccountViewModel.MyAccountViewModelCallbacks {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);
        ActivityMyAccountBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_my_account);
        MyAccountViewModel viewModel = new MyAccountViewModel(this);
        binding.setMyAccountViewModel(viewModel);
    }
}
