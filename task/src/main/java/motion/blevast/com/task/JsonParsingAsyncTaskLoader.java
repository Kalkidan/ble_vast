package motion.blevast.com.task;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.FileObserver;

import java.io.File;
import java.util.List;

//Loaders basics
public class JsonParsingAsyncTaskLoader extends AsyncTaskLoader<List<String>> {

    private List<String> list;

    private FileObserver fileObserver;

    /**
     * @param context
     * This will be a Json parsing task
     */
    public JsonParsingAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {

       // takeContentChanged()
        if(this.list != null){
            //if the list is not null
            //and just got back from configuration change or some
            //then
            deliverResult(this.list);
        } else {
            forceLoad();
        }
    }

    /**
     * @return {@link List<String>}
     */
    //
    //
    @Override
    public List<String> loadInBackground() {

        fileObserver = new FileObserver(new File(getContext().getFilesDir(), "downloaded.json").getPath()) {
            @Override
            public void onEvent(int i, String s) {

            }
        };

        //start watching the file
        fileObserver.startWatching();

        //
        SharedPreferences.OnSharedPreferenceChangeListener listener = (changedSharedPref, key) -> {
            //key -- the key of the preference that was changed
        };

        //This requires api level 16
        //isLoadInBackgroundCanceled();
        //
        //
        //
        return null;
    }

    @Override
    public void deliverResult(List<String> data) {
        //deliver a result
        //this is on the UI thread so
        //no lengthy resource consuming maniuplations
        super.deliverResult(data);
        list = data;
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
