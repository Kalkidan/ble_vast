package motion.blevast.com.task;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;

public class ImageAsyncLoadker implements androidx.loader.app.LoaderManager.LoaderCallbacks<Bitmap> {


    private Context context;

    public ImageAsyncLoadker(Context fetchActivity) {
        this.context = fetchActivity;
    }

    @NonNull
    @Override
    public Loader<Bitmap> onCreateLoader(int id, @Nullable Bundle args) {
        return new BitMapAsyncLoader(context);
    }

    @Override
    public void onLoadFinished(@NonNull androidx.loader.content.Loader<Bitmap> loader, Bitmap data) {

    }

    @Override
    public void onLoaderReset(@NonNull androidx.loader.content.Loader<Bitmap> loader) {

    }
}


