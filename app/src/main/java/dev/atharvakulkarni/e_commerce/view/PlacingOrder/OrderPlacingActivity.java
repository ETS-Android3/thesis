package dev.atharvakulkarni.e_commerce.view.PlacingOrder;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import dev.atharvakulkarni.e_commerce.R;

public class OrderPlacingActivity extends AppCompatActivity implements IOrderPlacingCallbacks{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            //first load select address fragment
            fragment = SelectAddressFragment.newInstance();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    @Override
    public void onDeliveryHereButtonClicked() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = OrderSummaryFragment.newInstance();
        fm.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onContinueButtonClicked() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = PaymentMethodFragment.newInstance();
        fm.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onConfirmButtonClicked() {
        //return to home page
        finish();
    }
}
