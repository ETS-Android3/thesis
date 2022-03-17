package dev.atharvakulkarni.e_commerce.view.PlacingOrder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.FragmentPaymentMethodBinding;

public class PaymentMethodFragment extends Fragment{
    private IOrderPlacingCallbacks mOrderPlacingCallbacks;
    public static Fragment newInstance()
    {
        return new PaymentMethodFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mOrderPlacingCallbacks = (IOrderPlacingCallbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOrderPlacingCallbacks= null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPaymentMethodBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_method, container, false);
        binding.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderPlacingCallbacks.onConfirmButtonClicked();
            }
        });
        return binding.getRoot();
    }
}
