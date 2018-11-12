package motion.blevast.com.executor.v26;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import motion.blevast.com.executor.util.ApiUtil;


/**
 * This will be used as a scheduler helper class.
 */

public class SchedulerHelper {

    public static final String TAG = SchedulerHelper.class.getSimpleName();

    private static final int GCM_JOB_ID = 1;

    /**
     *
     * This is a flag for executing one timer task
     */
    public static final String GCM_ONEOFF_TAG = "oneoff|[0,0]";
    private static final long REFRESH_INTERVAL  = 5 * 1000;
    private static final long INTERVAL = 10 *1000;

    /**
     *
     * This is executing over a period of time with earlier
     * execution period of 30 seconds.
     *
     * This is not standard and is subjective
     */
    public static final String GCM_REPEAT_TAG = "repeat|[7200,1800]";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void scheduleJob(Context context, Class<? extends JobService> classz, long scheduleTime, int id) {

        if(context == null || classz == null) return;

        final JobScheduler jobScheduler = (JobScheduler) context.getSystemService(
                Context.JOB_SCHEDULER_SERVICE);

        if (jobScheduler == null) return;
        //define component name
        final ComponentName name = new ComponentName(context, classz);
        final int result = jobScheduler.schedule(getJobInfo(id, scheduleTime, name));
        if (result == JobScheduler.RESULT_SUCCESS) {

        }else {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void cancelAllPendingJobs(Context context){
        final JobScheduler jobScheduler = (JobScheduler) context.getSystemService(
                Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler != null) jobScheduler.cancelAll();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void cancelPendingJobWithID(Context context, int id){
        final JobScheduler jobScheduler = (JobScheduler) context.getSystemService(
                Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler == null) return;
        jobScheduler.cancel(id);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static JobInfo getJobInfo(final int id, final long period, final ComponentName name) {

        JobInfo jobInfo = null;

        /**
         * This is just a trial that will show us that N is always running 15mins.
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            jobInfo = new JobInfo.Builder(id, name)
                    //.setMinimumLatency(period)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false)
                    .setPeriodic(INTERVAL, REFRESH_INTERVAL)
                    //Android O required .setRequiresBatteryNotLow(true)
                    //This is for boot complete .setPersisted(true)
                    .build();
        } else{}
        /*} else {

            *//**
             *
             *
             * This is just good to have it here.
             * Not that we care about this.
             *
             * TODO:: JUST for having it.
             *//*
            jobInfo = new JobInfo.Builder(id, name)
                    .setMinimumLatency(period)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false)
                    //This is for boot complete .setPersisted(true)
                    .build();*/
        //}

        return jobInfo;
    }
}
