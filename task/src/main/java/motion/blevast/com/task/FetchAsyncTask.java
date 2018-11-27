package motion.blevast.com.task;

import android.os.AsyncTask;

/**
 * For an {@link AsyncTask} to be implemented--> it at least need
 * doInBackground() method to be overridden
 */

public class FetchAsyncTask extends AsyncTask<String, Integer, Integer> {

    //Memory observability
    //This is how to set and get member variables

    //Order of execution
    //AsyncTasks are executed on a single background thread
    //It was changed at some point but reversed back in order to
    //prevent parallel execution errors.

    //Before the task is even executed
    //This method is used to set up different
    //UI elements
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //
    //This is a good area to show logs from a given task
    //
    @Override
    protected void onProgressUpdate(Integer... values) {
        //This takes in what ever is published
        //from from the doInBackground() method
        super.onProgressUpdate(values);
    }

    //Only this method is running on the background thread
    @Override
    protected Integer doInBackground(String... strings) {

        //String[] arrayArguments = strings;
        //Now deal with array arguments
        /**
         * This goes in the {@link #onProgressUpdate(String...)} method up
         */
        publishProgress(9);
        return null;
    }

    /**
     * @param integer this is passed as  a parameter of execution
     */
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    //on cancelled is called here.
    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    //This is the same integer we will recieve
    //as we do in the doInBackground() method
    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
    }
}
