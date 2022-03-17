package dev.atharvakulkarni.e_commerce.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivitySignInBinding;
import dev.atharvakulkarni.e_commerce.viewModel.SignInViewModel;

public class SignInActivity extends AppCompatActivity implements SignInViewModel.SignInViewModelCallbacks {
    public static final String TAG = SignInActivity.class.getSimpleName();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ActivitySignInBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
        SignInViewModel viewModel = new SignInViewModel(this);
        binding.setSignInViewModel(viewModel);
    }


    @Override
    public void onSignInSuccess() {
        Toast.makeText(SignInActivity.this,"Sign In Success",Toast.LENGTH_SHORT);
        Log.d(TAG, "onSignInSuccess: call from callback ?");
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        // start main activity
    }

    @Override
    public void onSignInFailure() {
        Toast.makeText(SignInActivity.this,"Sign in failed",Toast.LENGTH_SHORT);
        Log.d(TAG, "onSignInSuccess: call from callback ?");

    }

    @Override
    public void onSignUpLabelClick() {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
