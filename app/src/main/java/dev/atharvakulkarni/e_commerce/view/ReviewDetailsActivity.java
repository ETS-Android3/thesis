package dev.atharvakulkarni.e_commerce.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import dev.atharvakulkarni.e_commerce.R;
import dev.atharvakulkarni.e_commerce.model.ReviewImage;
import dev.atharvakulkarni.e_commerce.model.ShowReviewImage;
import dev.atharvakulkarni.e_commerce.utils.UIHelper;

public class ReviewDetailsActivity extends AppCompatActivity {



    public class ReviewDetailsAdapter extends RecyclerView.Adapter<ReviewDetailsAdapter.ReviewViewHolder> {
        private List<ReviewImage> mReviewImageList;
        private Context mContext;

        public ReviewDetailsAdapter(Context mContext) {
            mReviewImageList = new ArrayList<>();
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_review_details, viewGroup, false);
            return new ReviewViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewHolder reviewViewHolder, int i) {
            if (mReviewImageList != null) {

                ReviewImage reviewImage = mReviewImageList.get(i);
                if (reviewImage != null) {
//                    UIHelper.setThumbImageUriInView(reviewViewHolder.imageViewProfile,reviewImage.getImageName() );

                    reviewViewHolder.textViewName.setText(reviewImage.getUserName());
                    reviewViewHolder.textViewDate.setText(reviewImage.getTime());
                    reviewViewHolder.textViewDescription.setText(reviewImage.getReview());
                    reviewViewHolder.ratingBar.setRating(Float.parseFloat(reviewImage.getRating()));

                    if (reviewImage.getShowReviewImageList() != null) {
                        ReviewImageAdapter imageAdapter = new ReviewImageAdapter(reviewImage.getShowReviewImageList());
                        reviewViewHolder.recyclerViewImage.setAdapter(imageAdapter);
                        reviewViewHolder.recyclerViewImage.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                    }
//                    if (String.valueOf(reviewImage.getUserId()).equals(CustomSharedPrefs.getLoggedInUserId(mContext))){
//                        ReviewDetailsActivity.isAlreadyReviewed=true;
//                    }
                }

            }


        }

        /**
         * @param item     item type object
         * @param position int value of position where value will be inserted
         */
        public void addAllItemToPosition(List<ReviewImage> item, int position) {
            mReviewImageList.addAll(position, item);
            notifyItemInserted(position);
        }

        public void addItem(List<ReviewImage> newList) {
            for (ReviewImage reviewImage : newList) {
                this.mReviewImageList.add(reviewImage);
                notifyItemInserted(mReviewImageList.size() - 1);
            }
        }
        public void clearList() {
            mReviewImageList.clear();
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return mReviewImageList.size();
        }

        public class ReviewViewHolder extends RecyclerView.ViewHolder {
            ImageView imageViewProfile;
            TextView textViewName, textViewDate, textViewDescription;
            RatingBar ratingBar;
            RecyclerView recyclerViewImage;

            public ReviewViewHolder(@NonNull View itemView) {
                super(itemView);

                imageViewProfile = itemView.findViewById(R.id.image_view_profile);
                textViewName = itemView.findViewById(R.id.text_view_name);
                textViewDate = itemView.findViewById(R.id.text_view_date);
                textViewDescription = itemView.findViewById(R.id.text_view_message);
                ratingBar = itemView.findViewById(R.id.rating_bar_avg_rating);
                recyclerViewImage = itemView.findViewById(R.id.recycler_view_up_images);
            }
        }
    }

    public class ReviewImageAdapter extends RecyclerView.Adapter<ReviewImageAdapter.ImageViewHolder> {
        private List<ShowReviewImage> imageList;

        public ReviewImageAdapter(List<ShowReviewImage> imageList) {
            this.imageList = imageList;
        }
        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_review_up_images, viewGroup, false);
            return new ImageViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
            if (imageList!=null){
                ShowReviewImage showReviewImage=imageList.get(i);
                UIHelper.setThumbImageUriInView(imageViewHolder.mRoundedImageView , showReviewImage.getProfileImageOfReviewer());
            }
        }

        @Override
        public int getItemCount() {
            if (imageList !=null){
                return imageList.size();
            }else {
                return 0;
            }

        }


        public class ImageViewHolder extends RecyclerView.ViewHolder {
            RoundedImageView mRoundedImageView;

            public ImageViewHolder(@NonNull View itemView) {
                super(itemView);

                mRoundedImageView = itemView.findViewById(R.id.image_view_images);
            }
        }
    }
}
