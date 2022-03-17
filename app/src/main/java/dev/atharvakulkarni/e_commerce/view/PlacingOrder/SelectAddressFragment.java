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
import dev.atharvakulkarni.e_commerce.databinding.FragmentSelectAddressBinding;

public class SelectAddressFragment extends Fragment {
    private IOrderPlacingCallbacks mOrderPlacingCallbacks;
    public static Fragment newInstance()
    {
        return new SelectAddressFragment();
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
        FragmentSelectAddressBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_address, container, false);
        binding.deliverHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderPlacingCallbacks.onDeliveryHereButtonClicked();
            }
        });
        return binding.getRoot();
    }
}
