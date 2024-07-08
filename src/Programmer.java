public class Programmer {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ( Programmer )";
    }

    public void reviewTasks(Project project) throws Exception {
        project.PrintNewTasks();
    }
    public void assignTaskToSelf(Task task,String time) throws Exception {
        if ( task.getStatut()==TaskStatus.New) {
            task.setProgrammer(this);
            task.setTime(time);
        }
    }
    public  void  FinshTask(Task task,String AllTime) throws Exception {
        if (task.getProgrammer()==this) {
            task.setStatut(TaskStatus.InQA);
            task.setALLTimeTask(AllTime);
        }else throw  new Exception("This task is not for you");
    }
}

