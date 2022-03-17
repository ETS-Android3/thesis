package dev.atharvakulkarni.e_commerce.viewModel;

import androidx.databinding.BaseObservable;

public class NotificationViewModel extends BaseObservable {
    NotificationViewModelCallbacks mCallbacks;
    public NotificationViewModel(NotificationViewModelCallbacks callbacks)
    {
        this.mCallbacks = callbacks;
    }
    public interface NotificationViewModelCallbacks{
    }

}
