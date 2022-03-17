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
import dev.atharvakulkarni.e_commerce.databinding.FragmentOrderSummaryBinding;

public class OrderSummaryFragment extends Fragment {
    private IOrderPlacingCallbacks mOrderPlacingCallbacks;
    public static Fragment newInstance()
    {
        return new OrderSummaryFragment();
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
        FragmentOrderSummaryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_summary, container, false);
        binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderPlacingCallbacks.onContinueButtonClicked();
            }
        });
        return binding.getRoot();
    }
}
