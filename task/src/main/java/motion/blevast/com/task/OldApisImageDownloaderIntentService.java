package motion.blevast.com.task;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

/**
 * This is what comes to the rescue for API < 21
 * Schedules it as per the api level, mostly for the purpose
 * of integration....This is a scheduler!!
 */
public class OldApisImageDownloaderIntentService extends JobIntentService {



    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, OldApisImageDownloaderIntentService.class, 0, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

    }

}
