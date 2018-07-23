package motion.blevast.com.task;

public class TaskExecutor {

    TaskScheduler taskScheduler;

    public TaskExecutor(TaskSchedulerImpl taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public static TaskExecutor getExecutor(){
        return new TaskExecutor(new TaskSchedulerImpl());
    }

    public void execute(Task task){
        this.taskScheduler.execute(task);
    }
}
