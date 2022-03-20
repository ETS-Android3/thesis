package dev.atharvakulkarni.e_commerce.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivityProductDetailsBinding;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySignInBinding;
import dev.atharvakulkarni.e_commerce.databinding.LayoutShopBinding;
import dev.atharvakulkarni.e_commerce.viewModel.ProductDetailsViewModel;
import dev.atharvakulkarni.e_commerce.viewModel.SignInViewModel;

public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsViewModel.ProductDetailsViewModelCallbacks {
//    setContentView(R.layout.activity_sign_in);
//    ActivitySignInBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
//    SignInViewModel viewModel = new SignInViewModel(this);
//        binding.setSignInViewModel(viewModel);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ActivityProductDetailsBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details);
        ProductDetailsViewModel viewModel = new ProductDetailsViewModel(this);
        binding.setProductDetailsViewModel(viewModel);

        LayoutShopBinding layoutShopBinding = binding.layoutShop;
        //TODO more
        layoutShopBinding.shopImage.setOnClickListener(view -> {viewModel.onShopImageClick();});
    }
}
