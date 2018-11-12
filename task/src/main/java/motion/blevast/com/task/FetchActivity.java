package motion.blevast.com.task;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FetchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is Serial
        new FetchAsyncTask().execute("", "", " ");
        //This is out in the wild
        new FetchAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        //Loaders
        this.getSupportLoaderManager().initLoader(0, null, new ImageAsyncLoadker(this));
    }
}
