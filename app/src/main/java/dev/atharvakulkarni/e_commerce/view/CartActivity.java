package dev.atharvakulkarni.e_commerce.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.databinding.ActivityCartBinding;
import dev.atharvakulkarni.e_commerce.model.Product;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        mBinding.recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        updateUI();
    }

    public void updateUI() {
        //TODO get list of product
        List<Product> products = new ArrayList<>();
        products.add(new Product("SHJOE", 14.2, 3, "ME!", "TEstign1"));
        products.add(new Product("SHJOE2", 11.2, 2, "ME2", "TEstign55"));
        products.add(new Product("SHJO3", 17.2, 1, "ME3", "TEstign12"));
        products.add(new Product("SHJOE6", 11.2, 6, "ME4", "TEstign122"));
        products.add(new Product("SHJOE", 14.2, 3, "ME!", "TEstign1"));
        products.add(new Product("SHJOE2", 11.2, 2, "ME2", "TEstign55"));
        products.add(new Product("SHJO3", 17.2, 1, "ME3", "TEstign12"));
        products.add(new Product("SHJOE6", 11.2, 6, "ME4", "TEstign122"));
        products.add(new Product("SHJOE", 14.2, 3, "ME!", "TEstign1"));
        products.add(new Product("SHJOE2", 11.2, 2, "ME2", "TEstign55"));
        products.add(new Product("SHJO3", 17.2, 1, "ME3", "TEstign12"));
        products.add(new Product("SHJOE6", 11.2, 6, "ME4", "TEstign122"));
        if (products.size() > 0) {
            mBinding.layoutNoData.setVisibility(View.GONE);
        }
        mBinding.recyclerViewCart.setAdapter(new CartAdapter(products));
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Product mProduct;
        TextView mProductName, mProductPrice;
        ImageView mProductImage;
        TextView mProductQuantityText;
        TextView mDeleteButton;
        ImageView mPlusImageButton, mMinusImageButton;
        private int mProductPosition;

        public CartItemViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list_cart_product, parent, false));
            itemView.setOnClickListener(this);

            mProductName = itemView.findViewById(R.id.product_name);
            mProductPrice = itemView.findViewById(R.id.product_price);
            mProductImage = itemView.findViewById(R.id.product_image);
            mProductQuantityText = itemView.findViewById(R.id.product_quantity_text);
            mPlusImageButton = itemView.findViewById(R.id.plus_button);
            mMinusImageButton = itemView.findViewById(R.id.minus_button);

        }

        public void bind(Product product) {
            //TODO: edit here
            mProduct = product;
            mProductName.setText(mProduct.getProductName());
            mProductPrice.setText(String.valueOf(mProduct.getProductPrice()));
//            mProductImage.setImageBitmap(mProduct.getProductImage());
            mProductImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.shoes1, null));

            mPlusImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mProduct.setProductQuantity(mProduct.getProductQuantity() + 1);
                    mProductQuantityText.setText(String.valueOf(mProduct.getProductQuantity()));
                }
            });
            mMinusImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mProduct.getProductQuantity() > 0)
                        mProduct.setProductQuantity(mProduct.getProductQuantity() - 1);
                    mProductQuantityText.setText(String.valueOf(mProduct.getProductQuantity()));
                }
            });
            mProductQuantityText.setText(String.valueOf(mProduct.getProductQuantity()));

        }

        @Override
        public void onClick(View view) {
            // view product detail ?
        }

        public int getProductPosition() {
            return mProductPosition;
        }

        public void setProductPosition(int productPosition) {
            mProductPosition = productPosition;
        }
    }

    public class CartAdapter extends RecyclerView.Adapter<CartItemViewHolder> {
        private List<Product> mProducts;

        public CartAdapter(List<Product> products) {
            mProducts = products;
        }

        @NonNull
        @Override
        public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(CartActivity.this);
            return new CartItemViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
            Product product = mProducts.get(position);
            holder.bind(product);
            holder.setProductPosition(position);
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }
}