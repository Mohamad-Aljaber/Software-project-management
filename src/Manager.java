public class Manager {
    private String name;
    public Manager(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name + " ( Manager )";
    }
    public void reviewTasks(Task task) throws Exception {
        if ( task.getStatut()==TaskStatus.Done) {
            task.setManger(this);
            task.setStatut(TaskStatus.Approve);
        }
    }
}
