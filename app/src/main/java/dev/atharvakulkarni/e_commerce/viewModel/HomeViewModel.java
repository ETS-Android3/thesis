package dev.atharvakulkarni.e_commerce.viewModel;

import android.util.Log;
import android.widget.SearchView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import dev.atharvakulkarni.e_commerce.BR;

public class HomeViewModel extends BaseObservable {
    public static final String TAG = HomeViewModel.class.getSimpleName();
    private HomeViewModelCallbacks mCallbacks;
    public HomeViewModel(HomeViewModelCallbacks callBacks)
    {
        this.mCallbacks = callBacks;
    }
    public interface HomeViewModelCallbacks{
        public void onSearchQuerySubmit(String query);
        public void onCartIconClick();
        public void onNotificationIconClick();
        public void onHamburgerIconClick();
    }
    public void onCartIconClick(){
        mCallbacks.onCartIconClick();
    }
    public void onNotificationIconClick()
    {
        mCallbacks.onNotificationIconClick();
    }
    public void onHamburgerIconClick()
    {
        mCallbacks.onHamburgerIconClick();
    }


}
