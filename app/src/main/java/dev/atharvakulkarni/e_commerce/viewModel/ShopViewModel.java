package dev.atharvakulkarni.e_commerce.viewModel;

public class ShopViewModel {
    private ShopViewModelCallbacks mCallbacks;
    public ShopViewModel(ShopViewModelCallbacks callbacks)
    {
        this.mCallbacks = callbacks;
    }
    public interface ShopViewModelCallbacks{

    }
}
