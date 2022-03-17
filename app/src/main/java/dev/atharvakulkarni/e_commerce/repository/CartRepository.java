package dev.atharvakulkarni.e_commerce.repository;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import dev.atharvakulkarni.e_commerce.model.Cart;
import dev.atharvakulkarni.e_commerce.model.CartApiResponse;
import dev.atharvakulkarni.e_commerce.model.Product;
import dev.atharvakulkarni.e_commerce.net.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartRepository {
    private Context mContext;
    private static CartRepository sCartRepository;
    private List<Product> mProducts;
    private static final String TAG = CartRepository.class.getSimpleName();

    private CartRepository(Context context) {
        mContext = context.getApplicationContext();
    }

    public static CartRepository get(Context context) {
        if (sCartRepository == null) {
            sCartRepository = new CartRepository(context);
        }
        return sCartRepository;
    }
    public void addProduct(Product product)
    {
        // TODO insert to database here
        mProducts.add(product);
    }
    public Product getProduct(String productId)
    {
        Product product = null;
        for(int i =0 ;i < mProducts.size(); i++)
        {
            if(mProducts.get(i).getProductId().equals(productId))
            {
                product = mProducts.get(i);
                break;
            }
        }
        return product;
    }
    public List<Product> getProducts()
    {
        return mProducts;
    }

//    private Application application;
//
//    public CartRepository(Application application)
//    {
//        this.application = application;
//    }
//
//    public LiveData<CartApiResponse> getProductsInCart(int userId)
//    {
//        final MutableLiveData<CartApiResponse> mutableLiveData = new MutableLiveData<>();
//
//        RetrofitClient.getInstance().getApi().getProductsInCart(userId).enqueue(new Callback<CartApiResponse>()
//        {
//            @Override
//            public void onResponse(Call<CartApiResponse> call, Response<CartApiResponse> response)
//            {
//                Log.d(TAG, "onResponse: Succeeded");
//
//                CartApiResponse cartApiResponse = response.body();
//
//                if (response.body() != null)
//                {
//                    mutableLiveData.setValue(cartApiResponse);
//                    Log.d(TAG, String.valueOf(response.body().getProductsInCart()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CartApiResponse> call, Throwable t)
//            {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//        return mutableLiveData;
//    }
}