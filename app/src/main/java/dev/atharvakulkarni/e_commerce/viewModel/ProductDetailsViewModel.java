package dev.atharvakulkarni.e_commerce.viewModel;

public class ProductDetailsViewModel {
    private ProductDetailsViewModelCallbacks mCallbacks;
    public ProductDetailsViewModel(ProductDetailsViewModelCallbacks callbacks)
    {
        mCallbacks = callbacks;
    }
    public interface ProductDetailsViewModelCallbacks{

    }
    public void onShopImageClick()
    {

    }
}
