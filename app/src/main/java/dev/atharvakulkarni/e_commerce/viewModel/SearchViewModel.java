package dev.atharvakulkarni.e_commerce.viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import dev.atharvakulkarni.e_commerce.BR;

public class SearchViewModel extends BaseObservable {
    private String mQuery;
    private SearchViewModelCallbacks mCallbacks;

    public SearchViewModel(SearchViewModelCallbacks callbacks) {
        this.mCallbacks = callbacks;
//        mQuery = query;
    }

    @Bindable
    public String getQuery() {
        return mQuery;
    }

    public void setQuery(String query) {
        mQuery = query;
        notifyPropertyChanged(BR.query);
    }

    public void onSearchButtonClick() {
        //do some query here
    }

    public interface SearchViewModelCallbacks {
    }
}
