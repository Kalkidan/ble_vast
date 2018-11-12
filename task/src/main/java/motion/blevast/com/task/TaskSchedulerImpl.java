package motion.blevast.com.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TaskSchedulerImpl implements TaskScheduler{

    public static final String TAG = TaskSchedulerImpl.class.getSimpleName();

    public static final int POOL_SIZE = 10;

    public static final int MAX_POOL_SIZE = 15;

    public static final int TIME_OUT = 30;

    private ThreadPoolExecutor threadPoolExecutor;
    private TaskHandler taskHandler;


    public TaskSchedulerImpl(){
        //
        threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIME_OUT,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        //A common handler thread...Only running in one thread
        HandlerThread iniThread = new HandlerThread("KAL[" + Math.abs(new Random().nextInt()) + "]");
        iniThread.start();
        taskHandler = new TaskHandler(iniThread.getLooper());

        /****************************************************
         * Basic differences here
         ***************************************************/
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        tr.start();
        tr.getId();

        HandlerThread htr = new HandlerThread("");
        htr.getLooper();

        /******************************************
         * Taking care of the message is the {@link android.os.Handler} job
         ****************************************/

        Handler handler = new Handler();

        //This handler is owned by the UI thread


    }

    @Override
    public void execute(Runnable runnable) {
        //Execute the runnable
        threadPoolExecutor.execute(runnable);
    }
}
