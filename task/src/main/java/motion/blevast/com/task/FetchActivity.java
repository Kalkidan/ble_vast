package motion.blevast.com.task;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

public class FetchActivity extends AppCompatActivity {

    private FetchAsyncTask fetchAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is Serial execution within a given thread

        //This is where we send in three different Strings
        //to be part of the doInBackground() parameters
        new FetchAsyncTask().execute("", "", " ");
        //This is out in the wild
        fetchAsyncTask = new FetchAsyncTask();
        fetchAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        fetchAsyncTask.cancel(true);

        //Loaders
        //If the loader created by the same id is already in use
        //We will be reusing the loader again and again
        //We can reference it, but usually no use
        //we can handle it in the callback
        Loader<Bitmap> loader = this.getSupportLoaderManager().initLoader(0, null, new ImageAsyncLoader(this));
        //this.getSupportLoaderManager().restartLoader()


        //Android Oreo way of starting a foreground service
        //startForegroundService()


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
