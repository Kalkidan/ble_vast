package com.blevast.motion;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BackgroundDataJobService extends JobService {

    private static final String TAG = BackgroundDataJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters params) {

        Log.d(TAG, "Job Started");
        jobFinished(params, false);

        //If we use Async task or loaders here we need to tell the system
        //that we are on it and return true.
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        jobFinished(params, false);
        return false;
    }



}
