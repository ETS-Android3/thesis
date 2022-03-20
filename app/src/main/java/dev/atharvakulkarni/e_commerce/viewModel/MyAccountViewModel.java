package dev.atharvakulkarni.e_commerce.viewModel;

public class MyAccountViewModel {
    private MyAccountViewModelCallbacks mCallbacks;
    public MyAccountViewModel(MyAccountViewModelCallbacks callbacks)
    {
        this.mCallbacks = callbacks;
    }
    public interface MyAccountViewModelCallbacks{

    }
}
