package dev.atharvakulkarni.e_commerce.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.SliderItem;

import dev.atharvakulkarni.e_commerce.adapter.slider_adapter;
import dev.atharvakulkarni.e_commerce.databinding.FragmentHomeBinding;
import dev.atharvakulkarni.e_commerce.viewModel.HomeViewModel;


public class HomeFragment extends Fragment implements HomeViewModel.HomeViewModelCallbacks {
    //HomeViewModel mViewModel;
    SearchView searchView;
    ImageView cart;
    ImageView notifications;

    SliderView sliderView;
    private slider_adapter adapter;

    @Override
    public void onSearchQuerySubmit(String query) {
        // start SearchActivity
        Intent intent = new Intent(getActivity(),SearchActivity.class);
        intent.putExtra(SearchActivity.EXTRA_QUERY_STRING,query);
        startActivity(intent);
    }

    @Override
    public void onCartIconClick() {
        Intent intent = new Intent(getActivity(),CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNotificationIconClick() {
        Intent intent = new Intent(getActivity(), NotificationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHamburgerIconClick() {
      ((MainActivity)getActivity()).getActivityMainBinding().drawerLayout.openDrawer(GravityCompat.START);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        HomeViewModel viewModel = new HomeViewModel(this);
        binding.setHomeViewModel(viewModel);
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //to do change this ?
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra(SearchActivity.EXTRA_QUERY_STRING,query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        //load 10 or more item_card_view_product
        for(int i = 0 ;i < 10 ;i++)
        {
            //TODO set price and name of the product
            View view = inflater.inflate(R.layout.item_card_view_product,binding.newProductsLayout,false);
            ImageView productImage = view.findViewById(R.id.product_image);
            productImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //start product details activity

                }
            });
            LikeButton likeButton = view.findViewById(R.id.like_button);
            likeButton.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
                    // process to add this to wishlist
                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    //process to remove this from wishlist
                }
            });
            binding.newProductsLayout.addView(view);
        }

        return binding.getRoot();
    }

    //    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        //        setContentView(R.layout.activity_sign_in);
////        ActivitySignInBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
////        SignInViewModel viewModel = new SignInViewModel(this);
////        binding.setSignInViewModel(viewModel);
//    }
    //    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//    {
//      // View view = inflater.inflate(R.layout.home,container,false);
//
//        homeBinding = DataBindingUtil.inflate(inflater, R.layout.home, container, false);
//        View view = homeBinding.getRoot();
//
//        cart = homeBinding.cart;
//        searchView = homeBinding.searchView;
//        sliderView = homeBinding.imageSlider;
//        notifications = homeBinding.notifications;
//
//
////        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.purple));
//
//       // mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
//      //  mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
//
//
//       // mViewModel.init();
//
//        /*mViewModel.getUsers().observe(this, users -> {
//            // update UI
//        });*/
//
//      /*  mViewModel.getUsers().observe(getContext(), new Observer<VolumesResponse>()
//        {
//            @Override
//            public void onChanged(VolumesResponse volumesResponse)
//            {
//                // update the ui.
//                if(volumesResponse != null)
//                    adapter.setResults(volumesResponse.getItems());
//            }
//        });*/
//
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
//        {
//            @Override
//            public boolean onQueryTextSubmit(String query)
//            {
//                if(query.equals("shoes"))
//                {
//                    Intent intent = new Intent(getContext(), search_result.class);
//                    startActivity(intent);
//                }
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText)
//            {
//                return false;
//            }
//        });
//
//        cart.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(getContext(), CartActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        notifications.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), NotificationsActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//        adapter = new slider_adapter(getContext());
//
//        sliderView.setSliderAdapter(adapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();
//
//        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener()
//        {
//            @Override
//            public void onIndicatorClicked(int position)
//            {
//                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
//            }
//        });
//
//        addNewItem(view);
//        renewItems(view);
//        removeLastItem(view);
//
//        return view;
//    }

    public void renewItems(View view)
    {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++)
        {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0)
            {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            }
            else
            {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view)
    {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view)
    {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }
}