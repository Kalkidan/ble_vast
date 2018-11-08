package com.blevast.motion.adapter;

//********//
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
//*******//
import android.widget.ImageView;
import com.blevast.motion.R;
//
import com.squareup.picasso.Picasso;

public class DataBindingAdapter {

    /**
     * @param url
     * @param view
     */
    @BindingAdapter("imageUrl")
    public static void imageUrl(ImageView view, ObservableField<String> url){
        Picasso.get().
                load(url.get()).
                placeholder(R.drawable.rounded_drawable).
                error(R.drawable.rounded_drawable).
                into(view);
    }

    /**
     * @param url
     * @param view
     */
    @BindingAdapter("android:background")
    public static void background(ImageView view, ObservableField<String> url){
        Picasso.get().
                load(url.get()).
                placeholder(R.drawable.rounded_drawable).
                error(R.drawable.rounded_drawable).
                into(view);
    }
}
