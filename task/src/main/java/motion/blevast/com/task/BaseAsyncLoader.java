package motion.blevast.com.task;

import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class BaseAsyncLoader<T> extends AsyncTaskLoader<T> {

    protected T data;

    public BaseAsyncLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(T data) {
        super.deliverResult(data);
        this.data = data;
    }
}
