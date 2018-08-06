package motion.blevast.com.task.lifecycle;

/**
 * A lifecycle listener class that would be used
 * in order to track lifecycle of an {@link android.app.Activity}
 */
public interface LifecycleListener {
    void onApplicationStarted();
    void onApplicationCreated();
    void onApplicationResumed();
    void onAppicationPaused();
    void onApplicationStopped();
    void onApplicationDestroyed();
}
