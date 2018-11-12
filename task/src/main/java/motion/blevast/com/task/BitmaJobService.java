package motion.blevast.com.task;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BitmaJobService extends JobService {

    private FetchAsyncTask fetchAsyncTask;

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        fetchAsyncTask = new FetchAsyncTask(){
            @Override
            protected void onPostExecute(Integer integer) {
                jobFinished(jobParameters, false);
            }
        };

        //This can be true just to let the system know that
        //we need more time.
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
