package motion.blevast.com.task;

import android.content.Context;

import java.util.concurrent.atomic.AtomicInteger;
import androidx.loader.content.AsyncTaskLoader;

/**
 * This is a generic {@link AsyncTaskLoader}
 */
public abstract class FetchAsyncLoader<T> extends AsyncTaskLoader<T> {

    private T mData;
    public boolean hasResult = false;


    public FetchAsyncLoader(final Context context) {
        super(context);
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
        //this part should be removed from support library 27.1.0 :
        //else if (hasResult)
        //    deliverResult(mData);
    }

    @Override
    public void deliverResult(final T data) {
        mData = data;
        hasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (hasResult) {
            onReleaseResources(mData);
            mData = null;
            hasResult = false;
        }
    }

    protected void onReleaseResources(T data) {
        //nothing to do.
    }

    public T getResult() {
        return mData;
    }
}
