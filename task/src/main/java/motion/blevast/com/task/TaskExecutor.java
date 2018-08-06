package motion.blevast.com.task;

public class TaskExecutor {

    TaskScheduler taskScheduler;
    static TaskExecutor INSTANCE;

    public TaskExecutor(TaskSchedulerImpl taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public static TaskExecutor getExecutor(){
        return INSTANCE != null ? INSTANCE = new TaskExecutor(new TaskSchedulerImpl()) : INSTANCE;
    }

    public void execute(Task task){
        this.taskScheduler.execute(task);
    }
}
