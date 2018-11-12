package motion.blevast.com.task;

import android.os.AsyncTask;

public class FetchAsyncTask extends AsyncTask<String, String, Integer> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    //Only this method is running on the background thread
    @Override
    protected Integer doInBackground(String... strings) {

        String[] arrayArguments = strings;
        //Now deal with array arguments
        /**
         * This goes in the {@link #onProgressUpdate(String...)} method up
         */
        publishProgress("");
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}
