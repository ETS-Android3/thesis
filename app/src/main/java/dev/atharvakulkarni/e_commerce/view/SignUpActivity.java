package dev.atharvakulkarni.e_commerce.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.viewModel.SignUpViewModel;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySignUpBinding;
import dev.atharvakulkarni.e_commerce.databinding.FragmentSignupBinding;

public class SignUpActivity extends AppCompatActivity implements SignUpViewModel.SignUpViewModelCallbacks {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActivitySignUpBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        SignUpViewModel viewModel = new SignUpViewModel(this);
        binding.setSignUpViewModel(viewModel);
    }

    @Override
    public void onSignUpFailure() {
        Toast.makeText(SignUpActivity.this,"Sign up new account success",Toast.LENGTH_SHORT);
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(SignUpActivity.this,"Sign up new account failed",Toast.LENGTH_SHORT);
    }

    @Override
    public void onSignInLabelClick() {
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
}
