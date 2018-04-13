package motion.blevast.com.executor.v26;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
        /**
         *
         * The component part we want to run.
         *
         */
        final ComponentName name = new ComponentName(context, classz);

        /**
         *
         * Schedule the {@link JobInfo}
         */
        final int result = jobScheduler.schedule(getJobInfo(id, scheduleTime, name));

        /**
         *
         * Check if we successfuly scheduled the {@link JobInfo}
         */
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

        final JobInfo jobInfo;

        if (ApiUtil.isAndroid_O()) {
            jobInfo = new JobInfo.Builder(id, name)
                    .setMinimumLatency(period)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false)
                    .setRequiresBatteryNotLow(true)
                    .setPersisted(true)
                    .build();
        } else {

            /**
             *
             *
             * This is just good to have it here.
             * Not that we care about this.
             *
             * TODO:: JUST for having it.
             */
            jobInfo = new JobInfo.Builder(id, name)
                    .setMinimumLatency(period)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false)
                    .setPersisted(true)
                    .build();
        }

        return jobInfo;
    }
}
