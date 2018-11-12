package motion.blevast.com.task;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

public class BitMapAsyncLoader extends FetchAsyncLoader<Bitmap> {

    public BitMapAsyncLoader(Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Bitmap loadInBackground() {
        //Load up the bitmap
        return null;
    }
}
