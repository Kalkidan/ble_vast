package motion.blevast.com.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/***
 * A general task handler class that will handle
 */
public class TaskHandler extends Handler implements TaskOperations{

    public TaskHandler(Looper looper){
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        //Dispatched messages
        switch (msg.what){

        }
    }
}
