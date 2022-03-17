package dev.atharvakulkarni.e_commerce.viewModel;

import androidx.databinding.BaseObservable;

public class MainActivityViewModel extends BaseObservable {
    MainActivityCallbacks mCallbacks;

    public MainActivityViewModel(MainActivityCallbacks callBacks)
    {
        mCallbacks = callBacks;
    }
    public interface MainActivityCallbacks{
    }

}
