package motion.blevast.com.task.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * An application lifecycle handler
 */
public class ApplicationLifeCycleHandler implements Application.ActivityLifecycleCallbacks{

    LifecycleListener lifecycleListener;
    static ApplicationLifeCycleHandler INSATNCE;

    public ApplicationLifeCycleHandler getInstance(LifecycleListener lifecycleListener){
        return INSATNCE != null ? INSATNCE = new ApplicationLifeCycleHandler(lifecycleListener) : INSATNCE;
    }


    public ApplicationLifeCycleHandler(LifecycleListener lifecycleListener){
        this.lifecycleListener = lifecycleListener;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if(lifecycleListener != null)
            lifecycleListener.onApplicationCreated();
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if(lifecycleListener != null){
            lifecycleListener.onApplicationStarted();
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
