package dev.atharvakulkarni.e_commerce.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import dev.atharvakulkarni.e_commerce.model.CartApiResponse;
import dev.atharvakulkarni.e_commerce.repository.CartRepository;

public class CartViewModel extends AppCompatActivity
{
    private CartRepository cartRepository;
    private CartViewModelCallbacks mCallbacks;

//    public CartViewModel(@NonNull Application application)
//    {
//        super(application);
//        cartRepository = new CartRepository(application);
//    }
    public CartViewModel(CartViewModelCallbacks callbacks)
    {
        this.mCallbacks = callbacks;
    }

    public interface CartViewModelCallbacks {

    }

//    public LiveData<CartApiResponse> getProductsInCart(int userId)
//    {
//        return cartRepository.getProductsInCart(userId);
//    }
}